package ru.itis.yaylunch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.yaylunch.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
