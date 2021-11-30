package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import a.Modelo.Consulta;

import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AgregarRegistroCompraPanel extends JPanel {
	private static final Object[] String = null;
	public int modo;
	public boolean existenRutsSinDireccion;
	public Consulta consulta = new Consulta();
	
	private JLabel lblAlertaArticulo;
	private JComboBox articuloCB;
	private JTextField fechaPedidaTextField;
	private JLabel lblAlertaFechaPedida;
	private JLabel lblAlertaUnidadesAdquiridas;
	private JTextField unidadesAdquiridasTextField;
	private JTextField costoUnitarioTextField;
	private JTextField fechaReciboTextField;
	private JLabel lblAlertaFechaRecibo;
	private JLabel lblAlertaCostoUnitario;
	private JComboBox proveedorCB;
	private JLabel lblAlertaProveedor;
	private JPanel lineaFechaPedida;
	private JPanel lineaUnidadesAdquiridas;
	private JPanel lineaCostoUnitario;
	private JPanel lineaFechaRecibo;
	private JButton btnVolver;
	public JButton btnRefrezcar;
	
	public AgregarRegistroCompraPanel(int modo, JComponent[] paneles, JButton btnRefrezcar) {
		this.modo = modo;
		this.btnRefrezcar = btnRefrezcar;
		setBounds(0,0,732,558);
		setBackground(new Color(51,51,51));
		setLayout(null);
		
		lblAlertaProveedor = new JLabel("");
		lblAlertaProveedor.setVisible(false);
		lblAlertaProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaProveedor.setIcon(new ImageIcon(AgregarDireccionPanel.class.getResource("/imagenes/alert-icon-white.png")));
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
		unidadesAdquiridasTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarCalle();
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
		
		DefaultComboBoxModel modelo = crearModeloComboBoxArticulo();
		articuloCB = new JComboBox(new String[] {});
		articuloCB.setModel(modelo);
		articuloCB.setBounds(138, 180, 214, 21);
		add(articuloCB);
		
		JLabel lblCostoUnitario = new JLabel("Costo unitario (CLP)");
		lblCostoUnitario.setForeground(Color.WHITE);
		lblCostoUnitario.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblCostoUnitario.setBounds(383, 267, 106, 14);
		add(lblCostoUnitario);
		
		costoUnitarioTextField = new JTextField();
		costoUnitarioTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarNumCalle();
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
		fechaPedidaTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarComuna();
			}
		});
		fechaPedidaTextField.setToolTipText("a");
		fechaPedidaTextField.setText("yyyy-mm-dd");
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
		fechaReciboTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarCiudad();
			}
		});
		fechaReciboTextField.setText("yyyy-mm-dd");
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
		add(btnAgregarRegistroCompra);
		
		lblAlertaFechaPedida = new JLabel("");
		lblAlertaFechaPedida.setVisible(false);
		lblAlertaFechaPedida.setToolTipText("Hay un error de formato");
		lblAlertaFechaPedida.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaFechaPedida.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaFechaPedida.setBounds(99, 222, 30, 27);
		add(lblAlertaFechaPedida);
		
		lblAlertaUnidadesAdquiridas = new JLabel("");
		lblAlertaUnidadesAdquiridas.setVisible(false);
		lblAlertaUnidadesAdquiridas.setToolTipText("Hay un error de formato");
		lblAlertaUnidadesAdquiridas.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaUnidadesAdquiridas.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaUnidadesAdquiridas.setBounds(98, 280, 30, 27);
		add(lblAlertaUnidadesAdquiridas);
		
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
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setForeground(Color.WHITE);
		lblProveedor.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblProveedor.setBounds(383, 155, 62, 14);
		add(lblProveedor);
		
		DefaultComboBoxModel modelo2 = crearModeloComboBoxProveedor();
		proveedorCB = new JComboBox(new Object[]{});
		proveedorCB.setModel(modelo2);
		proveedorCB.setBounds(383, 180, 214, 21);
		add(proveedorCB);
		
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
		btnVolver.setIcon(new ImageIcon(AgregarDireccionPanel.class.getResource("/imagenes/volver-white.png")));
		btnVolver.setBounds(0, 510, 68, 48);
		add(btnVolver);
	}
	
	private DefaultComboBoxModel crearModeloComboBoxProveedor() {
		ArrayList proveedores = consulta.getProveedor();
		if(proveedores.size()>0) {
			existenRutsSinDireccion = true;
			String[] listaProveedores = new String[proveedores.size()+1];
			System.out.println(proveedores.size());
			listaProveedores[0] = "Seleccione...";
			for(int i=1; i<=proveedores.size();i++) {
				listaProveedores[i] = proveedores.get(i-1).toString();
			}
			return new DefaultComboBoxModel(listaProveedores);
		}else {
			lblAlertaProveedor.setVisible(true);
			return new DefaultComboBoxModel(new String[] {"No hay proveedores"});
		}
	}
	
	private DefaultComboBoxModel crearModeloComboBoxArticulo() {
		ArrayList articulo = consulta.getDescripcionArticulosConStock();
		if(articulo.size()>0) {
			String[] listaArticulos = new String[articulo.size()+1];
			System.out.println(articulo.size());
			listaArticulos[0] = "Seleccione...";
			for(int i=1; i<=articulo.size();i++) {
				listaArticulos[i] = articulo.get(i-1).toString();
			}
			return new DefaultComboBoxModel(listaArticulos);
		}else {
			lblAlertaArticulo.setVisible(true);
			return new DefaultComboBoxModel(new String[] {"No existen articulos"});
		}
	}

	private void agregarDatos() {
		agregarDatosTablaDireccion();
	}
	
	private void agregarDatosTablaDireccion() {
		if (modo == 1) {
			consulta.addDireccion((String)proveedorCB.getSelectedItem(), articuloCB.getSelectedIndex(), Integer.parseInt(costoUnitarioTextField.getText()),unidadesAdquiridasTextField.getText() , fechaReciboTextField.getText(), fechaPedidaTextField.getText()); 
		} else if(modo == 2) {
			
		}
	}

	private boolean isTodoCorrecto() {
		if(verificarCalle() && verificarNumCalle() && verificarRegion() && verificarComuna() && verificarCiudad() && existenRutsSinDireccion && proveedorCB.getSelectedIndex()!=0) {
			return true;
		}
		return false;
	}
	
	private boolean verificarCiudad() {
		if(fechaReciboTextField.equals("") || fechaReciboTextField.getText().length()>20 || !isOnlyAlpha(fechaReciboTextField.getText())) {
			lblAlertaFechaRecibo.setVisible(true);
			setErroneo(lineaFechaRecibo, lblAlertaFechaRecibo);
			return false;
		}
		setAcertado(lineaFechaRecibo, lblAlertaFechaRecibo);
		lblAlertaFechaRecibo.setVisible(false);
		return true;
	}
	
	private boolean verificarComuna() {
		if(fechaPedidaTextField.equals("") || fechaPedidaTextField.getText().length()>20 || !isOnlyAlpha(fechaPedidaTextField.getText())) {
			setErroneo(lineaFechaPedida, lblAlertaFechaPedida);
			return false;
		}
		setAcertado(lineaFechaPedida, lblAlertaFechaPedida);
		return true;
	}

	private boolean verificarRegion() {
		if(articuloCB.getSelectedIndex() == 0) {
			lblAlertaArticulo.setVisible(true);
			return false;
		}
		lblAlertaArticulo.setVisible(false);
		return true;
	}

	private boolean verificarNumCalle() {
		if(costoUnitarioTextField.getText().equals("") || costoUnitarioTextField.getText().contains(" ") || costoUnitarioTextField.getText().length()>10 || !costoUnitarioTextField.getText().matches("[0-9]+") ) {
			setErroneo(lineaCostoUnitario, lblAlertaCostoUnitario);
			return false;
		}
		setAcertado(lineaCostoUnitario, lblAlertaCostoUnitario);
		return true;
	}

	private boolean verificarCalle() {
		if(unidadesAdquiridasTextField.equals("") || unidadesAdquiridasTextField.getText().length()>50 || !isOnlyAlpha(unidadesAdquiridasTextField.getText())) {
			setErroneo(lineaUnidadesAdquiridas, lblAlertaUnidadesAdquiridas);
			return false;
		}
		setAcertado(lineaUnidadesAdquiridas, lblAlertaUnidadesAdquiridas);
		return true;
	}
	
	public boolean isOnlyAlpha(String name) {
	    char[] chars = name.toCharArray();

	    for (char c : chars) {
	        if(!Character.isLetter(c) && c != ' ') {
	            return false;
	        }
	    }
	    return true;
	}
	
	public boolean isHasAlpha(String name) {
	    char[] chars = name.toCharArray();

	    for (char c : chars) {
	        if(Character.isLetter(c)) {
	            return true;
	        }
	    }
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
        		String text = txtUser.getText();
        		Color color = new Color(170, 170, 170);
        		if (txtUser.getForeground().equals(color) && txtUser.getText().length() < maxCaracteres) {
        			txtUser.setText("");
        			txtUser.setForeground(new Color(255, 255, 255));
        		}
        	}
        });
	}

}
