package Conta;

import java.util.ArrayList;

public class Conta {
	protected String numeroConta = gerarNumeroRandomico();
	protected String agencia;
	protected Double saldo = 0.0;
	protected ArrayList<Movimentacao> movimentacao = new ArrayList();

	public static String gerarNumeroRandomico() {
	    int min = 10000; // menor número possível com 5 dígitos
	    int max = 99999; // maior número possível com 5 dígitos
	    int numero = (int) (Math.random() * (max - min + 1) + min); // gera o número randômico
	    return String.format("%05d", numero); // formata o número como uma string com 5 dígitos
	}

	public String getNumeroConta() {
		return this.numeroConta;
	}
	
	public ArrayList<Movimentacao> getMovimentacao(){
		return this.movimentacao;
	}
	
	public Conta () {
		this.agencia = "123";
	};
	
	public Conta (Double valorInicial) {
		this.saldo = valorInicial;
	};
	
	public Double getSaldo() {
		return this.saldo;
	}
	
	public void movimenta(Movimentacao movimentacao) {	
		if (movimentacao.origem.saldo < movimentacao.valor) {
			System.out.println("A conta não possui saldo suficiente.");
			return;
		}
		
		movimentacao.origem.saldo -= movimentacao.valor;
		movimentacao.origem.movimentacao.add(movimentacao);
		
		movimentacao.destino.saldo += movimentacao.valor;
		movimentacao.destino.movimentacao.add(movimentacao);
	}
}
