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
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;

import mongodb.Articulo;
import mongodb.Consulta;
import mongodb.Medida;

import javax.swing.event.ChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class AgregarArticuloPanel extends JPanel {

	private static final long serialVersionUID = -4579039619021999060L;
	public int modo;
	public boolean existenRutsSinDireccion;
	ArrayList<String> elementoSeleccionado;
	
	private JLabel lblAlertaMarca;
	private JTextField descripcionTextField;
	private JLabel lblAlertaDescripcion;
	private JTextField stockTextField;
	private JTextField precioTextField;
	private JLabel lblAlertaPrecioUnitario;
	private JLabel lblAlertaStock;
	private JLabel lblAlertaTipoObjeto;
	private JPanel lineaDescripcion;
	private JPanel lineaStock;
	private JPanel lineaPrecioUnitario;
	private JButton btnVolver;
	public JButton btnRefrezcar;
	private JTextField marcaTextField;
	private JPanel lineaMarca;
	private JTextField tipoObjetoTextField;
	private JPanel lineaTipoObjeto;
	private JLabel lblAlto;
	private JTextField altoTextField;
	private JPanel lineaAlto;
	private JLabel lblAncho;
	private JTextField anchoTextField;
	private JPanel lineaAncho;
	private JLabel lblLargo;
	private JTextField largoTextField;
	private JPanel lineaLargo;
	private JTextField medidaTextField;
	private JLabel lblMedida;
	private JPanel lineaMedida;
	
	private String tipo_medidas = "";
	
	public AgregarArticuloPanel(int modo, JComponent[] paneles, JButton btnRefrezcar, ArrayList<String> elementoSeleccionado) {
		this.modo = modo;
		this.btnRefrezcar = btnRefrezcar;
		this.elementoSeleccionado = elementoSeleccionado;
		setBounds(0,0,732,558);
		setBackground(new Color(51,51,51));
		setLayout(null);
		
		lblAlertaTipoObjeto = new JLabel("");
		lblAlertaTipoObjeto.setVisible(false);
		lblAlertaTipoObjeto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaTipoObjeto.setIcon(new ImageIcon(AgregarArticuloPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaTipoObjeto.setBounds(604, 177, 30, 27);
		add(lblAlertaTipoObjeto);
		
		JLabel lblAgregarArticulo = new JLabel("Art\u00EDculo");
		lblAgregarArticulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarArticulo.setForeground(Color.WHITE);
		lblAgregarArticulo.setFont(new Font("Roboto Medium", Font.PLAIN, 41));
		lblAgregarArticulo.setBounds(215, 11, 302, 55);
		add(lblAgregarArticulo);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setForeground(Color.WHITE);
		lblMarca.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblMarca.setBounds(137, 158, 62, 14);
		add(lblMarca);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setForeground(Color.WHITE);
		lblStock.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblStock.setBounds(137, 263, 106, 14);
		add(lblStock);
		
		stockTextField = new JTextField();
		stockTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				verificarStock();
			}
		});
		stockTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarStock();
			}
		});
		stockTextField.setText("EJ: 2");
		stockTextField.setOpaque(false);
		stockTextField.setForeground(new Color(170, 170, 170));
		stockTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		stockTextField.setCaretColor(Color.WHITE);
		stockTextField.setBorder(null);
		stockTextField.setBackground(new Color(51, 51, 51));
		stockTextField.setBounds(137, 273, 47, 21);
		eventoCambiarJTextField(stockTextField, stockTextField.getText(), 50);
		add(stockTextField);
		
		lineaStock = new JPanel();
		lineaStock.setPreferredSize(new Dimension(0, 3));
		lineaStock.setBackground(Color.WHITE);
		lineaStock.setBounds(137, 297, 47, 3);
		add(lineaStock);
		GroupLayout gl_lineaStock = new GroupLayout(lineaStock);
		gl_lineaStock.setHorizontalGroup(
			gl_lineaStock.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaStock.setVerticalGroup(
			gl_lineaStock.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaStock.setLayout(gl_lineaStock);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblDescripcion.setBounds(138, 212, 106, 14);
		add(lblDescripcion);
		
		descripcionTextField = new JTextField();
		descripcionTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarDescripcion();
			}
		});
		descripcionTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarDescripcion();
			}
		});
		descripcionTextField.setToolTipText("");
		descripcionTextField.setText("EJ: Anillo de Onyx");
		descripcionTextField.setOpaque(false);
		descripcionTextField.setForeground(new Color(170, 170, 170));
		descripcionTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		descripcionTextField.setCaretColor(Color.WHITE);
		descripcionTextField.setBorder(null);
		descripcionTextField.setBackground(new Color(51, 51, 51));
		descripcionTextField.setBounds(138, 225, 214, 21);
		eventoCambiarJTextField(descripcionTextField, descripcionTextField.getText(), 50);
		add(descripcionTextField);
		
		lineaDescripcion = new JPanel();
		lineaDescripcion.setPreferredSize(new Dimension(0, 3));
		lineaDescripcion.setBackground(Color.WHITE);
		lineaDescripcion.setBounds(138, 249, 214, 3);
		add(lineaDescripcion);
		GroupLayout gl_lineaDescripcion = new GroupLayout(lineaDescripcion);
		gl_lineaDescripcion.setHorizontalGroup(
			gl_lineaDescripcion.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaDescripcion.setVerticalGroup(
			gl_lineaDescripcion.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaDescripcion.setLayout(gl_lineaDescripcion);
		
		JLabel lblPrecioUnitario = new JLabel("Precio unitario (CLP)");
		lblPrecioUnitario.setForeground(Color.WHITE);
		lblPrecioUnitario.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblPrecioUnitario.setBounds(383, 212, 106, 14);
		add(lblPrecioUnitario);
		
		precioTextField = new JTextField();
		precioTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarPrecioUnitario();
			}
		});
		precioTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarPrecioUnitario();
			}
		});
		precioTextField.setText("EJ: 2000");
		precioTextField.setOpaque(false);
		precioTextField.setForeground(new Color(170, 170, 170));
		precioTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		precioTextField.setCaretColor(Color.WHITE);
		precioTextField.setBorder(null);
		precioTextField.setBackground(new Color(51, 51, 51));
		precioTextField.setBounds(383, 225, 214, 21);
		eventoCambiarJTextField(precioTextField, precioTextField.getText(), 20);
		add(precioTextField);
		
		lineaPrecioUnitario = new JPanel();
		lineaPrecioUnitario.setPreferredSize(new Dimension(0, 3));
		lineaPrecioUnitario.setBackground(Color.WHITE);
		lineaPrecioUnitario.setBounds(383, 249, 214, 3);
		add(lineaPrecioUnitario);
		GroupLayout gl_lineaPrecioUnitario = new GroupLayout(lineaPrecioUnitario);
		gl_lineaPrecioUnitario.setHorizontalGroup(
			gl_lineaPrecioUnitario.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaPrecioUnitario.setVerticalGroup(
			gl_lineaPrecioUnitario.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaPrecioUnitario.setLayout(gl_lineaPrecioUnitario);
		
		JButton btnAgregarArticulo = new JButton("AGREGAR ART\u00CDCULO");
		btnAgregarArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isTodoCorrecto()) {
					agregarDatos();
					btnRefrezcar.doClick();
					paneles[1].setVisible(true);
					paneles[0].setBounds(929, 39, 732, 558);
				}
			}
		});
		btnAgregarArticulo.setBorder(null);
		btnAgregarArticulo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarArticulo.setBackground(Color.WHITE);
		btnAgregarArticulo.setFont(new Font("Roboto Light", Font.PLAIN, 25));
		btnAgregarArticulo.setBounds(215, 458, 302, 64);
		eventoExpandirDisminuirTamanoBoton(btnAgregarArticulo, 15);
		add(btnAgregarArticulo);
		
		lblAlertaDescripcion = new JLabel("");
		lblAlertaDescripcion.setVisible(false);
		lblAlertaDescripcion.setToolTipText("Hay un error de formato");
		lblAlertaDescripcion.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaDescripcion.setBounds(99, 225, 30, 27);
		add(lblAlertaDescripcion);
		
		lblAlertaStock = new JLabel("");
		lblAlertaStock.setVisible(false);
		lblAlertaStock.setToolTipText("Hay un error de formato");
		lblAlertaStock.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaStock.setBounds(99, 273, 30, 27);
		add(lblAlertaStock);
		
		lblAlertaPrecioUnitario = new JLabel("");
		lblAlertaPrecioUnitario.setVisible(false);
		lblAlertaPrecioUnitario.setToolTipText("Hay un error de formato");
		lblAlertaPrecioUnitario.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaPrecioUnitario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaPrecioUnitario.setBounds(604, 225, 30, 27);
		add(lblAlertaPrecioUnitario);
		
		lblAlertaMarca = new JLabel("");
		lblAlertaMarca.setVisible(false);
		lblAlertaMarca.setToolTipText("Hay un error de formato");
		lblAlertaMarca.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaMarca.setBounds(98, 174, 30, 27);
		add(lblAlertaMarca);
		
		JLabel lblTipoObjeto = new JLabel("Tipo de objeto");
		lblTipoObjeto.setForeground(Color.WHITE);
		lblTipoObjeto.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblTipoObjeto.setBounds(383, 158, 134, 14);
		add(lblTipoObjeto);
		
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
		
		marcaTextField = new JTextField();
		marcaTextField.setToolTipText("");
		marcaTextField.setText("EJ: Anillo de Onyx");
		marcaTextField.setOpaque(false);
		marcaTextField.setForeground(new Color(170, 170, 170));
		marcaTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		marcaTextField.setCaretColor(Color.WHITE);
		marcaTextField.setBorder(null);
		marcaTextField.setBackground(new Color(51, 51, 51));
		marcaTextField.setBounds(138, 174, 214, 21);
		add(marcaTextField);
		
		lineaMarca = new JPanel();
		lineaMarca.setPreferredSize(new Dimension(0, 3));
		lineaMarca.setBackground(Color.WHITE);
		lineaMarca.setBounds(138, 198, 214, 3);
		add(lineaMarca);
		GroupLayout gl_lineaMarca = new GroupLayout(lineaMarca);
		gl_lineaMarca.setHorizontalGroup(
			gl_lineaMarca.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaMarca.setVerticalGroup(
			gl_lineaMarca.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaMarca.setLayout(gl_lineaMarca);
		
		tipoObjetoTextField = new JTextField();
		tipoObjetoTextField.setText("EJ: 2000");
		tipoObjetoTextField.setOpaque(false);
		tipoObjetoTextField.setForeground(new Color(170, 170, 170));
		tipoObjetoTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tipoObjetoTextField.setCaretColor(Color.WHITE);
		tipoObjetoTextField.setBorder(null);
		tipoObjetoTextField.setBackground(new Color(51, 51, 51));
		tipoObjetoTextField.setBounds(383, 174, 214, 21);
		add(tipoObjetoTextField);
		
		lineaTipoObjeto = new JPanel();
		lineaTipoObjeto.setPreferredSize(new Dimension(0, 3));
		lineaTipoObjeto.setBackground(Color.WHITE);
		lineaTipoObjeto.setBounds(383, 198, 214, 3);
		add(lineaTipoObjeto);
		GroupLayout gl_lineaTipoObjeto = new GroupLayout(lineaTipoObjeto);
		gl_lineaTipoObjeto.setHorizontalGroup(
			gl_lineaTipoObjeto.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaTipoObjeto.setVerticalGroup(
			gl_lineaTipoObjeto.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaTipoObjeto.setLayout(gl_lineaTipoObjeto);
		
		ButtonGroup group = new ButtonGroup();
		
		JRadioButton cbMedidaEspecifica = new JRadioButton("Medida especifica");
		cbMedidaEspecifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisibleMedidaEspecifica(true);
			}
		});
		cbMedidaEspecifica.setFont(new Font("Segoe UI", Font.BOLD, 11));
		cbMedidaEspecifica.setForeground(Color.WHITE);
		cbMedidaEspecifica.setBackground(new Color(51, 51, 51));
		cbMedidaEspecifica.setBounds(231, 321, 121, 23);
		group.add(cbMedidaEspecifica);
		
		
		JRadioButton cbMedidaGeneral = new JRadioButton("Medida general");
		cbMedidaGeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisibleMedidaEspecifica(false);
			}
		});
		cbMedidaGeneral.setForeground(Color.WHITE);
		cbMedidaGeneral.setFont(new Font("Segoe UI", Font.BOLD, 11));
		cbMedidaGeneral.setBackground(new Color(51, 51, 51));
		cbMedidaGeneral.setBounds(380, 321, 109, 23);
		group.add(cbMedidaGeneral);
		
		add(cbMedidaEspecifica);
		add(cbMedidaGeneral);
		
		lblAlto = new JLabel("Alto");
		lblAlto.setForeground(Color.WHITE);
		lblAlto.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblAlto.setBounds(286, 376, 106, 14);
		lblAlto.setVisible(false);
		add(lblAlto);
		
		altoTextField = new JTextField();
		altoTextField.setText("0");
		altoTextField.setOpaque(false);
		altoTextField.setForeground(new Color(170, 170, 170));
		altoTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		altoTextField.setCaretColor(Color.WHITE);
		altoTextField.setBorder(null);
		altoTextField.setBackground(new Color(51, 51, 51));
		altoTextField.setBounds(286, 386, 47, 21);
		altoTextField.setVisible(false);
		add(altoTextField);
		
		lineaAlto = new JPanel();
		lineaAlto.setPreferredSize(new Dimension(0, 3));
		lineaAlto.setBackground(Color.WHITE);
		lineaAlto.setBounds(286, 410, 47, 3);
		lineaAlto.setVisible(false);
		add(lineaAlto);
		GroupLayout gl_lineaAlto = new GroupLayout(lineaAlto);
		gl_lineaAlto.setHorizontalGroup(
			gl_lineaAlto.createParallelGroup(Alignment.LEADING)
				.addGap(0, 47, Short.MAX_VALUE)
				.addGap(0, 47, Short.MAX_VALUE)
		);
		gl_lineaAlto.setVerticalGroup(
			gl_lineaAlto.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaAlto.setLayout(gl_lineaAlto);
		
		lblAncho = new JLabel("Ancho");
		lblAncho.setForeground(Color.WHITE);
		lblAncho.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblAncho.setBounds(345, 376, 106, 14);
		lblAncho.setVisible(false);
		add(lblAncho);
		
		anchoTextField = new JTextField();
		anchoTextField.setText("0");
		anchoTextField.setOpaque(false);
		anchoTextField.setForeground(new Color(170, 170, 170));
		anchoTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		anchoTextField.setCaretColor(Color.WHITE);
		anchoTextField.setBorder(null);
		anchoTextField.setBackground(new Color(51, 51, 51));
		anchoTextField.setBounds(345, 386, 47, 21);
		anchoTextField.setVisible(false);
		add(anchoTextField);
		
		lineaAncho = new JPanel();
		lineaAncho.setPreferredSize(new Dimension(0, 3));
		lineaAncho.setBackground(Color.WHITE);
		lineaAncho.setBounds(345, 410, 47, 3);
		lineaAncho.setVisible(false);
		add(lineaAncho);
		GroupLayout gl_lineaAncho = new GroupLayout(lineaAncho);
		gl_lineaAncho.setHorizontalGroup(
			gl_lineaAncho.createParallelGroup(Alignment.LEADING)
				.addGap(0, 47, Short.MAX_VALUE)
				.addGap(0, 47, Short.MAX_VALUE)
		);
		gl_lineaAncho.setVerticalGroup(
			gl_lineaAncho.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaAncho.setLayout(gl_lineaAncho);
		
		lblLargo = new JLabel("Largo");
		lblLargo.setForeground(Color.WHITE);
		lblLargo.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblLargo.setBounds(402, 376, 106, 14);
		lblLargo.setVisible(false);
		add(lblLargo);
		
		largoTextField = new JTextField();
		largoTextField.setText("0");
		largoTextField.setOpaque(false);
		largoTextField.setForeground(new Color(170, 170, 170));
		largoTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		largoTextField.setCaretColor(Color.WHITE);
		largoTextField.setBorder(null);
		largoTextField.setBackground(new Color(51, 51, 51));
		largoTextField.setBounds(402, 386, 47, 21);
		largoTextField.setVisible(false);
		add(largoTextField);
		
		lineaLargo = new JPanel();
		lineaLargo.setPreferredSize(new Dimension(0, 3));
		lineaLargo.setBackground(Color.WHITE);
		lineaLargo.setBounds(402, 410, 47, 3);
		lineaLargo.setVisible(false);
		add(lineaLargo);
		GroupLayout gl_lineaLargo = new GroupLayout(lineaLargo);
		gl_lineaLargo.setHorizontalGroup(
			gl_lineaLargo.createParallelGroup(Alignment.LEADING)
				.addGap(0, 47, Short.MAX_VALUE)
				.addGap(0, 47, Short.MAX_VALUE)
		);
		gl_lineaLargo.setVerticalGroup(
			gl_lineaLargo.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaLargo.setLayout(gl_lineaLargo);
		
		medidaTextField = new JTextField();
		medidaTextField.setText("");
		medidaTextField.setOpaque(false);
		medidaTextField.setForeground(new Color(170, 170, 170));
		medidaTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		medidaTextField.setCaretColor(Color.WHITE);
		medidaTextField.setBorder(null);
		medidaTextField.setBackground(new Color(51, 51, 51));
		medidaTextField.setBounds(345, 386, 47, 21);
		medidaTextField.setVisible(false);
		add(medidaTextField);
		
		lblMedida = new JLabel("Medida");
		lblMedida.setForeground(Color.WHITE);
		lblMedida.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblMedida.setBounds(345, 376, 106, 14);
		lblMedida.setVisible(false);
		add(lblMedida);
		
		lineaMedida = new JPanel();
		lineaMedida.setPreferredSize(new Dimension(0, 3));
		lineaMedida.setBackground(Color.WHITE);
		lineaMedida.setBounds(345, 410, 47, 3);
		lineaMedida.setVisible(false);
		add(lineaMedida);
		GroupLayout gl_lineaMedida = new GroupLayout(lineaMedida);
		gl_lineaMedida.setHorizontalGroup(
			gl_lineaMedida.createParallelGroup(Alignment.LEADING)
				.addGap(0, 47, Short.MAX_VALUE)
				.addGap(0, 47, Short.MAX_VALUE)
		);
		gl_lineaMedida.setVerticalGroup(
			gl_lineaMedida.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaMedida.setLayout(gl_lineaMedida);
		
		if (modo == 2) {
			setElementos(elementoSeleccionado);
		}
	}
	
	private void setVisibleMedidaEspecifica(boolean value) {
			// show/hide MedidaEspecifica
			lblAlto.setVisible(value);
			lblAncho.setVisible(value);
			lblLargo.setVisible(value);
			altoTextField.setVisible(value);
			anchoTextField.setVisible(value);
			largoTextField.setVisible(value);
			lineaAlto.setVisible(value);
			lineaAncho.setVisible(value);
			lineaLargo.setVisible(value);
			// hide/show MedidaGeneral
			lineaMedida.setVisible(!value);
			lblMedida.setVisible(!value);
			medidaTextField.setVisible(!value);
			
			if (value) {
				tipo_medidas = "Medida Especifica";
			} else {
				tipo_medidas = "Medida General";
			}
	}
	
	private void setElementos(ArrayList<String> elementoSeleccionado) {
		cambiarColorTextFieldsBlanco();
		stockTextField.setText(elementoSeleccionado.get(3));
		precioTextField.setText(elementoSeleccionado.get(4));
		descripcionTextField.setText(elementoSeleccionado.get(5));
	}
	
	private void setIndiceElementoSeleccionado(JComboBox comboBox, String elementoABuscar) {
		for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).toString().contains(elementoABuscar)) {
            	comboBox.setSelectedIndex(i);
            	break;
            }
        }
	}
	
	private void cambiarColorTextFieldsBlanco() {
		Component[] componentes = this.getComponents();
		for(int i = 0; i<componentes.length;i++) {
			if(componentes[i].getClass().equals(JTextField.class)) {
				componentes[i].setForeground(Color.WHITE);
			}
		}
	}
	
	private boolean verificarTipoObjeto() {
		if(!tipoObjetoTextField.getText().matches("[a-zA-Z0-9ñÑ ]{1,50}")|| tipoObjetoTextField.getText().charAt(0) == ' ') {
			setErroneo(lineaTipoObjeto, lblAlertaTipoObjeto);
			return false;
		}
		setAcertado(lineaTipoObjeto, lblAlertaTipoObjeto);
		return true;
	}

	private void agregarDatos() {
		agregarArticulo();
	}
	
	private void agregarArticulo() {
		Consulta consulta = new Consulta();
		Medida medidas = null;
		if (tipo_medidas.equalsIgnoreCase("Medida Especifica")) {
			medidas = new Medida(Integer.parseInt(altoTextField.getText()), Integer.parseInt(anchoTextField.getText()), Integer.parseInt(largoTextField.getText()));
		} else if (tipo_medidas.equalsIgnoreCase("Medida General")) {
			medidas = new Medida(medidaTextField.getText());
		}
		Articulo articulo = new Articulo(descripcionTextField.getText(), tipoObjetoTextField.getText(), marcaTextField.getText(), 
				Integer.parseInt(stockTextField.getText()), Integer.parseInt(precioTextField.getText()), medidas);
		if (modo == 1) {
			consulta.addArticulo(articulo);
		}else {
			//consulta.updt
		}
	}

	private boolean isTodoCorrecto() {
		if(verificarStock() && verificarMarca() && verificarDescripcion() && verificarPrecioUnitario() && verificarTipoObjeto()) {
			return true;
		}
		return false;
	}
	
	private boolean verificarPrecioUnitario() {
		if(!precioTextField.getText().matches("[0-9]{1,10}") || precioTextField.getText().charAt(0) == '0') {
			setErroneo(lineaPrecioUnitario, lblAlertaPrecioUnitario);
			return false;
		}
		setAcertado(lineaPrecioUnitario, lblAlertaPrecioUnitario);
		return true;
	}
	
	private boolean verificarDescripcion() {
		if(!descripcionTextField.getText().matches("[a-zA-Z0-9ñÑ ]{1,50}")|| descripcionTextField.getText().charAt(0) == ' ') {
			setErroneo(lineaDescripcion, lblAlertaDescripcion);
			return false;
		}
		setAcertado(lineaDescripcion, lblAlertaDescripcion);
		return true;
	}
	
	private boolean verificarMarca() {
		if(!marcaTextField.getText().matches("[a-zA-Z0-9ñÑ ]{1,50}")|| marcaTextField.getText().charAt(0) == ' ') {
			setErroneo(lineaMarca, lblAlertaMarca);
			return false;
		}
		setAcertado(lineaMarca, lblAlertaMarca);
		return true;
	}

	private boolean verificarStock() {
		if(!stockTextField.getText().matches("[0-9]{1,5}") || stockTextField.getText().charAt(0) == '0') {
			setErroneo(lineaStock, lblAlertaStock);
			return false;
		}
		setAcertado(lineaStock, lblAlertaStock);
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
				boton.setFont(new Font("Roboto Light", Font.BOLD, 26));
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
	
	private String obtenerIdEnString(String opcionSeleccionada) {
		char[] caracteres = opcionSeleccionada.toCharArray();
		String id = "";
		for(char c : caracteres) {
			if(c == ' ') {
				break;
			}
			id+= c;
		}
		return id;
	}
}
