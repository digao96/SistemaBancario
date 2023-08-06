package br.com.banco;

public interface ContaFactoryProduct {
	ContaBancaria criarConta(Pessoa titular, Banco banco, int nroConta, double saldo, String senha);
}
