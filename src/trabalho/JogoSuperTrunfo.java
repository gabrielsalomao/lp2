package trabalho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public abstract class JogoSuperTrunfo {
    private ArrayList<CartaSuperTrunfo> cartas;
    private ArrayList<CartaSuperTrunfo> mesa;
    private Jogador jogador1;
    private Jogador jogador2;

    public JogoSuperTrunfo(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }

    public ArrayList<CartaSuperTrunfo> getCartas() {
        return this.cartas;
    }

    public void setCartas(ArrayList<CartaSuperTrunfo> cartas) {
        this.cartas = cartas;
    }

    public ArrayList<CartaSuperTrunfo> getMesa() {
        return this.mesa;
    }

    public void setMesa(ArrayList<CartaSuperTrunfo> mesa) {
        this.mesa = mesa;
    }

    public void embaralhar() {
        Collections.shuffle(this.cartas);
    }

    public void distribuir() {

        var cartasJogador1 = new ArrayList<CartaSuperTrunfo>();
        var cartasJogador2 = new ArrayList<CartaSuperTrunfo>();

        while (this.cartas.size() > 0) {
            cartasJogador1.add(this.cartas.remove(this.cartas.size()));
            cartasJogador2.add(this.cartas.remove(this.cartas.size()));
        }

        this.jogador1.setCartas(cartasJogador1);
        this.jogador2.setCartas(cartasJogador2);
    }

    public abstract void carregarCartas();

    public int vencedor() {
        return this.jogador1.isSemCartas() ? 1 : this.jogador2.isSemCartas() ? 2 : 0;
    }
}
