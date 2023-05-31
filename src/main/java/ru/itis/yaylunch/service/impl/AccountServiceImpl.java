package ru.itis.yaylunch.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.itis.yaylunch.dto.forms.ProfileForm;
import ru.itis.yaylunch.dto.request.SetRoleRestaurantRequest;
import ru.itis.yaylunch.dto.request.SetRoleSchoolRequest;
import ru.itis.yaylunch.dto.response.ProfileInfoResponse;
import ru.itis.yaylunch.exceptions.AccountNotFoundException;
import ru.itis.yaylunch.mapper.AccountMapper;
import ru.itis.yaylunch.models.*;
import ru.itis.yaylunch.repositories.*;
import ru.itis.yaylunch.service.AccountService;
import ru.itis.yaylunch.service.AddressService;
import ru.itis.yaylunch.service.RestaurantService;
import ru.itis.yaylunch.service.SchoolService;

import java.util.Optional;

import static ru.itis.yaylunch.models.Account.Role.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AddressService addressService;
    private final SchoolService schoolService;
    private final RestaurantService restaurantService;
    private final AccountMapper accountMapper;
    private final SchoolRepository schoolRepository;
    private final ClientRepository clientRepository;
    private final RestaurantRepository restaurantRepository;
    private final AddressRepository addressRepository;

    @Override
    public Optional<Account> getCurrentAccountFromSecurityContext() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        username = principal.toString();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }
        log.info("getCurrentAccountFromSecurityContext for user with principal {}", username);
        return accountRepository.findAccountByEmail(username);
    }

    @Override
    public void setRoleSchool(SetRoleSchoolRequest setRoleSchoolRequest) {
        Account account = getCurrentAccountFromSecurityContext().get();
        account.setRole(SCHOOL);

        School newSchool = School.builder()
                .account(account)
                .address(addressService.getEntity(setRoleSchoolRequest.getAddressId()))
                .bankAccount(setRoleSchoolRequest.getBankAccount())
                .name(setRoleSchoolRequest.getName())
                .build();

        newSchool = schoolService.save(newSchool);
        account.setSchool(newSchool);

        accountRepository.save(account);
    }

    @Override
    public void setRoleRestaurant(SetRoleRestaurantRequest setRoleRestaurantRequest) {
        Account account = getCurrentAccountFromSecurityContext().get();
        account.setRole(RESTAURANT);

        Restaurant newRestaurant = Restaurant
                .builder()
                .content(setRoleRestaurantRequest.getContent())
                .address(addressService.getEntity(setRoleRestaurantRequest.getAddressId()))
                .name(setRoleRestaurantRequest.getName())
                .build();

        newRestaurant = restaurantService.save(newRestaurant);
        account.setRestaurants(newRestaurant);

        accountRepository.save(account);
    }

    @Override
    public ProfileForm getCurrentProfileInfoResponse() {
        Account account = getCurrentAccountFromSecurityContext()
                .orElseThrow(AccountNotFoundException::new);
        ProfileForm profile = null;
        if (account.getRole().equals(USER)) {
            Client client = account.getClient();
            profile = ProfileForm.builder()
                    .role(account.getRole())
                    .firstName(client.getFirstName())
                    .lastName(client.getLastName())
                    .className(client.getClassName())
                    .grade(client.getGrade())
                    .email(account.getEmail())
                    .phone(account.getPhone())
                    .build();
            if (client.getSchool() != null) {
                profile.setClientSchoolName(client.getSchool().getName());
                profile.setClientSchoolId(client.getSchool().getId());
            }
        } else if (account.getRole().equals(SCHOOL)) {
            School school = account.getSchool();
            profile = ProfileForm.builder()
                    .role(account.getRole())
                    .name(school.getName())
                    .email(account.getEmail())
                    .phone(account.getPhone())
                    .build();
            if (school.getAddress() != null) {
                profile.setCity(school.getAddress().getCity());
                profile.setCountry(school.getAddress().getCountry());
                profile.setStreet(school.getAddress().getStreet());
                profile.setHouse(school.getAddress().getHouse());
                profile.setPostalCode(school.getAddress().getPostalCode());
            }
        } else if (account.getRole().equals(RESTAURANT)) {
            Restaurant restaurant = account.getRestaurants();
            profile = ProfileForm.builder()
                    .role(account.getRole())
                    .name(restaurant.getName())
                    .email(account.getEmail())
                    .phone(account.getPhone())
                    .content(restaurant.getContent())
                    .build();
            if (restaurant.getAddress() != null) {
                profile.setCity(restaurant.getAddress().getCity());
                profile.setCountry(restaurant.getAddress().getCountry());
                profile.setStreet(restaurant.getAddress().getStreet());
                profile.setHouse(restaurant.getAddress().getHouse());
                profile.setPostalCode(restaurant.getAddress().getPostalCode());
            }
        }
        return profile;
    }

    @Override
    public void updateProfile(ProfileForm form) {
        Account account = getCurrentAccountFromSecurityContext()
                .orElseThrow(AccountNotFoundException::new);
        if (account.getRole().equals(USER)){
            Client client = account.getClient();
            if(!form.getFirstName().isBlank()) {
                client.setFirstName(form.getFirstName());
            }
            if (!form.getLastName().isBlank()){
                client.setLastName(form.getLastName());
            }
            if(!form.getPhone().isBlank()) {
                account.setPhone(form.getPhone());
            }
            if(!form.getEmail().isBlank()) {
                account.setEmail(form.getEmail());
            }
            if(!form.getClassName().isBlank()){
                client.setClassName(form.getClassName());
            }
            if(form.getGrade()!=null){
                client.setGrade(form.getGrade());
            }
            if (form.getClientSchoolId()!=null){
                client.setSchool(schoolRepository.getById(form.getClientSchoolId()));
            }
            accountRepository.save(account);
            clientRepository.save(client);
        } else if (account.getRole().equals(SCHOOL)) {
            School school = account.getSchool();
            Address address = new Address();
            if(!form.getName().isBlank()) {
                school.setName(form.getName());
            }
            if(!form.getPhone().isBlank()) {
                account.setPhone(form.getPhone());
            }
            if(!form.getEmail().isBlank()) {
                account.setEmail(form.getEmail());
            }
            if(!form.getCountry().isBlank()){
                address.setCountry(form.getCountry());
            }
            if(!form.getCity().isBlank()){
                address.setCity(form.getCity());
            }
            if(!form.getStreet().isBlank()){
                address.setStreet(form.getStreet());
            }
            if(!form.getHouse().isBlank()){
                address.setHouse(form.getHouse());
            }
            if(!form.getPostalCode().isBlank()){
                address.setPostalCode(form.getPostalCode());
            }
            accountRepository.save(account);

            if (!address.equals(new Address())) {
                Address address1 = addressRepository.save(address);
                school.setAddress(address1);
            }
            schoolRepository.save(school);
        } else if (account.getRole().equals(RESTAURANT)) {
            Restaurant restaurant = account.getRestaurants();
            Address address = new Address();
            if (!form.getName().isBlank()) {
                restaurant.setName(form.getName());
            }
            if (!form.getPhone().isBlank()) {
                account.setPhone(form.getPhone());
            }
            if (!form.getContent().isBlank()) {
                restaurant.setContent(form.getContent());
            }
            if (!form.getEmail().isBlank()) {
                account.setEmail(form.getEmail());
            }
            if (!form.getCountry().isBlank()) {
                address.setCountry(form.getCountry());
            }
            if (!form.getCity().isBlank()) {
                address.setCity(form.getCity());
            }
            if (!form.getStreet().isBlank()) {
                address.setStreet(form.getStreet());
            }
            if (!form.getHouse().isBlank()) {
                address.setHouse(form.getHouse());
            }
            if (!form.getPostalCode().isBlank()) {
                address.setPostalCode(form.getPostalCode());
            }
            if (!address.equals(new Address())) {
                Address address1 = addressRepository.save(address);
                restaurant.setAddress(address1);
            }
            accountRepository.save(account);

            restaurantRepository.save(restaurant);

        }
    }
}
