package trabalho;

public class CartaHeroisMarvel extends CartaSuperTrunfo {
    private int altura;
    private int inteligencia;
    private int forca;
    private int velocidade;
    private int habilidade;

    CartaHeroisMarvel(String nome, String identificador, boolean trunfo, int altura, int inteligencia, int forca, int velocidade, int habilidade) {
        super(nome, identificador, trunfo);
        this.altura = altura;
        this.inteligencia = inteligencia;
        this.forca = forca;
        this.velocidade = velocidade;
        this.habilidade = habilidade;
    }

    public int getAltura() {
        return this.altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getInteligencia() {
        return this.inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getForca() {
        return this.forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getVelocidade() {
        return this.velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getHabilidade() {
        return this.habilidade;
    }

    public void setHabilidade(int habilidade) {
        this.habilidade = velocidade;
    }

    public String printALl() {
        return super.printAlll() +
                "\n1-ALTURA: " + this.getAltura() +
                "\n2-INTELIGÊNCIA: " + this.getInteligencia() +
                "\n3-FORÇA: " + this.getForca() +
                "\n4-VELOCIDADE: " + this.getVelocidade() +
                "\n5-HABILIDADE: " + this.getHabilidade();
    }

    @Override
    public void mostrarListaAtributos() {
        System.out.println("1 - ALTURA");
        System.out.println("2 - INTELIGÊNCIA");
        System.out.println("3 - FORÇA");
        System.out.println("4 - VELOCIDADE");
        System.out.println("5 - HABILIDADE");
    }

    @Override
    public int getAtributo(int atributo) {
        switch (atributo) {
            case 1:
                return this.getAltura();
            case 2:
                return this.getInteligencia();
            case 3:
                return this.getForca();
            case 4:
                return this.getVelocidade();
            default:
                return this.getHabilidade();
        }
    }

    public String getNomeAtributo(int atributo) {
        switch (atributo) {
            case 1:
                return "ALTURA";
            case 2:
                return "INTELIGÊNCIA";
            case 3:
                return "FORÇA";
            case 4:
                return "VELOCIDADE";
            default:
                return "HABILIDADE";
        }
    }
}
