package mongodb;

public enum Iloveny {

	ADMINISTRADOR("Administrador"),
	ARTICULO("articulo"),
	USUARIO("usuario"),
	REGISTROCOMPRA("registrocompra"),
	REGISTROVENTA("registroventa");

	private String string;
	
	private Iloveny(String string) {
		this.string = string;
	}
	
	@Override
	public String toString() {
		return string;
	}
	
}
