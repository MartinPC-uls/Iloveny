package vista;

public class Inicializador {
	
	private static Login login = new Login();
	
	public static void main(String[] args) {
                System.out.println("Aplicación iniciada correctamente.");
		login.frame.setVisible(true);
	}
	
}
