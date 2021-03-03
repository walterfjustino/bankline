package com.bankline.bankline.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankline.bankline.data.service.ContaService;

@RestController
@RequestMapping(value = "api/contas")
public class ContasController {
	
	@Autowired
	private ContaService contaService;
	
	
	

}
