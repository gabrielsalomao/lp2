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
    private String estadoDaPartida = "NOVO";
    private String tipoDoJogo = "";

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

        this.jogo1.verificaCartas(this.jogador1, this.jogador2, this.estadoDaPartida);

        switch (this.estadoDaPartida) {
            case "NOVO":
                if (this.jogador1.socket == null) {
                    this.cadastrarSocketDoJogador(this.jogador1, clienteQueEnviou, msg);
                    var ps1 = new PrintStream(this.jogador1.socket.getOutputStream());
                    ps1.println("Escolha o jogo:\n1-Cavaleiros do zodiaco\n2-Heróis Marvel");
                } else if (tipoDoJogo == "") {
                    var ps1 = new PrintStream(this.jogador1.socket.getOutputStream());
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
                                this.estadoDaPartida = "EMPROGRESSO";
                                this.jogo1.setCartaAtualDosJogadoresCavaleiro(this.jogador1, this.jogador2);
                                this.jogo1.getCartaAtualDosJogadoresCavaleiro(this.jogador1, this.jogador2);
                                this.jogadores.add(this.jogador1);
                                this.jogadores.add(this.jogador2);
                                Collections.shuffle(this.jogadores);
                                if (this.jogo1.verificaTrunfoCavaleiro(this.jogadores.get(0), this.jogadores.get(1), this.novaPartida)) {
                                    this.jogo1.enviarInfoParaJogadoresCavaleiro();
                                } else {
                                    this.jogadores.get(0).jogadorDaVez = true;
                                    this.jogo1.enviarInfoParaJogadoresCavaleiro();
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
                            this.jogo1.compararCartasCavaleiro(this.estadoDaPartida, this.empate, this.novaPartida, this.jogador1, this.jogador2, this.jogador1, this.jogador2, Integer.parseInt(msg));
                        }
                        if (clienteQueEnviou == this.jogador2.socket && this.jogador2.jogadorDaVez) {
                            this.jogo1.compararCartasCavaleiro(this.estadoDaPartida, this.empate, this.novaPartida, this.jogador1, this.jogador2, this.jogador2, this.jogador1, Integer.parseInt(msg));
                        }
                        break;
                }
            case "2":

                break;
            case "FINALIZADA":
                this.jogo1.gravarLogJogo();
                break;
        }
    }
}
