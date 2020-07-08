package trabalho;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {

    private int porta;
    private List<Socket> clientes;
    private Jogador jogador1 = new Jogador("");
    private Jogador jogador2 = new Jogador("");
    private JogoCavaleirosZodiaco jogo = new JogoCavaleirosZodiaco(jogador1, jogador2);
    private boolean jogoEscolhido = false;
    private boolean jogadorSorteado = false;

    public Servidor(int porta) {
        this.porta = porta;
        this.clientes = new ArrayList<>();
    }

    public void executa() throws IOException {
        try (ServerSocket servidor = new ServerSocket(this.porta)) {
            System.out.println("Porta 5555 aberta!");

            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Nova conexão com o cliente " +
                        cliente.getInetAddress().getHostAddress());

                this.clientes.add(cliente);

                TratadorDeMensagemDoCliente tc = new TratadorDeMensagemDoCliente(cliente, this);
                new Thread(tc).start();
            }
        }
    }

    public void distribuiMensagem(Socket clienteQueEnviou, String msg) throws IOException {
//        for (Socket cliente : this.clientes) {
//            if (!cliente.equals(clienteQueEnviou)) {
//                try {
//                    PrintStream ps = new PrintStream(cliente.getOutputStream());
//                    ps.println(msg);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            if(this.clientes.get(0) != null && !this.jogoEscolhido){
//
//            }
//        }

        for (Socket cliente : this.clientes) {
            if (this.jogador1.socket == null || this.jogador2.socket == null) {
                if (this.jogador1.socket == null) {
                    this.jogador1.socket = cliente;
                    if (this.jogador1.socket == cliente) {
                        this.jogador1.setNome(msg);
                        this.jogador1.cartaAtual = this.jogador1.getProximaCarta();
                        PrintStream ps = new PrintStream(cliente.getOutputStream());
                        ps.println("Olà " + this.jogador1.getNome() + ", aguardando Jogador 2");
                    }
                }

                if (this.jogador1.socket != null && this.jogador2.socket == null && cliente != this.jogador1.socket) {
                    this.jogador2.socket = cliente;
                    if (this.jogador2.socket == cliente) {
                        this.jogador2.setNome(msg);
                        this.jogador2.cartaAtual = this.jogador2.getProximaCarta();

                        PrintStream ps = new PrintStream(cliente.getOutputStream());
                        ps.println("Olà " + this.jogador2.getNome());
                        ps.println(this.jogador2.cartaAtual.printALl());

                        PrintStream ps1 = new PrintStream(this.jogador1.socket.getOutputStream());
                        ps1.println(this.jogador1.cartaAtual.printALl());

                        int sorteio = (int) Math.random() * 1;

                        if (sorteio == 1) {
                            ps1.println("Escolha um atributo:");
                        } else {
                            ps1.println("Jogador 2 é o primeiro, aguarde a escolha do atributo");
                            ps.println("Escolha um atributo:");
                        }
                    }
                }
            } else {
                if (this.jogador1.jogadorDaVez) {
                    var atributo = Integer.parseInt(msg);

                    int vencedor = this.jogador1.cartaAtual.compararAtributo(this.jogador2.cartaAtual, atributo);

                }
            }
        }
    }
}