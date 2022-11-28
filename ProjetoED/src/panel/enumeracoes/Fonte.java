package panel.enumeracoes;

public enum Fonte {
	
	ARIAL("Arial");
	
	Fonte(final String fonte) {
		this.fonte = fonte;
	}
	
	private final String fonte;
	
	public String getFonte() {
		return fonte;
	}
	
	@Override
	public String toString() {
		return fonte;
	}
}