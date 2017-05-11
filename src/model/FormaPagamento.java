package model;

public enum FormaPagamento {
	DINHEIRO("Dinheiro"),
	CARTAO_CREDITO("Cartão de Credito"),
	CARTAO_DEBITO("Cartão de débito"),
	CHEQUE("Cheque"),
	BOLETO_BANCARIO("Boleto bancário"),
	DEPOSITO_BANCARIO("Deposito bancário");

	private String descricao;
	
	FormaPagamento(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return descricao;
	}
}
