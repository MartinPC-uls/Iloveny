package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AgregarUsuario extends JFrame{

	private static final long serialVersionUID = 1744095522065285861L;
	public JTextField textoID;
	public JTextField textoNombre;
	public JTextField textoCantidad;
	public JTextField textoPrecio;
	public JTextField textField_4;
	public JLabel lblNombre;
	public JLabel lblApellidos;
	public JLabel lblRut;
	public JLabel lblTelefono;
	public JButton btnAgregar;
	
	public AgregarUsuario() {
		setUndecorated(true);
    	getContentPane().setBackground(new Color(51,51,51));
        try {
		initialize();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	
	private void initialize() throws IOException {
		setResizable(false);
        setVisible(true);
        setBounds(100, 100, 473, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);
        
        
        JLabel lblAgregar = new JLabel();
        lblAgregar.setVerticalAlignment(SwingConstants.CENTER);
        lblAgregar.setText("Agregar Usuario");
        lblAgregar.setHorizontalAlignment(SwingConstants.CENTER);
        lblAgregar.setForeground(Color.WHITE);
        lblAgregar.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
        lblAgregar.setBounds(0, 29, 473, 35);
        getContentPane().add(lblAgregar);
        
        textoID = new JTextField();
        textoID.setBounds(24, 96, 408, 20);
        getContentPane().add(textoID);
        textoID.setColumns(10);
        
        textoNombre = new JTextField();
        textoNombre.setColumns(10);
        textoNombre.setBounds(24, 154, 408, 20);
        getContentPane().add(textoNombre);
        
        textoCantidad = new JTextField();
        textoCantidad.setColumns(10);
        textoCantidad.setBounds(24, 208, 408, 20);
        getContentPane().add(textoCantidad);
        
        textoPrecio = new JTextField();
        textoPrecio.setColumns(10);
        textoPrecio.setBounds(24, 265, 408, 20);
        getContentPane().add(textoPrecio);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(24, 322, 408, 20);
        getContentPane().add(textField_4);
        
        lblNombre = new JLabel("Nombre:");
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setBounds(24, 75, 192, 14);
        getContentPane().add(lblNombre);
        
        lblApellidos = new JLabel("Apellidos");
        lblApellidos.setForeground(Color.WHITE);
        lblApellidos.setBounds(24, 129, 192, 14);
        getContentPane().add(lblApellidos);
        
        lblRut = new JLabel("Rut:");
        lblRut.setForeground(Color.WHITE);
        lblRut.setBounds(24, 185, 192, 14);
        getContentPane().add(lblRut);
        
        lblTelefono = new JLabel("Telefono:");
        lblTelefono.setForeground(Color.WHITE);
        lblTelefono.setBounds(24, 239, 192, 14);
        getContentPane().add(lblTelefono);
        
        btnAgregar = new JButton();
        btnAgregar.setText("AGREGAR");
        btnAgregar.setFocusPainted(false);
        btnAgregar.setBorderPainted(false);
        btnAgregar.setBorder(null);
        btnAgregar.setBackground(new Color(0, 153, 153));
        btnAgregar.setBounds(76, 440, 314, 40);
        getContentPane().add(btnAgregar);
        
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setBounds(24, 297, 192, 14);
        getContentPane().add(lblEmail);
        
	}
}