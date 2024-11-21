package com.mitiara.backend.repositories;

import com.mitiara.backend.models.Price;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<Price, Integer> {
}
