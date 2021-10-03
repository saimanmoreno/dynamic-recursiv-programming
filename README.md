# Solving the Salesman Problem using Dynamic and Recursive Programming

# O Carteiro 
O Carteiro Paulo vai todos os dias de manhã distribuir o correio na sua 
carrinha vermelha. A carrinha do Paulo tem uma capacidade limitada e por vezes os sacos de 
correio ultrapassam o limite de carga. Quando isso acontece, o Paulo quer 
encher o máximo possível a sua carrinha, levando tanto peso quanto possível. 
No entanto, o Paulo não pode retirar cartas e encomendas de um saco para 
outro e apenas pode decidir se um determinado saco vai ou não ser 
transportado na carrinha.


Imagina por exemplo que o Paulo tinha no correio 4 sacos com os pesos de 
4Kg, 5Kg, 7Kg e 8Kg. Se a capacidade de carga é de 10Kg de correio, qual é 
o máximo peso de correio que o Paulo consegue levar numa viagem? Neste 
caso, o melhor que consegue fazer é levar 9Kg, que correspondem a 
transportar os dois sacos de 4Kg e 5Kg. E no caso geral? Tens de ajudar o 
Paulo!


# O Problema
Dado um conjunto de sacos de correio e os seus respectivos pesos, bem como 
o limite de carga da carrinha vermelha do Paulo, a tua tarefa é calcular o 
máximo peso que o Paulo consegue levar na carrinha, sabendo que um saco de 
correio não poder ser dividido (ou é transportado na carrinha ou fica na 
estação de correios).


# Input
Como dados de entrada temos dois inteiros S e C, sendo que S indica o 
número de sacos de correio e C indica a capacidade de carga máxima da 
carrinha (1 ≤ S ≤ 5000, 1 ≤ C ≤ 10000).


Seguem-se exactamente S linhas, cada uma contendo um número inteiro 
contendo o peso Pi de um saco de correio (1 ≤ Pi ≤ 500). Os sacos podem vir 
em qualquer ordem e podem existir vários sacos com o mesmo peso.


# Output
O output é constituído uma única linha, indicando o peso máximo que a 
carrinha consegue transportar, ou seja, qual a maior soma de pesos de um 
conjunto de sacos de correio que é menor ou igual à capacidade de carga de 
carrinha.


# Exemplo de Input 1
4 10 </br>
4 </br>
5 </br>
7 </br>
8 </br>


# Exemplo de Output 1
9 </br>

# Exemplo de Input 2
6 15 </br>
10 </br>
2 </br>
4 </br>
2 </br>
1 </br>
1 </br>

# Exemplo de Output 2
15
