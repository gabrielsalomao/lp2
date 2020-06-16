package lista6;

public class Retangulo {
    private double base;
    private double altura;

    Retangulo(double base, double altura) {
        this.altura = altura;
        this.base = base;
    }

    void setBase(double base) {
        this.base = base;
    }

    double getBase() {
        return this.base;
    }

    void setAltura(double altura) {
        this.altura = altura;
    }

    double getAltura() {
        return this.altura;
    }

    public double area() {
        return base * altura;
    }

    public double perimetro() {
        return 2 * (base + altura);
    }
}
