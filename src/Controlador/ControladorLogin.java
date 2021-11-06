package Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import vista.Login;
import a.Modelo.Consulta;

public class ControladorLogin extends Login {
	
	private static final long serialVersionUID = 1L;

	public ControladorLogin() {
		Consulta consulta = new Consulta();
		btnLogin.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		btnLogin.setBackground(new Color(0, 200, 200));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		btnLogin.setBackground(new Color(0, 153, 153));
	    	}
	    });
		
        btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(consulta.verificarAdmin(txtUser.getText(), txtPassword.getText())) {
        			System.out.println("Logeado dentro del sistema.");
        			lblErrorImage.setVisible(false);
        			lblErrorMessage.setVisible(false);
        			downPanelUser.setBackground(Color.GREEN);
        			downPanelPassword.setBackground(Color.GREEN);
        			// abrir ventana nueva..
        		} else {
        			System.out.println("No existe / mala contrasena");
        			lblErrorImage.setVisible(true);
        			lblErrorMessage.setVisible(true);
        			downPanelUser.setBackground(Color.RED);
        			downPanelPassword.setBackground(Color.RED);
        		}
        	}
        });
	}
	
}
