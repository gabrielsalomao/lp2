//package trabalho;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//
//public class JogoHeroisMarvel extends JogoSuperTrunfo {
//
//    public JogoHeroisMarvel(Jogador jogador1, Jogador jogador2) {
//        super(jogador1, jogador2);
//    }
//
//    @Override
//    public void carregarCartas() {
//        try{
//            var arquivo = new FileReader("C:\\cartas\\cavZod.txt");
//
//            var buffer = new BufferedReader(arquivo);
//
//            while(buffer.ready()) {
//                var arrayCarta = buffer.readLine().split("//");
//                System.out.println();
//            }
//
//        } catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
//}
