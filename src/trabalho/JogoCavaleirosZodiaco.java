package trabalho;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class JogoCavaleirosZodiaco extends JogoSuperTrunfo {
    private ArrayList<CartaCavaleirosZodiaco> cartas;
    private ArrayList<CartaCavaleirosZodiaco> mesa;
    public int atributoEscolhido;

    public JogoCavaleirosZodiaco(Jogador jogador1, Jogador jogador2) {
        super(jogador1, jogador2);
        carregarCartas();
        embaralhar();
        distribuir();
    }

    public ArrayList<CartaCavaleirosZodiaco> getCartas() {
        return this.cartas;
    }

    public void setCartas(ArrayList<CartaCavaleirosZodiaco> cartas) {
        this.cartas = cartas;
    }

    public ArrayList<CartaCavaleirosZodiaco> getMesa() {
        return this.mesa;
    }

    public void setMesa(ArrayList<CartaCavaleirosZodiaco> mesa) {
        this.mesa = mesa;
    }

    @Override
    public void embaralhar() {
        Collections.shuffle(this.getCartas());
    }

    @Override
    public void distribuir() {
        var cartasJogador1 = new ArrayList<CartaCavaleirosZodiaco>();
        var cartasJogador2 = new ArrayList<CartaCavaleirosZodiaco>();

        while (this.cartas.size() > 0) {
            cartasJogador1.add(this.cartas.remove(0));
            cartasJogador2.add(this.cartas.remove(0));
        }

        this.jogador1.setCartas(cartasJogador1);
        this.jogador2.setCartas(cartasJogador2);
    }

    @Override
    public void carregarCartas() {
        try {
            var cartas = new ArrayList<CartaCavaleirosZodiaco>();

            var arquivo = new FileReader("C:\\cartas\\cavZod.txt");

            var buffer = new BufferedReader(arquivo);

            while (buffer.ready()) {
                var arrayCarta = buffer.readLine().split("//");

                String nome = arrayCarta[0];
                String identificador = arrayCarta[1];
                boolean trunfo = Boolean.parseBoolean(arrayCarta[2]);
                int soco = Integer.parseInt(arrayCarta[3]);
                int chute = Integer.parseInt(arrayCarta[4]);
                int tecnica = Integer.parseInt(arrayCarta[5]);
                int conhecimentos = Integer.parseInt(arrayCarta[6]);
                int forca = Integer.parseInt(arrayCarta[7]);

                var carta = new CartaCavaleirosZodiaco(nome, identificador, trunfo,
                        soco, chute, tecnica, conhecimentos, forca);

                cartas.add(carta);
            }

            this.setCartas(cartas);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
