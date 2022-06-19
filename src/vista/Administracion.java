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
import java.util.Vector;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import mongodb.Consulta;
import tablas.Articulos;
import tablas.RegistrosCompras;
import tablas.RegistrosVentas;
import tablas.Usuarios;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ScrollPaneConstants;

public class Administracion extends JFrame {

	//public JFrame frame;
	public JLayeredPane layeredPane_1 = new JLayeredPane();
	public DefaultTableModel modeloTabla;
	public ArrayList<ArrayList<String>> elementosTabla;
	public ArrayList<Usuarios> elementosTablaUsuarios;
	public ArrayList<Articulos> elementosTablaArticulos;
	public ArrayList<RegistrosCompras> elementosTablaRegistrosCompras;
	public ArrayList<RegistrosVentas> elementosTablaRegistrosVentas; 
	public String nombreAdmin;
	
	private int xMouse;
	private int yMouse;
	public int modo = 1;
	public int columnaPK = 2;
	private JPanel botonX;
	private JPanel header;
	private JPanel IconoIlovenyPanel;
	private JLabel lblIcono;
	private JPanel MenuConBotonesPanel;
	private JButton btnUsuarios;
	private JButton btnArticulos;
	private JButton btnNewButton;
	private JLabel lblX;
	private JLabel lblTitulo;
	private JTextField buscadorTextField;
	private JScrollPane tablaScrollPane;
	private JTable tabla;
	private JButton btnModificar;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private JLayeredPane funcionesLayeredPane;
	public AgregarUsuarioPanel agregarUsuarioPanel;
	public AgregarArticuloPanel agregarArticuloPanel;
	public AgregarRegistroVentaPanel agregarRegistroVentaPanel;
	public AgregarRegistroCompraPanel agregarRegistroCompraPanel;
	private JPanel panelPrincipal;
	private JButton btnRegistroCompra;
	private TableRowSorter<TableModel> sorter;

	public Administracion(String nombreAdmin) {
		this.nombreAdmin = nombreAdmin;
		setIconImage(Toolkit.getDefaultToolkit().getImage(Administracion.class.getResource("/imagenes/iloveny-icon.png")));
		setUndecorated(true);
		initialize();
	}

	private void initialize() {
		getContentPane().setBackground(new Color(51, 51, 51));
		getContentPane().setLayout(null);
		setBounds(100, 100, 929, 598);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		this.construirPanelIloveny();
		this.construirPanelMenu();
		this.construirHeader();
		this.iniciarPanelPrincipal();		
	}
	
