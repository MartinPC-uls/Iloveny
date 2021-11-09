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

	private static final long serialVersionUID = 1744095522065285861L;
	public JTextField textoNombre;
	public JTextField textoMarca;
	public JTextField textoTipo;
	public JTextField textoStock;
	public JTextField textPrecio;
	public JLabel lblNombre;
	public JLabel lblMarca;
	public JLabel lblTipo;
	public JLabel lblStock;
	public JLabel lblEmail;
	public JButton btnAgregar;
	private JLabel panelImagen;
	private JButton btnExaminar;
	private JLabel lblImagen;
	
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
        setBounds(100, 100, 732, 520);
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
        
        textoNombre = new JTextField();
        textoNombre.setBounds(24, 96, 408, 20);
        getContentPane().add(textoNombre);
        textoNombre.setColumns(10);
        
        textoMarca = new JTextField();
        textoMarca.setColumns(10);
        textoMarca.setBounds(24, 154, 408, 20);
        getContentPane().add(textoMarca);
        
        textoTipo = new JTextField();
        textoTipo.setColumns(10);
        textoTipo.setBounds(24, 208, 408, 20);
        getContentPane().add(textoTipo);
        
        textoStock = new JTextField();
        textoStock.setColumns(10);
        textoStock.setBounds(24, 265, 408, 20);
        getContentPane().add(textoStock);
        
        textPrecio = new JTextField();
        textPrecio.setColumns(10);
        textPrecio.setBounds(24, 322, 408, 20);
        getContentPane().add(textPrecio);
        
        lblNombre = new JLabel("Ingrese el nombre del art\u00EDculo:");
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setBounds(24, 75, 192, 14);
        getContentPane().add(lblNombre);
        
        lblMarca = new JLabel("Ingrese ID de marca:");
        lblMarca.setForeground(Color.WHITE);
        lblMarca.setBounds(24, 129, 192, 14);
        getContentPane().add(lblMarca);
        
        lblTipo = new JLabel("Ingrese ID de tipo de art\u00EDculo:");
        lblTipo.setForeground(Color.WHITE);
        lblTipo.setBounds(24, 185, 192, 14);
        getContentPane().add(lblTipo);
        
        lblStock = new JLabel("Ingrese stock:");
        lblStock.setForeground(Color.WHITE);
        lblStock.setBounds(24, 239, 192, 14);
        getContentPane().add(lblStock);
        
        btnAgregar = new JButton();
        btnAgregar.setText("AGREGAR");
        btnAgregar.setFocusPainted(false);
        btnAgregar.setBorderPainted(false);
        btnAgregar.setBorder(null);
        btnAgregar.setBackground(new Color(0, 153, 153));
        btnAgregar.setBounds(76, 440, 314, 40);
        getContentPane().add(btnAgregar);
        
        JLabel lblPrecio = new JLabel("Ingrese precio:");
        lblPrecio.setForeground(Color.WHITE);
        lblPrecio.setBounds(24, 297, 192, 14);
        getContentPane().add(lblPrecio);
        
        panelImagen = new JLabel();
        panelImagen.setBounds(505, 76, 170, 163);
        getContentPane().add(panelImagen);
        
        btnExaminar = new JButton();
        btnExaminar.setText("EXAMINAR");
        btnExaminar.setFocusPainted(false);
        btnExaminar.setBorderPainted(false);
        btnExaminar.setBorder(null);
        btnExaminar.setBackground(new Color(0, 153, 153));
        btnExaminar.setBounds(543, 250, 101, 35);
        getContentPane().add(btnExaminar);
        
        lblImagen = new JLabel("Ingrese imagen:");
        lblImagen.setForeground(Color.WHITE);
        lblImagen.setBounds(483, 44, 192, 14);
        getContentPane().add(lblImagen);
        
	}
}