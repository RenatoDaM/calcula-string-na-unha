package com.example.calculadora.util.calculadora.string;

import com.example.calculadora.util.calculadora.string.operacoes.OperacaoStrategy;

import java.util.HashMap;
import java.util.Map;

public enum EnumOperacao implements OperacaoStrategy {

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

    private static Map<String, EnumOperacao> relacaoOperadorOperacao = new HashMap<>();

    EnumOperacao(String operador) {
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

    public static EnumOperacao informarOperadorParaCalcular(String operador) {
        EnumOperacao operacao = relacaoOperadorOperacao.get(operador);
        if (operacao == null) {
            throw new IllegalArgumentException("Operador inválido: " + operador);
        }
        return operacao;
    }
}
