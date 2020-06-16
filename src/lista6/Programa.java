package lista6;

import java.util.ArrayList;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        var s = new Scanner(System.in);

        var quadrados = new ArrayList<Quadrado>();
        var circulos = new ArrayList<Circulo>();
        var retangulos = new ArrayList<Retangulo>();

        var menuCirculo = new MenuCirculo();
        var menuQuadrado = new MenuQuadrado();
        var menuRetangulo = new MenuRetangulo();

        var opcao = "";

        do {
            System.out.println("1 - Menu círculo" +
                    "\n2 - Menu quadrado" +
                    "\n3 - Menu retângulo" +
                    "\n0 - Sair" +
                    "\nEscolha a opção:");

            opcao = s.next();

            switch (opcao) {
                case "1":
                    menuCirculo.menuCirculo(circulos);
                    break;
                case "2":
                    menuQuadrado.menuQuadrado(quadrados);
                    break;
                case "3":
                    menuRetangulo.menuRetangulo(retangulos);
                    break;
            }

        } while (!opcao.equals("0"));
    }
}
