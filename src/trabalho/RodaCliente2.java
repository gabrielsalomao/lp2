package trabalho;

import java.io.IOException;
import java.net.UnknownHostException;

public class RodaCliente2 {
    public static void main(String[] args)
            throws UnknownHostException, IOException {
        new Cliente("localhost", 5555).executa();
    }
}
