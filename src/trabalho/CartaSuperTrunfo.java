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

    public void printAll() {
        System.out.println("NOME: " + this.getNome());
        System.out.println("IDENTIFICADOR: " + this.getIdentificador());
        System.out.println("TRUNFO: " + (this.getTrunfo() ? "SIM" : "NÃO"));
    }

    public abstract void mostrarListaAtributos();

    public boolean CompararTrunfo(CartaSuperTrunfo cartaAdversario) {
        return cartaAdversario.getTrunfo();
    }

    public abstract int getAtributo(int atributo);

    public int compararAtributo(CartaSuperTrunfo cartaAdversaria, int atributo) {
        if (this.getAtributo(atributo) > cartaAdversaria.getAtributo(atributo)){
            return 1;
        }
        else if (this.getAtributo(atributo) < cartaAdversaria.getAtributo(atributo)){
            return 2;
        } else {
            return 0;
        }
    }
}
