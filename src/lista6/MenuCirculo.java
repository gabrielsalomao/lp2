package lista6;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuCirculo {
    public void menuCirculo(ArrayList<Circulo> circulos) {
        var s = new Scanner(System.in);
        var opcao = "";

        do {

            System.out.println("1 - Visualizar círculos" +
                    "\n2 - Cadastrar círculo" +
                    "\n3 - Editar círculo" +
                    "\n4 - Deletar círculo" +
                    "\n0 - Voltar");

            opcao = s.next();

            switch (opcao) {
                case "1":
                    if (circulos.isEmpty()) {
                        System.out.println("Nenhum círculo cadastrado");
                    } else {
                        visualizarCirculos(circulos);
                    }
                    break;
                case "2":
                    var novoCirculo = cadastrarCirculo();
                    circulos.add(novoCirculo);
                    break;
                case "3":
                    if (circulos.isEmpty()) {
                        System.out.println("Nenhum círculo cadastrado");
                    } else {
                        visualizarCirculos(circulos);
                        System.out.println("Insira o código do círculo que deseja editar: ");
                        var codigoDoTitulo = s.nextInt();
                        editarCirculo(circulos.get(codigoDoTitulo));
                    }
                    break;
                case "4":
                    if (circulos.isEmpty()) {
                        System.out.println("Nenhum círculo cadastrado");
                    } else {
                        visualizarCirculos(circulos);
                        System.out.println("Insira o código do círculo que deseja deletar: ");
                        var codigoDoTitulo = s.nextInt();
                        circulos.remove(codigoDoTitulo);
                    }
            }
        } while (!opcao.equals("0"));
    }

    static Circulo cadastrarCirculo() {
        var s = new Scanner(System.in);

        System.out.println("Insira o raio: ");
        var raio = s.nextDouble();

        return new Circulo(raio);
    }

    static void editarCirculo(Circulo circulo) {
        var s = new Scanner(System.in);

        System.out.println("Insira o raio: ");
        var raio = s.nextDouble();

        circulo.setRaio(raio);
    }

    static void visualizarCirculos(ArrayList<Circulo> circulos) {
        for (int i = 0; i < circulos.size(); i++) {
            var circulo = circulos.get(i);

            System.out.printf("Código: %d \nRaio: %.2f \nÁrea: %.2f\nPerimêtro: %.2f \n\n",
                    i, circulo.getRaio(), circulo.area(), circulo.perimetro());
        }
    }
}
