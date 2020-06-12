package lista4;

public class Pessoa {
    String nome;
    int idade;
    String cpf;

    Pessoa(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    void printAll() {
        System.out.println("Nome: " + this.nome + "\nIdade: " + this.idade + "\nCPF: " + this.cpf + "\n");
    }
}
