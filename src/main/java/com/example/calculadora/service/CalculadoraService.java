package com.example.calculadora.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CalculadoraService {
    /*
    %2B = +
    */
    public Double calcular(String equacao) throws Exception {
        String resultadoEmString = equacao.replace("%2B", "+");
        Pattern pattern = Pattern.compile("(\\d+)([-+*/])?");
        Matcher matcher = pattern.matcher(resultadoEmString);
        List<Double> numberList = new ArrayList<>();
        Optional<String> operator = Optional.ofNullable(null);

        int index = 0;
        // O programa ainda não respeita a ordem das operações, ele é funcional apenas para realizar
        // uma operação entre dois números.
        while (matcher.find()) {
            numberList.add(Double.parseDouble(matcher.group(1)));
            if (index == 0) operator = Optional.ofNullable(matcher.group(2));
            index++;
        }

        return aplicarOperacaoEntreDoisNumeros(operator, numberList);

    }

    private Double aplicarOperacaoEntreDoisNumeros(Optional<String> operador, List<Double> listaNumero) throws Exception {
        if (operador.isEmpty()) throw new Exception("Não foi possível compreender o operador");
        if (operador.get().equals("+")) {
            return listaNumero.get(0) + listaNumero.get(1);
        } else if (operador.get().equals("-")) {
            return listaNumero.get(0) - listaNumero.get(1);
        } else if (operador.get().equals("*")) {
            return listaNumero.get(0) * listaNumero.get(1);
        } else {
            return listaNumero.get(0) / listaNumero.get(1);
        }
    }
}
