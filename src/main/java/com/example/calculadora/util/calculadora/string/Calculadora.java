package com.example.calculadora.util.calculadora.string;

import com.example.calculadora.exception.OperadorInvalidoException;
import com.example.calculadora.util.calculadora.string.operacoes.*;

import java.util.*;
import java.util.regex.Pattern;

public class Calculadora {
    Map<String, OperacaoStrategy> relacaoOperadorOperacao = new HashMap<>();

    public Calculadora(){

    }

    public Calculadora(String novoOperador, OperacaoStrategy novaOperacao) {
        relacaoOperadorOperacao.put(novoOperador, novaOperacao);
    }

    // O programa ainda não respeita a ordem das operações, ele é funcional apenas para realizar
    // uma operação básica entre dois números.
    public Double calcular(String equacao) throws OperadorInvalidoException {
        var expressao = equacao.replace("%2B", "+");
        expressao = expressao.trim();

        // Insere um sinal positivo no primeiro número caso ele seja positivo e já não possua um sinal de +
        if (Character.isDigit(expressao.charAt(0))) {
            expressao = "+" + expressao;
        }

        List<Double> numberList = extrairNumeros(expressao);
        List<Optional<String>> operatorsList = extrairOperadores(expressao);

        // Verifica se o primeiro número da string é negativo
        if (operatorsList.get(0).get().equals("-")) {
            numberList.set(0, numberList.get(0) * -1);
        }

        // É possível que a expansão desse aplicativo seja quebrando uma
        // equação em várias operações menores, possivelmente ordenando em uma lista.
        return aplicarOperacoesEntreListas(operatorsList, numberList);
    }

    private Double aplicarOperacoesEntreListas(List<Optional<String>> operador, List<Double> listaNumero) throws OperadorInvalidoException {
        if (operador.isEmpty()) throw new OperadorInvalidoException("Operador não reconhecido");
        if (listaNumero.size() <= 1 || listaNumero.size() > 2) throw new OperadorInvalidoException("Não foi possível encontrar 2 números válidos apenas");
        if (operador.size() > 2) throw new OperadorInvalidoException("Foi encontrada uma operação inválida");
        return aplicarOperacao(listaNumero.get(0), operador.get(1).get(), listaNumero.get(1));
    }


    public Double aplicarOperacao(Double valor1, String operador2, Double valor2) {
        EnumOperacao calcular = EnumOperacao.informarOperadorParaCalcular(operador2);
        if (calcular == null) throw new IllegalArgumentException("Operador inválido.");
        return calcular.calcular(valor1, valor2);
    }

    private List<Double> extrairNumeros(String equacao) {
        var pattern = Pattern.compile("(\\d+)");
        var matcher = pattern.matcher(equacao);
        List<Double> numeros = new ArrayList<>();

        while (matcher.find()) {
            numeros.add(Double.parseDouble(Optional.ofNullable(matcher.group()).get()));
        }

        return numeros;
    }

    private List<Optional<String>> extrairOperadores(String equacao) {
        var pattern = Pattern.compile("([-+*/])");
        var matcher = pattern.matcher(equacao);
        List<Optional<String>> operadores = new ArrayList<>();

        while (matcher.find()) {
            operadores.add(Optional.ofNullable(matcher.group()));
        }

        return operadores;
    }
}
