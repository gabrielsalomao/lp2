package trabalho;

public class CartaCavaleirosZodiaco extends CartaSuperTrunfo {
    private int soco;
    private int chute;
    private int tecnica;
    private int conhecimentos;
    private int forca;

    CartaCavaleirosZodiaco(String nome, String identificador, boolean trunfo, int soco, int chute, int tecnica, int conhecimentos, int forca) {
        super(nome, identificador, trunfo);
        this.soco = soco;
        this.chute = chute;
        this.tecnica = tecnica;
        this.conhecimentos = conhecimentos;
        this.forca = forca;
    }

    public void printALl() {

    }

    @Override
    public void mostrarListaAtributos() {
        System.out.println("1 - SOCO");
    }

    @Override
    public int getAtributo(int atributo) {
        return 0;
    }
}
