# calcula-string-na-unha
É uma API que recebe uma expressão em formato de String e a calcula retornando um Double. Tentei aplicar o Design Pattern Strategy.<br/>
Obviamente já existem diversas bibliotecas mais completas que facilitariam, porém acabei me desafiando nisso.<br/>
Por enquanto só é compatível com operação entre dois números.<br/>
Primeiramente recebo a string e tento tratá-la, retirando espaços e definindo um sinal de "+" caso o primeiro número seja positivo porém sem sinal. Após alguns tratamentos básicos crio duas listas, listaOperadores e listaNumeros, e então adiciono os números e os operadores às suas listas respectivas para realizar o cálculo.<br/>
Possivelmente para aplicar a hierarquia das operações a forma que encontraria seguindo essa lógica seria organizar as listas também em ordem de hierarquia, e logo após realizar o cálculo, colocá-lo na lista (o resultado).
