package lista7.atv1;

public class Pessoa {
    protected String nome;
    protected int idade;
    protected char sexo = 'A';

    Pessoa(String nome, int idade, char sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    void setNome(String nome) {
        this.nome = nome;
    }

    void setIdade(int idade) {
        this.idade = idade;
    }

    void setSexo(char sexo) {
        this.sexo = sexo;
    }

    String getNome() {
        return this.nome;
    }

    int getIdade() {
        return this.idade;
    }

    char getSexo() {
        return this.sexo;
    }

    public void imprimirTudo() {
        System.out.printf("Nome: %s\n Idade: %d\n Sexo: %s", this.nome, this.idade, this.sexo);
    }
}