	private void iniciarPanelPrincipal() {
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(197, 39, 732, 558);
		panelPrincipal.setBackground(new Color(51,51,51));
		getContentPane().add(panelPrincipal);
		
		btnModificar = new JButton("");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tabla.getSelectedRow() > -1) {
					switch(modo) {
					
					case 1:
						String _id1 = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
						agregarUsuarioPanel = new AgregarUsuarioPanel(2, new JComponent[] {funcionesLayeredPane, panelPrincipal}, btnActualizar, _id1);
						cambiarPanel(agregarUsuarioPanel);
						break;
					case 2:
						String _id2 = tabla.getValueAt(tabla.getSelectedRow(), 5).toString();
						agregarArticuloPanel = new AgregarArticuloPanel(2, new JComponent[] {funcionesLayeredPane, panelPrincipal}, btnActualizar, _id2);
						cambiarPanel(agregarArticuloPanel);
						break;
					case 3:
						String _id3 = tabla.getValueAt(tabla.getSelectedRow(), 3).toString();
						agregarRegistroVentaPanel = new AgregarRegistroVentaPanel(2, new JComponent[] {funcionesLayeredPane, panelPrincipal}, btnActualizar, _id3);
						cambiarPanel(agregarRegistroVentaPanel);
						break;
					case 4:
						String _id4 = tabla.getValueAt(tabla.getSelectedRow(), 6).toString();
						agregarRegistroCompraPanel = new AgregarRegistroCompraPanel(2, new JComponent[] {funcionesLayeredPane, panelPrincipal}, btnActualizar, nombreAdmin, _id4);
						cambiarPanel(agregarRegistroCompraPanel);
						break;
					default:
					
					}
					moverLayeredPanel();
					panelPrincipal.setVisible(false);
				} else {
					Icon icon = new ImageIcon(Login.class.getResource("/imagenes/Exclamation-mark-icon.png"));
					JOptionPane.showMessageDialog(null, "No tiene una fila seleccioanda","Mensaje",JOptionPane.PLAIN_MESSAGE,icon);
				}
			
			}
		});
		btnModificar.setToolTipText("Modificar");
		this.addEventoBotonEnteredAndExited(btnModificar);
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/Edit-icon-white.png")));
		btnModificar.setBorder(null);
		btnModificar.setBackground(new Color(51,51,51));
		panelPrincipal.setLayout(null);
		btnModificar.setBounds(526, 67, 45, 45);
		panelPrincipal.add(btnModificar);
		
		btnAgregar = new JButton("");
		btnAgregar.setToolTipText("Agregar");
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/Add-icon-blanco.png")));
		btnAgregar.setBackground(new Color(51, 51, 51));
		btnAgregar.setBorder(null);
		this.addEventoBotonEnteredAndExited(btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(modo) {
				
				case 1:
					agregarUsuarioPanel = new AgregarUsuarioPanel(1, new JComponent[] {funcionesLayeredPane, panelPrincipal}, btnActualizar, null);
					cambiarPanel(agregarUsuarioPanel);
					break;
				case 2:
					agregarArticuloPanel = new AgregarArticuloPanel(1, new JComponent[] {funcionesLayeredPane, panelPrincipal}, btnActualizar, null);
					cambiarPanel(agregarArticuloPanel);
					break;
				case 3:
					agregarRegistroVentaPanel = new AgregarRegistroVentaPanel(1, new JComponent[] {funcionesLayeredPane, panelPrincipal}, btnActualizar, null);
					cambiarPanel(agregarRegistroVentaPanel);
					break;
				case 4:
					agregarRegistroCompraPanel = new AgregarRegistroCompraPanel(1, new JComponent[] {funcionesLayeredPane, panelPrincipal}, btnActualizar, nombreAdmin, null);
					cambiarPanel(agregarRegistroCompraPanel);
					break;
				default:
				
				}
				moverLayeredPanel();
				panelPrincipal.setVisible(false);
			}

		});
		btnAgregar.setBounds(576, 67,  45, 45);
		panelPrincipal.add(btnAgregar);
		
		btnEliminar = new JButton("");
		btnEliminar.setToolTipText("Eliminar");
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setBounds(new Rectangle(0, 0, 45, 45));
		btnEliminar.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/Trash-icon-white.png")));
		btnEliminar.setBackground(new Color(51, 51, 51));
		btnEliminar.setBorder(null);
		this.addEventoBotonEnteredAndExited(btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarFilaTabla();
			}
			
		});
		btnEliminar.setBounds(626, 67, 45, 45);
		panelPrincipal.add(btnEliminar);
		
		tabla = new JTable();
		tabla.setShowGrid(false);
		tabla.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Rut", "Nombre", "Apellidos", "Telefono", "Email"
				}
		));
		tabla.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				JTable table = (JTable)mouseEvent.getSource();
				Point point = mouseEvent.getPoint();
				int row = table.rowAtPoint(point);
				if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
					switch (modo) {
						case 1:
							String value1 = tabla.getValueAt(row, 0).toString();
							new DetallesUsuario(value1);
							break;
						case 2:
							String value2 = tabla.getValueAt(row, 5).toString();
							new DetallesArticulo(value2);
							break;
						case 3:
							String value3 = tabla.getValueAt(row, 3).toString();
							new DetallesRegistroVenta(value3);
							break;
						case 4:
							String value4 = tabla.getValueAt(row, 6).toString();
							new DetallesRegistroCompra(value4);
							break;
					}
				}
			}
		});
		
		iniciarTabla();
		rellenarTabla();
		
		btnActualizar = new JButton("");
		btnActualizar.setToolTipText("Refrezcar");
		btnActualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnActualizar.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/Reload-white.png")));
		btnActualizar.setBackground(new Color(51, 51, 51));
		btnActualizar.setBorder(null);
		this.addEventoBotonEnteredAndExited(btnActualizar);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarDatosTabla();
				repintarTabla();
				rellenarTabla();
			}
		});
		btnActualizar.setBounds(676, 67, 45, 45);
		panelPrincipal.add(btnActualizar);
		
		lblTitulo = new JLabel("Usuarios");
		lblTitulo.setFont(new Font("Roboto Medium", Font.PLAIN, 41));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBounds(10, 0, 711, 55);
		panelPrincipal.add(lblTitulo);
		
		buscadorTextField = new JTextField();
		buscadorTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				realizarBusqueda();
			}
		});
		buscadorTextField.setCaretColor(Color.WHITE);
		buscadorTextField.setFont(new Font("Roboto Light", Font.PLAIN, 25));
		buscadorTextField.setForeground(Color.WHITE);
		buscadorTextField.setBackground(new Color(51,51,51));
		buscadorTextField.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		buscadorTextField.setBounds(65, 67, 251, 41);
		panelPrincipal.add(buscadorTextField);
		buscadorTextField.setColumns(10);
		
		JLabel lblIconoLupa = new JLabel("");
		lblIconoLupa.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoLupa.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/lupa-white.png")));
		lblIconoLupa.setBounds(10, 67, 45, 45);
		panelPrincipal.add(lblIconoLupa);
		
		panelPrincipal.add(tablaScrollPane);
	}

	private void eliminarFilaTabla() {
		Consulta consulta = new Consulta();
		int row = tabla.getSelectedRow();
		if(row>-1) {
			int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el elemento seleccionado?");
			if (JOptionPane.YES_OPTION == confirm) {
				switch(modo) {
					case 1:
						consulta.delUsuario(tabla.getValueAt(row, 0).toString());
						break;
					case 2:
						consulta.delArticulo(tabla.getValueAt(row, 5).toString());
						break;
					case 3:
						consulta.delRegistroVenta(tabla.getValueAt(row, 3).toString());
						break;
					case 4:
						consulta.delRegistroCompra(tabla.getValueAt(row, 6).toString());
						break;
				}
				eliminarDatosTabla();
				repintarTabla();
				rellenarTabla();
			}
		} else {
			Icon icon = new ImageIcon(Login.class.getResource("/imagenes/Exclamation-mark-icon.png"));
			JOptionPane.showMessageDialog(null, "No tiene una fila seleccioanda","Mensaje",JOptionPane.PLAIN_MESSAGE,icon);
		}
	}

	private void realizarBusqueda() {
		String busqueda = buscadorTextField.getText();
		switch(modo) {
		 case 1:
			boolean byColumn1 = false;
			int c_index1 = 0;
			if (busqueda.contains("Rut: ")) {
				busqueda = busqueda.replace("Rut: ", "");
				byColumn1 = true;
				c_index1 = 0;
			} else if (busqueda.contains("Nombre: ")) {
				busqueda = busqueda.replace("Nombre: ", "");
				byColumn1 = true;
				c_index1 = 1;
			} else if (busqueda.contains("Apellidos: ")) {
				busqueda = busqueda.replace("Apellidos: ", "");
				byColumn1 = true;
				c_index1 = 2;
			} else if (busqueda.contains("Telefono: ")) {
				busqueda = busqueda.replace("Telefono: ", "");
				byColumn1 = true;
				c_index1 = 3;
			} else if (busqueda.contains("Email: ")) {
				busqueda = busqueda.replace("Email: ", "");
				byColumn1 = true;
				c_index1 = 4;
			}
			if (busqueda.trim().length() == 0) {
				sorter.setRowFilter(null);
			} else {
				if (busqueda.toCharArray()[0] == '+') {
				StringBuilder strb = new StringBuilder(busqueda);
				strb.deleteCharAt(0);
				busqueda = strb.toString();
			}
				if (!byColumn1)
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + busqueda));
				else
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + busqueda, c_index1));
			}
			break;
		case 2:
			boolean byColumn2 = false;
			int c_index2 = 0;
			if (busqueda.contains("Tipo: ")) {
				busqueda = busqueda.replace("Tipo: ", "");
				byColumn2 = true;
				c_index2 = 0;
			} else if (busqueda.contains("Marca: ")) {
				busqueda = busqueda.replace("Marca: ", "");
				byColumn2 = true;
				c_index2 = 1;
			} else if (busqueda.contains("Descripcion: ")) {
				busqueda = busqueda.replace("Descripcion: ", "");
				byColumn2 = true;
				c_index2 = 2;
			} else if (busqueda.contains("Stock: ")) {
				busqueda = busqueda.replace("Stock: ", "");
				byColumn2 = true;
				c_index2 = 3;
			} else if (busqueda.contains("Precio Unitario: ")) {
				busqueda = busqueda.replace("Precio Unitario: ", "");
				byColumn2 = true;
				c_index2 = 4;
			}
 			if (busqueda.trim().length() == 0) {
 				sorter.setRowFilter(null);
 			} else {
 				if (busqueda.toCharArray()[0] == '+') {
 					StringBuilder strb = new StringBuilder(busqueda);
 					strb.deleteCharAt(0);
 					busqueda = strb.toString();
 				}
 				if (!byColumn2)
 					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + busqueda, 0, 1, 2, 3, 4));
 				else {
 					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + busqueda, c_index2));
 				}
 			}
			break;
		case 3:
			boolean byColumn3 = false;
			int c_index3 = 0;
			if (busqueda.contains("Fecha: ")) {
				busqueda = busqueda.replace("Fecha: ", "");
				byColumn3 = true;
				c_index3 = 0;
			} else if (busqueda.contains("Cantidad Vendida: ")) {
				busqueda = busqueda.replace("Cantidad Vendida: ", "");
				byColumn3 = true;
				c_index3 = 1;
			} else if (busqueda.contains("Rut: ")) {
				busqueda = busqueda.replace("Rut: ", "");
				byColumn3 = true;
				c_index3 = 2;
			}
 			if (busqueda.trim().length() == 0) {
 				sorter.setRowFilter(null);
 			} else {
 				if (busqueda.toCharArray()[0] == '+') {
 					StringBuilder strb = new StringBuilder(busqueda);
 					strb.deleteCharAt(0);
 					busqueda = strb.toString();
 				}
 				if (!byColumn3)
 					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + busqueda, 0, 1, 2));
 				else
 					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + busqueda, c_index3));
 			}
			break;
		case 4:
			boolean byColumn4 = false;
			int c_index4 = 0;
			if (busqueda.contains("Usuario: ")) {
				busqueda = busqueda.replace("Usuario: ", "");
				byColumn4 = true;
				c_index4 = 0;
			} else if (busqueda.contains("Nombre Proveedor: ")) {
				busqueda = busqueda.replace("Nombre Proveedor: ", "");
				byColumn4 = true;
				c_index4 = 1;
			} else if (busqueda.contains("Unidades Adquiridas: ")) {
				busqueda = busqueda.replace("Unidades Adquiridas: ", "");
				byColumn4 = true;
				c_index4 = 2;
			} else if (busqueda.contains("Costo Unitario: ")) {
				busqueda = busqueda.replace("Costo Unitario: ", "");
				byColumn4 = true;
				c_index4 = 3;
			} else if (busqueda.contains("Fecha Pedida: ")) {
				busqueda = busqueda.replace("Fecha Pedida: ", "");
				byColumn4 = true;
				c_index4 = 4;
			} else if (busqueda.contains("Fecha Recibo: ")) {
				busqueda = busqueda.replace("Fecha Recibo: ", "");
				byColumn4 = true;
				c_index4 = 5;
			}
 			if (busqueda.trim().length() == 0) {
 				sorter.setRowFilter(null);
 			} else {
 				if (busqueda.toCharArray()[0] == '+') {
 					StringBuilder strb = new StringBuilder(busqueda);
 					strb.deleteCharAt(0);
 					busqueda = strb.toString();
 				}
 				if (!byColumn4)
 					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + busqueda, 0, 1, 2, 3, 4, 5));
 				else
 					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + busqueda, c_index4));
 			}
			break;
		}
	}

	private void repintarTabla() {
		modeloTabla = (DefaultTableModel)tabla.getModel();
		int espacioParaColumna = 0;
		if(150*tabla.getColumnCount() <= 711) {
			espacioParaColumna = 711/tabla.getColumnCount();
			if(espacioParaColumna*tabla.getColumnCount()<711) {
				espacioParaColumna+=(711-espacioParaColumna*tabla.getColumnCount());
			}
		} else {
			espacioParaColumna = 150;
		}
		for(int i = 0; i<tabla.getColumnCount(); i++) {
			tabla.getColumnModel().getColumn(i).setPreferredWidth(espacioParaColumna);
			tabla.setBounds(0, 0, tablaScrollPane.getWidth(), tablaScrollPane.getHeight());
			sorter = new TableRowSorter<TableModel>(tabla.getModel());
			tabla.setRowSorter(sorter);
			List<RowSorter.SortKey> sortKeys = new ArrayList<>(100);
			sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
			sorter.setSortKeys(sortKeys);
		}
	}
	
	private void iniciarTabla() {
		modeloTabla = (DefaultTableModel)tabla.getModel();
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabla.setPreferredScrollableViewportSize(tabla.getPreferredSize());
		for(int i = 0; i<tabla.getColumnCount(); i++) {
			tabla.getColumnModel().getColumn(i).setPreferredWidth(150);
		}
		tabla.getTableHeader().setOpaque(false);
		tabla.getTableHeader().setForeground(new Color(255, 255, 255));
		tablaScrollPane = new JScrollPane(tabla);
		tablaScrollPane.getViewport().setOpaque(false);
		tablaScrollPane.setOpaque(false);
		tablaScrollPane.setBounds(10, 114, 711, 434);
		
		tabla.setBounds(0, 0, tablaScrollPane.getWidth(), tablaScrollPane.getHeight());
		tabla.getTableHeader().setBackground(new Color(51,51,51));
		
		sorter = new TableRowSorter<TableModel>(tabla.getModel());
		tabla.setRowSorter(sorter);
		
		List<RowSorter.SortKey> sortKeys = new ArrayList<>(100);
		sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
	}

	private void construirHeader() {
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
		
		lblX = new JLabel("X");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Roboto", Font.BOLD, 15));
		lblX.setBounds(0, 0, 27, 27);
		botonX.add(lblX);
	}

	public void construirPanelMenu() {
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(-1, 196, 202, 416);
		getContentPane().add(scrollPane);
		MenuConBotonesPanel = new JPanel();
		scrollPane.setViewportView(MenuConBotonesPanel);
		MenuConBotonesPanel.setBackground(new Color(34, 34, 34));
		MenuConBotonesPanel.setPreferredSize(new Dimension(170, 550));
		MenuConBotonesPanel.setLayout(null);
		
		btnUsuarios = new JButton("USUARIOS");
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/user-icon-white.png")));
		btnUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modo != 1) {
					modo = 1;
					columnaPK = 2;
					eliminarDatosTabla();
					lblTitulo.setText("Usuarios");
					buscadorTextField.setText("");
					DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>( new String[] {"Seleccione...","Rut", "Nombre", "Apellidos", "Telefono", "Email"});
					tabla.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
									"Rut", "Nombre", "Apellidos", "Telefono", "Email"
							}
					));
					repintarTabla();
					rellenarTabla();
				}
				if(!panelPrincipal.isVisible()) {
					reacomodarPaneles();
				}
			}	
		});
		btnUsuarios.setFocusPainted(false);
		this.addEventoBotonEnteredAndExitedMenu(btnUsuarios);
		btnUsuarios.setForeground(Color.WHITE);
		btnUsuarios.setBackground(new Color(34,34,34));
		btnUsuarios.setBorder(null);
		btnUsuarios.setBounds(0, 0, 197, 43);
		MenuConBotonesPanel.add(btnUsuarios);
		
		btnArticulos = new JButton("ARTICULOS");
		btnArticulos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnArticulos.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/Box-White.png")));
		btnArticulos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnArticulos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modo != 2) {
					modo = 2;
					columnaPK = 0;
					eliminarDatosTabla();
					lblTitulo.setText("Articulos");
					buscadorTextField.setText("");
					DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>( new String[] {"Seleccione...", "Tipo", "Marca",
							"Descripcion", "Stock", "Precio Unitario", "ID"});
					tabla.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"Tipo", "Marca", "Descripcion", "Stock", "Precio Unitario", "ID"
							}
					));
					repintarTabla();
					rellenarTabla();
				}
				if(!panelPrincipal.isVisible()) {
					reacomodarPaneles();
				}
			}
		});
		btnArticulos.setFocusPainted(false);
		this.addEventoBotonEnteredAndExitedMenu(btnArticulos);
		btnArticulos.setForeground(Color.WHITE);
		btnArticulos.setBackground(new Color(34,34,34));
		btnArticulos.setBorder(null);
		btnArticulos.setBounds(0, 54, 197, 43);
		MenuConBotonesPanel.add(btnArticulos);
		
		JButton btnRegistroVenta = new JButton("REGISTRO VENTA");
		btnRegistroVenta.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/monedas-icono-white.png")));
		btnRegistroVenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistroVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modo != 3) {
					modo = 3;
					columnaPK = 4;
					eliminarDatosTabla();
					lblTitulo.setText("Registro venta");
					buscadorTextField.setText("");
					DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>( new String[] {"Seleccione...", "Fecha", "Cantidad Vendida", "Rut", "ID"});
					tabla.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
									"Fecha", "Cantidad Vendida", "Rut", "ID"
							}
					));
					repintarTabla();
					rellenarTabla();
				}
				if(!panelPrincipal.isVisible()) {
					reacomodarPaneles();
				}
			}
		});
		btnRegistroVenta.setForeground(Color.WHITE);
		btnRegistroVenta.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnRegistroVenta.setFocusPainted(false);
		btnRegistroVenta.setBorder(null);
		btnRegistroVenta.setBackground(new Color(34, 34, 34));
		btnRegistroVenta.setBounds(0, 108, 197, 43);
		addEventoBotonEnteredAndExitedMenu(btnRegistroVenta);
		MenuConBotonesPanel.add(btnRegistroVenta);
		
		btnRegistroCompra = new JButton("REGISTRO COMPRA");
		btnRegistroCompra.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/carrito-white.png")));
		btnRegistroCompra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistroCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modo != 4) {
					modo = 4;
					columnaPK = 0;
					eliminarDatosTabla();
					lblTitulo.setText("Registro compra");
					buscadorTextField.setText("");
					DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>( new String[] {"Seleccione...", "Usuario", "Nombre Proveedor",
							"Unidades Adquiridas", "Costo Unitario", "Fecha Pedida", "Fecha Recibo", "ID"});
					tabla.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
									"Usuario", "Nombre Proveedor", "Unidades Adquiridas", "Costo Unitario", "Fecha Pedida", "Fecha Recibo", "ID"
							}
					));
					repintarTabla();
					rellenarTabla();
				}
				if(!panelPrincipal.isVisible()) {
					reacomodarPaneles();
				}
			}
		});
		btnRegistroCompra.setForeground(Color.WHITE);
		btnRegistroCompra.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnRegistroCompra.setFocusPainted(false);
		btnRegistroCompra.setBorder(null);
		btnRegistroCompra.setBackground(new Color(34, 34, 34));
		btnRegistroCompra.setBounds(0, 162, 197, 43);
		addEventoBotonEnteredAndExitedMenu(btnRegistroCompra);
		MenuConBotonesPanel.add(btnRegistroCompra);
	}
	
	private void reacomodarPaneles() {
		panelPrincipal.setVisible(true);
		funcionesLayeredPane.setBounds(929,39,732,558);
	}	
	
	public void eliminarDatosTabla() {
		int rowCount = modeloTabla.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			modeloTabla.removeRow(i);
		}
	}
	
	public void rellenarTabla() {
		Consulta consulta = new Consulta();
		elementosTabla = new ArrayList<ArrayList<String>>();
		switch(modo) {
		case 1:
			elementosTablaUsuarios = consulta.getUsuarios();
			Vector elementos1 = new Vector();
			for (int i = 0; i < elementosTablaUsuarios.size(); i++) {
				elementos1 = new Vector();
				elementos1.add(elementosTablaUsuarios.get(i).get_Rut());
				elementos1.add(elementosTablaUsuarios.get(i).get_Nombre());
				elementos1.add(elementosTablaUsuarios.get(i).get_Apellidos());
				elementos1.add(elementosTablaUsuarios.get(i).get_Telefono());
				elementos1.add(elementosTablaUsuarios.get(i).get_Email());
				modeloTabla.addRow(elementos1);
			}
			break;
		case 2:
			elementosTablaArticulos = consulta.getArticulos();
			Vector elementos2 = new Vector();
			for (int i = 0; i < elementosTablaArticulos.size(); i++) {
				elementos2 = new Vector();
				elementos2.add(elementosTablaArticulos.get(i).get_Tipo());
				elementos2.add(elementosTablaArticulos.get(i).get_Marca());
				elementos2.add(elementosTablaArticulos.get(i).get_Descripcion());
				elementos2.add(elementosTablaArticulos.get(i).get_Stock());
				elementos2.add(elementosTablaArticulos.get(i).get_PrecioUnitario());
				elementos2.add(elementosTablaArticulos.get(i).get_ID());
				modeloTabla.addRow(elementos2);
			}
			break;
		case 3:
			elementosTablaRegistrosVentas = consulta.getRegistrosVentas();
			Vector elementos3 = new Vector();
			for (int i = 0; i < elementosTablaRegistrosVentas.size(); i++) {
				elementos3 = new Vector();
				elementos3.add(elementosTablaRegistrosVentas.get(i).get_Fecha());
				elementos3.add(elementosTablaRegistrosVentas.get(i).get_CantidadVendida());
				elementos3.add(elementosTablaRegistrosVentas.get(i).get_Rut());
				elementos3.add(elementosTablaRegistrosVentas.get(i).get_ID());
				modeloTabla.addRow(elementos3);
			}
			break;
		case 4:
			elementosTablaRegistrosCompras = consulta.getRegistrosCompras();
			Vector elementos4 = new Vector();
			for (int i = 0; i < elementosTablaRegistrosCompras.size(); i++) {
				elementos4 = new Vector();
				elementos4.add(elementosTablaRegistrosCompras.get(i).get_Usuario());
				elementos4.add(elementosTablaRegistrosCompras.get(i).get_NombreProveedor());
				elementos4.add(elementosTablaRegistrosCompras.get(i).get_UnidadesAdquiridas());
				elementos4.add(elementosTablaRegistrosCompras.get(i).get_CostoUnitario());
				elementos4.add(elementosTablaRegistrosCompras.get(i).get_FechaPedida());
				elementos4.add(elementosTablaRegistrosCompras.get(i).get_FechaRecibo());
				elementos4.add(elementosTablaRegistrosCompras.get(i).get_ID());
				modeloTabla.addRow(elementos4);
			}
			break;
		}
	}
	
	public void construirPanelIloveny() {
		
		funcionesLayeredPane = new JLayeredPane();
		funcionesLayeredPane.setLayout(null);
		funcionesLayeredPane.setBounds(929, 39, 732, 558);
		getContentPane().add(funcionesLayeredPane);
		IconoIlovenyPanel = new JPanel();
		IconoIlovenyPanel.setBounds(new Rectangle(0, 0, 197, 197));
		IconoIlovenyPanel.setBounds(0, 0, 197, 197);
		IconoIlovenyPanel.setBackground(new Color(34,34,34));
		getContentPane().add(IconoIlovenyPanel);
		
		lblIcono = new JLabel("");
		lblIcono.setBounds(new Rectangle(19, 18, 159, 156));
		ImageIcon iloveny_icon = new ImageIcon(Administracion.class.getResource("/imagenes/iloveny-icon.png"));
		IconoIlovenyPanel.setLayout(null);
		lblIcono.setIcon(new ImageIcon(iloveny_icon.getImage().getScaledInstance(lblIcono.getWidth(), lblIcono.getHeight(), Image.SCALE_SMOOTH)));
		IconoIlovenyPanel.add(lblIcono);
	}
	
	private ArrayList<String> getSelectedRow() {
		ArrayList<String> elementos = new ArrayList<String>();
		int row = tabla.getSelectedRow();
		for (int i = 0; i < tabla.getColumnCount(); i++) {
			elementos.add(String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), i)));
		}
		return elementos;
	}
	
	private void moverLayeredPanel() {
		funcionesLayeredPane.setBounds(197, 39, 732, 558);
	}

	private void cambiarPanel(JPanel panel) {
		funcionesLayeredPane.removeAll();
		funcionesLayeredPane.add(panel);
		funcionesLayeredPane.repaint();
		funcionesLayeredPane.revalidate();
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
