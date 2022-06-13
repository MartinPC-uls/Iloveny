package vista;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AgregarUsuarioPanel extends JPanel {
	
	private static final long serialVersionUID = -4869686066977683583L;
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	public int modoPanel=0;
	
	private JTextField rutTextField;
	private JTextField nombreTextField;
	private JTextField apellidosTextField;
	private JTextField numTelefonoTextField;
	private JTextField emailTextField;
	private JLabel lblAlertaRUT;
	private JLabel lblAlertaNombre;
	private JLabel lblAlertaNumTel;
	private JLabel lblAlertaEmail;
	private JLabel lblAlertaApellidos;
	private JPanel lineaEmail;
	private JPanel lineaRut;
	private JPanel lineaNombre;
	private JPanel lineaNumTel;
	private JPanel lineaApellidos;
	private JButton btnVolver;
	public JButton btnRefrezcar;
	private String rutAntiguo;
	private JTextField calleTextField;
	private JTextField numeroDomicilioTextField;
	private JTextField ciudadTextField;
	private JTextField comunaTextField;
	private JTextField regionTextField;

	public AgregarUsuarioPanel(int modo, JComponent[] paneles,JButton btnRefrezcar, ArrayList<String> elementoSeleccionado) {
		this.modoPanel = modo;
		this.btnRefrezcar = btnRefrezcar;
		setBounds(0,0,732,558);
		setBackground(new Color(51,51,51));
		setLayout(null);
		
		JLabel lblAgregarUsuario = new JLabel("Usuario\r\n");
		lblAgregarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarUsuario.setForeground(Color.WHITE);
		lblAgregarUsuario.setFont(new Font("Roboto Medium", Font.PLAIN, 41));
		lblAgregarUsuario.setBounds(215, 11, 302, 55);
		add(lblAgregarUsuario);
		
		JLabel lblRut = new JLabel("RUT");
		lblRut.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblRut.setForeground(Color.WHITE);
		lblRut.setBounds(135, 77, 62, 14);
		add(lblRut);
		
		lineaRut = new JPanel();
		lineaRut.setPreferredSize(new Dimension(0, 3));
		lineaRut.setBackground(Color.WHITE);
		lineaRut.setBounds(135, 114, 214, 3);
		add(lineaRut);
		GroupLayout gl_lineaRut = new GroupLayout(lineaRut);
		gl_lineaRut.setHorizontalGroup(
			gl_lineaRut.createParallelGroup(Alignment.LEADING)
				.addGap(0, 441, Short.MAX_VALUE)
				.addGap(0, 441, Short.MAX_VALUE)
		);
		gl_lineaRut.setVerticalGroup(
			gl_lineaRut.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaRut.setLayout(gl_lineaRut);
		
		rutTextField = new JTextField();
		rutTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarRut();
			}
		});
		rutTextField.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		verificarRut();
        	}
        });
		rutTextField.setText("EJ: 12.345.678-9");
		rutTextField.setOpaque(false);
		rutTextField.setForeground(new Color(170, 170, 170));
		rutTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		rutTextField.setCaretColor(Color.WHITE);
		rutTextField.setBorder(null);
		rutTextField.setBackground(new Color(51, 51, 51));
		rutTextField.setBounds(135, 90, 214, 21);
		eventoCambiarJTextField(rutTextField, rutTextField.getText(), 30);
		add(rutTextField);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblNombre.setBounds(135, 128, 62, 14);
		add(lblNombre);
		
		lineaNombre = new JPanel();
		lineaNombre.setPreferredSize(new Dimension(0, 3));
		lineaNombre.setBackground(Color.WHITE);
		lineaNombre.setBounds(135, 165, 214, 3);
		add(lineaNombre);
		GroupLayout gl_lineaNombre = new GroupLayout(lineaNombre);
		gl_lineaNombre.setHorizontalGroup(
			gl_lineaNombre.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaNombre.setVerticalGroup(
			gl_lineaNombre.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaNombre.setLayout(gl_lineaNombre);
		
		nombreTextField = new JTextField();
		nombreTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarNombre();
			}
		});
		nombreTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarNombre();
			}
		});
		nombreTextField.setText("EJ: Pedro");
		nombreTextField.setOpaque(false);
		nombreTextField.setForeground(new Color(170, 170, 170));
		nombreTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		nombreTextField.setCaretColor(Color.WHITE);
		nombreTextField.setBorder(null);
		nombreTextField.setBackground(new Color(51, 51, 51));
		nombreTextField.setBounds(135, 141, 214, 21);
		eventoCambiarJTextField(nombreTextField, nombreTextField.getText(),20);
		add(nombreTextField);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblApellidos.setBounds(380, 128, 62, 14);
		add(lblApellidos);
		
		lineaApellidos = new JPanel();
		lineaApellidos.setPreferredSize(new Dimension(0, 3));
		lineaApellidos.setBackground(Color.WHITE);
		lineaApellidos.setBounds(380, 165, 214, 3);
		add(lineaApellidos);
		GroupLayout gl_lineaApellidos = new GroupLayout(lineaApellidos);
		gl_lineaApellidos.setHorizontalGroup(
			gl_lineaApellidos.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaApellidos.setVerticalGroup(
			gl_lineaApellidos.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaApellidos.setLayout(gl_lineaApellidos);
		
		apellidosTextField = new JTextField();
		apellidosTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarApellidos();
			}
		});
		apellidosTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarApellidos();
			}
		});
		apellidosTextField.setText("EJ: Rodriguez Diaz");
		apellidosTextField.setOpaque(false);
		apellidosTextField.setForeground(new Color(170, 170, 170));
		apellidosTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		apellidosTextField.setCaretColor(Color.WHITE);
		apellidosTextField.setBorder(null);
		apellidosTextField.setBackground(new Color(51, 51, 51));
		apellidosTextField.setBounds(380, 141, 214, 21);
		eventoCambiarJTextField(apellidosTextField, apellidosTextField.getText(), 50);
		add(apellidosTextField);
		
		JLabel lblNumeroTelefonico = new JLabel("Numero Telefonico");
		lblNumeroTelefonico.setForeground(Color.WHITE);
		lblNumeroTelefonico.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblNumeroTelefonico.setBounds(135, 184, 94, 14);
		add(lblNumeroTelefonico);
		
		lineaNumTel = new JPanel();
		lineaNumTel.setPreferredSize(new Dimension(0, 3));
		lineaNumTel.setBackground(Color.WHITE);
		lineaNumTel.setBounds(135, 221, 214, 3);
		add(lineaNumTel);
		GroupLayout gl_lineaNumTel = new GroupLayout(lineaNumTel);
		gl_lineaNumTel.setHorizontalGroup(
			gl_lineaNumTel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaNumTel.setVerticalGroup(
			gl_lineaNumTel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaNumTel.setLayout(gl_lineaNumTel);
		
		numTelefonoTextField = new JTextField();
		numTelefonoTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarNumeroTelefonico();
			}
		});
		numTelefonoTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarNumeroTelefonico();
			}
		});
		numTelefonoTextField.setText("EJ: +56912345678 ");
		numTelefonoTextField.setOpaque(false);
		numTelefonoTextField.setForeground(new Color(170, 170, 170));
		numTelefonoTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		numTelefonoTextField.setCaretColor(Color.WHITE);
		numTelefonoTextField.setBorder(null);
		numTelefonoTextField.setBackground(new Color(51, 51, 51));
		numTelefonoTextField.setBounds(135, 197, 214, 21);
		eventoCambiarJTextField(numTelefonoTextField, numTelefonoTextField.getText(), 25);
		add(numTelefonoTextField);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblEmail.setBounds(380, 184, 62, 14);
		add(lblEmail);
		
		lineaEmail = new JPanel();
		lineaEmail.setPreferredSize(new Dimension(0, 3));
		lineaEmail.setBackground(Color.WHITE);
		lineaEmail.setBounds(380, 221, 214, 3);
		add(lineaEmail);
		GroupLayout gl_lineaEmail = new GroupLayout(lineaEmail);
		gl_lineaEmail.setHorizontalGroup(
			gl_lineaEmail.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaEmail.setVerticalGroup(
			gl_lineaEmail.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaEmail.setLayout(gl_lineaEmail);
		
		emailTextField = new JTextField();
		emailTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarEmail();
			}
		});
		emailTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarEmail();
			}
		});
		emailTextField.setText("EJ: ejemplo@ejemplo.com ");
		emailTextField.setOpaque(false);
		emailTextField.setForeground(new Color(170, 170, 170));
		emailTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		emailTextField.setCaretColor(Color.WHITE);
		emailTextField.setBorder(null);
		emailTextField.setBackground(new Color(51, 51, 51));
		emailTextField.setBounds(380, 197, 214, 21);
		eventoCambiarJTextField(emailTextField, emailTextField.getText(), 50);
		add(emailTextField);
		
		JButton btnAgregarUsuario = new JButton("AGREGAR USUARIO");
		btnAgregarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isTodoCorrecto()) {
					agregarDatos();
					btnRefrezcar.doClick();
					paneles[1].setVisible(true);
					paneles[0].setBounds(929, 39, 732, 558);
				}
			}
		});
		eventoExpandirDisminuirTamanoBoton(btnAgregarUsuario, 15);
		btnAgregarUsuario.setBorder(null);
		btnAgregarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarUsuario.setBackground(Color.WHITE);
		btnAgregarUsuario.setFont(new Font("Roboto Light", Font.PLAIN, 25));
		btnAgregarUsuario.setBounds(215, 458, 302, 64);
		add(btnAgregarUsuario);
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
		btnVolver.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/volver-white.png")));
		btnVolver.setBounds(0, 510, 68, 48);
		add(btnVolver);
		
		lblAlertaRUT = new JLabel("");
		lblAlertaRUT.setVisible(false);
		lblAlertaRUT.setToolTipText("Hay un error de formato");
		lblAlertaRUT.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaRUT.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaRUT.setBounds(95, 90, 30, 27);
		add(lblAlertaRUT);
		
		lblAlertaNombre = new JLabel("");
		lblAlertaNombre.setVisible(false);
		lblAlertaNombre.setToolTipText("Hay un error de formato");
		lblAlertaNombre.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaNombre.setBounds(95, 141, 30, 27);
		add(lblAlertaNombre);
		
		lblAlertaNumTel = new JLabel("");
		lblAlertaNumTel.setVisible(false);
		lblAlertaNumTel.setToolTipText("Hay un error de formato");
		lblAlertaNumTel.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaNumTel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaNumTel.setBounds(95, 197, 30, 27);
		add(lblAlertaNumTel);
		
		lblAlertaEmail = new JLabel("");
		lblAlertaEmail.setVisible(false);
		lblAlertaEmail.setToolTipText("Hay un error de formato");
		lblAlertaEmail.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaEmail.setBounds(601, 197, 30, 27);
		add(lblAlertaEmail);
		
		lblAlertaApellidos = new JLabel("");
		lblAlertaApellidos.setVisible(false);
		lblAlertaApellidos.setToolTipText("Hay un error de formato");
		lblAlertaApellidos.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaApellidos.setBounds(601, 141, 30, 27);
		add(lblAlertaApellidos);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setForeground(Color.WHITE);
		lblCalle.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblCalle.setBounds(135, 235, 62, 14);
		add(lblCalle);
		
		JPanel lineaCalle = new JPanel();
		lineaCalle.setPreferredSize(new Dimension(0, 3));
		lineaCalle.setBackground(Color.WHITE);
		lineaCalle.setBounds(135, 272, 214, 3);
		add(lineaCalle);
		GroupLayout gl_lineaCalle = new GroupLayout(lineaCalle);
		gl_lineaCalle.setHorizontalGroup(
			gl_lineaCalle.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaCalle.setVerticalGroup(
			gl_lineaCalle.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaCalle.setLayout(gl_lineaCalle);
		
		calleTextField = new JTextField();
		calleTextField.setText("EJ: Ulriksen");
		calleTextField.setOpaque(false);
		calleTextField.setForeground(new Color(170, 170, 170));
		calleTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		calleTextField.setCaretColor(Color.WHITE);
		calleTextField.setBorder(null);
		calleTextField.setBackground(new Color(51, 51, 51));
		calleTextField.setBounds(135, 248, 214, 21);
		add(calleTextField);
		
		JLabel lblNumeroDomicilio = new JLabel("Numero domicilio");
		lblNumeroDomicilio.setForeground(Color.WHITE);
		lblNumeroDomicilio.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblNumeroDomicilio.setBounds(380, 235, 214, 14);
		add(lblNumeroDomicilio);
		
		JPanel lineaNumeroDomicilio = new JPanel();
		lineaNumeroDomicilio.setPreferredSize(new Dimension(0, 3));
		lineaNumeroDomicilio.setBackground(Color.WHITE);
		lineaNumeroDomicilio.setBounds(380, 272, 214, 3);
		add(lineaNumeroDomicilio);
		GroupLayout gl_lineaNumeroDomicilio = new GroupLayout(lineaNumeroDomicilio);
		gl_lineaNumeroDomicilio.setHorizontalGroup(
			gl_lineaNumeroDomicilio.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaNumeroDomicilio.setVerticalGroup(
			gl_lineaNumeroDomicilio.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaNumeroDomicilio.setLayout(gl_lineaNumeroDomicilio);
		
		numeroDomicilioTextField = new JTextField();
		numeroDomicilioTextField.setText("EJ: 1234");
		numeroDomicilioTextField.setOpaque(false);
		numeroDomicilioTextField.setForeground(new Color(170, 170, 170));
		numeroDomicilioTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		numeroDomicilioTextField.setCaretColor(Color.WHITE);
		numeroDomicilioTextField.setBorder(null);
		numeroDomicilioTextField.setBackground(new Color(51, 51, 51));
		numeroDomicilioTextField.setBounds(380, 248, 214, 21);
		add(numeroDomicilioTextField);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setForeground(Color.WHITE);
		lblCiudad.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblCiudad.setBounds(135, 286, 62, 14);
		add(lblCiudad);
		
		JPanel lineaCiudad = new JPanel();
		lineaCiudad.setPreferredSize(new Dimension(0, 3));
		lineaCiudad.setBackground(Color.WHITE);
		lineaCiudad.setBounds(135, 323, 214, 3);
		add(lineaCiudad);
		GroupLayout gl_lineaCiudad = new GroupLayout(lineaCiudad);
		gl_lineaCiudad.setHorizontalGroup(
			gl_lineaCiudad.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaCiudad.setVerticalGroup(
			gl_lineaCiudad.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaCiudad.setLayout(gl_lineaCiudad);
		
		ciudadTextField = new JTextField();
		ciudadTextField.setText("EJ: La Serena");
		ciudadTextField.setOpaque(false);
		ciudadTextField.setForeground(new Color(170, 170, 170));
		ciudadTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		ciudadTextField.setCaretColor(Color.WHITE);
		ciudadTextField.setBorder(null);
		ciudadTextField.setBackground(new Color(51, 51, 51));
		ciudadTextField.setBounds(135, 299, 214, 21);
		add(ciudadTextField);
		
		JLabel lblComuna = new JLabel("Comuna");
		lblComuna.setForeground(Color.WHITE);
		lblComuna.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblComuna.setBounds(380, 286, 62, 14);
		add(lblComuna);
		
		JPanel lineaComuna = new JPanel();
		lineaComuna.setPreferredSize(new Dimension(0, 3));
		lineaComuna.setBackground(Color.WHITE);
		lineaComuna.setBounds(380, 323, 214, 3);
		add(lineaComuna);
		GroupLayout gl_lineaComuna = new GroupLayout(lineaComuna);
		gl_lineaComuna.setHorizontalGroup(
			gl_lineaComuna.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaComuna.setVerticalGroup(
			gl_lineaComuna.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaComuna.setLayout(gl_lineaComuna);
		
		comunaTextField = new JTextField();
		comunaTextField.setText("EJ: La Serena");
		comunaTextField.setOpaque(false);
		comunaTextField.setForeground(new Color(170, 170, 170));
		comunaTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		comunaTextField.setCaretColor(Color.WHITE);
		comunaTextField.setBorder(null);
		comunaTextField.setBackground(new Color(51, 51, 51));
		comunaTextField.setBounds(380, 299, 214, 21);
		add(comunaTextField);
		
		JLabel lblRegion = new JLabel("Regi\u00F3n");
		lblRegion.setForeground(Color.WHITE);
		lblRegion.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblRegion.setBounds(135, 337, 62, 14);
		add(lblRegion);
		
		JPanel lineaRegion = new JPanel();
		lineaRegion.setPreferredSize(new Dimension(0, 3));
		lineaRegion.setBackground(Color.WHITE);
		lineaRegion.setBounds(135, 374, 214, 3);
		add(lineaRegion);
		GroupLayout gl_lineaRegion = new GroupLayout(lineaRegion);
		gl_lineaRegion.setHorizontalGroup(
			gl_lineaRegion.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaRegion.setVerticalGroup(
			gl_lineaRegion.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaRegion.setLayout(gl_lineaRegion);
		
		regionTextField = new JTextField();
		regionTextField.setText("EJ: Coquimbo");
		regionTextField.setOpaque(false);
		regionTextField.setForeground(new Color(170, 170, 170));
		regionTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		regionTextField.setCaretColor(Color.WHITE);
		regionTextField.setBorder(null);
		regionTextField.setBackground(new Color(51, 51, 51));
		regionTextField.setBounds(135, 350, 214, 21);
		add(regionTextField);
		
		if (modo == 2) {
			btnAgregarUsuario.setText("MODIFICAR USUARIO");
			setElementos(elementoSeleccionado);
		}
	}
	
	private void setElementos(ArrayList<String> elementoSeleccionado) {
		nombreTextField.setForeground(Color.WHITE);
		nombreTextField.setText(elementoSeleccionado.get(0));
		apellidosTextField.setForeground(Color.WHITE);
		apellidosTextField.setText(elementoSeleccionado.get(1));
		rutTextField.setForeground(Color.WHITE);
		rutTextField.setText(elementoSeleccionado.get(2));
		rutAntiguo = elementoSeleccionado.get(2);
		numTelefonoTextField.setForeground(Color.WHITE);
		numTelefonoTextField.setText(elementoSeleccionado.get(3));
		emailTextField.setForeground(Color.WHITE);
		emailTextField.setText(elementoSeleccionado.get(4));
	}
	
	private void agregarDatos() {
		agregarDatosTablaUsuario();
	}

	private void agregarDatosTablaUsuario() {
		if (modoPanel == 1) {
			// TODO addUsuario    		
		} else if (modoPanel == 2) {
			// TODO updtUsuario
		}
	}

	private boolean isTodoCorrecto() {
		if(verificarRut() && verificarNombre() && verificarApellidos() && verificarNumeroTelefonico() && verificarEmail()) {
			return true;
		}else {
			return false;	
		}
	}

	public boolean verificarEmail() {
		if(emailTextField.getText().length()<50) {
			 Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailTextField.getText());
			 if(!matcher.find()) {
				 lineaEmail.setBackground(new Color(255,0,0));
				 lblAlertaEmail.setVisible(true);
				 return false;
			 }else {
				 lineaEmail.setBackground(new Color(50,205,50));
				 lblAlertaEmail.setVisible(false);
				 return true;
			 }
		}
		lblAlertaEmail.setVisible(true);
		lineaEmail.setBackground(new Color(255,0,0));
		return false;
	}

	private boolean verificarNumeroTelefonico() {
		if(!numTelefonoTextField.getText().matches("\\+((569)|(562)){1}[0-9]{8}")) { 
			setErroneo(lineaNumTel, lblAlertaNumTel);
			return false;
		}
		setAcertado(lineaNumTel, lblAlertaNumTel);
		return true;
	}
	
	private boolean verificarApellidos() {
		if(!apellidosTextField.getText().matches("[a-zA-Z ]{1,50}") || apellidosTextField.getText().charAt(0) == ' ') {
			setErroneo(lineaApellidos, lblAlertaApellidos);
			return false;
		}
		setAcertado(lineaApellidos, lblAlertaApellidos);
		return true;
	}

	private boolean verificarNombre() {
		if(!nombreTextField.getText().matches("[a-zA-Z]{1,20}")) {
			setErroneo(lineaNombre, lblAlertaNombre);
			return false;
		}
		setAcertado(lineaNombre, lblAlertaNombre);
		return true;
	}

	private boolean verificarRut() {
		if(rutTextField.getText().charAt(0) == '0') {
			setErroneo(lineaRut, lblAlertaRUT);
			return false;
		}
		if(rutTextField.getText().matches("[0-9]{1,2}[.][1-9][0-9]{2}[.][1-9][0-9]{2}[-]([0-9]|(k|K))")) {
			setAcertado(lineaRut,lblAlertaRUT);
			return true;
		}
		setErroneo(lineaRut, lblAlertaRUT);
		return false;
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
