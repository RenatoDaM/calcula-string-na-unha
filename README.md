# calcula-string-na-unha
É uma API que recebe uma expressão em formato de String e a calcula retornando um Double. Tentei aplicar o Design Pattern Strategy
Obviamente já existem diversas bibliotecas mais completas que facilitariam, porém acabei me desafiando nisso.
Por enquanto só é compatível com operação entre dois números.
Primeiramente recebo a string e tento tratá-la, retirando espaços e definindo um sinal de "+" caso o primeiro número seja positivo porém sem sinal. Após alguns 
tratamentos básicos crio duas listas, listaOperadores e listaNumeros.
Adiciono os números e os operadores às suas listas respectivas e então calculo.
Possivelmente a forma que encontraria seguindo essa lógica para aplicar a hierarquia das operações, seria organizar as listas também em hierarquia e após realizar
o cálculo colocá-lo na lista.
