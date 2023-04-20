package com.example.calculadora.util.calculadora.string;

import com.example.calculadora.util.calculadora.string.operacoes.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculadora {
    Map<String, CalcularOperacaoStrategy> relacaoOperadorOperacao = new HashMap<>();

    public Calculadora(){

    }

    public Calculadora(String novoOperador, CalcularOperacaoStrategy novaOperacao) {
        relacaoOperadorOperacao.put(novoOperador, novaOperacao);
    }

    public Double calcular(Double valor1, String operador2, Double valor2) {
        OperacaoEnum calcular = OperacaoEnum.informarOperadorParaCalcular(operador2);

        if (calcular == null) throw new IllegalArgumentException("Operador inválido.");
        return calcular.calcular(valor1, valor2);
    }
}
