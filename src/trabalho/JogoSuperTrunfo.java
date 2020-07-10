package trabalho;

import java.io.IOException;
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

    public int vencedorCavaleiro() {
        return this.jogador1.isSemCartasCavaleiro() ? 1 : this.jogador2.isSemCartasCavaleiro() ? 2 : 0;
    }

    public int vencedorHerois() {
        return this.jogador1.isSemCartasHeroi() ? 1 : this.jogador2.isSemCartasHeroi() ? 2 : 0;
    }

    public abstract void gravarLogJogo() throws IOException;
}
