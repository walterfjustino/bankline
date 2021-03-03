package com.bankline.bankline.data.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankline.bankline.data.dto.DashboardDTO;
import com.bankline.bankline.data.exception.UsuarioNaoEncontradoException;
import com.bankline.bankline.data.service.DashboardService;

@RestController
@RequestMapping(value = "/api/dashboard")
public class DashboardController {
	
	@Autowired
	private DashboardService dashboard;
	
	@GetMapping
	public ResponseEntity<?> dashboardAccounts(@RequestHeader("inicio") Date dtInicial,
											   @RequestHeader("fim") Date dtFinal, 
											   @RequestHeader("login") String login){
		
		System.out.println(login);
		
		try {
			DashboardDTO dto = dashboard.montar(dtInicial, dtFinal, login);
			return ResponseEntity.ok().body(dto);
		} catch (UsuarioNaoEncontradoException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
	}
	
	

}
