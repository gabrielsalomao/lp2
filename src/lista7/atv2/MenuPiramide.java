package lista7.atv2;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPiramide {
    public void MenuPiramide(ArrayList<Piramide> piramides) {
        var s = new Scanner(System.in);

        var opcao = "";

        do {
            System.out.println("1 - Cadastrar nova pirâmide" +
                    "\n2 - Listar pirâmides" +
                    "\n3 - Editar pirâmide" +
                    "\n4 - Excluir pirâmide" +
                    "\n0 - Voltar");

            opcao = s.next();

            switch (opcao) {
                case "1":
                    var piramide = cadastrarPiramide();
                    piramides.add(piramide);
                    break;
                case "2":
                    if (piramides.isEmpty()) {
                        System.out.println("Nenhuma pirâmide cadastrado");
                        break;
                    }
                    listarPiramides(piramides);
                    break;
                case "3":
                    if (piramides.isEmpty()) {
                        System.out.println("Nenhum pirâmide cadastrado");
                        break;
                    } else {
                        listarPiramides(piramides);
                        System.out.println("Insira o código do pirâmide: ");
                        var codigoDaPiramide = s.nextInt();
                        var piramideParaEdicao = piramides.get(codigoDaPiramide);
                        piramides.set(codigoDaPiramide, editarPiramide(piramideParaEdicao));
                    }
                    break;
                case "4":
                    if (piramides.isEmpty()) {
                        System.out.println("Nenhuma piramide cadastrado");
                        break;
                    } else {
                        listarPiramides(piramides);
                        System.out.println("Insira o código da pirâmide: ");
                        var codigoDaPiramide = s.nextInt();
                        piramides.remove(codigoDaPiramide);
                    }
                    break;
            }
        } while (!opcao.equals("0"));
    }

    static Piramide cadastrarPiramide() {
        var s = new Scanner(System.in);

        System.out.println("Insira o lado:");
        var lado = s.nextDouble();

        System.out.println("Insira a altura:");
        var altura = s.nextDouble();

        return new Piramide(lado, altura);
    }

    static void listarPiramides(ArrayList<Piramide> piramides) {
        for (int i = 0; i < piramides.size(); i++) {
            var piramide = piramides.get(i);

            System.out.printf("Código: %d\nLado: %.2f\nAltura: %.2f\nValume: %.2f\n\n",
                    i, piramide.getLado(), piramide.getAltura(), piramide.calculaVolume());
        }
    }

    static Piramide editarPiramide(Piramide piramide) {
        var s = new Scanner(System.in);

        System.out.println("Insira o lado:");
        var lado = s.nextDouble();

        System.out.println("Insira a altura:");
        var altura = s.nextDouble();

        piramide.setLado(lado);
        piramide.setAltura(altura);

        return piramide;
    }
}
