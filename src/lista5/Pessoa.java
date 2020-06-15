package lista5;

class Pessoa {
    private String nome;
    private char tipo;
    private int qtdeLivrosEmprestados;

    public Pessoa(String nome, char tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean setTipo(char tipo) {
        if (tipo != 'A' || tipo != 'P') {
            return false;
        }
        this.tipo = tipo;
        return true;
    }

    public char getTipo() {
        return this.tipo;
    }

    public boolean podeEmprestar() {
        switch (this.tipo) {
            case 'A':
                if (this.qtdeLivrosEmprestados < 3) {
                    return true;
                } else {
                    return false;
                }
            default:
                if (this.qtdeLivrosEmprestados < 5) {
                    return true;
                } else {
                    return false;
                }
        }
    }

    public void emprestar() {
        this.qtdeLivrosEmprestados++;
    }

    public void devolver() {
        this.qtdeLivrosEmprestados--;
    }

    public void printAll() {
        System.out.println("Nome: " + this.nome + "\nTipo: " + (tipo == 'A' ? "Aluno" : "Professor") +
                "\nQuantidade de livros emprestados: " + this.qtdeLivrosEmprestados);
    }
}
