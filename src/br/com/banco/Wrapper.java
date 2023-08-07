package br.com.banco;

public abstract class Wrapper implements ContaDecorator {

    protected ContaBancaria conta;

    public Wrapper(ContaBancaria conta) {
        this.conta = conta;
    }

    @Override
    public void realizarOperacao() {
        conta.realizarOperacao();
    }
}