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

public class AgregarTipoObjetoPanel extends JPanel {
	private static final Object[] String = null;
	public int modo;
	public boolean existenRutsSinDireccion;
	public Consulta consulta = new Consulta();
	private JTextField objetoTextField;
	private JLabel lblAlertaMarca;
	private JPanel lineaObjeto;
	private JButton btnVolver;
	public JButton btnRefrezcar;
	
	public AgregarTipoObjetoPanel(int modo, JComponent[] paneles, JButton btnRefrezcar) {
		this.modo = modo;
		this.btnRefrezcar = btnRefrezcar;
		setBounds(0,0,732,558);
		setBackground(new Color(51,51,51));
		setLayout(null);
		
		JLabel lblTipoObjeto = new JLabel("Tipo Objeto");
		lblTipoObjeto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoObjeto.setForeground(Color.WHITE);
		lblTipoObjeto.setFont(new Font("Roboto Medium", Font.PLAIN, 41));
		lblTipoObjeto.setBounds(199, 11, 302, 55);
		add(lblTipoObjeto);
		
		JLabel lblObjeto = new JLabel("Objeto");
		lblObjeto.setForeground(Color.WHITE);
		lblObjeto.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblObjeto.setBounds(250, 211, 106, 14);
		add(lblObjeto);
		
		objetoTextField = new JTextField();
		objetoTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarMarca();
			}
		});
		objetoTextField.setToolTipText("a");
		objetoTextField.setText("EJ: Cinturon");
		objetoTextField.setOpaque(false);
		objetoTextField.setForeground(new Color(170, 170, 170));
		objetoTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		objetoTextField.setCaretColor(Color.WHITE);
		objetoTextField.setBorder(null);
		objetoTextField.setBackground(new Color(51, 51, 51));
		objetoTextField.setBounds(250, 222, 214, 21);
		eventoCambiarJTextField(objetoTextField, objetoTextField.getText(), 20);
		add(objetoTextField);
		
		lineaObjeto = new JPanel();
		lineaObjeto.setPreferredSize(new Dimension(0, 3));
		lineaObjeto.setBackground(Color.WHITE);
		lineaObjeto.setBounds(248, 248, 214, 3);
		add(lineaObjeto);
		GroupLayout gl_lineaObjeto = new GroupLayout(lineaObjeto);
		gl_lineaObjeto.setHorizontalGroup(
			gl_lineaObjeto.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaObjeto.setVerticalGroup(
			gl_lineaObjeto.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaObjeto.setLayout(gl_lineaObjeto);
		
		JButton btnAgregarMarca = new JButton("AGREGAR MARCA");
		btnAgregarMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isTodoCorrecto()) {
					agregarDatos();
					btnRefrezcar.doClick();
					paneles[1].setVisible(true);
					paneles[0].setBounds(929, 39, 732, 558);
				}
			}
		});
		btnAgregarMarca.setBorder(null);
		btnAgregarMarca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarMarca.setBackground(Color.WHITE);
		btnAgregarMarca.setFont(new Font("Roboto Light", Font.PLAIN, 25));
		btnAgregarMarca.setBounds(199, 455, 302, 64);
		add(btnAgregarMarca);
		
		lblAlertaMarca = new JLabel("");
		lblAlertaMarca.setVisible(false);
		lblAlertaMarca.setToolTipText("Hay un error de formato");
		lblAlertaMarca.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaMarca.setBounds(215, 224, 30, 27);
		add(lblAlertaMarca);
		
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
			consulta.addMarca(objetoTextField.getText());
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
		if(objetoTextField.getText().equals("")) {
			lblAlertaMarca.setVisible(true);
			setErroneo(lineaObjeto, lblAlertaMarca);
			return false;
		}
		setAcertado(lineaObjeto, lblAlertaMarca);
		lblAlertaMarca.setVisible(false);
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
