package lista5;

import java.util.ArrayList;
import java.util.Scanner;

class Utils {
    public Pessoa cadastrarPessoa(Scanner s) {

        System.out.println("Nome:");
        var nome = s.next();

        System.out.println("Tipo(A/P):");
        var tipo = s.next();

        return new Pessoa(nome, tipo.charAt(0));
    }

    public void visualizarPessoas(ArrayList<Pessoa> pessoas) {
        if (!pessoas.isEmpty()) {
            for (var i = 0; i < pessoas.size(); i++) {
                System.out.printf("Código: %d \n", i);
                pessoas.get(i).printAll();
                System.out.println("\n");
            }

        } else {
            System.out.println("Nenhuma pessoa cadastrada");
        }
    }

    public Livro cadastrarLivro(Scanner s) {

        System.out.println("Nome:");
        var nome = s.next();

        System.out.println("Ano de lançamento: ");
        var anoLancamento = s.nextInt();

        System.out.println("Quantidade disponínel: ");
        var qtdeExemplaresDisponiveis = s.nextInt();

        return new Livro(nome, anoLancamento, qtdeExemplaresDisponiveis);
    }

    public void visualizarLivros(ArrayList<Livro> livros) {
        if (!livros.isEmpty()) {
            for (int i = 0; i < livros.size(); i++) {
                System.out.println("Código: " + i);
                livros.get(i).printAll();
            }
        } else {
            System.out.println("Nenhum livro cadastrado");
        }
    }

    public void visualizarEmprestimos(ArrayList<Emprestimo> emprestimos) {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo cadastrado:");
        } else {
            for (int i = 0; i < emprestimos.size(); i++) {
                System.out.println("Código:" + i +
                        "\nPessoa: " + emprestimos.get(i).getPessoa().getNome() +
                        "\nLivro: " + emprestimos.get(i).getLivro().getNome());
            }
        }
    }

}
