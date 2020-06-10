// Faça um programa onde o usuário escolherá a
// quantidade de elementos que serão armazenados
// em um vetor. Logo em seguida, crie o vetor
// preencha e apresente o maior número, sua
// frequência e as posições onde o mesmo aparece no
// vetor

package lista1;

import java.util.Arrays;
import java.util.Scanner;

public class atv2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Insira o tamanho do vetor");

        int tamanhoDoVetor = s.nextInt();

        int[] vetor = new int[tamanhoDoVetor];

        int maiorNumero = 0;

        for (int i = 0; i < vetor.length; i++) {
            if (i == 0)
                maiorNumero = vetor[i];

            if (vetor[i] > maiorNumero)
                maiorNumero = vetor[i];

            System.out.printf("Insira o valor da posição %d ", i);
            vetor[i] = s.nextInt();
        }

        String vetorEmString = String.join(", ", Arrays.toString(vetor));

        System.out.println("Vetor: " + vetorEmString);

        System.out.printf("Maior número do vetor: %d, Posição: %d", ObterMaiorNumeroDoVetor(vetor), OberPosicaoDoMaiorNumero(vetor, ObterMaiorNumeroDoVetor(vetor)));
    }

    public static int ObterMaiorNumeroDoVetor(int[] vetor) {
        int maiorNumero = 0;

        for (int i = 0; i < vetor.length; i++) {
            if (i == 0)
                maiorNumero = vetor[i];

            if (vetor[i] > maiorNumero)
                maiorNumero = vetor[i];
        }

        return maiorNumero;
    }

    public static int OberPosicaoDoMaiorNumero(int[] vetor, int maiorNumero) {
        int posicao = 0;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == maiorNumero)
                posicao = i;
        }

        return posicao;
    }
}
