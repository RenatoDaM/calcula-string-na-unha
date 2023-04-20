package com.example.calculadora.service;

import com.example.calculadora.exception.OperadorInvalidoException;
import com.example.calculadora.util.calculadora.string.Calculadora;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.regex.Pattern;

@Service
public class CalculadoraService {
    /*
    %2B = +
    */
    public Double calcularEntreDoisNumeros(String equacao) throws Exception {
        var resultadoEmString = equacao.replace("%2B", "+");
        resultadoEmString = resultadoEmString.trim();
        System.out.println(resultadoEmString);


        var verificarSinalDoPrimeiro = Pattern.compile("^[0-9]");
        var matcherVerificarSinal = verificarSinalDoPrimeiro.matcher(resultadoEmString);
        if (matcherVerificarSinal.find()) {
            StringBuilder builder = new StringBuilder(resultadoEmString);
            builder.insert(0, "+");
            resultadoEmString = builder.toString();
        }

        var patternOperador = Pattern.compile("([-+*/])");
        var patternNumero = Pattern.compile("(\\d+)");
        var matcherOperador = patternOperador.matcher(resultadoEmString);
        var matcherNumero = patternNumero.matcher(resultadoEmString);
        List<Double> numberList = new ArrayList<>();
        List<Optional<String>> operatorsList = new ArrayList<>();


        // O programa ainda não respeita a ordem das operações, ele é funcional apenas para realizar
        // uma operação básica entre dois números.
        while (matcherNumero.find()) {
            numberList.add(Double.parseDouble(Optional.ofNullable(matcherNumero.group()).get()));
        }

        boolean isFirstIteration = true;
        while (matcherOperador.find()) {

            if (matcherOperador.group().equals("-") && isFirstIteration) {
                System.out.println("trueeee");
                numberList.set(0, numberList.get(0) - numberList.get(0)*2);
            }
            isFirstIteration = false;
            operatorsList.add(Optional.ofNullable(matcherOperador.group()));

        }

        // É possível que a expansão desse aplicativo seja ainda usando o Calculadora.calcular, quebrando uma
        // equação em várias operações menores, após a quebra e ordenação irá chamar Calculadora.calcular.

        return aplicarOperacaoEntreDoisNumeros(operatorsList, numberList);

    }

    private Double aplicarOperacaoEntreDoisNumeros(List<Optional<String>> operador, List<Double> listaNumero) throws OperadorInvalidoException {
        if (operador.isEmpty()) throw new OperadorInvalidoException("Operador não reconhecido");
        if (listaNumero.size() <= 1 || listaNumero.size() > 2) throw new OperadorInvalidoException("Não foi possível encontrar 2 números válidos apenas");
        if (operador.size() > 2) throw new OperadorInvalidoException("Foi encontrada uma operação inválida");
        var calculadora = new Calculadora();
        return calculadora.calcular(listaNumero.get(0), operador.get(1).get(), listaNumero.get(1));
    }
}
