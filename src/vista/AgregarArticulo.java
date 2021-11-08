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

public class AgregarArticulo extends JFrame{
	public JTextField textoID;
	public JTextField textoNombre;
	public JTextField textoCantidad;
	public JTextField textoPrecio;
	public JTextField textField_4;
	public JTextField textField_5;
	public JLabel lblidTipoObjeto;
	public JLabel lblIngreseElNombre;
	public JLabel lblIngreseLaCantidad;
	public JLabel lblIngreseElPrecio;
	public JButton btnAgregar;
	
	public AgregarArticulo() {
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
        lblAgregar.setText("Agregar Art\u00EDculo");
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
        
        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(24, 379, 408, 20);
        getContentPane().add(textField_5);
        
        lblidTipoObjeto = new JLabel("Ingrese la ID del art\u00EDculo:");
        lblidTipoObjeto.setForeground(Color.WHITE);
        lblidTipoObjeto.setBounds(24, 75, 192, 14);
        getContentPane().add(lblidTipoObjeto);
        
        lblIngreseElNombre = new JLabel("Ingrese el nombre del art\u00EDculo:");
        lblIngreseElNombre.setForeground(Color.WHITE);
        lblIngreseElNombre.setBounds(24, 129, 192, 14);
        getContentPane().add(lblIngreseElNombre);
        
        lblIngreseLaCantidad = new JLabel("Ingrese la cantidad del art\u00EDculo:");
        lblIngreseLaCantidad.setForeground(Color.WHITE);
        lblIngreseLaCantidad.setBounds(24, 185, 192, 14);
        getContentPane().add(lblIngreseLaCantidad);
        
        lblIngreseElPrecio = new JLabel("Ingrese el precio del art\u00EDculo:");
        lblIngreseElPrecio.setForeground(Color.WHITE);
        lblIngreseElPrecio.setBounds(24, 239, 192, 14);
        getContentPane().add(lblIngreseElPrecio);
        
        btnAgregar = new JButton();
        btnAgregar.setText("AGREGAR");
        btnAgregar.setFocusPainted(false);
        btnAgregar.setBorderPainted(false);
        btnAgregar.setBorder(null);
        btnAgregar.setBackground(new Color(0, 153, 153));
        btnAgregar.setBounds(76, 440, 314, 40);
        getContentPane().add(btnAgregar);
        
	}
}