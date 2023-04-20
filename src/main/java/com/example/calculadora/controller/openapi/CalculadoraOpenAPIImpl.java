package com.example.calculadora.controller.openapi;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface CalculadoraOpenAPIImpl {
    @ApiResponse(description = "Retorna o resultando do cálculo entre dois números", responseCode = "200", content = @Content(mediaType = "application/json"))
    @Parameter(name = "equacao", description = "Aqui você insere 2 números com um operador entre eles. Operadores implementados até o momento: +, -, *, /", example = "10+10")
    public ResponseEntity<Double> calcular(@RequestParam String equacao) throws Exception;
}
