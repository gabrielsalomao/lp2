package trabalho;

import java.net.Socket;
import java.util.ArrayList;

public class Jogador {
    private String nome;
    private int vitorias;
    public boolean jogadorDaVez;
    public int atributoSelecionado;
    public CartaCavaleirosZodiaco cartaAtualCavaleiro;
    public CartaHeroisMarvel cartaAtualHeroi;
    private ArrayList<CartaCavaleirosZodiaco> cartasCavaleiro;
    public CartaHeroisMarvel cartaHeroisMarvel;
    private ArrayList<CartaHeroisMarvel> cartasHerois;
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

    public void setCartasCavaleiro(ArrayList<CartaCavaleirosZodiaco> cartas) {
        this.cartasCavaleiro = cartas;
    }

    public ArrayList<CartaHeroisMarvel> getCartasHerois() {
        return this.cartasHerois;
    }

    public void setCartasHerois(ArrayList<CartaHeroisMarvel> cartas) {
        this.cartasHerois = cartas;
    }

    public CartaCavaleirosZodiaco getProximaCartaCavaleiro() {
        return this.getCartasCavaleiro().remove(0);
    }

    public CartaHeroisMarvel getProximaCartaHeroi() {
        return this.getCartasHerois().remove(0);
    }

    public void adicionarCartaCavaleiro(CartaCavaleirosZodiaco cartas) {
        this.getCartasCavaleiro().add(cartas);
    }

    public void adicionarCartaHeroi(CartaHeroisMarvel cartas) {
        this.getCartasHerois().add(cartas);
    }

    public int getQuantidadeCartasCavaleiro() {
        return this.getCartasCavaleiro().size();
    }

    public int getQuantidadeCartasHeroi() {
        return this.getCartasHerois().size();
    }

    public boolean isSemCartasCavaleiro() {
        return this.getQuantidadeCartasCavaleiro() == 0;
    }

    public boolean isSemCartasHeroi() {
        return this.getQuantidadeCartasHeroi() == 0;
    }

    public void incrementarVitorias() {
        this.vitorias++;
    }
}