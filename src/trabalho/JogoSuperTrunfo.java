package trabalho;

import java.util.ArrayList;
import java.util.Collections;

public abstract class JogoSuperTrunfo {
    public Jogador jogador1;
    public Jogador jogador2;

    public JogoSuperTrunfo(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }


    public abstract void embaralhar();

    public abstract void distribuir();

    public abstract void carregarCartas();

    public int vencedor() {
        return this.jogador1.isSemCartas() ? 1 : this.jogador2.isSemCartas() ? 2 : 0;
    }
}
