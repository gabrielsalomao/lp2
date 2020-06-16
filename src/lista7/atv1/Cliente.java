package lista7.atv1;

public class Cliente extends Pessoa {
    private double valorDivida;

    Cliente(String nome, int idade, char sexo, double valorDivida) {
        super(nome, idade, sexo);

        this.valorDivida = valorDivida;
    }

    void setValorDivida(double valorDivida) {
        this.valorDivida = valorDivida;
    }

    double getValorDivida() {
        return this.valorDivida;
    }

    public void imprimirTudo() {
        System.out.printf("Nome: %s\n Idade: %d\n Sexo: %s\nValor da divida: %.2f",
                this.nome, this.idade, this.sexo, this.valorDivida);
    }
}
