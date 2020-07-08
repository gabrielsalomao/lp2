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

    public String getNome() {
        return this.nome;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public boolean getTrunfo() {
        return this.trunfo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setTrunfo(boolean trunfo) {
        this.trunfo = trunfo;
    }

    public String printAlll() {
        return "NOME: " + this.getNome() +
                "\nIDENTIFICADOR: " + this.getIdentificador() +
                "\nTRUNFO: " + (this.getTrunfo() ? "SIM" : "NÃO");
    }

    public abstract void mostrarListaAtributos();

    public abstract int getAtributo(int atributo);

    public boolean CompararTrunfo(CartaSuperTrunfo cartaAdversario) {
        return cartaAdversario.getTrunfo();
    }

    public int compararAtributo(CartaSuperTrunfo cartaAdversaria, int atributo) {
        if (this.getAtributo(atributo) > cartaAdversaria.getAtributo(atributo)) {
            return 1;
        } else if (this.getAtributo(atributo) < cartaAdversaria.getAtributo(atributo)) {
            return 2;
        } else {
            return 0;
        }
    }
}
