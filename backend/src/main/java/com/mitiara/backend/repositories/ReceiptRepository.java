package com.mitiara.backend.repositories;

import com.mitiara.backend.models.Receipt;
import org.springframework.data.repository.CrudRepository;

public interface ReceiptRepository extends CrudRepository<Receipt, Integer> {
}