package Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import vista.Login;
import a.Modelo.Consulta;

public class ControladorLogin {

	public ControladorLogin() {
		Login login = new Login();
		Consulta consulta = new Consulta();
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
        		if(consulta.verificarAdmin(login.txtUser.getText(), login.txtPassword.getText())) {
        			System.out.println("Logeado dentro del sistema.");
        			login.lblErrorImage.setVisible(false);
        			login.lblErrorMessage.setVisible(false);
        			login.downPanelUser.setBackground(Color.GREEN);
        			login.downPanelPassword.setBackground(Color.GREEN);
        			// abrir ventana nueva..
        		} else {
        			System.out.println("No existe / mala contrasena");
        			login.lblErrorImage.setVisible(true);
        			login.lblErrorMessage.setVisible(true);
        			login.downPanelUser.setBackground(Color.RED);
        			login.downPanelPassword.setBackground(Color.RED);
        		}
        	}
        });
		login.txtUser.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		String text = login.txtUser.getText();
        		
        		// cambiar downPanelUser a color rojo, si el usuario es incorrecto.
        		if (text.length() == 0) {
        			login.txtUser.setForeground(new Color(170, 170, 170));
        			login.txtUser.setText("Usuario");
        			login.downPanelUser.setBackground(Color.RED);
        		} else {
        			login.txtUser.setForeground(new Color(255, 255, 255));
        			login.downPanelUser.setBackground(Color.GREEN);
        		}
        	}
        	@Override
        	public void focusGained(FocusEvent e) {
        		String text = login.txtUser.getText();
        		Color color = new Color(170, 170, 170);
        		if (login.txtUser.getForeground().equals(color)) {
        			login.txtUser.setText("");
        			login.txtUser.setForeground(new Color(255, 255, 255));
        		}
        	}
        });
		login.txtPassword.addFocusListener(new FocusAdapter() {
	       	 @Override
	       	 public void focusLost(FocusEvent e) {
	         		String text = login.txtPassword.getText();
	         		
	         		// cambiar downPanelUser a color rojo, si el usuario es incorrecto.
	         		if (text.length() == 0) {
	         			login.txtPassword.setForeground(new Color(170, 170, 170));
	         			login.txtPassword.setText("password");
	         			login.downPanelPassword.setBackground(Color.RED);
	         		} else {
	         			login.txtPassword.setForeground(new Color(255, 255, 255));
	         			login.downPanelPassword.setBackground(Color.GREEN);
	         		}
	         	}
	         	@Override
	         	public void focusGained(FocusEvent e) {
	         		String text = login.txtPassword.getText();
	         		Color color = new Color(170, 170, 170);
	         		if (login.txtPassword.getForeground().equals(color)) {
	         			login.txtPassword.setText("");
	         			login.txtPassword.setForeground(new Color(255, 255, 255));
	         		}
	         	}
	        });
	}
	
}
