package br.com.banco;

public class ContaDecoratorIntereses extends Wrapper {

    private double intereses;

    public ContaDecoratorIntereses(ContaBancaria conta, double intereses) {
        super(conta);
        this.intereses = intereses;
    }

    @Override
    public void realizarOperacao() {
        super.realizarOperacao();
        double saldoActual = conta.getSaldo();
        double nuevoSaldo = saldoActual + (saldoActual * intereses);
        conta.setSaldo(nuevoSaldo);
        System.out.println("Aplicando intereses a la cuenta: " + conta.getNroConta());
    }
}

