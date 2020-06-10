package lista3.atv1;

import java.util.ArrayList;

public class Programa {
    public static void main(String[] args) {

        ArrayList<Carro> carros = new ArrayList<>();

        for (Carro carro : carros) {
            System.out.println(carro.marca);
        }

        System.out.println(carros.get(2).marca);

    }
}
