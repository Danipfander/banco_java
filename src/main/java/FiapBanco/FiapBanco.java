package FiapBanco;

import Conta.Boleto;
import Conta.Conta;
import Conta.Investimento;
import Conta.Movimentacao;
import Conta.Usuario;

public class FiapBanco {

	public static void main(String[] args) {
		Usuario usuario = login();
		usuario.deposito(new Movimentacao(new Conta(1500.0), 1500.0, usuario));
		
		transferencia(usuario);
		investimento(usuario);
		boleto(usuario);
		
		paginaInicial(usuario);
		extrato(usuario);		
	}
	
	public static void loggerLine() {
		System.out.println("------------------------------------------------");
	}
	
	public static Usuario login () {
		System.out.println("Execução do metodo (login)");
		
		String senha = "1234";
		
		Usuario autenticacao = new Usuario(senha).login(senha);
		loggerLine();
		
		if(autenticacao != null) {
			System.out.println("> Usuário autenticado com sucesso!");
		} else {
			System.out.println("> Senha incorreta ou não cadastrado.");
		}
		
		loggerLine();
		 
		System.out.println("Fim da execução do metodo (login)");
		
		return autenticacao;
	}
	
	public static void paginaInicial (Usuario conta) {
		System.out.println("Execução do metodo (paginaInicial)");
		loggerLine();
		
		System.out.println("> Saldo em conta: R$ "+ conta.getSaldo());
		loggerLine();
		for (Investimento inv : conta.investimento) {
			System.out.println("> " + inv.tipo + ": R$ " + inv.getSaldo());
		}
		
		loggerLine();
		System.out.println("Fim da execução do metodo (paginaInicial)");
	}
	
	public static void extrato (Usuario conta) {
		System.out.println("Execução do metodo (extrato)");
		loggerLine();
		for (Movimentacao movimentacao : conta.getMovimentacao()) {
			if (movimentacao.origem.getNumeroConta().equals(conta.getNumeroConta())) {
				System.out.println("> Enviou - R$ " + movimentacao.valor + " para " + movimentacao.destino.getNumeroConta());
			} else {
				System.out.println("> Recebeu - R$ " + movimentacao.valor + " de " + movimentacao.destino.getNumeroConta());
			}
		}
		loggerLine();
		System.out.println("Fim da execução do metodo (extrato)");
	}

	public static void transferencia (Usuario conta) {
		System.out.println("Execução do metodo (transferencia)");
		loggerLine();
		
		System.out.println("Saldo antes da transferencia: R$ " + conta.getSaldo());
		
		Usuario outro = new Usuario("1234");
		
		conta.movimenta(new Movimentacao(conta, 100.0, outro));
		
		System.out.println("Saldo depois da transferencia: R$ " + conta.getSaldo());
		System.out.println("Saldo na outra conta: R$ " + outro.getSaldo());
		
		loggerLine();
		System.out.println("Fim da execução do metodo (transferencia)");
	}
	
	public static void investimento (Usuario conta) {
		System.out.println("Execução do metodo (investimento)");
		loggerLine();
		
		System.out.println("Saldo antes do investimento: R$ " + conta.getSaldo());
		
		Investimento poupanca = new Investimento("Poupança");
		conta.investimento.add(poupanca);
		
		conta.aplicar(1000.0, poupanca);
		
		System.out.println("Saldo depois do investimento: R$ " + conta.getSaldo());
		System.out.println("Saldo na conta de investimento: R$ " + poupanca.getSaldo());
		
		loggerLine();
		System.out.println("Fim da execução do metodo (investimento)");
	}
	
	public static void boleto (Usuario conta) {
		System.out.println("Execução do metodo (boleto)");
		loggerLine();
		
		System.out.println("Saldo antes do pagamento do boleto: R$ " + conta.getSaldo());
		
		conta.boleto(new Boleto(275.0));
		
		System.out.println("Saldo depois do pagamento do boleto: R$ " + conta.getSaldo());
		
		loggerLine();
		System.out.println("Fim da execução do metodo (boleto)");
	}
	
}
