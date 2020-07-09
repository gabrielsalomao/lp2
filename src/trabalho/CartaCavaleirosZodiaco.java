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

    public int getSoco() {
        return this.soco;
    }

    public void setSoco(int soco) {
        this.soco = soco;
    }

    public int getChute() {
        return this.chute;
    }

    public void setChute(int chute) {
        this.chute = chute;
    }

    public int getTecnica() {
        return this.tecnica;
    }

    public void setTecnica() {
        this.tecnica = tecnica;
    }

    public int getConhecimentos() {
        return this.conhecimentos;
    }

    public void setConhecimentos(int conhecimentos) {
        this.conhecimentos = conhecimentos;
    }

    public int getForca() {
        return this.forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public String printALl() {
        return (super.printAlll() +
        "\n1-SOCO: " + this.getSoco() +
        "\n2-CHUTE: " + this.getChute() +
        "\n3-TÉCNICA: " + this.getTecnica()+
        "\n4-CONHECIMENTOS: " + this.getConhecimentos()+
        "\n5-FORÇA: " + this.getForca());
    }

    @Override
    public void mostrarListaAtributos() {
        System.out.println("1 - SOCO");
        System.out.println("2 - CHUTE");
        System.out.println("3 - TÉCNICA");
        System.out.println("4 - CONHECIMENTOS");
        System.out.println("5 - FORÇA");
    }

    @Override
    public int getAtributo(int atributo) {
        switch (atributo) {
            case 1:
                return this.getSoco();
            case 2:
                return this.getChute();
            case 3:
                return this.getTecnica();
            case 4:
                return this.getConhecimentos();
            default:
                return this.getForca();
        }
    }

    public String getNomeAtributo(int atributo) {
        switch (atributo) {
            case 1:
                return "SOCO";
            case 2:
                return "CHUTE";
            case 3:
                return "TÉCNICA";
            case 4:
                return "CONHECIMENTOS";
            default:
                return "FORÇA";
        }
    }
}
