package com.example.calculadora.service;

import com.example.calculadora.util.calculadora.string.Calculadora;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {
    /*
    %2B = +
    */
    public Double calcularEntreDoisNumeros(String equacao) throws Exception {
        Calculadora calculadora = new Calculadora();
        return calculadora.calcular(equacao);
    }

}
