package cv.edu.unicv;

import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author Simão Moreno
 * 
 * Este algoritmo calcula a capacidade maxima da carrinha usando a recursividade
 * com complexidade exponencial O(2^n) --> ma pratica
 * O algoritmo principal usando programacao dinamica (matrizes) esta em anexo
 */
public class Carteiro {

    public static void find(int[] A, int somatorio, int index, int sum, int[] carrinha) {

        int capac = 0;

        if (somatorio == sum) {
            // maximo encontrado
            for (int i = 0; i < carrinha.length; i++) {
                if (carrinha[i] == 1) {
//                    System.out.print(" " + A[i] + " "); se queremos ver os valores
//                    que a soma da igual a capacidade
                    capac += A[i];                          // somatorio 
                }
            }
//            System.out.println("Capacidade > " + capac);
            System.out.println(capac);
            exit(1);                                        // parar de calcular
            // usar outra forca mais bruta (exit) para encerrar um algoritmo que nunca 
            // mais para de ser executado (muito perigoso)
            
        } else if (index == A.length) {
            // fazer nada (continuar para c--)
        } else {
            carrinha[index] = 1;                            // selecionar o elemento
            somatorio += A[index];
            find(A, somatorio, index + 1, sum, carrinha);   // recursividade
            somatorio -= A[index];
            carrinha[index] = 0;                            // não selecionar o elemento
            find(A, somatorio, index + 1, sum, carrinha);
        }
        
        // se chegar aqui o algoritmo repete-se para c - 1
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int s = 0, c = 0;
        int pesos[], carrinha[];

        // 1 <= S <= 5000
        while (s < 1 || s > 5000) {
            s = in.nextInt();
        }

        pesos = new int[s];
        carrinha = new int[s];

        // 1 <= C <= 100000
        while (c < 1 || c > 10000) {
            c = in.nextInt();
        }

        // 1 <= Pi <= 500
        for (int i = 0; i < s; i++) {
            pesos[i] = in.nextInt();
            if (pesos[i] < 1 || pesos[i] > 500) {
                i--;
            }
        }

        // enquanto nao encontrar a capacidade maxima
        // forca bruta
        while (true) {
            find(pesos, 0, 0, c--, carrinha);
            // caso capacidade seja 10 e nao for possivel
            // obter esse valor com os pesos dos sacos
            // calcular para capacidade - 1, se capacidade - 1
            // tambem nao for possivel fazer para capacidade - 2
            // ---> c--
            // se c = 10 => find(pesos, 0, 0, 10, carrinha)
            // se nao encontrar o maximo igual a 10
            // c = 9 => find(pesos, 0, 0, 9, carrinha)
        }
    }
}
