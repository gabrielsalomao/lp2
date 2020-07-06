package trabalho;

public class JogoCavaleirosZodiaco extends JogoSuperTrunfo {
    public JogoCavaleirosZodiaco(Jogador jogador1, Jogador jogador2) {
        super(jogador1, jogador2);
        carregarCartas();
        embaralhar();
        distribuir();
    }

    @Override
    public void carregarCartas() {

    }
}
