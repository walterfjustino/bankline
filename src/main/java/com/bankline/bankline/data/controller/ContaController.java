package com.bankline.bankline.data.controller;


import com.bankline.bankline.data.model.ContaModel;
import com.bankline.bankline.data.model.Response;
import com.bankline.bankline.data.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/conta")
public class ContaController {


    @Autowired
    public ContaService contaService;






    //Cadastrar Conta
    @PostMapping
    public ResponseEntity<Response<Boolean>> cadastrar(@Valid @RequestBody ContaModel conta) {
        Response<Boolean> response = new Response<>();
        response.setData(contaService.cadastrar(conta));
        response.setStatusCode(HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
