package lista7.atv2;

public class Piramide extends SolidoGeometrico {
    private double lado;
    private double altura;

    Piramide(double lado, double altura) {
        this.lado = lado;
        this.altura = altura;
    }

    double getLado() {
        return this.lado;
    }

    double getAltura() {
        return this.altura;
    }

    void setLado(double lado) {
        this.lado = lado;
    }

    void setAltura(double altura) {
        this.altura = altura;
    }

    double calculaVolume() {
        return (this.altura * (this.lado * this.lado)) / 3;
    }
}
