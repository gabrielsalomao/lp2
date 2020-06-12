package lista3.atv1;

import java.util.ArrayList;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {

        var utils = new Utils();

        Scanner s = new Scanner(System.in);

        var carros = new ArrayList<Carro>();

        var opcao = "0";

        do {
            System.out.println("1 - Visualizar todos carros\n" +
                    "2 - Adicionar um carro\n" +
                    "3 - Selecionar um carro\n" +
                    "4 - Excluir um carro\n" +
                    "Escola a opção:");

            opcao = s.next();
            switch (opcao) {
                case "1":
                    if (carros.isEmpty()) {
                        System.out.println("Nenhum carro cadastrado");
                        break;
                    }
                    utils.listarCarros(carros);
                    break;
                case "2":
                    if (carros.size() >= 10) {
                        System.out.println("Quantidade máxima de carros cadastrado");
                        break;
                    }
                    var carro = utils.cadastrarCarro(s);
                    carros.add(carro);
                    break;
                case "3":
                    System.out.println("Insira o código do carro:");
                    int codigoDoCarro = s.nextInt();
                    utils.menuCarro(carros.get(codigoDoCarro), s);
                    break;
                case "4":
                    System.out.println("Insira o código do carro:");
                    codigoDoCarro = s.nextInt();
                    carros.remove(codigoDoCarro);
                    break;
            }

        } while (!opcao.equals("0"));
    }
}
