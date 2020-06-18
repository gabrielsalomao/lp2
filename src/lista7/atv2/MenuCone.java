package lista7.atv2;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuCone {
    public void MenuCone(ArrayList<Cone> cones) {
        var s = new Scanner(System.in);

        var opcao = "";

        do {
            System.out.println("1 - Cadastrar novo cone" +
                    "\n2 - Listar cones" +
                    "\n3 - Editar cone" +
                    "\n4 - Excluir cone" +
                    "\n0 - Voltar");

            opcao = s.next();

            switch (opcao) {
                case "1":
                    var cone = cadastrarCone();
                    cones.add(cone);
                    break;
                case "2":
                    if (cones.isEmpty()) {
                        System.out.println("Nenhum cone cadastrado");
                        break;
                    }
                    listarCones(cones);
                    break;
                case "3":
                    if (cones.isEmpty()) {
                        System.out.println("Nenhum cone cadastrado");
                        break;
                    } else {
                        listarCones(cones);
                        System.out.println("Insira o código do cone: ");
                        var codigoDoCone = s.nextInt();
                        var coneParaEdicao = cones.get(codigoDoCone);
                        cones.set(codigoDoCone, editarCone(coneParaEdicao));
                    }
                    break;
                case "4":
                    if (cones.isEmpty()) {
                        System.out.println("Nenhum cone cadastrado");
                        break;
                    } else {
                        listarCones(cones);
                        System.out.println("Insira o código do cone: ");
                        var codigoDoCone = s.nextInt();
                        cones.remove(codigoDoCone);
                    }
                    break;
            }

        } while (!opcao.equals("0"));
    }

    static Cone cadastrarCone() {
        var s = new Scanner(System.in);

        System.out.println("Insira o raio:");
        var raio = s.nextDouble();

        System.out.println("Insira a altura:");
        var altura = s.nextDouble();

        return new Cone(raio, altura);
    }

    static void listarCones(ArrayList<Cone> cones) {
        for (int i = 0; i < cones.size(); i++) {
            var cone = cones.get(i);

            System.out.printf("Código: %d\nRaio: %.2f\nAltura: %.2f\nValume: %.2f\n\n",
                    i, cone.getRaio(), cone.getAltura(), cone.calculaVolume());
        }
    }

    static Cone editarCone(Cone cone) {
        var s = new Scanner(System.in);

        System.out.println("Insira o raio:");
        var raio = s.nextDouble();

        System.out.println("Insira a altura:");
        var altura = s.nextDouble();

        cone.setRaio(raio);
        cone.setAltura(altura);

        return cone;
    }
}
