package lista5;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Scanner;

class Programa {
    public static void main(String[] args) {

        var s = new Scanner(System.in);

        var utils = new Utils();

        var pessoas = new ArrayList<Pessoa>();
        var livros = new ArrayList<Livro>();
        var emprestimos = new ArrayList<Emprestimo>();

        var opcao = "0";

        do {
            System.out.println("1 - Criar uma pessoa" +
                    "\n2 - Visualizar todas as pessoas" +
                    "\n3 - Criar um livro" +
                    "\n4 - Visualizar todos os livros" +
                    "\n5 - Realizar um empréstimo" +
                    "\n6 - Visualizar todos os empréstimos" +
                    "\n7 - Realizar a devolução de um empréstimo" +
                    "\n0 - Sair" +
                    "\nEscolha a opção:");

            opcao = s.next();

            switch (opcao) {
                case "1":
                    var pessoa = utils.cadastrarPessoa(s);
                    pessoas.add(pessoa);
                    break;
                case "2":
                    utils.visualizarPessoas(pessoas);
                    break;
                case "3":
                    var livro = utils.cadastrarLivro(s);
                    livros.add(livro);
                    break;
                case "4":
                    utils.visualizarLivros(livros);
                    break;
                case "5":
                    utils.visualizarPessoas(pessoas);
                    System.out.println("Selecione o código da pessoa:");
                    var codigoDaPessoa = s.nextInt();
                    var pessoaSelecionada = pessoas.get(codigoDaPessoa);
                    if (!pessoaSelecionada.podeEmprestar()) {
                        System.out.println("O livro não pode ser emprestado para essa pessoa");
                        break;
                    }
                    utils.visualizarLivros(livros);
                    System.out.println("Selecione o código do livro:");
                    var codigoDoLivro = s.nextInt();
                    var livroSelecionado = livros.get(codigoDoLivro);
                    if (!livroSelecionado.podeSerEmprestado()) {
                        System.out.println("O livro não pode ser emprestado");
                        break;
                    }
                    var emprestimo = new Emprestimo(pessoaSelecionada, livroSelecionado);
                    emprestimos.add(emprestimo);
                    break;
                case "6":
                    utils.visualizarEmprestimos(emprestimos);
                    break;
                case "7":
                    utils.visualizarEmprestimos(emprestimos);
                    System.out.println("Selecione o empréstimo que deseja devolver:");
                    var codigoDoEmprestimo = s.nextInt();
                    var emprestimoSelecionado = emprestimos.get(codigoDoEmprestimo);
                    emprestimoSelecionado.getPessoa().devolver();
                    emprestimoSelecionado.getLivro().devolver();
                    emprestimos.remove(emprestimoSelecionado);
                    break;
            }

        } while (!opcao.equals("0"));

    }
}
