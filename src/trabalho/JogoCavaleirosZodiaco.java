package trabalho;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

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

    public int vencedor() {
        return jogador1.getVitorias() > jogador2.getVitorias() ? 1 : jogador1.getVitorias() < jogador2.getVitorias() ? 2 : 0;
    }

    public void gravarLogJogo() throws IOException {
        var buffer = new BufferedWriter(new FileWriter("C:\\logJogos\\logJogos.txt", true));
        Jogador vencedor = null;

        switch (vencedor()) {
            case 1:
                vencedor = this.jogador1;
                break;
            case 2:
                vencedor = this.jogador2;
                break;
        }

        buffer.write("Cavaleiros J1: " + this.jogador1.getNome() +
                " J2: " + this.jogador2.getNome() +
                " V: " + vencedor.getNome() +
                " D/H: " + new Date());

        buffer.newLine();

        buffer.close();
    }
}
