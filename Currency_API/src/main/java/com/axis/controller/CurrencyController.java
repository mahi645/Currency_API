package com.axis.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.exception.DateNotFoundException;
import com.axis.model.Currency;
import com.axis.service.CurrencyService;
import com.axis.utils.AppConstant;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
	@Autowired
	CurrencyService currencyService;
	
	@GetMapping("/view")
	public ResponseEntity<List<Currency>> viewAll(){
		return new ResponseEntity<List<Currency>>(currencyService.getAll(),HttpStatus.OK);
		
	}

	@PostMapping("/add")
	public ResponseEntity<String> addCurrency(@RequestBody Currency currency){
		currencyService.addCurrency(currency);
		return new ResponseEntity<String>(AppConstant.ADD_MSG,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCurrency(@RequestBody Currency currency){
		currencyService.delete(currency);
		return new ResponseEntity<String>(AppConstant.DELETE_MSG,HttpStatus.OK);
	}
	
	@GetMapping("/date")
	public ResponseEntity<Currency> getByDate(@RequestBody Currency currency){
		return new ResponseEntity<Currency>(currencyService.findByDate(currency),HttpStatus.OK);
	}
	@GetMapping("/predict")
	public ResponseEntity<HashMap> getBy(@RequestBody Currency currency){
		Currency currency1=currencyService.findByDate(currency);
		
		if(currency1==null) {
			throw new DateNotFoundException(AppConstant.DateNotFound);
		}
		else {
			HashMap<String,String> map1=new HashMap<String,String>();
			String name=currency1.getCurrency()+" "+currency1.getCurrencyType();
			map1.put("predictedValue", name);
			return new ResponseEntity<HashMap>(map1,HttpStatus.OK);
		}
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateCurrency(@RequestBody Currency currency){
		return new ResponseEntity<String>(currencyService.update(currency),HttpStatus.OK);
	}
	@GetMapping("/exchange")
	public ResponseEntity<HashMap<String,String>> exchangeCurrency(@RequestBody Currency currency){
		
		
		return new ResponseEntity<HashMap<String,String>>(currencyService.exchangeCurrency(currency),HttpStatus.OK);
		}
}
