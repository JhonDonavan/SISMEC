package model;

public enum TipoCombustivel {
	NAO_POSSUI("Nao possui"), GASOLINA("Gasolina"), ETANOL("Etanol"), DIESEL("Diesel"), GNV("GNV");

	private String label;

	private TipoCombustivel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
