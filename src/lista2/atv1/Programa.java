//  Crie uma classe para a representação de pessoas, chamada Pessoa,
//  esta classe deve ter como atributos os dados de uma pessoa,
//  como nome, cpf, idade, altura, peso e profissão. Esta classe
//  deve possuir, também, os seguintes métodos:
//  Um método que apresente todos os seus dados mostrarTudo().
//  Um método fazerAniversario(), que incrementa sua idade em 1 unidade.
//  Um método fazerAtividadeFisica(int quantidadeAtividade), que diminuiu
//  o peso em 100 gramas por quantidade de atividade realizada.
//  Um método comer(int quantidadeComida), que aumenta o peso em 100 gramas
//  por quantidade de comida ingerida.
//  Um método mudarProfissao(String profissao), que altera a atual profissão da pessoa.
//  Seu programa principal deve ler os dados de uma pessoa por um Scanner e possuir um menu,
//  utilizando uma estrutura de repetição e uma estrutura de escolha,
//  onde seja possível utilizar os métodos criados, assim como finalizar o programa.

package lista2.atv1;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String opcao = "0";

        Pessoa pessoa = null;

        do {

            System.out.println(
                    "1 - Cadastrar pessoa " +
                            "\n2 - Mostrar dados" +
                            "\n3 - Fazer aniversário" +
                            "\n4 - Fazer atividade fisica" +
                            "\n5 - Comer" +
                            "\n6 - Mudar profissão" +
                            "\n0 - Sair" +
                            "\nEscolha uma opção:");

            opcao = s.next();

            switch (opcao) {
                case "1":
                    pessoa = CadastrarPessoa(s);
                    System.out.println(pessoa.mostrarTudo());
                    break;
                case "2":
                    if (pessoa == null) {
                        System.out.println("Nenhuma pessoa cadastrada");
                        break;
                    }
                    System.out.println(pessoa.mostrarTudo());
                    break;
                case "3":
                    if (pessoa == null) {
                        System.out.println("Nenhuma pessoa cadastrada");
                        break;
                    }
                    System.out.println("Fazer aniversário");
                    pessoa.fazerAniversario();
                    break;
                case "4":
                    if (pessoa == null) {
                        System.out.println("Nenhuma pessoa cadastrada");
                        break;
                    }
                    System.out.println("Fazer atividade fisica\n" +
                            "Insira a quantidade:");

                    int qnt = s.nextInt();

                    pessoa.fazerAtividadeFisica(qnt);
                    break;
                case "5":
                    if (pessoa == null) {
                        System.out.println("Nenhuma pessoa cadastrada");
                        break;
                    }
                    System.out.println("Fazer atividade fisica\n" +
                            "Insira a quantidade:");

                    qnt = s.nextInt();
                    pessoa.comer(qnt);
                    break;
                case "6":
                    if (pessoa == null) {
                        System.out.println("Nenhuma pessoa cadastrada");
                        break;
                    }
                    System.out.println("Mudar profissão\n" +
                            "Insira a nova profissão:");

                    String novaProfissao = s.next();
                    pessoa.mudarProfissao(novaProfissao);
                    break;
            }
        } while (!opcao.equals("0"));
    }

    public static Pessoa CadastrarPessoa(Scanner s) {
        System.out.println("Cadastro de pessoa");

        Pessoa pessoa = new Pessoa();

        System.out.println("Insira o nome:");
        pessoa.nome = s.next();

        System.out.println("Insira o CPF:");
        pessoa.cpf = s.next();

        System.out.println("Insira a idade:");
        pessoa.idade = s.nextInt();

        System.out.println("Insira a altura:");
        pessoa.altura = s.nextDouble();

        System.out.println("Insira o peso(g):");
        pessoa.peso = s.nextDouble();

        System.out.println("Insira a profissão:");
        pessoa.profissao = s.next();

        return pessoa;
    }
}
