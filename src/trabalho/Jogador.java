package trabalho;

import java.net.Socket;
import java.util.ArrayList;

public class Jogador {
    private String nome;
    private int vitorias;
    public boolean jogadorDaVez;
    public int atributoSelecionado;
    public CartaCavaleirosZodiaco cartaAtual;
    private ArrayList<CartaCavaleirosZodiaco> cartasCavaleiro;
    public Socket socket;

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

    public ArrayList<CartaCavaleirosZodiaco> getCartasCavaleiro() {
        return this.cartasCavaleiro;
    }

    public void setCartas(ArrayList<CartaCavaleirosZodiaco> cartas) {
        this.cartasCavaleiro = cartas;
    }

    public CartaCavaleirosZodiaco getProximaCarta() {
        return this.getCartasCavaleiro().remove(0);
    }

    public void adicionarCartaCavaleiro(CartaCavaleirosZodiaco cartas) {
        this.getCartasCavaleiro().add(cartas);
    }

    public int getQuantidadeCartas() {
        return this.getCartasCavaleiro().size();
    }

    public boolean isSemCartas() {
        return this.getQuantidadeCartas() == 0;
    }

    public void incrementarVitorias() {
        this.vitorias++;
    }
}