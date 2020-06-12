package lista5;

public class Livro {
    private String nome;
    private int anoLancamento;
    private int qtdeExemplaresDisponiveis;

    public Livro(String nome, int anoLancamento, int qtdeExemplaresDisponiveis) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.qtdeExemplaresDisponiveis = qtdeExemplaresDisponiveis;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setQtdeExemplaresDisponiveis(int qtdeExemplaresDisponiveis) {
        this.qtdeExemplaresDisponiveis = qtdeExemplaresDisponiveis;
    }

    public int getQtdeExemplaresDisponiveis() {
        return this.qtdeExemplaresDisponiveis;
    }

    public boolean podeSerEmprestado() {
        return this.qtdeExemplaresDisponiveis > 0;
    }

    public void emprestar() {
        qtdeExemplaresDisponiveis--;
    }

    public void devolver() {
        qtdeExemplaresDisponiveis++;
    }

    public void printAll() {
        System.out.println("Nome: " + this.nome + "\nLançamento: " + this.anoLancamento +
                "\nExemplares disponiveis: " + this.anoLancamento);
    }
}
