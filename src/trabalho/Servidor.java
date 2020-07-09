package trabalho;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Servidor {
    private int porta;
    private List<Socket> clientes;
    private ArrayList<Jogador> jogadores = new ArrayList<>();
    private Jogador jogador1 = new Jogador("");
    private Jogador jogador2 = new Jogador("");
    private JogoCavaleirosZodiaco jogo = new JogoCavaleirosZodiaco(jogador1, jogador2);
    private boolean jogoEscolhido = false;
    private boolean jogadorSorteado = false;
    private boolean novaPartida = false;
    private boolean empate = false;
    private ArrayList<CartaCavaleirosZodiaco> mesa = new ArrayList<>();
    private String estadoDaPartida = "NOVO";

    public Servidor(int porta) {
        this.porta = porta;
        this.clientes = new ArrayList<>();
    }

    public void executa() throws IOException {
        try (var servidor = new ServerSocket(this.porta)) {
            System.out.println("Porta 5555 aberta!");

            while (true) {
                Socket cliente = servidor.accept();

                System.out.println("Nova conexão com o cliente " +
                        cliente.getInetAddress().getHostAddress());

                this.clientes.add(cliente);

                var tc = new TratadorDeMensagemDoCliente(cliente, this);

                new Thread(tc).start();
            }
        }
    }

    public void getCartaAtualDosJogadores() throws IOException {
        var ps = new PrintStream(this.jogador2.socket.getOutputStream());
        ps.println("\nSUA CARTA\n" + this.jogador2.cartaAtual.printALl());

        var ps1 = new PrintStream(this.jogador1.socket.getOutputStream());
        ps1.println("\nSUA CARTA\n" + this.jogador1.cartaAtual.printALl());
    }

    public void setCartaAtualDosJogadores() {
        this.jogador1.cartaAtual = this.jogador1.getProximaCarta();
        this.jogador2.cartaAtual = this.jogador2.getProximaCarta();
    }

    public boolean verificaTrunfo(Jogador atual, Jogador adversario) throws IOException {
        var ps1 = new PrintStream(atual.socket.getOutputStream());
        var ps2 = new PrintStream(adversario.socket.getOutputStream());

        if (atual.cartaAtual.getTrunfo()) {
            this.novaPartida = true;

            ps1.println("TRUNFO - VOCE VENCEU");
            ps2.println("OPONENTE TINHA TRUNFO - VOCE PERDEU");

            atual.jogadorDaVez = false;
            adversario.jogadorDaVez = true;

            this.setCartaAtualDosJogadores();
            this.getCartaAtualDosJogadores();

            this.novaPartida = true;

            atual.jogadorDaVez = false;
            adversario.jogadorDaVez = true;

            return true;
        } else if (adversario.cartaAtual.getTrunfo()) {
            this.novaPartida = true;

            ps2.println("TRUNFO - VOCE VENCEU");
            ps1.println("OPONENTE TINHA TRUNFO - VOCE PERDEU");

            atual.jogadorDaVez = false;
            adversario.jogadorDaVez = true;

            this.setCartaAtualDosJogadores();
            this.getCartaAtualDosJogadores();

            this.novaPartida = true;

            atual.jogadorDaVez = false;
            adversario.jogadorDaVez = true;

            return true;
        }
        return false;
    }

    public void compararCartas(Jogador atual, Jogador adversario, int atributo) throws IOException {
        var ps1 = new PrintStream(atual.socket.getOutputStream());
        var ps2 = new PrintStream(adversario.socket.getOutputStream());

        int vencedor = atual.cartaAtual.compararAtributo(adversario.cartaAtual, atributo);

        if (this.verificaTrunfo(atual, adversario)) {
            return;
        } else {
            switch (vencedor) {
                case 1:
                    ps1.println("ATRIBUTO ESCOLHIDO: " + atual.cartaAtual.getNomeAtributo(atributo));
                    ps1.println("VALOR DO ATRIBUTO DO OPONENTE: " + adversario.cartaAtual.getAtributo(atributo));

                    ps2.println("ATRIBUTO ESCOLHIDO: " + atual.cartaAtual.getNomeAtributo(atributo));
                    ps2.println("VALOR DO ATRIBUTO DO OPONENTE: " + atual.cartaAtual.getAtributo(atributo));

                    ps2.println("Você perdeu");
                    ps1.println("Você venceu");

                    atual.incrementarVitorias();

                    if (this.empate) {
                        atual.incrementarVitorias();
                        this.empate = false;
                    }
                    break;
                case 2:
                    ps1.println("ATRIBUTO ESCOLHIDO: " + atual.cartaAtual.getNomeAtributo(atributo));
                    ps1.println("VALOR DO ATRIBUTO DO OPONENTE: " + adversario.cartaAtual.getAtributo(atributo));

                    ps2.println("ATRIBUTO ESCOLHIDO: " + atual.cartaAtual.getNomeAtributo(atributo));
                    ps2.println("VALOR DO ATRIBUTO DO OPONENTE: " + atual.cartaAtual.getAtributo(atributo));

                    ps1.println("Você perdeu");
                    ps2.println("Você venceu");

                    adversario.incrementarVitorias();

                    if (this.empate) {
                        adversario.incrementarVitorias();
                        this.empate = false;
                    }

                    break;
                default:
                    ps2.println("Empate");
                    ps1.println("Empate");

                    this.empate = true;
                    break;
            }
            atual.jogadorDaVez = false;
            adversario.jogadorDaVez = true;
            this.setCartaAtualDosJogadores();
            this.getCartaAtualDosJogadores();
            if (this.jogador1.cartaAtual.getTrunfo() || this.jogador2.cartaAtual.getTrunfo()) {
                this.compararCartas(adversario, atual, 1);
            } else {
                this.enviarInfoParaJogadores();
            }
        }
    }

    public void enviarInfoParaJogadores() throws IOException {
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

    public void cadastrarSocketDoJogador(Jogador jogador, Socket cliente, String msg) throws IOException {
        jogador.socket = cliente;
        jogador.setNome(msg);
        var ps = new PrintStream(jogador.socket.getOutputStream());
        ps.println("Olà " + jogador.getNome());
    }

    public void distribuiMensagem(Socket clienteQueEnviou, String msg) throws IOException {

        if (this.jogador1.isSemCartas() && this.jogador2.isSemCartas() && this.estadoDaPartida != "FINALIZADA") {
            var ps1 = new PrintStream(this.jogador1.socket.getOutputStream());
            var ps2 = new PrintStream(this.jogador2.socket.getOutputStream());

            switch (this.jogo.vencedor()) {
                case 1:
                    ps1.println("Voce venceu");
                    ps2.println("Voce perdeu");
                    break;
                case 2:
                    ps2.println("Voce venceu");
                    ps1.println("Voce perdeu");
                    break;
            }

            this.estadoDaPartida = "FINALIZADA";
        }

        switch (this.estadoDaPartida) {
            case "NOVO":
                if (this.jogador1.socket == null) {
                    this.cadastrarSocketDoJogador(this.jogador1, clienteQueEnviou, msg);
                    var ps1 = new PrintStream(this.jogador1.socket.getOutputStream());
                    ps1.println("Aguardando jogador 2...");
                } else {
                    if (this.jogador2.socket == null && clienteQueEnviou != jogador1.socket) {
                        this.cadastrarSocketDoJogador(this.jogador2, clienteQueEnviou, msg);
                        this.estadoDaPartida = "EMPROGRESSO";
                        this.setCartaAtualDosJogadores();
                        this.getCartaAtualDosJogadores();
                        this.jogadores.add(this.jogador1);
                        this.jogadores.add(this.jogador2);
                        Collections.shuffle(this.jogadores);
                        if (this.verificaTrunfo(this.jogadores.get(0), this.jogadores.get(1))) {
                            this.enviarInfoParaJogadores();
                        } else {
                            this.jogadores.get(0).jogadorDaVez = true;
                            this.enviarInfoParaJogadores();
                        }
                    }
                }

                break;
            case "EMPROGRESSO":
                if (clienteQueEnviou == this.jogador1.socket && this.jogador1.jogadorDaVez) {
                    this.compararCartas(this.jogador1, this.jogador2, Integer.parseInt(msg));
                }
                if (clienteQueEnviou == this.jogador2.socket && this.jogador2.jogadorDaVez) {
                    this.compararCartas(this.jogador2, this.jogador1, Integer.parseInt(msg));
                }

                break;
            case "FINALIZADA":
                this.jogo.gravarLogJogo();
                break;
        }
    }
}

