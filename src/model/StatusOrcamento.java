package model;

public enum StatusOrcamento {

	EMITIDO("Emitido"), ORCAMENTO("Orçamento"), CANCELADO("Cancelado"), FINALIZADO("Finalizado");

	private String label;

	private StatusOrcamento(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
