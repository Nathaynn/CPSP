package com.mitiara.backend.repositories;

import com.mitiara.backend.models.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
