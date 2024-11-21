package com.mitiara.backend.repositories;

import com.mitiara.backend.models.Service;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<Service, Integer> {
}
