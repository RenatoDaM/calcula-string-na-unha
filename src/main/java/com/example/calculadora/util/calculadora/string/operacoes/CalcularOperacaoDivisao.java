package com.example.calculadora.util.calculadora.string.operacoes;

public class CalcularOperacaoDivisao implements CalcularOperacaoStrategy {

    @Override
    public Double calcular(Double valor1, Double valor2) {
        return valor1 / valor2;
    }
}
