package com.bankline.bankline.data.controller;

import com.bankline.bankline.data.model.ContaModel;
import com.bankline.bankline.data.model.DashboardModel;
import com.bankline.bankline.data.model.Response;
import com.bankline.bankline.data.service.DashboardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/dashboard")
public class DashboardController {


  /*  private DashboardService dashboardService;

    //Cadastrar Conta
    @PostMapping
    public ResponseEntity<Response<Boolean>> get(@Valid @RequestBody DashboardModel dashboardModel) {
        Response<Boolean> response = new Response<>();
        response.setData(dashboardService.(d));
        response.setStatusCode(HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
	*/

}
