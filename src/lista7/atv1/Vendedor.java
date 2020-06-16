package lista7.atv1;

public class Vendedor extends Funcionario {
    private double valorVendas;
    private int quantidadeVendas;

    Vendedor(String nome, int idade, char sexo, double salario, double valorVendas, int quantidadeVendas) {
        super(nome, idade, sexo, salario);

        this.valorVendas = valorVendas;
        this.quantidadeVendas = quantidadeVendas;
    }

    public void imprimirTudo() {
        System.out.printf("Nome: %s\n Idade: %d\n Sexo: %s\n" +
                        "Salário : %.2f\nValor de vendas: %s\nQuantidade de vendas: %s",
                this.nome, this.idade, this.sexo, this.salario, this.valorVendas, this.quantidadeVendas);
    }
}
