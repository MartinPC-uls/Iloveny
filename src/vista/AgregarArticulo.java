package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import a.Modelo.Consulta;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSpinner;

public class AgregarArticulo extends Administracion {

	private static final long serialVersionUID = 1744095522065285861L;
	public JTextField textoPrecio;
	public JTextField textoURLImagen;
	public JLabel lblDescripcion;
	public JLabel lblMarca;
	public JLabel lblTipo;
	public JLabel lblStock;
	public JLabel lblEmail;
	public JButton btnAgregar;
	private JLabel panelImagen;
	private JLabel lblUrlImagen;
	private JFrame frame;
	private Consulta consulta = new Consulta();
	private JDialog _frame;
	private int idArticuloAntiguo = 0;
	private JComboBox comboBox;
	
	public AgregarArticulo(JButton button) {
	        try {
			initialize(button);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initialize(JButton buttonToPress) throws IOException {
		 frame = new JFrame();
		 frame.setResizable(false);
		 
		 frame.setUndecorated(true);
		 frame.getContentPane().setBackground(new Color(51,51,51));
	        frame.setVisible(true);
	        frame.setBounds(100, 100, 463, 411);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	        frame.getContentPane().setLayout(null);
        
        
	        JLabel lblAgregar = new JLabel();
	        lblAgregar.setVerticalAlignment(SwingConstants.CENTER);
	        lblAgregar.setText("Agregar Art\u00EDculo");
	        lblAgregar.setHorizontalAlignment(SwingConstants.CENTER);
	        lblAgregar.setForeground(Color.WHITE);
	        lblAgregar.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
	        lblAgregar.setBounds(0, 29, 473, 35);
	        frame.getContentPane().add(lblAgregar);
	        
	        textoPrecio = new JTextField();
	        textoPrecio.setColumns(10);
	        textoPrecio.setBounds(24, 209, 170, 20);
	        frame.getContentPane().add(textoPrecio);
	        
	        lblDescripcion = new JLabel("Ingrese la descripcion del art\u00EDculo:");
	        lblDescripcion.setForeground(Color.WHITE);
	        lblDescripcion.setBounds(24, 75, 192, 14);
	        frame.getContentPane().add(lblDescripcion);
	        
	        lblMarca = new JLabel("Seleccionar marca:");
	        lblMarca.setForeground(Color.WHITE);
	        lblMarca.setBounds(24, 140, 192, 14);
	        frame.getContentPane().add(lblMarca);
	        
	        lblTipo = new JLabel("Seleccionar Tipo");
	        lblTipo.setForeground(Color.WHITE);
	        lblTipo.setBounds(240, 140, 192, 14);
	        frame.getContentPane().add(lblTipo);
	        
	        lblStock = new JLabel("Ingrese stock:");
	        lblStock.setForeground(Color.WHITE);
	        lblStock.setBounds(240, 197, 77, 14);
	        frame.getContentPane().add(lblStock);
	        
	        btnAgregar = new JButton();/*
	        btnAgregar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		// something else...
	        		button.doClick(); // refresh
	        	}
	        });*/
	        btnAgregar.setText("AGREGAR");
	        btnAgregar.setFocusPainted(false);
	        btnAgregar.setBorderPainted(false);
	        btnAgregar.setBorder(null);
	        btnAgregar.setBackground(new Color(0, 153, 153));
	        btnAgregar.setBounds(76, 341, 314, 40);
	        frame.getContentPane().add(btnAgregar);
	        
	        JLabel lblPrecio = new JLabel("Ingrese precio:");
	        lblPrecio.setForeground(Color.WHITE);
	        lblPrecio.setBounds(24, 197, 192, 14);
	        frame.getContentPane().add(lblPrecio);
	        
	        panelImagen = new JLabel();
	        panelImagen.setBounds(505, 76, 170, 163);
	        frame.getContentPane().add(panelImagen);
	        
	        lblUrlImagen = new JLabel("Ingrese URL imagen:");
	        lblUrlImagen.setForeground(Color.WHITE);
	        lblUrlImagen.setBounds(24, 250, 192, 14);
	        frame.getContentPane().add(lblUrlImagen);
	        
	        textoURLImagen = new JTextField();
	        textoURLImagen.setColumns(10);
	        textoURLImagen.setBounds(24, 275, 408, 32);
	        frame.getContentPane().add(textoURLImagen);
	        
	        comboBox = new JComboBox();
	        comboBox.setBounds(24, 154, 170, 32);
	        frame.getContentPane().add(comboBox);
	        
	        JTextArea textArea = new JTextArea();
	        textArea.setBounds(24, 92, 408, 37);
	        frame.getContentPane().add(textArea);
	        
	        JComboBox comboBox_1 = new JComboBox();
	        comboBox_1.setBounds(240, 155, 170, 31);
	        frame.getContentPane().add(comboBox_1);
	        
	        JSpinner spinner = new JSpinner();
	        spinner.setBounds(240, 209, 77, 20);
	        frame.getContentPane().add(spinner);
	        
	        btnAgregar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		if(isVerified()) {
	        			aplicarCambios(buttonToPress);
	        		}
	        	}
	        });
        
	}
	
	private boolean isVerified() {
		if(emailIsValido() && marcaIsValido() && nombreIsValido() && stockIsValido() && tipoIsValido() && imagenIsValida()) {
			return true;
		}
		return false;
	}

	private boolean tipoIsValido() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean nombreIsValido() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean stockIsValido() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean marcaIsValido() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean imagenIsValida() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean emailIsValido() {
		// TODO Auto-generated method stub
		return false;
	}

	private void aplicarCambios(JButton buttonToPress) {
		/* Hay que cambiar esto.- FB
		int IDMarca = Integer.parseInt(textoMarca.getText());
		int IDTipo = Integer.parseInt(textoTipo.getText());
		int stock = Integer.parseInt(textoStock.getText());
		int precioUnitario = Integer.parseInt(textoPrecio.getText());
		String descripcion = textoNombre.getText();
		String imagen = textoURLImagen.getText();
		if (btnAgregar.getText().equals("AGREGAR")) {
    		consulta.addArticulo(IDTipo, IDMarca, stock, descripcion, imagen, precioUnitario);
		} else if (btnAgregar.getText().equals("MODIFICAR")){
			
			consulta.updtArticulo(IDTipo, IDMarca, stock, precioUnitario, idArticuloAntiguo, descripcion, imagen);
		}*/
		buttonToPress.doClick();
		_frame.dispose();
	}

	public void setElements(String idArticuloAntiguo, String IDMarca, String IDTipo, String stock, String precioUnitario, String descripcion, String imagen) {
		/*Esto tambien textoMarca.setText(IDMarca);
		textoTipo.setText(IDTipo);
		textoStock.setText(stock);
		textoPrecio.setText(precioUnitario);
		textoNombre.setText(descripcion);
		textoURLImagen.setText("imagen");
		this.idArticuloAntiguo = Integer.parseInt(idArticuloAntiguo);*/
	}
}