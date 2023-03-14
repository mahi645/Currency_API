package com.axis.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.exception.DateNotFoundException;
import com.axis.exception.DuplicateDateFound;
import com.axis.exception.USD_NotFound;
import com.axis.model.Currency;
import com.axis.repository.CurrencyRepository;
import com.axis.utils.AppConstant;
@Service
public class CurrencyServiceImpl implements CurrencyService{
	@Autowired
	CurrencyRepository currencyRepository;

	@Override
	public List<Currency> getAll() {
		// TODO Auto-generated method stub
		List<Currency> list=currencyRepository.findAll();
		List<Currency> list1=list.stream()
				.sorted(Comparator.comparing(Currency::getDate)).collect(Collectors.toList());	
		int len=list.size();
		
		if(len<=30) {
			return list;
		}
		else {
			return list.stream()
	                .skip(len-30)
	                .limit(len)
	                .collect(Collectors.toList());
			
		}
				
	}

	@Override
	public String addCurrency(Currency currency) {
		// TODO Auto-generated method stub
		Currency currency1=currencyRepository.findByDate(currency.getDate());
		if(currency1!=null) {
			throw new DuplicateDateFound(AppConstant.DATE_FOUND_MSG);
		}
		else {
			currencyRepository.save(currency);
			return AppConstant.ADD_MSG;
		}
		
	}

	@Override
	public String update(Currency currency) {
		// TODO Auto-generated method stub
		Currency currency1=currencyRepository.findByDate(currency.getDate());
		if(currency1==null) {
			throw new DateNotFoundException(AppConstant.DateNotFound);
		}
		else {
			currency1.setDate(currency.getDate());
			currencyRepository.save(currency1);
			return AppConstant.UPDATE_MSG;
		}
	
	}

	@Override
	public String delete(Currency currency) {
		// TODO Auto-generated method stub
		Currency currency1=currencyRepository.findByDate(currency.getDate());
		if(currency1==null) {
			throw new DateNotFoundException(AppConstant.DateNotFound);
		}
		else {
			currencyRepository.delete(currency1);
			return AppConstant.DELETE_MSG;
		}
		
	}

	@Override
	public Currency findByDate(Currency currency) {
		// TODO Auto-generated method stub
		Currency currency1=currencyRepository.findByDate(currency.getDate());
		if(currency1==null) {
			throw new DateNotFoundException(AppConstant.DateNotFound);
		}
		else {
			return currency1;
		}
		
	}

	@Override
	public HashMap<String,String> exchangeCurrency(Currency currency) {
		// TODO Auto-generated method stub

		HashMap<String,String> map1=new HashMap<String,String>();	
			String key1=currency.getCurrency()+" "+currency.getCurrencyType();
			String value1=(currency.getCurrency()*82.295)+" "+"INR";
			map1.put(key1, value1);

	return map1;	
		

	}
}
