package trabalho;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class JogoHeroisMarvel extends JogoSuperTrunfo {
    private ArrayList<CartaHeroisMarvel> cartas;
    private ArrayList<CartaHeroisMarvel> mesa;
    public int atributoEscolhido;

    public JogoHeroisMarvel(Jogador jogador1, Jogador jogador2) {
        super(jogador1, jogador2);
        carregarCartas();
        embaralhar();
        distribuir();
    }

    public ArrayList<CartaHeroisMarvel> getCartas() {
        return this.cartas;
    }

    public void setCartas(ArrayList<CartaHeroisMarvel> cartas) {
        this.cartas = cartas;
    }

    public ArrayList<CartaHeroisMarvel> getMesa() {
        return this.mesa;
    }

    public void setMesa(ArrayList<CartaHeroisMarvel> mesa) {
        this.mesa = mesa;
    }

    @Override
    public void embaralhar() {
        Collections.shuffle(this.getCartas());
    }

    @Override
    public void distribuir() {
        var cartasJogador1 = new ArrayList<CartaHeroisMarvel>();
        var cartasJogador2 = new ArrayList<CartaHeroisMarvel>();

        while (this.cartas.size() > 0) {
            cartasJogador1.add(this.cartas.remove(0));
            cartasJogador2.add(this.cartas.remove(0));
        }

        this.jogador1.setCartasHerois(cartasJogador1);
        this.jogador2.setCartasHerois(cartasJogador2);
    }

    @Override
    public void carregarCartas() {
        try {
            var cartas = new ArrayList<CartaHeroisMarvel>();

            var arquivo = new FileReader("C:\\cartas\\marvel.txt");

            var buffer = new BufferedReader(arquivo);

            while (buffer.ready()) {
                var arrayCarta = buffer.readLine().split("//");

                String nome = arrayCarta[0];
                String identificador = arrayCarta[1];
                boolean trunfo = Boolean.parseBoolean(arrayCarta[2]);
                int altura = Integer.parseInt(arrayCarta[3]);
                int inteligencia = Integer.parseInt(arrayCarta[4]);
                int forca = Integer.parseInt(arrayCarta[5]);
                int velocidade = Integer.parseInt(arrayCarta[6]);
                int habilidade = Integer.parseInt(arrayCarta[7]);

                var carta = new CartaHeroisMarvel(nome, identificador, trunfo,
                        altura, inteligencia, forca, velocidade, habilidade);

                cartas.add(carta);
            }

            this.setCartas(cartas);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int vencedor() {
        return jogador1.getVitorias() > jogador2.getVitorias() ? 1 : jogador1.getVitorias() < jogador2.getVitorias() ? 2 : 0;
    }

    public void gravarLogJogo() throws IOException {
        var buffer = new BufferedWriter(new FileWriter("C:\\logJogos\\logJogos.txt", true));
        Jogador vencedor = null;

        switch (this.vencedor()) {
            case 1:
                vencedor = this.jogador1;
                break;
            case 2:
                vencedor = this.jogador2;
                break;
        }

        buffer.write("Herois J1: " + this.jogador1.getNome() +
                " J2: " + this.jogador2.getNome() +
                " V: " + vencedor.getNome() +
                " D/H: " + new Date());

        buffer.newLine();

        buffer.close();
    }
}
