package lista3.atv1;

import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
    public void listarCarros(ArrayList<Carro> carros) {

        var codigo = 0;

        for (var carro : carros) {
            System.out.println("Código: " + codigo + "\n" + carro.mostrarDados() + "\n");
            codigo++;
        }
    }

    public Carro cadastrarCarro(Scanner s) {
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

    public void menuCarro(Carro carro, Scanner s) {
        var opcao = "0";

        do {
            System.out.println(
                    "1 - Mostrar dados" +
                            "\n2 - Pintar" +
                            "\n3 - Ligar" +
                            "\n4 - Desligar" +
                            "\n5 - Aumentar marcha" +
                            "\n6 - Diminuir marcha" +
                            "\n7 - Acelerar" +
                            "\n8 - Frear" +
                            "\n0 - Voltar" +
                            "\nEscolha uma opção:");

            opcao = s.next();

            switch (opcao) {
                case "1":
                    if (carro == null) {
                        System.out.println("Nenhum carro cadastrado");
                        break;
                    }
                    System.out.println("Dados do carro");

                    System.out.println(carro.mostrarDados());

                    break;

                case "2":
                    if (carro == null) {
                        System.out.println("Nenhum carro cadastrado");
                        break;
                    }
                    System.out.println("Pintar carro\n" +
                            "Insira a nova cor: ");

                    String novaCor = s.next();

                    carro.pintar(novaCor);
                    break;
                case "3":
                    if (carro == null) {
                        System.out.println("Nenhum carro cadastrado");
                        break;
                    }

                    System.out.println("Carro ligado");

                    carro.ligar();

                    break;
                case "4":
                    if (carro == null) {
                        System.out.println("Nenhum carro cadastrado");
                        break;
                    }

                    System.out.println("Carro desligado");

                    carro.desligar();

                    break;
                case "5":
                    if (carro == null) {
                        System.out.println("Nenhum carro cadastrado");
                        break;
                    }

                    System.out.println("Marcha aumentada");

                    carro.aumentarMarcha();

                    break;
                case "6":
                    if (carro == null) {
                        System.out.println("Nenhum carro cadastrado");
                        break;
                    }

                    System.out.println("Marcha diminuida");

                    carro.diminuirMarcha();

                    break;
                case "7":
                    if (carro == null) {
                        System.out.println("Nenhum carro cadastrado");
                        break;
                    }

                    System.out.println("Acelerar");

                    System.out.println("Insira a quantidade que deseja acelerar: ");

                    int velocidade = s.nextInt();

                    carro.acelerar(velocidade);

                    break;
                case "8":
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
}
