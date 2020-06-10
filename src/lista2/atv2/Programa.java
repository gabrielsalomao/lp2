// Crie uma classe para a representação de carros, chamada Carro,
// com as informações sobre marca, modelo, cor, placa, velocidade,
// marcha e ligado. Deve conter os seguintes métodos:
//  Um método que apresenta todas as informações do carro.
//  Um método pintar(String cor), que muda a cor do carro.
//  Um método ligar(), que liga o carro.
//  Um método desligar(), que desliga o carro.
//  Um método aumentarMarcha(), que aumenta a marcha do carro.
//  Um método diminuirMarcha(), que diminui a marcha do carro.
//  Um método acelerar(int velocidade), que aumenta a velocidade do carro,
//  acrescentando a velocidade passada por parâmetro.
//  Um método frear(int velocidade), que diminua velocidade do carro,
//  subtraindo a velocidade passada por parâmetro.
//  Na classe principal, crie um carro, preencha os atributos através de
//  entradas do usuário e faça um menu, utilizando uma estrutura de
//  repetição e uma estrutura de escolha, onde seja possível manipular
//  o carro utilizando os métodos criados, assim como finalizar o programa.

package lista2.atv2;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String opcao = "0";

        Carro carro = null;

        do {
            System.out.println(
                    "1 - Cadastrar carro " +
                            "\n2 - Mostrar dados" +
                            "\n3 - Pintar" +
                            "\n4 - Ligar" +
                            "\n5 - Desligar" +
                            "\n6 - Aumentar marcha" +
                            "\n7 - Diminuir marcha" +
                            "\n8 - Acelerar" +
                            "\n9 - Frear" +
                            "\n0 - Sair" +
                            "\nEscolha uma opção:");

            opcao = s.next();

            switch (opcao) {
                case "1":
                    carro = CadastrarCarro(s);
                    System.out.println(carro.mostrarDados());
                    break;
                case "2":
                    if (carro == null) {
                        System.out.println("Nenhum carro cadastrado");
                        break;
                    }
                    System.out.println("Dados do carro");
                    System.out.println(carro.mostrarDados());
                    break;

                case "3":
                    if (carro == null) {
                        System.out.println("Nenhum carro cadastrado");
                        break;
                    }
                    System.out.println("Pintar carro\n" +
                            "Insira a nova cor: ");
                    String novaCor = s.next();
                    carro.pintar(novaCor);
                    break;
                case "4":
                    if (carro == null) {
                        System.out.println("Nenhum carro cadastrado");
                        break;
                    }
                    System.out.println("Carro ligado");
                    carro.ligar();
                    break;
                case "5":
                    if (carro == null) {
                        System.out.println("Nenhum carro cadastrado");
                        break;
                    }
                    System.out.println("Carro desligado");
                    carro.desligar();
                    break;
                case "6":
                    if (carro == null) {
                        System.out.println("Nenhum carro cadastrado");
                        break;
                    }
                    System.out.println("Marcha aumentada");
                    carro.aumentarMarcha();
                    break;
                case "7":
                    if (carro == null) {
                        System.out.println("Nenhum carro cadastrado");
                        break;
                    }
                    System.out.println("Marcha diminuida");
                    carro.diminuirMarcha();
                    break;
                case "8":
                    if (carro == null) {
                        System.out.println("Nenhum carro cadastrado");
                        break;
                    }
                    System.out.println("Acelerar");
                    System.out.println("Insira a quantidade que deseja acelerar: ");
                    int velocidade = s.nextInt();
                    carro.acelerar(velocidade);
                    break;
                case "9":
                    if (carro == null) {
                        System.out.println("Nenhum carro cadastrado");
                        break;
                    }
                    System.out.println("Frear");
                    System.out.println("Insira a quantidade que deseja frear: ");
                    velocidade = s.nextInt();
                    carro.frear(velocidade);
                    break;
            }

        } while (!opcao.equals("0"));
    }

    public static Carro CadastrarCarro(Scanner s) {
        System.out.println("Cadastro de carro");

        Carro carro = new Carro();

        System.out.println("Insira a marca:");
        carro.marca = s.next();

        System.out.println("Insira o modelo:");
        carro.modelo = s.next();

        System.out.println("Insira a cor:");
        carro.cor = s.next();

        System.out.println("Insira a placa:");
        carro.placa = s.next();

        System.out.println("Insira a velocidade:");
        carro.velocidade = s.nextInt();

        System.out.println("Insira a marcha:");
        carro.marcha = s.nextInt();

        System.out.println("Ligado?(s/n):");
        String ligado = s.next();
        carro.ligado = ligado.equals("s") ? true : false;

        return carro;
    }
}
