package Conta;

import java.util.ArrayList;

public class Usuario extends Conta {
	public String senha;
	public ArrayList<Investimento> investimento = new ArrayList();
	
	public Usuario (String senha) {
		this.senha = senha;
	}
	
	public Usuario login(String senha) {
		if(this.senha.equals(senha)) {
			return this;
		}
		
		return null;
	}
	
	public Boolean deposito (Movimentacao deposito) {
		super.movimenta(deposito);		
		return true;
	}
	
	public void aplicar (Double valor, Investimento destino) {
		destino.movimenta(new Movimentacao(this, valor, destino));
	}
	
	public void boleto (Boleto boleto) {
		super.movimenta(new Movimentacao(this, boleto.valor, boleto));
	}
}
