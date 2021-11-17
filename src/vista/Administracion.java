package vista;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import a.Modelo.Consulta;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class Administracion extends JFrame {

	//public JFrame frame;
	public JLayeredPane layeredPane_1 = new JLayeredPane();
	Consulta consulta = new Consulta();
	public JTable tableUsuarios;
	public JTable tableArticulos;
	public DefaultTableModel model2;
	public DefaultTableModel model;
	public ArrayList<ArrayList<String>> usuarios; 
	public ArrayList<ArrayList<String>> articulos; 
	public JButton btnActualizarUsuarios;
	public JPanel panelArticulos;
	private JTextField buscadorUsuariosTextField;
	private JTextField textField;
	
	private int xMouse;
	private int yMouse;
	private JPanel botonX;
	private JPanel header;

	public Administracion() {
		setUndecorated(true);
		initialize();
	}

	private void initialize() {
		//new JFrame();
		getContentPane().setBackground(new Color(51, 51, 51));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(34, 34, 34));
		panel.setBounds(0, 0, 197, 598);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		header = new JPanel();
		header.setLayout(null);
		this.eventoHeader();
		header.setBackground(new Color(51, 51, 51));
		header.setBounds(0, 0, 929, 39);
		
		getContentPane().add(header);
		
		botonX = new JPanel();
		botonX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonX.setLayout(null);
		this.eventoBotonX();
		botonX.setBackground(new Color(51, 51, 51));
		botonX.setBounds(902, 0, 27, 27);
		header.add(botonX);
		
		JLabel lblX = new JLabel("X");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Roboto", Font.BOLD, 15));
		lblX.setBounds(0, 0, 27, 27);
		botonX.add(lblX);
		
		layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(196, 39, 731, 559);
		getContentPane().add(layeredPane_1);
		layeredPane_1.setLayout(new CardLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		layeredPane_1.add(panel_1, "name_54251509904100");
		panel_1.setLayout(null);
		
		JPanel panelUsuarios = new JPanel();
		panelUsuarios.setBackground(new Color(51, 51, 51));
		layeredPane_1.add(panelUsuarios, "name_54331093143100");
		panelUsuarios.setLayout(null);
		
		JButton btnModificarUsuarios = new JButton("");
		this.addEventoBotonEnteredAndExited(btnModificarUsuarios);
		btnModificarUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificarUsuarios.setBounds(new Rectangle(0, 0, 45, 45));
		btnModificarUsuarios.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/Edit-icon-white.png")));
		btnModificarUsuarios.setBorder(null);
		btnModificarUsuarios.setBackground(new Color(51,51,51));
		btnModificarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = tableUsuarios.getSelectedRow();
				if(row<0) {
					mostrarAlertaFilaNoSeleccionada();
				} else {
					abrirVentanaAgregarUsuario(row);
				}
			}
		});
		btnModificarUsuarios.setBounds(526, 67, 45, 45);
		panelUsuarios.add(btnModificarUsuarios);
		
		JButton btnAgregarUsuarios = new JButton("");
		btnAgregarUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarUsuarios.setBounds(new Rectangle(0, 0, 45, 45));
		btnAgregarUsuarios.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/Add-icon-blanco.png")));
		btnAgregarUsuarios.setBackground(new Color(51, 51, 51));
		btnAgregarUsuarios.setBorder(null);
		this.addEventoBotonEnteredAndExited(btnAgregarUsuarios);
		btnAgregarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarUsuario agregarUsuario = new AgregarUsuario(btnActualizarUsuarios);
			}
		});
		btnAgregarUsuarios.setBounds(576, 67,  45, 45);
		panelUsuarios.add(btnAgregarUsuarios);
		
		JButton btnEliminarUsuarios = new JButton("");
		btnEliminarUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminarUsuarios.setBounds(new Rectangle(0, 0, 45, 45));
		btnEliminarUsuarios.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/Trash-icon-white.png")));
		btnEliminarUsuarios.setBackground(new Color(51, 51, 51));
		btnEliminarUsuarios.setBorder(null);
		this.addEventoBotonEnteredAndExited(btnEliminarUsuarios);
		btnEliminarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarUsuario();
			}
		});
		btnEliminarUsuarios.setBounds(626, 67, 45, 45);
		panelUsuarios.add(btnEliminarUsuarios);
		
		tableUsuarios = new JTable();
		tableUsuarios.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nombre", "Apellidos", "Rut", "Telefonos", "Email"
				}
		));
		model = (DefaultTableModel)tableUsuarios.getModel();
		tableUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableUsuarios.setPreferredScrollableViewportSize(tableUsuarios.getPreferredSize());
		tableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(150);
		tableUsuarios.getColumnModel().getColumn(1).setPreferredWidth(150);
		tableUsuarios.getColumnModel().getColumn(2).setPreferredWidth(150);
		tableUsuarios.getColumnModel().getColumn(3).setPreferredWidth(150);
		tableUsuarios.getColumnModel().getColumn(4).setPreferredWidth(150);
		tableUsuarios.getTableHeader().setOpaque(false);
		tableUsuarios.getTableHeader().setForeground(new Color(255, 255, 255));
		JScrollPane scrollPaneUsuarios = new JScrollPane(tableUsuarios);
		scrollPaneUsuarios.getViewport().setOpaque(false);
		scrollPaneUsuarios.setOpaque(false);
		//table.setBackground(SystemColor.menu);
		//scrollPane.getViewport().setBackground(SystemColor.menu);
		//scrollPane.setBackground(SystemColor.menu);
		//scrollPane.getViewport().setBackground(SystemColor.menu);
		//scrollPane.getViewport().setBackground(new Color(51,51,51));
		scrollPaneUsuarios.setBounds(10, 114, 711, 434);
		tableUsuarios.setBounds(0, 0, scrollPaneUsuarios.getWidth(), scrollPaneUsuarios.getHeight());
		
		tableUsuarios.getTableHeader().setBackground(new Color(51,51,51));
		
		panelUsuarios.add(scrollPaneUsuarios);
		
		JButton btnUsuarios = new JButton("USUARIOS");
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/user-icon-white.png")));
		btnUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(panelUsuarios);
				//consulta.getUsuarios(orden)
			}
		});
		btnUsuarios.setFocusPainted(false);
		this.addEventoBotonEnteredAndExitedMenu(btnUsuarios);
		btnUsuarios.setForeground(Color.WHITE);
		btnUsuarios.setBackground(new Color(34,34,34));
		btnUsuarios.setBorder(null);
		btnUsuarios.setBounds(0, 195, 197, 43);
		panel.add(btnUsuarios);
		
		JButton btnArticulos = new JButton("ART\u00CDCULOS");
		btnArticulos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnArticulos.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/Box-White.png")));
		btnArticulos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnArticulos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(panelArticulos);
			}
		});
		btnArticulos.setFocusPainted(false);
		this.addEventoBotonEnteredAndExitedMenu(btnArticulos);
		btnArticulos.setForeground(Color.WHITE);
		btnArticulos.setBackground(new Color(34,34,34));
		btnArticulos.setBorder(null);
		btnArticulos.setBounds(0, 249, 197, 43);
		panel.add(btnArticulos);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(panelUsuarios);
			}
		});
		btnNewButton_2.setFocusPainted(false);
		this.addEventoBotonEnteredAndExitedMenu(btnNewButton_2);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(34,34,34));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBounds(0, 303, 197, 43);
		panel.add(btnNewButton_2);
		
		ImageIcon iloveny_icon = new ImageIcon(Administracion.class.getResource("/imagenes/iloveny-icon.png"));
		JLabel lblIcono = new JLabel("");
		lblIcono.setBounds(26, 11, 140, 140);
		lblIcono.setIcon(new ImageIcon(iloveny_icon.getImage().getScaledInstance(lblIcono.getWidth(), lblIcono.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(lblIcono);
		
		setBounds(100, 100, 929, 598);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableUsuarios.getModel());
		tableUsuarios.setRowSorter(sorter);
		
		btnActualizarUsuarios = new JButton("");
		btnActualizarUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnActualizarUsuarios.setBounds(new Rectangle(0, 0, 45, 45));
		btnActualizarUsuarios.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/Reload-white.png")));
		btnActualizarUsuarios.setBackground(new Color(51, 51, 51));
		btnActualizarUsuarios.setBorder(null);
		this.addEventoBotonEnteredAndExited(btnActualizarUsuarios);
		btnActualizarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refresh_usuarios();
			}
		});
		btnActualizarUsuarios.setBounds(676, 67, 45, 45);
		panelUsuarios.add(btnActualizarUsuarios);
		
		JLabel lblTituloUsuarios = new JLabel("Usuarios");
		lblTituloUsuarios.setFont(new Font("Roboto Medium", Font.PLAIN, 41));
		lblTituloUsuarios.setForeground(Color.WHITE);
		lblTituloUsuarios.setBounds(10, 0, 194, 55);
		panelUsuarios.add(lblTituloUsuarios);
		
		JComboBox comboBoxUsuarios = new JComboBox(new String[] {"Seleccione...","Nombre", "Apellidos", "Rut", "Telefonos", "Email"});
		comboBoxUsuarios.setFont(new Font("Roboto Light", Font.PLAIN, 15));
		comboBoxUsuarios.setName("");
		comboBoxUsuarios.setForeground(Color.BLACK);
		comboBoxUsuarios.setBorder(null);
		comboBoxUsuarios.setBounds(315, 67, 115, 41);
		panelUsuarios.add(comboBoxUsuarios);
		
		buscadorUsuariosTextField = new JTextField();
		buscadorUsuariosTextField.setCaretColor(Color.WHITE);
		buscadorUsuariosTextField.setFont(new Font("Roboto Light", Font.PLAIN, 25));
		buscadorUsuariosTextField.setForeground(Color.WHITE);
		buscadorUsuariosTextField.setBackground(new Color(51,51,51));
		buscadorUsuariosTextField.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		buscadorUsuariosTextField.setBounds(65, 67, 251, 41);
		panelUsuarios.add(buscadorUsuariosTextField);
		buscadorUsuariosTextField.setColumns(10);
		
		JLabel lblIconoLupa = new JLabel("");
		lblIconoLupa.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoLupa.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/lupa-white.png")));
		lblIconoLupa.setBounds(10, 67, 45, 45);
		panelUsuarios.add(lblIconoLupa);
		
		JLabel lblComboBox = new JLabel("Buscar por:");
		lblComboBox.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblComboBox.setForeground(Color.WHITE);
		lblComboBox.setBounds(316, 52, 69, 14);
		panelUsuarios.add(lblComboBox);
		
		panelArticulos = new JPanel();
		panelArticulos.setLayout(null);
		panelArticulos.setBackground(new Color(51, 51, 51));
		layeredPane_1.add(panelArticulos, "name_47993813931900");
		
		JButton btnModificarArticulos = new JButton("");
		btnModificarArticulos.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/Edit-icon-white.png")));
		btnModificarArticulos.setBorder(null);
		btnModificarArticulos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificarArticulos.setBackground(new Color(51,51,51));
		this.addEventoBotonEnteredAndExited(btnModificarArticulos);
		btnModificarArticulos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = tableArticulos.getSelectedRow();
				String idArticulo = tableUsuarios.getValueAt(row, 0).toString();
				String IDMarca = tableUsuarios.getValueAt(row, 1).toString();
				String IDTipo = tableUsuarios.getValueAt(row, 2).toString();
				String stock = tableUsuarios.getValueAt(row, 3).toString();
				String precioUnitario = tableUsuarios.getValueAt(row, 4).toString();
				String descripcion = tableUsuarios.getValueAt(row, 5).toString();
				String imagen = tableUsuarios.getValueAt(row, 6).toString();
				AgregarArticulo agregarArticulo = new AgregarArticulo(btnActualizarUsuarios);
				agregarArticulo.setElements(idArticulo, IDMarca, IDTipo, stock, precioUnitario, descripcion, imagen);
			}
		});
		btnModificarArticulos.setBounds(526, 67, 45, 45);
		panelArticulos.add(btnModificarArticulos);
		
		JButton btnAgregarArticulos = new JButton("");
		btnAgregarArticulos.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/Add-icon-blanco.png")));
		btnAgregarArticulos.setBorder(null);
		btnAgregarArticulos.setBackground(new Color(51,51,51));
		this.addEventoBotonEnteredAndExited(btnAgregarArticulos);
		btnAgregarArticulos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarArticulos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO
			}
		});
		btnAgregarArticulos.setBounds(576, 67,  45, 45);
		panelArticulos.add(btnAgregarArticulos);
		
		JButton btnEliminarArticulos = new JButton("");
		btnEliminarArticulos.setBackground(new Color(51,51,51));
		this.addEventoBotonEnteredAndExited(btnEliminarArticulos);
		btnEliminarArticulos.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/Trash-icon-white.png")));
		btnEliminarArticulos.setBorder(null);
		btnEliminarArticulos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminarArticulos.setBounds(626, 67, 45, 45);
		panelArticulos.add(btnEliminarArticulos);
		
		tableArticulos = new JTable();
		tableArticulos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"idArticulo", "idMarca", "idTipo", "stock", "precioUnitario", "descripcion", "rutaImagen"
				}
		));
		model2 = (DefaultTableModel)tableArticulos.getModel();
		tableArticulos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableArticulos.setPreferredScrollableViewportSize(tableArticulos.getPreferredSize());
		tableArticulos.getColumnModel().getColumn(0).setPreferredWidth(150);
		tableArticulos.getColumnModel().getColumn(1).setPreferredWidth(150);
		tableArticulos.getColumnModel().getColumn(2).setPreferredWidth(150);
		tableArticulos.getColumnModel().getColumn(3).setPreferredWidth(150);
		tableArticulos.getColumnModel().getColumn(4).setPreferredWidth(150);
		tableArticulos.getColumnModel().getColumn(5).setPreferredWidth(150);
		tableArticulos.getColumnModel().getColumn(6).setPreferredWidth(150);
		tableArticulos.getTableHeader().setOpaque(false);
		tableArticulos.getTableHeader().setForeground(new Color(255, 255, 255));
		JScrollPane scrollPaneArticulos = new JScrollPane(tableArticulos);
		scrollPaneArticulos.getViewport().setOpaque(false);
		scrollPaneArticulos.setOpaque(false);
		//table.setBackground(SystemColor.menu);
		//scrollPane.getViewport().setBackground(SystemColor.menu);
		//scrollPane.setBackground(SystemColor.menu);
		//scrollPane.getViewport().setBackground(SystemColor.menu);
		//scrollPane.getViewport().setBackground(new Color(51,51,51));
		scrollPaneArticulos.setBounds(10, 114, 711, 434);
		tableArticulos.setBounds(0, 0, scrollPaneArticulos.getWidth(), scrollPaneArticulos.getHeight());
		
		tableArticulos.getTableHeader().setBackground(new Color(51,51,51));
		
		panelArticulos.add(scrollPaneArticulos);
		
		TableRowSorter<TableModel> sorter2 = new TableRowSorter<TableModel>(tableArticulos.getModel());
		tableArticulos.setRowSorter(sorter2);
		
		JButton btnActualizarArticulos = new JButton("");
		btnActualizarArticulos.setBackground(new Color(51,51,51));
		this.addEventoBotonEnteredAndExited(btnActualizarArticulos);
		btnActualizarArticulos.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/Reload-white.png")));
		btnActualizarArticulos.setBorder(null);
		btnActualizarArticulos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnActualizarArticulos.setBounds(676, 67, 45, 45);
		panelArticulos.add(btnActualizarArticulos);
		
		JLabel lblTituloArticulos = new JLabel("Articulos");
		lblTituloArticulos.setForeground(Color.WHITE);
		lblTituloArticulos.setFont(new Font("Roboto Medium", Font.PLAIN, 41));
		lblTituloArticulos.setBounds(10, 0, 194, 55);
		panelArticulos.add(lblTituloArticulos);
		
		JLabel lblIconoLupa_1 = new JLabel("");
		lblIconoLupa_1.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/lupa-white.png")));
		lblIconoLupa_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoLupa_1.setBounds(10, 67, 45, 45);
		panelArticulos.add(lblIconoLupa_1);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Roboto Light", Font.PLAIN, 25));
		textField.setColumns(10);
		textField.setCaretColor(Color.WHITE);
		textField.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		textField.setBackground(new Color(51, 51, 51));
		textField.setBounds(65, 67, 251, 41);
		panelArticulos.add(textField);
		
		JComboBox comboBoxArticulos = new JComboBox(new String[] {"Seleccione...","idArticulo", "idMarca", "idTipo", "stock", "precioUnitario", "descripcion", "rutaImagen"});
		comboBoxArticulos.setFont(new Font("Roboto Light", Font.PLAIN, 15));
		comboBoxArticulos.setForeground(Color.BLACK);
		comboBoxArticulos.setBorder(null);
		comboBoxArticulos.setBounds(315, 67, 115, 41);
		panelArticulos.add(comboBoxArticulos);
		
		JLabel lblComboBox_1 = new JLabel("Buscar por:");
		lblComboBox_1.setForeground(Color.WHITE);
		lblComboBox_1.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblComboBox_1.setBounds(316, 52, 69, 14);
		panelArticulos.add(lblComboBox_1);
		
		List<RowSorter.SortKey> sortKeys = new ArrayList<>(100);
		sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
		
		addUsuarios();
		addArticulos();
	}
	
	private void eliminarUsuario() {
		int row = tableUsuarios.getSelectedRow();
		String value = tableUsuarios.getValueAt(row, 2).toString(); // RUT
		System.out.println(value);
		int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro que quiere eliminar " + value + "?");
		if (JOptionPane.YES_OPTION == confirm) {
			consulta.delUsuario(value);
			refresh_usuarios();
		}
	}

	public void refresh_usuarios() {
		int rowCount = model.getRowCount();
		System.out.println(rowCount);
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		addUsuarios();
	}
	public void refresh_articulos() {
		int rowCount = model2.getRowCount();
		System.out.println(rowCount);
		for (int i = rowCount - 1; i >= 0; i--) {
			model2.removeRow(i);
		}
		addArticulos();
	}
	
	public void addUsuarios() {
		usuarios = new ArrayList<ArrayList<String>>();
		usuarios = consulta.getUsuarios("nombreusuario");
		ArrayList<String> elementos;
		for (int i = 0; i < usuarios.size(); i++) {
			elementos = new ArrayList<String>();
			for (int j = 0; j < usuarios.get(i).size(); j++) {
				elementos.add(usuarios.get(i).get(j));
			}
			model.addRow(new Object[] {elementos.get(0), elementos.get(1), elementos.get(2), elementos.get(3), elementos.get(4)});
		}
	}
	
	public void addArticulos() {
		// "idArticulo", "idMarca", "idTipo", "stock", "precioUnitario", "descripcion", "rutaImagen"
		articulos = new ArrayList<ArrayList<String>>();
		articulos = consulta.getListaArticulo("idarticulo");
		ArrayList<String> elementos;
		for (int i = 0; i < articulos.size(); i++) {
			elementos = new ArrayList<String>();
			for (int j = 0; j < articulos.get(i).size(); j++) {
				elementos.add(articulos.get(i).get(j));
			}
			model2.addRow(new Object[] {elementos.get(0), elementos.get(1), elementos.get(2), elementos.get(3), elementos.get(4), elementos.get(5), elementos.get(6)});
		}
	}
	
	public void switchPanels(JPanel panel) {
		layeredPane_1.removeAll();
		layeredPane_1.add(panel);
		layeredPane_1.repaint();
		layeredPane_1.revalidate();
	}
	
	public void addEventoBotonEnteredAndExitedMenu(JButton boton) {
		boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				boton.setBackground(new Color(221, 30, 38));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				boton.setBackground(new Color(34, 34, 34));
			}
		});
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
	
	private void mostrarAlertaFilaNoSeleccionada() {
		// TODO Auto-generated method stub
		
	}
	
	private void abrirVentanaAgregarUsuario(int row) {
		String nombre = tableUsuarios.getValueAt(row, 0).toString();
		String apellidos = tableUsuarios.getValueAt(row, 1).toString();
		String rut = tableUsuarios.getValueAt(row, 2).toString();
		String telefonos = tableUsuarios.getValueAt(row, 3).toString();
		String email = tableUsuarios.getValueAt(row, 4).toString();
		AgregarUsuario agregarUsuario = new AgregarUsuario(btnActualizarUsuarios);
		agregarUsuario.setElements(nombre, apellidos, rut, telefonos, email);
	}
	
	private void eventoHeader() {
		header.addMouseMotionListener(new MouseMotionAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent e) {
        		int x = e.getXOnScreen();
        		int y = e.getYOnScreen();
        		setLocation(x - xMouse, y- yMouse);
        	}
        });
      header.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		xMouse= e.getX();
        		yMouse= e.getY();
        	}
        });
	}

	private void eventoBotonX() {
		botonX.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		botonX.setBackground(new Color(255,0,0));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		botonX.setBackground(new Color(51,51,51));
        	}
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		System.exit(0);
        	}
        	@Override
        	public void mousePressed(MouseEvent e) {
        		botonX.setBackground(new Color(139,0,0));
        	}
        });
	}
}
