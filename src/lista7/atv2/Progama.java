package lista7.atv2;

import java.util.ArrayList;
import java.util.Scanner;

public class Progama {
    public static void main(String[] args) {
        var s = new Scanner(System.in);

        var cilindros = new ArrayList<Cilindro>();
        var cones = new ArrayList<Cone>();
        var piramides = new ArrayList<Piramide>();

        var menuClindro = new MenuCilindro();
        var menuCone = new MenuCone();
        var menuPiramide = new MenuPiramide();

        var opcao = "";

        do {
            System.out.println("1 - Menu cilindro" +
                    "\n2 - Menu cone" +
                    "\n3 - Menu pirâmide" +
                    "\n0 - Sair" +
                    "\nEscolha a opção: ");

            opcao = s.next();

            switch (opcao) {
                case "1":
                    menuClindro.MenuCilindro(cilindros);
                    break;
                case "2":
                    menuCone.MenuCone(cones);
                    break;
                case "3":
                    menuPiramide.MenuPiramide(piramides);
                    break;
            }
        } while (!opcao.equals("0"));
    }
}
