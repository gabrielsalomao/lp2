package lista4;

public class ContaCorrente {
    Pessoa correntista;
    double saldo;
    String agencia;
    String numero;

    ContaCorrente(Pessoa correntista, double saldo, String agencia, String numero) {
        this.correntista = correntista;
        this.saldo = saldo;
        this.agencia = agencia;
        this.numero = numero;
    }

    void printAll() {
        this.correntista.printAll();
        System.out.println("Saldo: " + this.saldo +
                "\nAgência: " + this.agencia + "\nNúmero: " + this.numero);
    }

    void deposito(double valor) {
        this.saldo += valor;
    }

    boolean saque(double valor) {
        if (valor > this.saldo)
            return false;
        this.saldo -= valor;
        return true;
    }

    boolean transferencia(double valor, ContaCorrente contaDestino) {
        if (valor > this.saldo)
            return false;
        this.saldo -= valor;
        contaDestino.saldo += valor;
        return true;
    }
}
