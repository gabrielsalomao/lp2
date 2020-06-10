// Faça um programa onde o usuário escolhe a quantidade
// de linhas e colunas de uma matriz. Logo em seguida, crie a matriz,
// preencha e mostre a soma de todas as linhas (uma por vez) e de
// todas as colunas (uma por vez).

package lista1;

import java.util.Scanner;

public class atv3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Insira a quantidade de linhas do vetor: ");
        int linha = s.nextInt();

        System.out.println("Insira a quantidade de colunas do vetor: ");
        int coluna = s.nextInt();

        int[][] matriz = new int[linha][coluna];

        for (int l = 0; l < matriz.length; l++) {
            for (int c = 0; c < matriz[l].length; c++) {
                matriz[l][c] = s.nextInt();
            }
        }

        for (int l = 0; l < matriz.length; l++) {
            for (int c = 0; c < matriz[l].length; c++) {
                System.out.print(matriz[l][c] + " ");
            }
            System.out.printf("\n");
        }

        int[] vetorSomaDasColunas = ObterSomaDasColunasDaMatriz(matriz);
        int[] vetorSomaDasLinhas = ObterSomaDasLinhasDaMatriz(matriz);

        System.out.println("Soma das linhas:");
        for (int i = 0; i < vetorSomaDasLinhas.length; i++) {
            System.out.printf("%d - linha %d\n", i + 1, vetorSomaDasLinhas[i]);
        }

        System.out.println("Soma das colunas:");
        for (int i = 0; i < vetorSomaDasColunas.length; i++) {
            System.out.printf("%d - coluna %d\n", i + 1, vetorSomaDasColunas[i]);
        }
    }

    public static int[] ObterSomaDasColunasDaMatriz(int[][] vetor) {
        int quantidadeDeColunas = vetor[0].length;

        int vetorDaSomaDasColunas[] = new int[quantidadeDeColunas];

        for (int l = 0; l < vetor.length; l++) {
            for (int c = 0; c < vetor[l].length; c++) {
                vetorDaSomaDasColunas[c] += vetor[l][c];
            }
        }

        return vetorDaSomaDasColunas;
    }

    public static int[] ObterSomaDasLinhasDaMatriz(int[][] vetor) {
        int quantidadeDeLinhas = vetor.length;

        int vetorDaSomaDasLinhas[] = new int[quantidadeDeLinhas];

        for (int l = 0; l < vetor.length; l++) {
            for (int c = 0; c < vetor[l].length; c++) {
                vetorDaSomaDasLinhas[l] += vetor[l][c];
            }
        }

        return vetorDaSomaDasLinhas;
    }
}
