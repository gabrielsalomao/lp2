package lista7.atv2;

public class Cilindro extends SolidoGeometrico {
    private double raio;
    private double altura;

    Cilindro(double raio, double altura) {
        this.raio = raio;
        this.altura = altura;
    }

    double getRaio() {
        return this.raio;
    }

    double getAltura() {
        return this.altura;
    }

    void setRaio(double raio) {
        this.raio = raio;
    }

    void setAltura(double altura) {
        this.altura = altura;
    }

    double calculaVolume() {
        return Math.PI * ((this.raio * this.raio) * altura);
    }
}
