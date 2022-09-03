package br.com.banco;

import javax.swing.JOptionPane;

public class ContaPoupanca extends ContaBancaria {
	
	public ContaPoupanca(Pessoa titular, Banco banco, int nroConta, double saldo,
			String senha) {
		super(titular, banco, nroConta, saldo, senha);
	}

	private double rendimento = 0.5;
	private int saquesMensais = 3;
	
	public void info(StringBuffer buffer) {
		buffer.append("\nBanco: "+this.Banco.getNome());
		buffer.append("\nN�mero da Conta: "+this.NroConta);
		buffer.append("\nTitular: "+this.Titular.Nome+" "+this.Titular.Sobrenome);
		buffer.append("\nSaldo: "+this.Saldo+" R$");
		buffer.append("\nRendimento: "+this.rendimento+"% ao M�s");
		buffer.append("\nSaques Restantes: "+this.saquesMensais);
		buffer.append("\n\n");
	}
	
	public void novoMes() {
		this.Saldo = this.Saldo+rendimento;
		saquesMensais = 3;
	}
	
	public void saque() {
		if (saquesMensais <= 0) {
			JOptionPane.showMessageDialog(null, "Voc� j� sacou tr�s vezes esse m�s!");
		} else {
			double sacar = Integer.parseInt(JOptionPane.showInputDialog("Deseja Sacar quanto na conta Poupan�a?"));
			this.Saldo = Saldo-sacar;
			JOptionPane.showMessageDialog(null, "Saque Realizado com Sucesso!");
			this.saquesMensais = saquesMensais-1;
		}

	}
	
	public void saque(double valor) {
		if (saquesMensais <= 0) {
			JOptionPane.showMessageDialog(null, "Voc� j� sacou tr�s vezes esse m�s!");
		} else {
			this.Saldo = Saldo-valor;
		}
	}

	public double getRendimento() {
		return rendimento;
	}

	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}

	public int getSaquesMensais() {
		return saquesMensais;
	}

	public void setSaquesMensais(int saquesMensais) {
		this.saquesMensais = saquesMensais;
	}
	
	

}
