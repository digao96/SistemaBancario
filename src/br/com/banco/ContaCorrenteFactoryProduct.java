package br.com.banco;

public class ContaCorrenteFactoryProduct implements ContaFactory {
    @Override
    public ContaBancaria criarConta(Pessoa titular, Banco banco, int nroConta, double saldo, String senha) {
        return new ContaCorrente(titular, banco, nroConta, saldo, senha);
    }
}




