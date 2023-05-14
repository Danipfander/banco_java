package Conta;

public class Investimento extends Conta {

	public String tipo;
	
	public Investimento aplicar(Movimentacao investimento) {	
		super.movimentacao.add(investimento);
		super.saldo += investimento.valor;
		
		return this;
	}
	
	public Investimento (String tipo) {
		this.tipo = tipo;
	}
}
