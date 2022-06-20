package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import mongodb.Articulo;
import mongodb.ArticuloID;
import mongodb.Consulta;
import mongodb.RegistroCompra;

import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AgregarRegistroCompraPanel extends JPanel {

	private static final long serialVersionUID = -1178501338264937978L;
	public int modo;
	public boolean existenRutsSinDireccion;
	
	ArrayList<ArticuloID> articulos = new ArrayList<ArticuloID>();
	private JLabel lblAlertaArticulo;
	@SuppressWarnings("rawtypes")
	private JComboBox articuloCB;
	private JTextField fechaPedidaTextField;
	private JLabel lblAlertaFechaPedida;
	private JTextField unidadesAdquiridasTextField;
	private JTextField costoUnitarioTextField;
	private JTextField fechaReciboTextField;
	private JLabel lblAlertaFechaRecibo;
	private JLabel lblAlertaCostoUnitario;
	private JLabel lblAlertaProveedor;
	private JPanel lineaFechaPedida;
	private JPanel lineaUnidadesAdquiridas;
	private JPanel lineaCostoUnitario;
	private JPanel lineaFechaRecibo;
	private JButton btnVolver;
	public JButton btnRefrezcar;
	@SuppressWarnings("unused")
	private String nombreAdmin;
	private JLabel lblAlertaUnidadesAdquirida;
	private int unidadesAdquiridasAntigua;
	private int stock;
	private JLabel lblProveedor;
	private JTextField proveedorTextField;
	private JPanel lineaProveedor;
	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel modelo;
	private String _id;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AgregarRegistroCompraPanel(int modo, JComponent[] paneles, JButton btnRefrezcar, String nombreAdmin, String _id) {
		this._id = _id;
		this.modo = modo;
		this.btnRefrezcar = btnRefrezcar;
		setBounds(0,0,732,558);
		setBackground(new Color(51,51,51));
		setLayout(null);
		this.nombreAdmin = nombreAdmin;
		
		lblAlertaProveedor = new JLabel("");
		lblAlertaProveedor.setVisible(false);
		lblAlertaProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaProveedor.setIcon(new ImageIcon(AgregarRegistroCompraPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaProveedor.setBounds(604, 177, 30, 27);
		add(lblAlertaProveedor);
		
		JLabel lblAgregarUsuario = new JLabel("Registro Compra");
		lblAgregarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarUsuario.setForeground(Color.WHITE);
		lblAgregarUsuario.setFont(new Font("Roboto Medium", Font.PLAIN, 41));
		lblAgregarUsuario.setBounds(155, 11, 441, 55);
		add(lblAgregarUsuario);
		
		JLabel lblArticulo = new JLabel("Articulo");
		lblArticulo.setForeground(Color.WHITE);
		lblArticulo.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblArticulo.setBounds(138, 155, 62, 14);
		add(lblArticulo);
		
		JLabel lblUnidadesAdquiridas = new JLabel("Unidades adquiridas");
		lblUnidadesAdquiridas.setForeground(Color.WHITE);
		lblUnidadesAdquiridas.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblUnidadesAdquiridas.setBounds(138, 267, 132, 14);
		add(lblUnidadesAdquiridas);
		
		lineaUnidadesAdquiridas = new JPanel();
		lineaUnidadesAdquiridas.setPreferredSize(new Dimension(0, 3));
		lineaUnidadesAdquiridas.setBackground(Color.WHITE);
		lineaUnidadesAdquiridas.setBounds(138, 304, 49, 3);
		add(lineaUnidadesAdquiridas);
		GroupLayout gl_lineaUnidadesAdquiridas = new GroupLayout(lineaUnidadesAdquiridas);
		gl_lineaUnidadesAdquiridas.setHorizontalGroup(
			gl_lineaUnidadesAdquiridas.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaUnidadesAdquiridas.setVerticalGroup(
			gl_lineaUnidadesAdquiridas.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaUnidadesAdquiridas.setLayout(gl_lineaUnidadesAdquiridas);
		
		unidadesAdquiridasTextField = new JTextField();
		unidadesAdquiridasTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				verificarUnidadesAdquiridas();
			}
		});
		unidadesAdquiridasTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarUnidadesAdquiridas();
			}
		});
		unidadesAdquiridasTextField.setText("1");
		unidadesAdquiridasTextField.setOpaque(false);
		unidadesAdquiridasTextField.setForeground(new Color(170, 170, 170));
		unidadesAdquiridasTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		unidadesAdquiridasTextField.setCaretColor(Color.WHITE);
		unidadesAdquiridasTextField.setBorder(null);
		unidadesAdquiridasTextField.setBackground(new Color(51, 51, 51));
		unidadesAdquiridasTextField.setBounds(138, 280, 49, 21);
		eventoCambiarJTextField(unidadesAdquiridasTextField, unidadesAdquiridasTextField.getText(), 50);
		add(unidadesAdquiridasTextField);
		
		if (modo == 1)
			modelo = crearModeloComboBoxArticulo();
		else if (modo == 2)
			modelo = new DefaultComboBoxModel(new String[] {"No existen articulos"});
		articuloCB = new JComboBox(new String[] {});
		articuloCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (modo == 1)
					setArticuloSeleccionado(articuloCB.getSelectedIndex());
			}
		});
		articuloCB.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarArticulo();
			}
		});
		articuloCB.setModel(modelo);
		articuloCB.setBounds(138, 180, 214, 21);
		add(articuloCB);
		
		JLabel lblCostoUnitario = new JLabel("Costo unitario (CLP)");
		lblCostoUnitario.setForeground(Color.WHITE);
		lblCostoUnitario.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblCostoUnitario.setBounds(383, 267, 106, 14);
		add(lblCostoUnitario);
		
		costoUnitarioTextField = new JTextField();
		costoUnitarioTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarCostoUnitario();
			}
		});
		costoUnitarioTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarCostoUnitario();
			}
		});
		costoUnitarioTextField.setText("1000");
		costoUnitarioTextField.setOpaque(false);
		costoUnitarioTextField.setForeground(new Color(170, 170, 170));
		costoUnitarioTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		costoUnitarioTextField.setCaretColor(Color.WHITE);
		costoUnitarioTextField.setBorder(null);
		costoUnitarioTextField.setBackground(new Color(51, 51, 51));
		costoUnitarioTextField.setBounds(383, 280, 96, 21);
		eventoCambiarJTextField(costoUnitarioTextField, costoUnitarioTextField.getText(), 50);
		add(costoUnitarioTextField);
		
		lineaCostoUnitario = new JPanel();
		lineaCostoUnitario.setPreferredSize(new Dimension(0, 3));
		lineaCostoUnitario.setBackground(Color.WHITE);
		lineaCostoUnitario.setBounds(383, 304, 96, 3);
		add(lineaCostoUnitario);
		GroupLayout gl_lineaCostoUnitario = new GroupLayout(lineaCostoUnitario);
		gl_lineaCostoUnitario.setHorizontalGroup(
			gl_lineaCostoUnitario.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaCostoUnitario.setVerticalGroup(
			gl_lineaCostoUnitario.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaCostoUnitario.setLayout(gl_lineaCostoUnitario);
		
		JLabel lblFechaPedida = new JLabel("Fecha pedida");
		lblFechaPedida.setForeground(Color.WHITE);
		lblFechaPedida.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblFechaPedida.setBounds(138, 212, 106, 14);
		add(lblFechaPedida);
		
		fechaPedidaTextField = new JTextField();
		fechaPedidaTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarFechaPedida();
			}
		});
		fechaPedidaTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarFechaPedida();
			}
		});
		fechaPedidaTextField.setToolTipText("");
		fechaPedidaTextField.setText("AAAA-MM-DD");
		fechaPedidaTextField.setOpaque(false);
		fechaPedidaTextField.setForeground(new Color(170, 170, 170));
		fechaPedidaTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		fechaPedidaTextField.setCaretColor(Color.WHITE);
		fechaPedidaTextField.setBorder(null);
		fechaPedidaTextField.setBackground(new Color(51, 51, 51));
		fechaPedidaTextField.setBounds(138, 225, 214, 21);
		eventoCambiarJTextField(fechaPedidaTextField, fechaPedidaTextField.getText(), 20);
		add(fechaPedidaTextField);
		
		lineaFechaPedida = new JPanel();
		lineaFechaPedida.setPreferredSize(new Dimension(0, 3));
		lineaFechaPedida.setBackground(Color.WHITE);
		lineaFechaPedida.setBounds(138, 249, 214, 3);
		add(lineaFechaPedida);
		GroupLayout gl_lineaFechaPedida = new GroupLayout(lineaFechaPedida);
		gl_lineaFechaPedida.setHorizontalGroup(
			gl_lineaFechaPedida.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaFechaPedida.setVerticalGroup(
			gl_lineaFechaPedida.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaFechaPedida.setLayout(gl_lineaFechaPedida);
		
		JLabel lblFechaRecibo = new JLabel("Fecha recibo");
		lblFechaRecibo.setForeground(Color.WHITE);
		lblFechaRecibo.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblFechaRecibo.setBounds(383, 212, 106, 14);
		add(lblFechaRecibo);
		
		fechaReciboTextField = new JTextField();
		fechaReciboTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarFechaRecibo();
			}
		});
		fechaReciboTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarFechaRecibo();
			}
		});
		fechaReciboTextField.setText("AAAA-MM-DD");
		fechaReciboTextField.setOpaque(false);
		fechaReciboTextField.setForeground(new Color(170, 170, 170));
		fechaReciboTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		fechaReciboTextField.setCaretColor(Color.WHITE);
		fechaReciboTextField.setBorder(null);
		fechaReciboTextField.setBackground(new Color(51, 51, 51));
		fechaReciboTextField.setBounds(383, 225, 214, 21);
		eventoCambiarJTextField(fechaReciboTextField, fechaReciboTextField.getText(), 20);
		add(fechaReciboTextField);
		
		lineaFechaRecibo = new JPanel();
		lineaFechaRecibo.setPreferredSize(new Dimension(0, 3));
		lineaFechaRecibo.setBackground(Color.WHITE);
		lineaFechaRecibo.setBounds(383, 249, 214, 3);
		add(lineaFechaRecibo);
		GroupLayout gl_lineaFechaRecibo = new GroupLayout(lineaFechaRecibo);
		gl_lineaFechaRecibo.setHorizontalGroup(
			gl_lineaFechaRecibo.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaFechaRecibo.setVerticalGroup(
			gl_lineaFechaRecibo.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaFechaRecibo.setLayout(gl_lineaFechaRecibo);
		
		JButton btnAgregarRegistroCompra = new JButton("AGREGAR REGISTRO COMPRA");
		if (modo == 2)
			btnAgregarRegistroCompra.setText("EDITAR REGISTRO COMPRA");
		btnAgregarRegistroCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isTodoCorrecto()) {
					agregarDatos();
					btnRefrezcar.doClick();
					paneles[1].setVisible(true);
					paneles[0].setBounds(929, 39, 732, 558);
				}
			}
		});
		btnAgregarRegistroCompra.setBorder(null);
		btnAgregarRegistroCompra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarRegistroCompra.setBackground(Color.WHITE);
		btnAgregarRegistroCompra.setFont(new Font("Roboto Light", Font.PLAIN, 25));
		btnAgregarRegistroCompra.setBounds(138, 458, 458, 64);
		eventoExpandirDisminuirTamanoBoton(btnAgregarRegistroCompra, 15);
		add(btnAgregarRegistroCompra);
		
		lblAlertaFechaPedida = new JLabel("");
		lblAlertaFechaPedida.setVisible(false);
		lblAlertaFechaPedida.setToolTipText("Hay un error de formato");
		lblAlertaFechaPedida.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaFechaPedida.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaFechaPedida.setBounds(99, 222, 30, 27);
		add(lblAlertaFechaPedida);
		
		lblAlertaUnidadesAdquirida = new JLabel("");
		lblAlertaUnidadesAdquirida.setVisible(false);
		lblAlertaUnidadesAdquirida.setToolTipText("Hay un error de formato");
		lblAlertaUnidadesAdquirida.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaUnidadesAdquirida.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaUnidadesAdquirida.setBounds(98, 280, 30, 27);
		add(lblAlertaUnidadesAdquirida);
		
		lblAlertaCostoUnitario = new JLabel("");
		lblAlertaCostoUnitario.setVisible(false);
		lblAlertaCostoUnitario.setToolTipText("Hay un error de formato");
		lblAlertaCostoUnitario.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaCostoUnitario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaCostoUnitario.setBounds(489, 280, 30, 27);
		add(lblAlertaCostoUnitario);
		
		lblAlertaFechaRecibo = new JLabel("");
		lblAlertaFechaRecibo.setVisible(false);
		lblAlertaFechaRecibo.setToolTipText("Hay un error de formato");
		lblAlertaFechaRecibo.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaFechaRecibo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaFechaRecibo.setBounds(604, 225, 30, 27);
		add(lblAlertaFechaRecibo);
		
		lblAlertaArticulo = new JLabel("");
		lblAlertaArticulo.setVisible(false);
		lblAlertaArticulo.setToolTipText("Hay un error de formato");
		lblAlertaArticulo.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaArticulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaArticulo.setBounds(98, 174, 30, 27);
		add(lblAlertaArticulo);
		if (modo == 2)
			lblAlertaArticulo.setVisible(false);
		
		btnVolver = new JButton("");
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver.setBorder(null);
		addEventoBotonEnteredAndExited(btnVolver);
		btnVolver.setBackground(new Color(51,51,51));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				paneles[1].setVisible(true);
				paneles[0].setBounds(929, 39, 732, 558);
			}
		});
		btnVolver.setIcon(new ImageIcon(AgregarArticuloPanel.class.getResource("/imagenes/volver-white.png")));
		btnVolver.setBounds(0, 510, 68, 48);
		add(btnVolver);
		
		lblProveedor = new JLabel("Proveedor");
		lblProveedor.setForeground(Color.WHITE);
		lblProveedor.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblProveedor.setBounds(383, 164, 106, 14);
		add(lblProveedor);
		
		proveedorTextField = new JTextField();
		proveedorTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarProveedor();
			}
		});
		proveedorTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarProveedor();
			}
		});
		proveedorTextField.setText("EJ: Proveedor1");
		proveedorTextField.setOpaque(false);
		proveedorTextField.setForeground(new Color(170, 170, 170));
		proveedorTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		proveedorTextField.setCaretColor(Color.WHITE);
		proveedorTextField.setBorder(null);
		proveedorTextField.setBackground(new Color(51, 51, 51));
		proveedorTextField.setBounds(383, 177, 214, 21);
		eventoCambiarJTextField(proveedorTextField, proveedorTextField.getText(), 50);
		add(proveedorTextField);
		
		lineaProveedor = new JPanel();
		lineaProveedor.setPreferredSize(new Dimension(0, 3));
		lineaProveedor.setBackground(Color.WHITE);
		lineaProveedor.setBounds(383, 201, 214, 3);
		add(lineaProveedor);
		GroupLayout gl_lineaProveedor = new GroupLayout(lineaProveedor);
		gl_lineaProveedor.setHorizontalGroup(
			gl_lineaProveedor.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaProveedor.setVerticalGroup(
			gl_lineaProveedor.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaProveedor.setLayout(gl_lineaProveedor);
		
		if (modo == 2) {
			setElementos(_id);
		}
	}
	
	RegistroCompra registroCompra = null;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void setElementos(String _id) {
		Consulta consulta = new Consulta();
		registroCompra = consulta.getRegistroCompra(_id);
		articulo = registroCompra.get_articulo();
		String nombreTipo = registroCompra.get_articulo().get_nombretipo();
		String descripcion = registroCompra.get_articulo().get_descripcion();
		String marca = registroCompra.get_articulo().get_nombremarca();
		
		modelo = new DefaultComboBoxModel(new String[] {nombreTipo + " " + descripcion + ", " + marca});
		articuloCB.setModel(modelo);
		
		cambiarColorTextFieldsBlanco();
		
		proveedorTextField.setText(registroCompra.get_nombreprov());
		fechaPedidaTextField.setText(registroCompra.get_fechapedida());
		fechaReciboTextField.setText(registroCompra.get_fecharecibo());
		unidadesAdquiridasTextField.setText(String.valueOf(registroCompra.get_unidadesadquiridas()));
		costoUnitarioTextField.setText(String.valueOf(registroCompra.get_costounitario()));
	}
	
	private void cambiarColorTextFieldsBlanco() {
		Component[] componentes = this.getComponents();
	        for(int i = 0; i<componentes.length;i++) {
	       	 if(componentes[i].getClass().equals(JTextField.class)) {
	       		 componentes[i].setForeground(Color.WHITE);
	       	 }
	        }
	}
	
	private boolean verificarProveedor() {
		if(!proveedorTextField.getText().matches("[a-zA-Z0-9ñÑ ]{1,50}") || proveedorTextField.getText().charAt(0) == ' ') {
			setErroneo(lineaProveedor, lblAlertaProveedor);
			return false;
		}
		setAcertado(lineaProveedor, lblAlertaProveedor);
		return true;
	}
	
	String[] ids;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private DefaultComboBoxModel crearModeloComboBoxArticulo() {
		Consulta consulta = new Consulta();
		ArrayList<ArticuloID> articulo = consulta.getDescripcionArticulosConStock();
		if(articulo.size()>0) {
			String[] listaArticulos = new String[articulo.size()+1];
			ids = new String[articulo.size()+1];
			listaArticulos[0] = "Seleccione...";
			ids[0] = "0";
			for(int i=1; i<=articulo.size();i++) {
				articulos.add(articulo.get(i-1));
				listaArticulos[i] = articulo.get(i-1).nombretipo + " " + articulo.get(i-1).descripcion + ", " + articulo.get(i-1).nombremarca;
				ids[i] = articulo.get(i-1).objectId;
			}
			return new DefaultComboBoxModel(listaArticulos);
		}else {
			lblAlertaArticulo.setVisible(true);
			return new DefaultComboBoxModel(new String[] {"No existen articulos"});
		}
	}

	private void agregarDatos() {
		agregarRegistroCompra();
	}
	
	static Articulo articulo = null;
	private void setArticuloSeleccionado(int index) {
		Consulta consulta = new Consulta();
		String id = null;
		if (modo == 1)
			id = ids[index];
		else if (modo == 2)
			id = _id;
		System.out.println("id: " + id);
		articulo = consulta.getArticulo(id);
	}
	
	private void agregarRegistroCompra() {
		Consulta consulta = new Consulta();
		RegistroCompra registroCompra;
		String usuario = "admin";
		String nombreprov = proveedorTextField.getText();
		int unidadesadquiridas = Integer.parseInt(unidadesAdquiridasTextField.getText());
		int costounitario = Integer.parseInt(costoUnitarioTextField.getText());
		String fechapedida = fechaPedidaTextField.getText();
		String fecharecibo = fechaReciboTextField.getText();
		registroCompra = new RegistroCompra(nombreprov, usuario, unidadesadquiridas, costounitario, fechapedida, fecharecibo, articulo);
		if (modo == 1) {
			consulta.addRegistroCompra(registroCompra);
		} else if(modo == 2) {
			consulta.updtRegistroCompra(_id, registroCompra);
		}
	}
	
	private int getNewStock(int stock, int cNueva, int cAntigua) {
		if (cNueva > cAntigua) {
			return stock+(cNueva-cAntigua);
		} else if (cNueva < cAntigua) {
			return stock-(cAntigua-cNueva);
		} else if (cNueva == cAntigua) {
			return stock;
		}
		return stock;
	}
	
	private boolean verificarFechas() {
		try {
			Date fechaRecibo = new SimpleDateFormat("yyyy-MM-dd").parse(fechaReciboTextField.getText());
			Date fechaPedida = new SimpleDateFormat("yyyy-MM-dd").parse(fechaPedidaTextField.getText());
			if (fechaRecibo.compareTo(fechaPedida) < 0) {
				setErroneo(lineaFechaPedida, lblAlertaFechaPedida);
				setErroneo(lineaFechaRecibo, lblAlertaFechaRecibo);
				Icon icon = new ImageIcon(Login.class.getResource("/imagenes/Exclamation-mark-icon.png"));
				JOptionPane.showMessageDialog(null, "La fecha de recibo no puede ser antes de la fecha de pedido","Mensaje",JOptionPane.PLAIN_MESSAGE,icon);
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return true;
	}

	private boolean isTodoCorrecto() {
		if (modo == 1) {
			if(verificarUnidadesAdquiridas() && verificarCostoUnitario() && verificarArticulo() && verificarFechaPedida() && verificarFechaRecibo() && verificarProveedor()
					&& verificarFechas()) {
				return true;
			}
		} else if (modo == 2) {
			if(verificarUnidadesAdquiridas() && verificarCostoUnitario() && verificarFechaPedida() && verificarFechaRecibo() && verificarProveedor()
					&& verificarFechas() && verificarStock()) {
				return true;
			}
		}
		return false;
	}
	
	private boolean verificarStock() {
		if (getNewStock(this.stock,Integer.parseInt(unidadesAdquiridasTextField.getText()), unidadesAdquiridasAntigua) < 0) {
			setErroneo(lineaUnidadesAdquiridas, lblAlertaUnidadesAdquirida);
			Icon icon = new ImageIcon(Login.class.getResource("/imagenes/Exclamation-mark-icon.png"));
			JOptionPane.showMessageDialog(null, "Las unidades adquiridas son mayores al stock disponible: " + stock,"Mensaje",JOptionPane.PLAIN_MESSAGE,icon);
			return false;
		} else {
			setAcertado(lineaUnidadesAdquiridas, lblAlertaUnidadesAdquirida);
			return true;
		}
	}
	
	private boolean verificarFechaRecibo() {
		if (!fechaReciboTextField.getText().matches("^([2][0][0-3][0-9])[-]([0][1-9]|[1][0-2])[-]([0][1-9]|[1-2][0-9]|[3][0-1])$") && 
				!fechaReciboTextField.getText().matches("^([2][0][0-3][0-9])[-]([0][1-9]|[1][0-2])[-]([0][1-9]|[1-2][0-9]|[3][0-1]) "
						+ "([0-1]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$")) {
			lblAlertaFechaRecibo.setVisible(true);
			setErroneo(lineaFechaRecibo, lblAlertaFechaRecibo);
			return false;
		}
		setAcertado(lineaFechaRecibo, lblAlertaFechaRecibo);
		lblAlertaFechaRecibo.setVisible(false);
		return true;
	}
	
	private boolean verificarFechaPedida() {
		if(!fechaPedidaTextField.getText().matches("^([2][0][0-3][0-9])[-]([0][1-9]|[1][0-2])[-]([0][1-9]|[1-2][0-9]|[3][0-1])$") && 
				!fechaPedidaTextField.getText().matches("^([2][0][0-3][0-9])[-]([0][1-9]|[1][0-2])[-]([0][1-9]|[1-2][0-9]|[3][0-1]) "
						+ "([0-1]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$")) {
			setErroneo(lineaFechaPedida, lblAlertaFechaPedida);
			return false;
		}
		setAcertado(lineaFechaPedida, lblAlertaFechaPedida);
		return true;
	}

	private boolean verificarArticulo() {
		if(articuloCB.getSelectedIndex() == 0) {
			lblAlertaArticulo.setVisible(true);
			return false;
		}
		lblAlertaArticulo.setVisible(false);
		return true;
	}

	private boolean verificarCostoUnitario() {
		if(!costoUnitarioTextField.getText().matches("[0-9]{1,10}") || costoUnitarioTextField.getText().charAt(0) == '0' ) {
			setErroneo(lineaCostoUnitario, lblAlertaCostoUnitario);
			return false;
		}
		setAcertado(lineaCostoUnitario, lblAlertaCostoUnitario);
		return true;
	}

	private boolean verificarUnidadesAdquiridas() {
		if(!unidadesAdquiridasTextField.getText().matches("[0-9]{1,5}") || unidadesAdquiridasTextField.getText().charAt(0) == '0') {
			setErroneo(lineaUnidadesAdquiridas, lblAlertaUnidadesAdquirida);
			return false;
		}
		setAcertado(lineaUnidadesAdquiridas, lblAlertaUnidadesAdquirida);
		return true;
	}
	
	public void setAcertado(JPanel panel, JLabel label){
		label.setVisible(false);
		panel.setBackground(new Color(50,205,50));
	}
	
	public void setErroneo(JPanel panel, JLabel label) {
		label.setVisible(true);
		panel.setBackground(new Color(255,0,0));
	}
	
	public void addEventoBotonEnteredAndExited(JButton boton){
		boton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			boton.setBackground(new Color(31,31,31));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			boton.setBackground(new Color(51,51,51));
		}
		});
	}
	
	private void eventoCambiarJTextField(JTextField txtUser, String relleno, int maxCaracteres) {
		txtUser.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		String text = txtUser.getText();
        		if (text.length() == 0 || text.length() >maxCaracteres) {
        			if(text.length() == 0) {
        				txtUser.setText(relleno);
        				txtUser.setForeground(new Color(170, 170, 170));
        			}
        		} else {
        			txtUser.setForeground(new Color(255, 255, 255));
        		}
        	}
        	@Override
        	public void focusGained(FocusEvent e) {
        		txtUser.getText();
        		Color color = new Color(170, 170, 170);
        		if (txtUser.getForeground().equals(color) && txtUser.getText().length() < maxCaracteres) {
        			txtUser.setText("");
        			txtUser.setForeground(new Color(255, 255, 255));
        		}
        	}
        });
	}
	
	private void eventoExpandirDisminuirTamanoBoton(JButton boton, int pixeles) {
		boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {	
				boton.setBounds(
						(int)boton.getBounds().getX()-pixeles/2,
						(int)boton.getBounds().getY()-pixeles/2,
						(int)boton.getBounds().getWidth()+pixeles,
						(int)boton.getBounds().getHeight()+pixeles);
				boton.setFont(new Font("Roboto Light", Font.BOLD, 27));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				boton.setBounds(
						(int)boton.getBounds().getX()+pixeles/2,
						(int)boton.getBounds().getY()+pixeles/2,
						(int)boton.getBounds().getWidth()-pixeles,
						(int)boton.getBounds().getHeight()-pixeles);
				boton.setFont(new Font("Roboto Light", Font.PLAIN, 25));
			}
		});
	}

}
