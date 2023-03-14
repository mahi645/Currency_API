package com.axis.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import com.axis.model.Currency;

public interface CurrencyService {
	public List<Currency> getAll();
	public String addCurrency(Currency currency);
	public String update(Currency currency);
	public String delete(Currency currency);
	public Currency findByDate(Currency currency);
//	public HashMap<String,String> predictedValue(Currency currency);
	public HashMap<String,String> exchangeCurrency(Currency currency);

}
