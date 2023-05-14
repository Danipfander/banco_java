package Conta;

public class Movimentacao {
	public String tipo;
	public Double valor;
	public Conta origem;
	public Conta destino;

	public Movimentacao (Conta origem, Double valor, Conta destino) {
		this.valor = valor;
		this.origem = origem;
		this.destino = destino;
	}
	
}
