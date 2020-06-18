package lista7.atv2;


import java.util.ArrayList;
import java.util.Scanner;

public class MenuCilindro {
    public void MenuCilindro(ArrayList<Cilindro> cilindros) {
        var s = new Scanner(System.in);

        var opcao = "";

        do {
            System.out.println("1 - Cadastrar novo cilindro" +
                    "\n2 - Listar cilindros" +
                    "\n3 - Editar cilindro" +
                    "\n4 - Excluir cilindro" +
                    "\n0 - Voltar");

            opcao = s.next();

            switch (opcao) {
                case "1":
                    var cilindro = cadastrarCilindro();
                    cilindros.add(cilindro);
                    break;
                case "2":
                    if (cilindros.isEmpty()) {
                        System.out.println("Nenhum cilindro cadastrado");
                        break;
                    }
                    listarCilindros(cilindros);
                    break;
                case "3":
                    if (cilindros.isEmpty()) {
                        System.out.println("Nenhum cilindro cadastrado");
                        break;
                    } else {
                        listarCilindros(cilindros);
                        System.out.println("Insira o código do cilindro: ");
                        var codigoDoCilindro = s.nextInt();
                        var cilindroParaEdicao = cilindros.get(codigoDoCilindro);
                        cilindros.set(codigoDoCilindro, editarCilindro(cilindroParaEdicao));
                    }
                    break;
                case "4":
                    if (cilindros.isEmpty()) {
                        System.out.println("Nenhum cilindro cadastrado");
                        break;
                    } else {
                        listarCilindros(cilindros);
                        System.out.println("Insira o código do cilindro: ");
                        var codigoDoCilindro = s.nextInt();
                        cilindros.remove(codigoDoCilindro);
                    }
                    break;
            }

        } while (!opcao.equals("0"));
    }

    static Cilindro cadastrarCilindro() {
        var s = new Scanner(System.in);

        System.out.println("Insira o raio:");
        var raio = s.nextDouble();

        System.out.println("Insira a altura:");
        var altura = s.nextDouble();

        return new Cilindro(raio, altura);
    }

    static void listarCilindros(ArrayList<Cilindro> cilindros) {
        for (int i = 0; i < cilindros.size(); i++) {
            var cilindro = cilindros.get(i);

            System.out.printf("Código: %d\nRaio: %.2f\nAltura: %.2f\nValume: %.2f\n\n",
                    i, cilindro.getRaio(), cilindro.getAltura(), cilindro.calculaVolume());
        }
    }

    static Cilindro editarCilindro(Cilindro cilindro) {
        var s = new Scanner(System.in);

        System.out.println("Insira o raio:");
        var raio = s.nextDouble();

        System.out.println("Insira a altura:");
        var altura = s.nextDouble();

        cilindro.setRaio(raio);
        cilindro.setAltura(altura);

        return cilindro;
    }
}



