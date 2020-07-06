package trabalho;

import java.io.BufferedReader;
import java.io.FileReader;

public class Programa {
    public static void main(String[] args) {
        try{
            var arquivo = new FileReader("cavZod.txt");

            var buffer = new BufferedReader(arquivo);

            while(buffer.ready()) {
                String linha = buffer.readLine();
                System.out.println(buffer.readLine());
            }

        } catch (Exception e){

        }
    }
}
