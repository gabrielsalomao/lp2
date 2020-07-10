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
    private JogoCavaleirosZodiaco jogo1 = new JogoCavaleirosZodiaco(jogador1, jogador2);
    private JogoHeroisMarvel jogo2 = new JogoHeroisMarvel(jogador1, jogador2);
    private boolean jogoEscolhido = false;
    private boolean jogadorSorteado = false;
    private boolean novaPartida = false;
    private boolean empate = false;
    private ArrayList<CartaCavaleirosZodiaco> mesa = new ArrayList<>();
    private String tipoDoJogo = "";
    private String estadoPartida = "NOVO";

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

    public void cadastrarSocketDoJogador(Jogador jogador, Socket cliente, String msg) throws IOException {
        jogador.socket = cliente;
        jogador.setNome(msg);
        var ps = new PrintStream(jogador.socket.getOutputStream());
        ps.println("Olà " + jogador.getNome());
    }

    public void distribuiMensagem(Socket clienteQueEnviou, String msg) throws IOException {

        switch (this.tipoDoJogo) {
            case "1":
                this.estadoPartida = this.jogo1.estadoDaPartida;
                break;
            case "2":
                this.estadoPartida = this.jogo2.estadoDaPartida;
                break;
        }

        switch (this.estadoPartida) {
            case "NOVO":
                if (this.jogador1.socket == null) {
                    this.cadastrarSocketDoJogador(this.jogador1, clienteQueEnviou, msg);
                    var ps1 = new PrintStream(this.jogador1.socket.getOutputStream());
                    ps1.println("Escolha o jogo:\n1-Cavaleiros do zodiaco\n2-Heróis Marvel");
                } else if (this.tipoDoJogo == "" || this.tipoDoJogo == "NOVOJOGO") {
                    var ps1 = new PrintStream(this.jogador1.socket.getOutputStream());

                    if (this.tipoDoJogo == "NOVOJOGO") {
                        ps1.println("Escolha o jogo:\n1-Cavaleiros do zodiaco\n2-Heróis Marvel");
                    }
                    switch (msg) {
                        case "1":
                            this.tipoDoJogo = "1";
                            break;
                        case "2":
                            this.tipoDoJogo = "2";
                            break;
                    }
                    ps1.println("Aguardando jogador 2...");
                } else {
                    if (this.jogador2.socket == null && clienteQueEnviou != jogador1.socket) {
                        switch (this.tipoDoJogo) {
                            case "1":
                                this.cadastrarSocketDoJogador(this.jogador2, clienteQueEnviou, msg);
                                this.jogo1.estadoDaPartida = "EMPROGRESSO";
                                this.jogo1.setCartaAtualDosJogadoresCavaleiro(this.jogador1, this.jogador2);
                                this.jogadores.add(this.jogador1);
                                this.jogadores.add(this.jogador2);
                                Collections.shuffle(this.jogadores);
                                if (this.jogo1.verificaTrunfoCavaleiro(this.jogadores.get(0), this.jogadores.get(1), this.novaPartida)) {
                                    this.jogo1.setCartaAtualDosJogadoresCavaleiro(this.jogador1, this.jogador2);
                                    this.jogo1.getCartaAtualDosJogadoresCavaleiro(this.jogador1, this.jogador2);
                                    this.jogo1.enviarInfoParaJogadoresCavaleiro();
                                } else {
                                    this.jogo1.getCartaAtualDosJogadoresCavaleiro(this.jogador1, this.jogador2);

                                    this.jogadores.get(0).jogadorDaVez = true;
                                    this.jogo1.enviarInfoParaJogadoresCavaleiro();
                                }
                                break;
                            case "2":
                                this.cadastrarSocketDoJogador(this.jogador2, clienteQueEnviou, msg);
                                this.jogo2.estadoDaPartida = "EMPROGRESSO";
                                this.jogo2.setCartaAtualDosJogadoresHeroi(this.jogador1, this.jogador2);
                                this.jogadores.add(this.jogador1);
                                this.jogadores.add(this.jogador2);
                                Collections.shuffle(this.jogadores);
                                if (this.jogo2.verificaTrunfoHeroi(this.jogadores.get(0), this.jogadores.get(1), this.novaPartida)) {
                                    this.jogo2.setCartaAtualDosJogadoresHeroi(this.jogador1, this.jogador2);
                                    this.jogo2.getCartaAtualDosJogadoresHeroi(this.jogador1, this.jogador2);
                                    this.jogo2.enviarInfoParaJogadoresHeroi();
                                } else {
                                    this.jogo2.getCartaAtualDosJogadoresHeroi(this.jogador1, this.jogador2);

                                    this.jogadores.get(0).jogadorDaVez = true;
                                    this.jogo2.enviarInfoParaJogadoresHeroi();
                                }
                                break;
                        }
                    }
                }

                break;
            case "EMPROGRESSO":
                switch (this.tipoDoJogo) {
                    case "1":
                        if (clienteQueEnviou == this.jogador1.socket && this.jogador1.jogadorDaVez) {
                            this.jogo1.compararCartasCavaleiro(this.empate, this.novaPartida, this.jogador1, this.jogador2, this.jogador1, this.jogador2, Integer.parseInt(msg));
                        }
                        if (clienteQueEnviou == this.jogador2.socket && this.jogador2.jogadorDaVez) {
                            this.jogo1.compararCartasCavaleiro(this.empate, this.novaPartida, this.jogador1, this.jogador2, this.jogador2, this.jogador1, Integer.parseInt(msg));
                        }
                        break;
                    case "2":
                        if (clienteQueEnviou == this.jogador1.socket && this.jogador1.jogadorDaVez) {
                            this.jogo2.compararCartasHeroi(this.empate, this.novaPartida, this.jogador1, this.jogador2, this.jogador1, this.jogador2, Integer.parseInt(msg));
                        }
                        if (clienteQueEnviou == this.jogador2.socket && this.jogador2.jogadorDaVez) {
                            this.jogo2.compararCartasHeroi(this.empate, this.novaPartida, this.jogador1, this.jogador2, this.jogador2, this.jogador1, Integer.parseInt(msg));
                        }
                        break;
                }
            case "2":

                break;
            case "FINALIZADA":
                var ps1 = new PrintStream(this.jogador1.socket.getOutputStream());
                var ps2 = new PrintStream(this.jogador2.socket.getOutputStream());

                this.jogo1.carregarCartas();
                this.jogo1.embaralhar();
                this.jogo1.distribuir();

                this.jogo2.carregarCartas();
                this.jogo2.embaralhar();
                this.jogo2.distribuir();

                ps1.println("\nEscolha o jogo:\n1-Cavaleiros do zodiaco\n2-Heróis Marvel");
                ps2.println("\nEsperando jogador 1 recomeçar a partida");

                this.jogo1.estadoDaPartida = "RECOMECAR";
                this.jogo2.estadoDaPartida = "RECOMECAR";
                break;
            case "RECOMECAR":
                if (clienteQueEnviou == jogador1.socket) {
                    switch (msg) {
                        case "1":
                            this.tipoDoJogo = "1";
                            break;
                        case "2":
                            this.tipoDoJogo = "2";
                            break;
                    }

                    switch (this.tipoDoJogo) {
                        case "1":
                            this.jogo1.estadoDaPartida = "EMPROGRESSO";
                            this.jogo1.setCartaAtualDosJogadoresCavaleiro(this.jogador1, this.jogador2);
                            this.jogadores.add(this.jogador1);
                            this.jogadores.add(this.jogador1);
                            this.jogadores.add(this.jogador2);
                            Collections.shuffle(this.jogadores);
                            if (this.jogo1.verificaTrunfoCavaleiro(this.jogadores.get(0), this.jogadores.get(1), this.novaPartida)) {
                                this.jogo1.setCartaAtualDosJogadoresCavaleiro(this.jogador1, this.jogador2);
                                this.jogo1.getCartaAtualDosJogadoresCavaleiro(this.jogador1, this.jogador2);
                                this.jogo1.enviarInfoParaJogadoresCavaleiro();
                            } else {
                                this.jogo1.getCartaAtualDosJogadoresCavaleiro(this.jogador1, this.jogador2);

                                this.jogadores.get(0).jogadorDaVez = true;
                                this.jogo1.enviarInfoParaJogadoresCavaleiro();
                            }
                            break;
                        case "2":
                            this.jogo2.estadoDaPartida = "EMPROGRESSO";
                            this.jogo2.setCartaAtualDosJogadoresHeroi(this.jogador1, this.jogador2);
                            this.jogadores.add(this.jogador1);
                            this.jogadores.add(this.jogador1);
                            this.jogadores.add(this.jogador2);
                            Collections.shuffle(this.jogadores);
                            if (this.jogo2.verificaTrunfoHeroi(this.jogadores.get(0), this.jogadores.get(1), this.novaPartida)) {
                                this.jogo2.setCartaAtualDosJogadoresHeroi(this.jogador1, this.jogador2);
                                this.jogo2.getCartaAtualDosJogadoresHeroi(this.jogador1, this.jogador2);
                                this.jogo2.enviarInfoParaJogadoresHeroi();
                            } else {
                                this.jogo2.getCartaAtualDosJogadoresHeroi(this.jogador1, this.jogador2);

                                this.jogadores.get(0).jogadorDaVez = true;
                                this.jogo2.enviarInfoParaJogadoresHeroi();
                            }
                            break;
                    }
                }
                break;
        }
    }
}
