package br.com.banco;

public class ContaDecoratorTransacoes extends Wrapper {

    public ContaDecoratorTransacoes(ContaBancaria conta) {
        super(conta);
    }

    @Override
    public void realizarOperacao() {
        super.realizarOperacao();
        System.out.println("Registrando transacción en la cuenta: " + conta.getNroConta());
    }
}
