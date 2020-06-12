package lista4;

import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        var pessoa1 = new Pessoa("João", 18, "000.000.000-00");
        var pessoa2 = new Pessoa("Maria", 18, "000.000.000-00");

        var conta1 = new ContaCorrente(pessoa1, 1000, "0000", "00001");
        var conta2 = new ContaCorrente(pessoa2, 1000, "0000", "00002");

        var s = new Scanner(System.in);

        var opcao = "0";

        do {
            System.out.println("1 - Depositar na conta 1" +
                    "\n2 - Sacar da conta 1" +
                    "\n3 - Transferir da conta 1 para conta 2" +
                    "\n4 - Ver todos os dados da conta 1" +
                    "\n5 - Depositar na conta 2" +
                    "\n6 - Sacar da conta 2" +
                    "\n7 - Transferir da conta 2 para conta 1" +
                    "\n8 - Ver todos os dados da conta 2" +
                    "\n0 - Sair" +
                    "\nEscolha uma opção: ");

            opcao = s.next();

            switch (opcao) {
                case "1":
                    System.out.println("Insira o valor que deseja depositar na conta 1: ");
                    double valor = s.nextDouble();
                    conta1.deposito(valor);
                    break;
                case "2":
                    System.out.println("Insira o valor que deseja sacar da conta 1: ");
                    valor = s.nextDouble();

                    if (!conta1.saque(valor))
                        System.out.println("O saque ultrapassou o saldo da conta");
                    break;
                case "3":
                    System.out.println("Insira o valor que deseja transferir da conta 1 para conta 2: ");
                    valor = s.nextDouble();

                    if (!conta1.transferencia(valor, conta2))
                        System.out.println("A trânsferencia ultrapassou o saldo da conta 1");
                    break;
                case "4":
                    conta1.printAll();
                    break;
                case "5":
                    System.out.println("Insira o valor que deseja depositar na conta 2: ");
                    valor = s.nextDouble();
                    conta2.deposito(valor);
                    break;
                case "6":
                    System.out.println("Insira o valor que deseja sacar da conta 2: ");
                    valor = s.nextDouble();

                    if (!conta2.saque(valor))
                        System.out.println("O saque ultrapassou o saldo da conta");
                    break;
                case "7":
                    System.out.println("Insira o valor que deseja transferir da conta 2 para conta 1: ");
                    valor = s.nextDouble();

                    if (!conta2.transferencia(valor, conta1))
                        System.out.println("A trânsferencia ultrapassou o saldo da conta 2");
                    break;
                case "8":
                    conta2.printAll();
                    break;
            }
        } while (!opcao.equals("0"));
    }
}
