package lista7.atv1;

public class Gerente extends Funcionario {
    private String nomeGerencia;

    Gerente(String nome, int idade, char sexo, double salario) {
        super(nome, idade, sexo, salario);

        this.nomeGerencia = nomeGerencia;
    }

    double valorINSS() {
        return this.salario * 0.13;
    }

    public void imprimirTudo() {
        System.out.printf("Nome: %s\n Idade: %d\n Sexo: %s\nSalário : %.2f\nNome gerencia: %s",
                this.nome, this.idade, this.sexo, this.salario, this.nomeGerencia);
    }
}
