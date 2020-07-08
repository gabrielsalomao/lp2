package trabalho;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

    private String host;
    private int porta;

    public Cliente(String host, int porta) {
        this.host = host;
        this.porta = porta;
    }

    public void executa() throws UnknownHostException, IOException {
        try(Socket cliente = new Socket(this.host, this.porta);
            Scanner teclado = new Scanner(System.in);
            PrintStream saida = new PrintStream(cliente.getOutputStream())) {
            System.out.println("Bem-vindo");


            RecebedorDeMensagemDoServidor r = new RecebedorDeMensagemDoServidor(cliente.getInputStream());
            new Thread(r).start();

            System.out.println("Insira seu nome:");
            while (teclado.hasNextLine()) {
                saida.println(teclado.nextLine());
            }
        }
    }
}