package trabalho;

public abstract class CartaSuperTrunfo {
    private String nome;
    private String identificador;
    private boolean trunfo;


    CartaSuperTrunfo(String nome, String identificador, boolean trunfo) {
        this.nome = nome;
        this.identificador = identificador;
        this.trunfo = trunfo;
    }

    public void printAll() {
        System.out.println("Nome: " + this.nome + "\nIdentificador: " + this.identificador +
                "\nTrunfo: " + (this.trunfo ? "sim" : "não"));
    }

    public abstract void mostrarListaAtributos();

    public boolean CompararTrunfo(CartaSuperTrunfo cartaAdversario) {

    }

    public abstract int getAtributo(int atributo);

    public int compararAtributo(CartaSuperTrunfo cartaAdversarioa, int atributo) {

    }

    ;
}
