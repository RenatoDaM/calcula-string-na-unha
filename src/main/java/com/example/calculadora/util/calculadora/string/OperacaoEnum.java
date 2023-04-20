package com.example.calculadora.util.calculadora.string;

import com.example.calculadora.util.calculadora.string.operacoes.CalcularOperacaoStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum OperacaoEnum implements CalcularOperacaoStrategy {

    ADICAO("+") {
        @Override
        public Double calcular(Double valor1, Double valor2) {
            return valor1 + valor2;
        }

    },
    SUBTRACAO("-") {
        @Override
        public Double calcular(Double valor1, Double valor2) {
            return valor1 - valor2;
        }
    },
    MULTIPLICACAO("*") {
        @Override
        public Double calcular(Double valor1, Double valor2) {
            return valor1 * valor2;
        }
    },
    DIVISAO("/") {
        @Override
        public Double calcular(Double valor1, Double valor2) {
            return valor1 / valor2;
        }
    };

    String operador;

    private static Map<String, OperacaoEnum> relacaoOperadorOperacao = new HashMap<>();

    OperacaoEnum(String operador) {
        this.operador = operador;
    }

    public String getOperador() {
        return operador;
    }

    static {
        relacaoOperadorOperacao.put("+", ADICAO);
        relacaoOperadorOperacao.put("-", SUBTRACAO);
        relacaoOperadorOperacao.put("*", MULTIPLICACAO);
        relacaoOperadorOperacao.put("/", DIVISAO);
    }

    public static OperacaoEnum informarOperadorParaCalcular(String operador) {
        OperacaoEnum operacao = relacaoOperadorOperacao.get(operador);
        if (operacao == null) {
            throw new IllegalArgumentException("Operador inválido: " + operador);
        }
        return operacao;
    }
}
