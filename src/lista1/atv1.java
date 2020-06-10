// Criar uma calculadora utilizando estrutura de
// repetição com teste no final (do ... while) e
// estrutura de escolha (switch case), com as opções
// somar, subtrair, multiplicar e dividir. Você deve ler
// dois valores reais, a e b, logo em seguida o usuário
// escolherá a operação. Ao final, será realizada uma
// pergunta se o usuário quer continuar realizando
// cálculos ou finalizar a calculadora.

package lista1;

import java.util.Scanner;

public class atv1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Double a = 0.00, b = 0.00;

        String opcao = "0";

        do {
            System.out.println("Calculadora" +
                    "\n1 - Somar " +
                    "\n2 - Subtrair" +
                    "\n3 - Multiplicar" +
                    "\n4 - Dividir" +
                    "\n0 - Sair" +
                    "\nEscolha uma opção:");

            opcao = s.next();

            switch (opcao) {
                case "1":
                    System.out.println("SOMA");

                    System.out.println("Insira o primeiro número:");
                    a = s.nextDouble();

                    System.out.println("Insira o segundo número:");
                    b = s.nextDouble();

                    System.out.printf("Total: %.2f \n", Somar(a, b));
                    break;
                case "2":
                    System.out.println("SUBTRAÇÃO");

                    System.out.println("Insira o primeiro número:");
                    a = s.nextDouble();

                    System.out.println("Insira o segundo número:");
                    b = s.nextDouble();

                    System.out.printf("Total: %.2f \n", Subtrair(a, b));
                    break;
                case "3":
                    System.out.println("MULTIPLICAÇÃO");

                    System.out.println("Insira o primeiro número:");
                    a = s.nextDouble();

                    System.out.println("Insira o segundo número:");
                    b = s.nextDouble();

                    System.out.printf("Total: %.2f \n", Multiplicar(a, b));
                    break;
                case "4":
                    System.out.println("DIVISÃO");

                    System.out.println("Insira o primeiro número:");
                    a = s.nextDouble();

                    System.out.println("Insira o segundo número:");
                    b = s.nextDouble();

                    System.out.printf("Total: %.2f \n", Dividir(a, b));
                    break;
            }
        } while (!opcao.equals("0"));
    }

    public static double Somar(double a, double b) {
        return a + b;
    }

    public static double Dividir(double a, double b) {
        if (b == 0)
            return 0;

        return a / b;
    }

    public static double Subtrair(double a, double b) {
        return a - b;
    }

    public static double Multiplicar(double a, double b) {
        return a * b;
    }
}
