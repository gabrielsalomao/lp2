package lista2.atv2;

public class Carro {
    public String marca;
    public String modelo;
    public String cor;
    public String placa;
    public int velocidade;
    public int marcha;
    public boolean ligado;

    public String mostrarDados() {
        return "Marca: " + this.marca + "\nModelo: " + this.modelo +
                "\nCor: " + this.cor + "\nPlaca: " + this.placa +
                "\nVelocidade: " + this.velocidade + "\nMarcha: " + this.marcha +
                "\nLigado: " + (this.ligado ? "Sim" : "Não");
    }

    public void pintar(String cor) {
        this.cor = cor;
    }

    public void ligar() {
        this.ligado = true;
    }

    public void desligar() {
        this.ligado = false;
    }

    public void aumentarMarcha() {
        this.marcha++;
    }

    public void diminuirMarcha() {
        this.marcha--;
    }

    public void acelerar(int velocidade) {
        this.velocidade += velocidade;
    }

    public void frear(int velocidade) {
        this.velocidade -= velocidade;
    }
}
