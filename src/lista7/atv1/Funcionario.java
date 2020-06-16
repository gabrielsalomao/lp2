package lista7.atv1;

public class Funcionario extends Pessoa {
    protected double salario;

    Funcionario(String nome, int idade, char sexo, double salario) {
        super(nome, idade, sexo);

        this.salario = salario;
    }

    void setSalario(double salario) {
        this.salario = salario;
    }

    double getSalario() {
        return this.salario;
    }

    double valorINSS() {
        return this.salario * 0.11;
    }

    public void imprimirTudo() {
        System.out.printf("Nome: %s\n Idade: %d\n Sexo: %s\nSalário : %.2f",
                this.nome, this.idade, this.sexo, this.salario);
    }
}
