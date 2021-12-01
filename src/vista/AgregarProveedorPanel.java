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

public class AgregarProveedorPanel extends JPanel {
	private static final Object[] String = null;
	public int modo;
	public boolean existenRutsSinDireccion;
	public Consulta consulta = new Consulta();
	private JTextField proveedortextField;
	private JLabel lblAlertaProveedor;
	private JPanel lineaProveedor;
	private JButton btnVolver;
	public JButton btnRefrezcar;
	
	public AgregarProveedorPanel(int modo, JComponent[] paneles, JButton btnRefrezcar) {
		this.modo = modo;
		this.btnRefrezcar = btnRefrezcar;
		setBounds(0,0,732,558);
		setBackground(new Color(51,51,51));
		setLayout(null);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblProveedor.setForeground(Color.WHITE);
		lblProveedor.setFont(new Font("Roboto Medium", Font.PLAIN, 41));
		lblProveedor.setBounds(215, 11, 302, 55);
		add(lblProveedor);
		
		JLabel lblProveedor2 = new JLabel("Proveedor:");
		lblProveedor2.setForeground(Color.WHITE);
		lblProveedor2.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblProveedor2.setBounds(259, 210, 106, 14);
		add(lblProveedor2);
		
		proveedortextField = new JTextField();
		proveedortextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarMarca();
			}
		});
		proveedortextField.setToolTipText("a");
		proveedortextField.setText("EJ: Proveedor3");
		proveedortextField.setOpaque(false);
		proveedortextField.setForeground(new Color(170, 170, 170));
		proveedortextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		proveedortextField.setCaretColor(Color.WHITE);
		proveedortextField.setBorder(null);
		proveedortextField.setBackground(new Color(51, 51, 51));
		proveedortextField.setBounds(259, 222, 214, 21);
		eventoCambiarJTextField(proveedortextField, proveedortextField.getText(), 20);
		add(proveedortextField);
		
		lineaProveedor = new JPanel();
		lineaProveedor.setPreferredSize(new Dimension(0, 3));
		lineaProveedor.setBackground(Color.WHITE);
		lineaProveedor.setBounds(259, 248, 214, 3);
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
		
		JButton btnAgregarProveedor = new JButton("AGREGAR PROVEEDOR");
		btnAgregarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isTodoCorrecto()) {
					agregarDatos();
					btnRefrezcar.doClick();
					paneles[1].setVisible(true);
					paneles[0].setBounds(929, 39, 732, 558);
				}
			}
		});
		btnAgregarProveedor.setBorder(null);
		btnAgregarProveedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarProveedor.setBackground(Color.WHITE);
		btnAgregarProveedor.setFont(new Font("Roboto Light", Font.PLAIN, 25));
		btnAgregarProveedor.setBounds(206, 455, 320, 64);
		add(btnAgregarProveedor);
		
		lblAlertaProveedor = new JLabel("");
		lblAlertaProveedor.setVisible(false);
		lblAlertaProveedor.setToolTipText("Hay un error de formato");
		lblAlertaProveedor.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaProveedor.setBounds(223, 222, 30, 27);
		add(lblAlertaProveedor);
		
		//DefaultComboBoxModel modelo = crearModeloComboBox();
		
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
	
	/*private DefaultComboBoxModel crearModeloComboBox() {
		ArrayList ruts = consulta.getRutsSinDireccion();
		if(ruts.size()>0) {
			existenRutsSinDireccion = true;
			String[] listaRuts = new String[ruts.size()+1];
			System.out.println(ruts.size());
			listaRuts[0] = "Seleccione...";
			for(int i=1; i<=ruts.size();i++) {
				listaRuts[i] = ruts.get(i-1).toString();
			}
			return new DefaultComboBoxModel(listaRuts);
		}else {
			lblAlertaRut.setVisible(true);
			existenRutsSinDireccion = false;
			return new DefaultComboBoxModel(new String[] {"No existen ruts"});
		}
	}*/

	private void agregarDatos() {
		agregarDatosTablaMarca();
	}
	
	private void agregarDatosTablaMarca() {
		if (modo == 1) {
			consulta.addMarca(proveedortextField.getText());
		} else if(modo == 2) {
			
		}
	}

	private boolean isTodoCorrecto() {
		if(verificarMarca()) {
			return true;
		}
		return false;
	}
	
	private boolean verificarMarca() {
		if(proveedortextField.getText().equals("")) {
			lblAlertaProveedor.setVisible(true);
			setErroneo(lineaProveedor, lblAlertaProveedor);
			return false;
		}
		setAcertado(lineaProveedor, lblAlertaProveedor);
		lblAlertaProveedor.setVisible(false);
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
	}

}
