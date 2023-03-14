package com.axis.repository;

import java.time.LocalDate;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.axis.model.Currency;

public interface CurrencyRepository extends MongoRepository<Currency,Integer>{
	public Currency findByDate(LocalDate date);

}
