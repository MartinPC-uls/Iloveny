package vista;

public class Inicializador {
	
	public static void main(String args[]) {
		System.out.println("Hola mundo:3");
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
	
}
