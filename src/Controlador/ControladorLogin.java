package Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import vista.Login;
import a.Modelo.Consulta;

public class ControladorLogin {
	
	
	public ControladorLogin() {
		Consulta consulta = new Consulta();
		Login login = new Login();
		login.btnLogin.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		login.btnLogin.setBackground(new Color(0, 200, 200));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		login.btnLogin.setBackground(new Color(0, 153, 153));
	    	}
	    });
		
        login.btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(consulta.verificarAdmin(login.txtJtextfield.getText(), login.pwdJpasswordfield.getText())) {
        			System.out.println("Logeado dentro del sistema.");
        			// abrir ventana nueva..
        		} else {
        			System.out.println("No existe/ mala contrasena");
        		}
        	}
        });
	}
}
