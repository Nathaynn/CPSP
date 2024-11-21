package com.mitiara.backend.repositories;

import com.mitiara.backend.models.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {
}
