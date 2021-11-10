package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import a.Modelo.Consulta;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarUsuario extends Administracion {

	public JTextField txtNombre;
	public JTextField txtApellidos;
	public JTextField txtRut;
	public JTextField txtTelefono;
	public JTextField txtEmail;
	public JLabel lblNombre;
	public JLabel lblApellidos;
	public JLabel lblRut;
	public JLabel lblTelefono;
	public JButton btnAgregar;
	private Consulta consulta = new Consulta();
	private JDialog _frame;
	
	private String rutAntiguo = "";
	
	public AgregarUsuario(JButton buttonToPress) {
		try {
       	 	initialize(buttonToPress);
			_frame.getContentPane().setBackground(new Color(51,51,51));
        	} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initialize(JButton buttonToPress) throws IOException {
		 _frame = new JDialog();
		 _frame.setResizable(false);
	        _frame.setVisible(true);
	        _frame.setBounds(100, 100, 473, 520);
	
	        _frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	        _frame.getContentPane().setLayout(null);
	        
	        JLabel lblAgregar = new JLabel();
	        lblAgregar.setVerticalAlignment(SwingConstants.CENTER);
	        lblAgregar.setText("Agregar Usuario");
	        lblAgregar.setHorizontalAlignment(SwingConstants.CENTER);
	        lblAgregar.setForeground(Color.WHITE);
	        lblAgregar.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
	        lblAgregar.setBounds(0, 29, 473, 35);
	        _frame.getContentPane().add(lblAgregar);
	        
	        txtNombre = new JTextField();
	        txtNombre.setBounds(24, 96, 408, 20);
	        _frame.getContentPane().add(txtNombre);
	        txtNombre.setColumns(10);
	        
	        txtApellidos = new JTextField();
	        txtApellidos.setColumns(10);
	        txtApellidos.setBounds(24, 154, 408, 20);
	        _frame.getContentPane().add(txtApellidos);
	        
	        txtRut = new JTextField();
	        txtRut.setColumns(10);
	        txtRut.setBounds(24, 208, 408, 20);
	        _frame.getContentPane().add(txtRut);
	        
	        txtTelefono = new JTextField();
	        txtTelefono.setColumns(10);
	        txtTelefono.setBounds(24, 265, 408, 20);
	        _frame.getContentPane().add(txtTelefono);
	        
	        txtEmail = new JTextField();
	        txtEmail.setColumns(10);
	        txtEmail.setBounds(24, 322, 408, 20);
	        _frame.getContentPane().add(txtEmail);
	        
	        lblNombre = new JLabel("Nombre:");
	        lblNombre.setForeground(Color.WHITE);
	        lblNombre.setBounds(24, 75, 192, 14);
	        _frame.getContentPane().add(lblNombre);
	        
	        lblApellidos = new JLabel("Apellidos");
	        lblApellidos.setForeground(Color.WHITE);
	        lblApellidos.setBounds(24, 129, 192, 14);
	        _frame.getContentPane().add(lblApellidos);
	        
	        lblRut = new JLabel("Rut:");
	        lblRut.setForeground(Color.WHITE);
	        lblRut.setBounds(24, 185, 192, 14);
	        _frame.getContentPane().add(lblRut);
	        
	        lblTelefono = new JLabel("Telefono:");
	        lblTelefono.setForeground(Color.WHITE);
	        lblTelefono.setBounds(24, 239, 192, 14);
	        _frame.getContentPane().add(lblTelefono);
	        
	        btnAgregar = new JButton();
	        btnAgregar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		String nombreUsuario = txtNombre.getText();
	        		String apellidos = txtApellidos.getText();
	        		String rut = txtRut.getText();
	        		String telefono = txtTelefono.getText();
	        		String email = txtEmail.getText();
	        		if (btnAgregar.getText().equals("AGREGAR")) {
		        		consulta.addUsuario(nombreUsuario, apellidos, rut, telefono, email);
	        		} else if (btnAgregar.getText().equals("MODIFICAR")){
	        			consulta.updtUsuario(rut, rutAntiguo, nombreUsuario, apellidos, telefono, email);
	        		}
	        		buttonToPress.doClick();
	        		_frame.dispose();
	        	}
	        });
	        btnAgregar.setText("AGREGAR");
	        btnAgregar.setFocusPainted(false);
	        btnAgregar.setBorderPainted(false);
	        btnAgregar.setBorder(null);
	        btnAgregar.setBackground(new Color(0, 153, 153));
	        btnAgregar.setBounds(76, 440, 314, 40);
	        _frame.getContentPane().add(btnAgregar);
	        
	        JLabel lblEmail = new JLabel("Email:");
	        lblEmail.setForeground(Color.WHITE);
	        lblEmail.setBounds(24, 297, 192, 14);
	        _frame.getContentPane().add(lblEmail);
        
	}
	
	public void setElements(String nombre, String apellidos, String rut, String telefonos, String email) {
		txtNombre.setText(nombre);
		txtApellidos.setText(apellidos);
		txtRut.setText(rut);
		txtTelefono.setText(telefonos);
		txtEmail.setText(email);
		rutAntiguo = rut;
		btnAgregar.setText("MODIFICAR");
	}
	
}