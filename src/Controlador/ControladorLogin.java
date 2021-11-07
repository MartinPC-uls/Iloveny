package Controlador;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import vista.Administracion;
import vista.Login;
import a.Modelo.Consulta;

public class ControladorLogin {
	
	Timer tm;

	public ControladorLogin() {
		Login login = new Login();
		Consulta consulta = new Consulta();
		eventoCambioColorBtnLogin(login);
		eventoCambiarTxtUser(login);
		eventoCambiarTxtPassword(login);
		eventoClickBtnLogin(login,consulta);
	}
	
	private void eventoCambiarTxtPassword(Login login) {
		login.txtPassword.addFocusListener(new FocusAdapter() {
	       	 @Override
	       	 public void focusLost(FocusEvent e) {
	         		String text = login.txtPassword.getText();
	         		
	         		// cambiar downPanelUser a color rojo, si el usuario es incorrecto.
	         		if (text.length() == 0 || text.length() >16) {
	         			login.txtPassword.setForeground(new Color(170, 170, 170));
	         			if(text.length() == 0) {
	         				login.txtPassword.setText("password");
	         			}
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

	private void eventoCambiarTxtUser(Login login) {
		login.txtUser.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		String text = login.txtUser.getText();
        		// cambiar downPanelUser a color rojo, si el usuario es incorrecto.
        		if (text.length() == 0 || text.length() >20) {
        			if(text.length() == 0) {
        				login.txtUser.setText("Usuario");
        				login.txtUser.setForeground(new Color(170, 170, 170));
        			}
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
        		if (login.txtUser.getForeground().equals(color) && login.txtUser.getText().length() < 20) {
        			login.txtUser.setText("");
        			login.txtUser.setForeground(new Color(255, 255, 255));
        		}
        	}
        });
	}

	private void mostrarAlerta(boolean isPositivo) throws HeadlessException, IOException {
		if(isPositivo) {
			JOptionPane.showMessageDialog(null, "Bienvenido","Mensaje",JOptionPane.PLAIN_MESSAGE,new ImageIcon(ImageIO.read(new File("res/images/success-icon.png"))));
		} else {
			JOptionPane.showMessageDialog(null, "Credenciales no encontradas","Mensaje",JOptionPane.PLAIN_MESSAGE,new ImageIcon(ImageIO.read(new File("res/images/Exclamation-mark-icon.png"))));
		}
	}
	
	private void eventoClickBtnLogin(Login login, Consulta consulta) {
		login.btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(consulta.verificarAdmin(login.txtUser.getText(), login.txtPassword.getText())) {
        			System.out.println("Logeado dentro del sistema.");
        			login.lblErrorImage.setVisible(false);
        			login.lblErrorMessage.setVisible(false);
        			login.downPanelUser.setBackground(Color.GREEN);
        			login.downPanelPassword.setBackground(Color.GREEN);
        				try {
						mostrarAlerta(true);
					} catch (HeadlessException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
        			ControladorAdministracion administracion = new ControladorAdministracion();
        		} else {
        			System.out.println("No existe / mala contrasena");
        			login.lblErrorImage.setVisible(true);
        			login.lblErrorMessage.setVisible(true);
        			login.downPanelUser.setBackground(Color.RED);
        			login.downPanelPassword.setBackground(Color.RED);
        				try {
						mostrarAlerta(false);
					} catch (HeadlessException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
        		}
        	}
        });
	}

	private void eventoCambioColorBtnLogin(Login login) {
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
	}
	
}
