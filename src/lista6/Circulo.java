package lista6;

public class Circulo extends EntityBase {

    private double raio;

    Circulo(double raio) {
        this.raio = raio;
    }

    double area() {
        return this.pi * (this.raio * this.raio);
    }

    double perimetro() {
        return (this.pi * 2) * this.raio;
    }

    public double getRaio() {
        return this.raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
}
