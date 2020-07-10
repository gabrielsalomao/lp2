package trabalho;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class JogoHeroisMarvel extends JogoSuperTrunfo {
    private ArrayList<CartaHeroisMarvel> cartas;
    private ArrayList<CartaHeroisMarvel> mesa;
    public int atributoEscolhido;
    public String estadoDaPartida = "NOVO";

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

    public void getCartaAtualDosJogadoresHeroi(Jogador j1, Jogador j2) throws IOException {
        var ps = new PrintStream(j2.socket.getOutputStream());
        ps.println("\nSUA CARTA\n" + j2.cartaAtualHeroi.printALl());

        var ps1 = new PrintStream(j1.socket.getOutputStream());
        ps1.println("\nSUA CARTA\n" + j1.cartaAtualHeroi.printALl());
    }

    public void setCartaAtualDosJogadoresHeroi(Jogador j1, Jogador j2) {
        j1.cartaAtualHeroi = j1.getProximaCartaHeroi();
        j2.cartaAtualHeroi = j2.getProximaCartaHeroi();
    }

    public boolean verificaTrunfoHeroi(Jogador atual, Jogador adversario, boolean novaPartida) throws IOException {
        var ps1 = new PrintStream(atual.socket.getOutputStream());
        var ps2 = new PrintStream(adversario.socket.getOutputStream());

        if (atual.cartaAtualHeroi.getTrunfo()) {
            novaPartida = true;

            this.getCartaAtualDosJogadoresHeroi(this.jogador1, this.jogador2);

            ps1.println("TRUNFO - VOCE VENCEU");
            ps2.println("OPONENTE TINHA TRUNFO - VOCE PERDEU");

            atual.jogadorDaVez = false;
            adversario.jogadorDaVez = true;

            atual.incrementarVitorias();

            return true;
        } else if (adversario.cartaAtualHeroi.getTrunfo()) {
            novaPartida = true;

            this.getCartaAtualDosJogadoresHeroi(this.jogador1, this.jogador2);

            ps2.println("TRUNFO - VOCE VENCEU");
            ps1.println("OPONENTE TINHA TRUNFO - VOCE PERDEU");

            atual.jogadorDaVez = true;
            adversario.jogadorDaVez = false;

            adversario.incrementarVitorias();

            return true;
        }

        return false;
    }

    public boolean verificaCartas(Jogador j1, Jogador j2) throws IOException {
        if (j1.isSemCartasHeroi() && j2.isSemCartasHeroi() && this.estadoDaPartida != "FINALIZADA") {
            var ps1 = new PrintStream(this.jogador1.socket.getOutputStream());
            var ps2 = new PrintStream(this.jogador2.socket.getOutputStream());

            switch (this.vencedor()) {
                case 1:
                    ps1.println("\nVOCE VENCEU O JOGO");
                    ps2.println("\nVOCE PERDEU O JOGO");
                    break;
                case 2:
                    ps2.println("\nVOCE VENCEU O JOGO");
                    ps1.println("\nVOCE PERDEU O JOGO");
                    break;
            }

            ps1.println("Precione enter para nova partida");
            ps2.println("Precione enter para nova partida");

            this.gravarLogJogo();

            this.estadoDaPartida = "FINALIZADA";
            return true;
        }
        return false;
    }

    public void compararCartasHeroi(boolean empate, boolean novaPartida, Jogador j1, Jogador j2, Jogador atual, Jogador adversario, int atributo) throws IOException {
        var ps1 = new PrintStream(atual.socket.getOutputStream());
        var ps2 = new PrintStream(adversario.socket.getOutputStream());

        int vencedor = atual.cartaAtualHeroi.compararAtributo(adversario.cartaAtualHeroi, atributo);

        atual.jogadorDaVez = false;
        adversario.jogadorDaVez = true;

        var tempAtualCart = atual.cartaAtualHeroi;
        var tempAdversarioCart = adversario.cartaAtualHeroi;

        if (this.verificaTrunfoHeroi(j1, j2, novaPartida)) {
            if (this.verificaCartas(j1, j2))
                return;
            this.setCartaAtualDosJogadoresHeroi(j1, j2);
            this.getCartaAtualDosJogadoresHeroi(j1, j2);
            this.enviarInfoParaJogadoresHeroi();
            return;
        } else {
            switch (vencedor) {
                case 1:
                    ps1.println("ATRIBUTO ESCOLHIDO: " + tempAtualCart.getNomeAtributo(atributo));
                    ps1.println("VALOR DO ATRIBUTO DO OPONENTE: " + tempAdversarioCart.getAtributo(atributo));

                    ps2.println("ATRIBUTO ESCOLHIDO: " + tempAtualCart.getNomeAtributo(atributo));
                    ps2.println("VALOR DO ATRIBUTO DO OPONENTE: " + tempAdversarioCart.getAtributo(atributo));

                    ps2.println("Você perdeu");
                    ps1.println("Você venceu");

                    atual.incrementarVitorias();

                    if (empate) {
                        atual.incrementarVitorias();
                        empate = false;
                    }
                    break;
                case 2:
                    ps1.println("ATRIBUTO ESCOLHIDO: " + tempAtualCart.getNomeAtributo(atributo));
                    ps1.println("VALOR DO ATRIBUTO DO OPONENTE: " + tempAdversarioCart.getAtributo(atributo));

                    ps2.println("ATRIBUTO ESCOLHIDO: " + tempAtualCart.getNomeAtributo(atributo));
                    ps2.println("VALOR DO ATRIBUTO DO OPONENTE: " + tempAtualCart.getAtributo(atributo));

                    ps2.println("Você venceu");
                    ps1.println("Você perdeu");

                    adversario.incrementarVitorias();

                    if (empate) {
                        adversario.incrementarVitorias();
                        empate = false;
                    }

                    break;
                default:
                    ps2.println("Empate");
                    ps1.println("Empate");

                    empate = true;
                    break;
            }

            if (this.verificaCartas(j1, j2))
                return;

            this.setCartaAtualDosJogadoresHeroi(j1, j2);

            if (this.verificaTrunfoHeroi(j1, j2, novaPartida)) {
                if (this.verificaCartas(j1, j2)) {
                    return;
                }
                this.setCartaAtualDosJogadoresHeroi(j1, j2);
                this.getCartaAtualDosJogadoresHeroi(j1, j2);
                this.enviarInfoParaJogadoresHeroi();
                return;
            }

            this.getCartaAtualDosJogadoresHeroi(j1, j2);
            this.enviarInfoParaJogadoresHeroi();
        }
    }

    public void enviarInfoParaJogadoresHeroi() throws IOException {
        var ps1 = new PrintStream(this.jogador1.socket.getOutputStream());
        var ps2 = new PrintStream(this.jogador2.socket.getOutputStream());

        if (this.jogador1.jogadorDaVez) {
            ps1.println("Sua vez, escolha um atributo: ");
            ps2.println("Vez do jogador 1, aguarde a escolha do atributo");
        } else {
            ps2.println("Sua vez, escolha um atributo: ");
            ps1.println("Vez do jogador 2, aguarde a escolha do atributo");
        }
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

            var arquivo = new FileReader("src/trabalho/cartas/marvel.txt", StandardCharsets.UTF_8);

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
        var buffer = new BufferedWriter(new FileWriter("src/trabalho/log/logJogos.txt", true));
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
