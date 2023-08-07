package br.com.banco;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		boolean online = true;
		boolean controle = true;
		String menu = " --- Menu Principal --- \n[1] Cadastrar Banco\n[2] Cadastrar Pessoa\n[3] Cadastrar Conta\n"
		+"[4] Listar Contas\n[5] Logar na Conta \n[0] Sair do Programa";
		ArrayList<ContaBancaria> AccountList = new ArrayList<>();
		ArrayList<Banco> BankList = new ArrayList<>();
		ArrayList<Pessoa> PeopleList = new ArrayList<>();

		// Variaveis que armazena a posi��o do array,
		// IdPessoa(PeopleList) - IdBanco(BankList) - IdConta(AccountList)
		int idP = 0;
		int idB = 0;
		int idC = 0;
		
		ContaFactoryProduct contaFactory = null;
		
		do {
			int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Banco IFRS / Campus Restinga", JOptionPane.QUESTION_MESSAGE));

			switch (opcao) {

			// CADASTRANDO O BANCO
			case 1:
				Banco banco = new Banco(null, null, 0);
				banco.cadastrarBanco(banco);
				//cadastrarBanco(banco);
				banco = new Banco(banco.getNome(), banco.getCNPJ(), banco.getNroBanco());
				BankList.add(banco);
				JOptionPane.showMessageDialog(null, "Banco Cadastrado");
				break;
				
			// CADASTRANDO PESSOA
			case 2:
				Pessoa pessoa = new Pessoa(null, null, 0, null);
				cadastrarPessoa(pessoa);
				pessoa = new Pessoa(pessoa.getNome(), pessoa.getSobrenome(), pessoa.getIdade(), pessoa.getCpf());
				PeopleList.add(pessoa);
				JOptionPane.showMessageDialog(null, "Pessoa Cadastrada");
				break;

			// CADASTRANDO CONTA
			case 3:
				if ((PeopleList.isEmpty() == true) || (BankList.isEmpty() == true)) {
					JOptionPane.showMessageDialog(null, "Cadastre uma Pessoa e um Banco no Sistema",
							"N�o � poss�vel criar uma conta", JOptionPane.INFORMATION_MESSAGE);
				} else {
					int x = Integer.parseInt(JOptionPane
							.showInputDialog("Deseja Cadastrar qual Conta?\n[1] Conta Poupan�a\n[2] Conta Corrente"));

					if (x == 1) {
<<<<<<< Updated upstream
						contaFactory = new ContaPoupancaFactoryProduct();
					}

					else if (x == 2) {
						contaFactory = new ContaCorrenteFactoryProduct();
=======
					    ContaPoupanca contaP = new ContaPoupanca(null, null, 0, 0, null);
					    cadastrarConta(contaP, BankList, PeopleList, idP, idB);
					    contaP = new ContaPoupanca(contaP.getTitular(), contaP.getBanco(), contaP.getNroConta(),
					            contaP.getSaldo(), contaP.getSenha());
					    
					    // Aplicar el decorador de transacciones
					    ContaDecorator contaDecorada = new ContaDecoratorTransacoes(contaP);
					    AccountList.add(contaDecorada);
					    
					    JOptionPane.showMessageDialog(null, "Conta Poupança Adicionada");
					}

					if (x == 2) {
					    ContaCorrente contaC = new ContaCorrente(null, null, 0, 0, null);
					    cadastrarConta(contaC, BankList, PeopleList, idP, idB);
					    contaC = new ContaCorrente(contaC.getTitular(), contaC.getBanco(), contaC.getNroConta(),
					            contaC.getSaldo(), contaC.getSenha());
					    
					    // Aplicar el decorador de transacciones y de intereses
					    ContaDecorator contaDecorada = new ContaDecoratorTransacoes(contaC);
					    contaDecorada = new ContaDecoratorIntereses(contaDecorada, 0.02); // 2% de intereses
					    
					    AccountList.add(contaDecorada);
					    
					    JOptionPane.showMessageDialog(null, "Conta Corrente Adicionada");
>>>>>>> Stashed changes
					}
                    if (contaFactory != null) {
                        ContaBancaria conta = cadastrarConta(contaFactory, BankList, PeopleList, idP, idB);
                        AccountList.add(conta);
                        JOptionPane.showMessageDialog(null, "Conta Adicionada");
                    }
				}
				break;
				
			// LISTANDO TODAS  CONTAS
			case 4:
				StringBuffer listaConta = new StringBuffer();
				if (AccountList.isEmpty() == true) {
					JOptionPane.showMessageDialog(null, "N�o h� nenhuma conta cadastrada!");
					break;
				} else {
					for (int x = 0; x < AccountList.size(); x++) {
						metodoInstanceof(AccountList, x, listaConta);
					}
				}
				JOptionPane.showMessageDialog(null, listaConta, "Contas Cadastradas", JOptionPane.PLAIN_MESSAGE);
				break;
				
			// LOGIN PARA ENTRAR NA CONTA
			case 5:
				if (AccountList.isEmpty() == true) {
					JOptionPane.showMessageDialog(null, "N�o h� nenhuma conta cadastrada!");
					break;
				} else {
					int i = 0;
					StringBuffer listaPessoa = new StringBuffer();
					
					for (ContaBancaria lista : AccountList) {
						listaPessoa.append("[" + i + "] " + lista.Titular.Nome + " " + lista.Titular.Sobrenome + "\n");
						i++;
					}
					idC = Integer.parseInt(
							JOptionPane.showInputDialog(null, listaPessoa, "Selecione uma Conta", JOptionPane.PLAIN_MESSAGE));
				
					ContaBancaria contaBancaria = AccountList.get(idC);
					String senha = JOptionPane.showInputDialog("Digite sua Senha ");
					
					
					// VERIFICANDO SENHA PARA ENTRAR NO PAINEL DE CONTROLE DA CONTA!
					if (contaBancaria.verificaSenha(senha) == true) {
						do {
							
					        StringBuffer painelConta = new StringBuffer();
					        metodoInstanceof(AccountList, idC, painelConta);
					        painelConta.append("___________________________");
					        painelConta.append("\n[1] Sacar");
					        painelConta.append("\n[2] Depositar");
					        painelConta.append("\n[3] Novo Mês");
					        painelConta.append("\n[0] Sair da Conta");

					        int opcaoPainelConta = Integer.parseInt(
					            JOptionPane.showInputDialog(null, painelConta, "Painel de Controle - Conta " + contaBancaria.getNroConta(), JOptionPane.PLAIN_MESSAGE));
					            
					        // Utilizar el método realizarOperacao() de la instancia decorada
					        contaBancaria.realizarOperacao(opcaoPainelConta);

					        if (opcaoPainelConta == 0) {
					            controle = false;
					            break;
					        }
							
						} while (controle = true);
					}
						 else {
								JOptionPane.showMessageDialog(null, "Senha Incorreta!");
								break;
							}
				}
					break;
			
			// SAIR DO PROGRAMA		
			case 0:
				online = false;
				JOptionPane.showMessageDialog(null, "Saiu do Programa\nRodrigo Borges Rodrigues\n2019011764");
				break;

			// LOOPING	
			default:
				JOptionPane.showMessageDialog(null, "Op��o n�o encontrada");
				break;
			}

		} while (online == true);

	}

	static void cadastrarBanco(Banco cadastraBanco) {
		cadastraBanco.setNome(JOptionPane.showInputDialog("Nome do Banco: "));
		cadastraBanco.setCNPJ(JOptionPane.showInputDialog("CNPJ do Banco " + cadastraBanco.getNome()));
		cadastraBanco.setNroBanco(
				Integer.parseInt(JOptionPane.showInputDialog("N�mero do Banco " + cadastraBanco.getNome())));
	}

	static void cadastrarPessoa(Pessoa cadastraPessoa) {
		cadastraPessoa.setNome(JOptionPane.showInputDialog("Nome: "));
		cadastraPessoa.setSobrenome(JOptionPane.showInputDialog("Sobre Nome: "));
		cadastraPessoa.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade: ")));
		cadastraPessoa.setCpf(JOptionPane.showInputDialog("CPF: "));
	}
	
    static ContaBancaria cadastrarConta(ContaFactoryProduct contaFactory, ArrayList<Banco> BankList,
            ArrayList<Pessoa> PeopleList, int idP, int idB) {
        // Listando as Pessoas e Selecionando e guardando a info na variavel = ID PESSOA
        // ... (resto del código de la función)

        // Informa��es Adcionais
        int nroConta = Integer.parseInt(JOptionPane.showInputDialog("N�mero da Conta: "));
        double saldo = Integer.parseInt(JOptionPane.showInputDialog("Saldo na Conta: "));
        String senha = JOptionPane.showInputDialog("Senha da Conta: ");
        
        return contaFactory.criarConta(PeopleList.get(idP), BankList.get(idB), nroConta, saldo, senha);
    }

	
	static void metodoInstanceof (ArrayList<ContaBancaria> AccountList, int x, StringBuffer buffer) {
		if (AccountList.get(x) instanceof ContaPoupanca) {
			ContaPoupanca contaP = (ContaPoupanca) AccountList.get(x);
			buffer.append("[Conta Poupan�a]");
			contaP.info(buffer);
		}
		if (AccountList.get(x) instanceof ContaCorrente) {
			ContaCorrente contaC = (ContaCorrente) AccountList.get(x);
			buffer.append("[Conta Corrente]");
			contaC.info(buffer);
		}
	}

	static void opcaoConta (int opcao, ContaBancaria conta, boolean contador) {
		
		if (conta instanceof ContaPoupanca) {
			ContaPoupanca contaP = (ContaPoupanca) conta;
			switch (opcao) {
			case 1: 
				contaP.saque();
				break;
			case 2:
				contaP.deposito();
				break;
				
			case 3:	
				contaP.novoMes();
				break;
				
			case 0:
				contador = false;
				break;
			}
		}
		if (conta instanceof ContaCorrente) {
			ContaCorrente contaC = (ContaCorrente) conta;
			switch (opcao) {
			case 1: 
				contaC.saque();
				break;
			case 2:
				contaC.deposito();
				break;
				
			case 3:
				contaC.novoMes();
				break;
				
			case 0:
				contador = false;
				break;
			}	
		}
	}
}
