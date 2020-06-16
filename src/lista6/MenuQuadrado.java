package lista6;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuQuadrado {
    public void menuQuadrado(ArrayList<Quadrado> quadrados) {
        var s = new Scanner(System.in);
        var opcao = "";

        do {

            System.out.println("1 - Visualizar quadrados" +
                    "\n2 - Cadastrar quadrado" +
                    "\n3 - Editar quadrado" +
                    "\n4 - Deletar quadrado" +
                    "\n0 - Voltar");

            opcao = s.next();

            switch (opcao) {
                case "1":
                    if (quadrados.isEmpty()) {
                        System.out.println("Nenhum círculo cadastrado");
                    } else {
                        visualizarQuadrados(quadrados);
                    }
                    break;
                case "2":
                    var novoQuadrado = cadastrarQuadrado();
                    quadrados.add(novoQuadrado);
                    break;
                case "3":
                    if (quadrados.isEmpty()) {
                        System.out.println("Nenhum quadrado cadastrado");
                    } else {
                        visualizarQuadrados(quadrados);
                        System.out.println("Insira o código do quadrado que deseja editar: ");
                        var codigoDoTitulo = s.nextInt();
                        editarQuadrado(quadrados.get(codigoDoTitulo));
                    }
                    break;
                case "4":
                    if (quadrados.isEmpty()) {
                        System.out.println("Nenhum quadrado cadastrado");
                    } else {
                        visualizarQuadrados(quadrados);
                        System.out.println("Insira o código do quadrado que deseja deletar: ");
                        var codigoDoTitulo = s.nextInt();
                        quadrados.remove(codigoDoTitulo);
                    }
            }
        } while (!opcao.equals("0"));
    }

    static Quadrado cadastrarQuadrado() {
        var s = new Scanner(System.in);

        System.out.println("Insira o lados: ");
        var lado = s.nextDouble();

        return new Quadrado(lado);
    }

    static void editarQuadrado(Quadrado quadrado) {
        var s = new Scanner(System.in);

        System.out.println("Insira o lado: ");
        var lado = s.nextDouble();

        quadrado.setLado(lado);
    }

    static void visualizarQuadrados(ArrayList<Quadrado> quadrados) {
        for (int i = 0; i < quadrados.size(); i++) {
            var quadrado = quadrados.get(i);

            System.out.printf("Código: %d \nLado: %.2f \nÁrea: %.2f\nPerimêtro: %.2f \n\n",
                    i, quadrado.getLado(), quadrado.area(), quadrado.perimetro());
        }
    }
}
