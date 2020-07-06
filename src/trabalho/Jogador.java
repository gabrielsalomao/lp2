package trabalho;

import java.util.ArrayList;

public class Jogador {
    private String nome;
    private int vitorias;
    private ArrayList<CartaSuperTrunfo> cartas;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVitorias() {
        return this.vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public ArrayList<CartaSuperTrunfo> getCartas() {
        return this.cartas;
    }

    public void setCartas(ArrayList<CartaSuperTrunfo> cartas) {
        this.cartas = cartas;
    }

    public CartaSuperTrunfo getProximaCarta(){
        return this.getCartas().remove(0);
    }

    public void adicionarCarta(CartaSuperTrunfo carta) {
        this.getCartas().add(carta);
    }

    public int getQuantidadeCartas() {
        return this.getCartas().size();
    }

    public boolean isSemCartas() {
        return this.getQuantidadeCartas() == 0;
    }

    public void incrementarVitorias() {
        this.vitorias++;
    }
}