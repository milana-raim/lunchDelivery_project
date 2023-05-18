package ru.itis.yaylunch.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.yaylunch.dto.BrandDto;
import ru.itis.yaylunch.dto.forms.BrandForm;
import ru.itis.yaylunch.dto.mapper.BrandMapper;
import ru.itis.yaylunch.exceptions.BrandNotFoundException;
import ru.itis.yaylunch.exceptions.ForbiddenException;
import ru.itis.yaylunch.models.newer.Account;
import ru.itis.yaylunch.models.Brand;
import ru.itis.yaylunch.repositories.BrandsRepository;
import ru.itis.yaylunch.services.BrandsService;
import ru.itis.yaylunch.services.SecurityService;

import java.util.List;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class BrandsServiceImpl implements BrandsService {
    private final BrandsRepository brandsRepository;
    private final BrandMapper brandMapper;
    private final SecurityService securityService;

    @Override
    public BrandDto getBrand(Long id) {
        Brand brand = brandsRepository.findById(id).orElseThrow((Supplier<RuntimeException>) ()
                -> new BrandNotFoundException("Brand not found")
        );
        return brandMapper.toBrandDto(brand);
    }

    @Override
    public List<BrandDto> getAllBrands() {
        return brandMapper.toBrandDtoList(brandsRepository.findAll());
    }

    @Override
    public BrandDto updateBrand(Long id, BrandForm newData) {
        Brand brand = brandsRepository.findById(id).orElseThrow((Supplier<RuntimeException>) ()
                -> new BrandNotFoundException("Brand not found")
        );
        brand.setBrandName(newData.getBrandName());
        brand.setDescription(newData.getDescription());

        brandsRepository.save(brand);

        return brandMapper.toBrandDto(brand);
    }

    @Override
    public BrandDto deleteBrand(Long id) {
        Brand brand = brandsRepository.findById(id).orElseThrow((Supplier<RuntimeException>) ()
                -> new BrandNotFoundException("Brand not found")
        );
        brand.setState(Brand.State.DELETED);

        brandsRepository.save(brand);

        return brandMapper.toBrandDto(brand);
    }

    @Override
    public BrandDto createBrand(BrandForm brandForm) {
        Account account = securityService.getAuthorizedAccount();
        if(account.getRole().equals(Account.Role.USER)) throw new ForbiddenException("this user is not organization");

        Brand brand = Brand.builder()
                .brandName(brandForm.getBrandName())
                .description(brandForm.getDescription())
                .organization(account.getOrganization())
                .state(Brand.State.ACTIVE)
                .build();

        return brandMapper.toBrandDto(brandsRepository.save(brand));
    }
}
