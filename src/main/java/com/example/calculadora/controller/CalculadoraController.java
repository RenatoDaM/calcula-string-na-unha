package com.example.calculadora.controller;

import com.example.calculadora.controller.openapi.CalculadoraOpenAPIImpl;
import com.example.calculadora.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController implements CalculadoraOpenAPIImpl {

    @Autowired
    CalculadoraService calculadoraService;

    @RequestMapping(value = "/calcular-dois-numeros", method = RequestMethod.GET)
    public ResponseEntity<Double> calcular(@RequestParam String equacao) throws Exception {
        System.out.println(equacao);
        return ResponseEntity.ok().body(calculadoraService.calcular(equacao));
    }
}
