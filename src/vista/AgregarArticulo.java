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

public class AgregarArticulo extends Administracion {

	private static final long serialVersionUID = 1744095522065285861L;
	public JTextField textoNombre;
	public JTextField textoMarca;
	public JTextField textoTipo;
	public JTextField textoStock;
	public JTextField textoPrecio;
	public JTextField textoURLImagen;
	public JLabel lblNombre;
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
	        frame.setBounds(100, 100, 463, 520);
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
	        
	        textoNombre = new JTextField();
	        textoNombre.setBounds(24, 96, 408, 20);
	        frame.getContentPane().add(textoNombre);
	        textoNombre.setColumns(10);
	        
	        textoMarca = new JTextField();
	        textoMarca.setColumns(10);
	        textoMarca.setBounds(24, 154, 408, 20);
	        frame.getContentPane().add(textoMarca);
	        
	        textoTipo = new JTextField();
	        textoTipo.setColumns(10);
	        textoTipo.setBounds(24, 208, 408, 20);
	        frame.getContentPane().add(textoTipo);
	        
	        textoStock = new JTextField();
	        textoStock.setColumns(10);
	        textoStock.setBounds(24, 265, 408, 20);
	        frame.getContentPane().add(textoStock);
	        
	        textoPrecio = new JTextField();
	        textoPrecio.setColumns(10);
	        textoPrecio.setBounds(24, 322, 408, 20);
	        frame.getContentPane().add(textoPrecio);
	        
	        lblNombre = new JLabel("Ingrese el nombre del art\u00EDculo:");
	        lblNombre.setForeground(Color.WHITE);
	        lblNombre.setBounds(24, 75, 192, 14);
	        frame.getContentPane().add(lblNombre);
	        
	        lblMarca = new JLabel("Seleccionar marca:");
	        lblMarca.setForeground(Color.WHITE);
	        lblMarca.setBounds(24, 129, 192, 14);
	        frame.getContentPane().add(lblMarca);
	        
	        lblTipo = new JLabel("Seleccionar Art\u00EDculo:");
	        lblTipo.setForeground(Color.WHITE);
	        lblTipo.setBounds(24, 185, 192, 14);
	        frame.getContentPane().add(lblTipo);
	        
	        lblStock = new JLabel("Ingrese stock:");
	        lblStock.setForeground(Color.WHITE);
	        lblStock.setBounds(24, 239, 192, 14);
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
	        btnAgregar.setBounds(79, 432, 314, 40);
	        frame.getContentPane().add(btnAgregar);
	        
	        JLabel lblPrecio = new JLabel("Ingrese precio:");
	        lblPrecio.setForeground(Color.WHITE);
	        lblPrecio.setBounds(24, 297, 192, 14);
	        frame.getContentPane().add(lblPrecio);
	        
	        panelImagen = new JLabel();
	        panelImagen.setBounds(505, 76, 170, 163);
	        frame.getContentPane().add(panelImagen);
	        
	        lblUrlImagen = new JLabel("Ingrese URL imagen:");
	        lblUrlImagen.setForeground(Color.WHITE);
	        lblUrlImagen.setBounds(24, 353, 192, 14);
	        frame.getContentPane().add(lblUrlImagen);
	        
	        textoURLImagen = new JTextField();
	        textoURLImagen.setColumns(10);
	        textoURLImagen.setBounds(24, 378, 408, 20);
	        frame.getContentPane().add(textoURLImagen);
	        
	        btnAgregar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		
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
	        		}
	        		buttonToPress.doClick();
	        		_frame.dispose();
	        	}
	        });
        
	}
	
	public void setElements(String idArticuloAntiguo, String IDMarca, String IDTipo, String stock, String precioUnitario, String descripcion, String imagen) {
		textoMarca.setText(IDMarca);
		textoTipo.setText(IDTipo);
		textoStock.setText(stock);
		textoPrecio.setText(precioUnitario);
		textoNombre.setText(descripcion);
		textoURLImagen.setText("imagen");
		this.idArticuloAntiguo = Integer.parseInt(idArticuloAntiguo);
	}
}