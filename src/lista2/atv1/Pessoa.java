package lista2.atv1;

public class Pessoa {
    String nome;
    String cpf;
    int idade;
    double altura;
    double peso;
    String profissao;

    public String mostrarTudo() {
        return "Nome: " + this.nome + "\nCPF: " + this.cpf +
                "\nIdade: " + this.idade + "\nAltura: " + this.altura +
                "\nPeso: " + this.peso + "\nProfissão: " + this.profissao;
    }

    public void fazerAniversario() {
        this.idade++;
    }

    public void fazerAtividadeFisica(int quantidadeAtividade) {
        this.peso -= 100 * quantidadeAtividade;
    }

    public void comer(int quantidadeComida) {
        this.peso += 100 * quantidadeComida;
    }

    public void mudarProfissao(String profissao) {
        this.profissao = profissao;
    }
}
