package lista6;

public class Quadrado {
    private double lado;

    Quadrado(double lado) {
        this.lado = lado;
    }

    double area() {
        return this.lado * this.lado;
    }

    double perimetro() {
        return this.lado * 4;
    }

    void setLado(double lado) {
        this.lado = lado;
    }

    double getLado() {
        return this.lado;
    }
}
