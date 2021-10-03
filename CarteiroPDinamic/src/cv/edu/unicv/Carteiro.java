package cv.edu.unicv;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Simao Moreno
 * Este algoritmo calcula a capacidade maxima da carrinha usando a programacao
 * dinamica, mas criei um algoritmo secundario com complexidade exponencial O(2^n) --> ma pratica
 * para calcular a capacidade maxima usando recursividade, em anexo
 */
public class Carteiro {
    
    // dp[i][j] ira armazenar true se capac j é possível com 
    // elementos de matriz de 0 a i 
    static boolean[][] dp; 
    
    static void maxPeso(ArrayList<Integer> arr){
        
        int capac = 0;
        
        for (int peso: arr){
            capac += peso;
        }
        
        System.out.println(capac);
    }
       
    // Uma função recursiva para imprimir todos os subconjuntos 
    // com a ajuda de dp[][].  O vetor p[] armazena o subconjunto atual.
    static void printSubconjRec(int arr[], int i, int capac, 
            ArrayList<Integer> p) { 
        
        // Se chegamos ao final e a soma é diferente de zero. 
        // Imprimimos p[] apenas se arr[0] for igual a soma ou 
        // dp[0][capac] for verdadeiro.
        if (i == 0 && capac != 0 && dp[0][capac]) { 
            p.add(arr[i]);
            maxPeso(p);
            p.clear(); 
            return; 
        } else if (i == 0 && capac == 0) { 
            maxPeso(p);
            p.clear(); 
            return; 
        } 
       
        // Se determinada soma pode ser alcançada após 
        // ignorar o elemento atual. 
        if (dp[i-1][capac]) { 
            
            ArrayList<Integer> b = new ArrayList<>();   // Crie um novo vetor para armazenar o caminho
            b.addAll(p); 
            printSubconjRec(arr, i-1, capac, b); 
        } 
       
        // Se determinada soma pode ser alcançada após 
        // considerar o elemento atual.
        else if (capac >= arr[i] && dp[i-1][capac-arr[i]]) { 
            p.add(arr[i]); 
            printSubconjRec(arr, i-1, capac-arr[i], p); 
        } 
    } 
       
    // Imprime todos os subconjuntos de pesos [0..n-1] com a capacidade 0.
    static void imprimirTodosSubconj(int pesos[], int n_sacos, int capac) { 
       
        dp = new boolean[n_sacos][capac + 1]; 
        
        for (int i=0; i<n_sacos; ++i)
            dp[i][0] = true;   
       
        // a capacidade pode ser alcancado com um unico saco
        // Soma pesos[0] pode ser alcançado com um único elemento
        if (pesos[0] <= capac) 
           dp[0][pesos[0]] = true; 
       
        // Preencha o restante das entradas em dp[][] 
        for (int i = 1; i < n_sacos; ++i) 
            for (int j = 0; j < capac + 1; ++j) 
                dp[i][j] = (pesos[i] <= j) 
                        ? (dp[i-1][j] || dp[i-1][j-pesos[i]])
                        : dp[i - 1][j]; 
        
        // se não é possivel obter subconjuntos com soma igual a capac
        // tentar obter para capac-1
        if (dp[n_sacos-1][capac] == false) { 
//            System.out.println("Não há subconjuntos com soma "+ capac); 
            imprimirTodosSubconj(pesos, n_sacos, capac-1);
            return; 
        } 
       
        // agora, percorremos dp[][] recursivamente para encontrar 
        // todos os caminhos de dp[n_sacos-1][capac] 
        ArrayList<Integer> p = new ArrayList<>(); 
        printSubconjRec(pesos, n_sacos-1, capac, p); 
    }
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        int s = 0, c = 0;
        int pesos[];
        
        while(s<1 || s>5000){
            s = in.nextInt();
        }
        
        pesos = new int[s];
        
        while(c<1 || c>10000){
            c = in.nextInt();
        }
        
        for (int i = 0; i < s; i++) {
            pesos[i] = in.nextInt();
            if(pesos[i] <1 || pesos[i]>500) {
                i--;  
            }
        }
        
        imprimirTodosSubconj(pesos, s, c); 
    }
}
