package br.com.banco;

public class ContaPoupancaFactoryProduct implements ContaFactory {
    @Override
    public ContaBancaria criarConta(Pessoa titular, Banco banco, int nroConta, double saldo, String senha) {
        return new ContaPoupanca(titular, banco, nroConta, saldo, senha);
    }
}
