package lista6;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuRetangulo {
    public void menuRetangulo(ArrayList<Retangulo> retangulos) {
        var s = new Scanner(System.in);
        var opcao = "";

        do {

            System.out.println("1 - Visualizar retângulos" +
                    "\n2 - Cadastrar retângulo" +
                    "\n3 - Editar retângulo" +
                    "\n4 - Deletar retângulo" +
                    "\n0 - Voltar");

            opcao = s.next();

            switch (opcao) {
                case "1":
                    if (retangulos.isEmpty()) {
                        System.out.println("Nenhum retângulo cadastrado");
                    } else {
                        visualizarRetangulos(retangulos);
                    }
                    break;
                case "2":
                    var novoCirculo = cadastrarRetangulo();
                    retangulos.add(novoCirculo);
                    break;
                case "3":
                    if (retangulos.isEmpty()) {
                        System.out.println("Nenhum retângulo cadastrado");
                    } else {
                        visualizarRetangulos(retangulos);
                        System.out.println("Insira o código do retângulo que deseja editar: ");
                        var codigoDoTitulo = s.nextInt();
                        editarRetangulo(retangulos.get(codigoDoTitulo));
                    }
                    break;
                case "4":
                    if (retangulos.isEmpty()) {
                        System.out.println("Nenhum retângulo cadastrado");
                    } else {
                        visualizarRetangulos(retangulos);
                        System.out.println("Insira o código do retângulo que deseja deletar: ");
                        var codigoDoTitulo = s.nextInt();
                        retangulos.remove(codigoDoTitulo);
                    }
            }
        } while (!opcao.equals("0"));
    }

    static Retangulo cadastrarRetangulo() {
        var s = new Scanner(System.in);

        System.out.println("Insira a altura: ");
        var altura = s.nextDouble();

        System.out.println("Insira a base: ");
        var base = s.nextDouble();

        return new Retangulo(altura, base);
    }

    static void editarRetangulo(Retangulo retangulo) {
        var s = new Scanner(System.in);

        System.out.println("Insira a altura: ");
        var altura = s.nextDouble();

        System.out.println("Insira a base: ");
        var base = s.nextDouble();

        retangulo.setAltura(altura);
        retangulo.setBase(base);
    }

    static void visualizarRetangulos(ArrayList<Retangulo> retangulos) {
        for (int i = 0; i < retangulos.size(); i++) {
            var retangulo = retangulos.get(i);

            System.out.printf("Código: %d  \nAltura: %.2f \nBase: %.2f \nÁrea: %.2f\nPerimêtro: %.2f \n\n",
                    i, retangulo.getAltura(), retangulo.getBase(), retangulo.area(), retangulo.perimetro());
        }
    }
}
