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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Administracion extends JFrame {

	//public JFrame frame;
	public JLayeredPane layeredPane_1 = new JLayeredPane();
	public Consulta consulta = new Consulta();
	public DefaultTableModel modeloTabla;
	public ArrayList<ArrayList<String>> elementosTabla; 
	
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
	@SuppressWarnings("rawtypes")
	private JComboBox filtroCB;
	private JScrollPane tablaScrollPane;
	private JTable tabla;
	private JButton btnModificar;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private JLayeredPane funcionesLayeredPane;
	public AgregarUsuarioPanel agregarUsuarioPanel;
	public AgregarDireccionPanel agregarDireccionPanel;
	public AgregarArticuloPanel agregarArticuloPanel;
	public AgregarMedidaGeneralPanel agregarMedidaGeneralPanel;
	public AgregarMedidaEspecificaPanel agregarMedidaEspecificaPanel;
	public AgregarRegistroVentaPanel agregarRegistroVentaPanel;
	private JPanel panelPrincipal;
	private JButton btnRegistroCompra;
	private JButton btnMarcas;
	private JButton btnTiposObjeto;

	public Administracion() {
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
		this.addEventoBotonEnteredAndExited(btnModificar);
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/Edit-icon-white.png")));
		btnModificar.setBorder(null);
		btnModificar.setBackground(new Color(51,51,51));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*int row = tableUsuarios.getSelectedRow();
				if(row<0) {
					mostrarAlertaFilaNoSeleccionada();
				} else {
					abrirVentanaAgregarUsuario(row);
				}*/
			}
		});
		panelPrincipal.setLayout(null);
		btnModificar.setBounds(526, 67, 45, 45);
		panelPrincipal.add(btnModificar);
		
		btnAgregar = new JButton("");
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/Add-icon-blanco.png")));
		btnAgregar.setBackground(new Color(51, 51, 51));
		btnAgregar.setBorder(null);
		this.addEventoBotonEnteredAndExited(btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(modo) {
				
				case 1:
					agregarUsuarioPanel = new AgregarUsuarioPanel(1, new JComponent[] {funcionesLayeredPane, panelPrincipal}, btnActualizar);
					cambiarPanel(agregarUsuarioPanel);
					break;
				case 2:
					agregarDireccionPanel = new AgregarDireccionPanel(1, new JComponent[] {funcionesLayeredPane, panelPrincipal}, btnActualizar);
					cambiarPanel(agregarDireccionPanel);
					break;
				case 3:
					agregarArticuloPanel = new AgregarArticuloPanel(1, new JComponent[] {funcionesLayeredPane, panelPrincipal}, btnActualizar);
					cambiarPanel(agregarArticuloPanel);
					break;
				case 4:
					agregarMedidaGeneralPanel = new AgregarMedidaGeneralPanel(1, new JComponent[] {funcionesLayeredPane, panelPrincipal}, btnActualizar);
					cambiarPanel(agregarMedidaGeneralPanel);
					break;
				case 5:
					agregarMedidaEspecificaPanel = new AgregarMedidaEspecificaPanel(1, new JComponent[] {funcionesLayeredPane, panelPrincipal}, btnActualizar);
					cambiarPanel(agregarMedidaEspecificaPanel);
					break;
				case 6:
					agregarRegistroVentaPanel = new AgregarRegistroVentaPanel(1, new JComponent[] {funcionesLayeredPane, panelPrincipal}, btnActualizar);
					cambiarPanel(agregarRegistroVentaPanel);
					break;
				default:
				
				}
				moverLayeredPanel();
				panelPrincipal.setVisible(false);
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

		});
		btnAgregar.setBounds(576, 67,  45, 45);
		panelPrincipal.add(btnAgregar);
		
		btnEliminar = new JButton("");
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
		tabla.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nombre", "Apellidos", "Rut", "Telefonos", "Email"
				}
		));
		iniciarTabla();
		rellenarTabla();
		btnActualizar = new JButton("");
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
		
		filtroCB = new JComboBox(new String[] {"Seleccione...","Nombre", "Apellidos", "Rut", "Telefonos", "Email"});
		filtroCB.setFont(new Font("Roboto Light", Font.PLAIN, 15));
		filtroCB.setName("");
		filtroCB.setForeground(Color.BLACK);
		filtroCB.setBorder(null);
		filtroCB.setBounds(315, 67, 115, 41);
		panelPrincipal.add(filtroCB);
		
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
		
		JLabel lblComboBox = new JLabel("Buscar por:");
		lblComboBox.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblComboBox.setForeground(Color.WHITE);
		lblComboBox.setBounds(316, 52, 69, 14);
		panelPrincipal.add(lblComboBox);
		
		panelPrincipal.add(tablaScrollPane);
	}

	private void eliminarFilaTabla() {
		int row = tabla.getSelectedRow();
		String value = tabla.getValueAt(row, columnaPK).toString();
		System.out.println(value);
		int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro que quiere eliminar " + value + "?");
		if (JOptionPane.YES_OPTION == confirm) {
			switch(modo) {
				case 1:						
					consulta.delDireccion(value);
					consulta.delRegistroVentaRut(value);
					consulta.delUsuario(value);
					break;
				case 2:
					consulta.delDireccion(value);
					break;
				case 3:
					consulta.delMedidaE(Integer.parseInt(value));
					consulta.delMedidaG(Integer.parseInt(value));
					consulta.delRegistroCompraIdArticulo(Integer.parseInt(value));
					consulta.delRegistroVentaIdArticulo(Integer.parseInt(value));
					consulta.delArticulo(Integer.parseInt(value));
					break;
				case 4:
					consulta.delMedidaG(Integer.parseInt(value));
					break;
				case 5:
					consulta.delMedidaE(Integer.parseInt(value));
					break;
				case 6:
					consulta.delRegistroVenta(Integer.parseInt(value));
					break;
				case 8:
					ArrayList idsArticulos = consulta.getidArticulosSegunMarca(Integer.parseInt(value));
					for (int i = 0; i < idsArticulos.size(); i++) {
						consulta.delRegistroCompraIdArticulo(Integer.parseInt(idsArticulos.get(i).toString()));
						consulta.delRegistroVentaIdArticulo(Integer.parseInt(idsArticulos.get(i).toString()));
					}
					consulta.delArticuloSegunMarca(Integer.parseInt(value));
					consulta.delMarca(Integer.parseInt(value));
					break;
					
				default:
			}
			eliminarDatosTabla();
			repintarTabla();
			rellenarTabla();
		}
	}

	private void realizarBusqueda() {
		eliminarDatosTabla();
		elementosTabla = new ArrayList<ArrayList<String>>();
		switch(modo) {
		case 1:
			elementosTabla = consulta.getListaArticuloBusqueda(filtroCB.getSelectedItem().toString(), buscadorTextField.getText());
			break;
		case 2:
			elementosTabla = consulta.getDirecciones();
			break;
		case 3:
			elementosTabla = consulta.getListaArticulo("idarticulo");
			break;
		case 4:
			elementosTabla = consulta.getListaMedidaG("idarticulo");
			break;
		case 5:
			elementosTabla = consulta.getListaMedidaE("idarticulo");
			break;
			
		case 6:
			elementosTabla = consulta.getRegistrosVenta("idventa");
			break;
		case 8:
			System.out.println("ESTAMOS AQUI EN CASE 8 XD");
			elementosTabla = consulta.getMarca();
			System.out.println("SALIENDO DE CASE 8 DX - " + elementosTabla.get(1).get(1));
			break;
		default:
			
		}
		Vector elementos = new Vector();
		for (int i = 0; i < elementosTabla.size(); i++) {
			elementos = new Vector();
			for (int j = 0; j < elementosTabla.get(i).size(); j++) {
				elementos.add(elementosTabla.get(i).get(j));
			}
			modeloTabla.addRow(elementos);
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
		}else {
			espacioParaColumna = 150;
		}
		
		for(int i = 0; i<tabla.getColumnCount(); i++) {
			tabla.getColumnModel().getColumn(i).setPreferredWidth(espacioParaColumna);
			System.out.println("Va en la columna numero: "+i+" "+tabla.getColumnModel().getColumn(i));
			tabla.setBounds(0, 0, tablaScrollPane.getWidth(), tablaScrollPane.getHeight());
			TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabla.getModel());
			tabla.setRowSorter(sorter);
			List<RowSorter.SortKey> sortKeys = new ArrayList<>(100);
			sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
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
			System.out.println("Va en la columna numero: "+i+" "+tabla.getColumnModel().getColumn(i));
		}
		tabla.getTableHeader().setOpaque(false);
		tabla.getTableHeader().setForeground(new Color(255, 255, 255));
		tablaScrollPane = new JScrollPane(tabla);
		tablaScrollPane.getViewport().setOpaque(false);
		tablaScrollPane.setOpaque(false);
		tablaScrollPane.setBounds(10, 114, 711, 434);
		
		tabla.setBounds(0, 0, tablaScrollPane.getWidth(), tablaScrollPane.getHeight());
		tabla.getTableHeader().setBackground(new Color(51,51,51));
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabla.getModel());
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
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(0, 191, 197, 406);
		getContentPane().add(scrollPane);
		MenuConBotonesPanel = new JPanel();
		scrollPane.setViewportView(MenuConBotonesPanel);
		MenuConBotonesPanel.setBackground(new Color(34, 34, 34));
		MenuConBotonesPanel.setPreferredSize(new Dimension(170, 600));
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
					DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>( new String[] {"Seleccione...","Nombre", "Apellidos", "Rut", "Telefonos", "Email"});
					filtroCB.setModel(model);
					tabla.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"Nombre", "Apellidos", "Rut", "Telefonos", "Email"
							}
					));
					repintarTabla();
					rellenarTabla();
					filtroCB.setSelectedIndex(0);
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
		
		btnArticulos = new JButton("ART\u00CDCULOS");
		btnArticulos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnArticulos.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/Box-White.png")));
		btnArticulos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnArticulos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modo != 3) {
					modo = 3;
					columnaPK = 0;
					eliminarDatosTabla();
					lblTitulo.setText("Artículos");
					buscadorTextField.setText("");
					DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>( new String[] {"Seleccione...","ID Articulo", "Tipo de articulo", "Marca", "Stock", "Precio unitario", "Descripcion", "rutaImagen"});
					filtroCB.setModel(model);
					tabla.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"ID Articulo", "Tipo de articulo", "Marca", "Stock", "Precio unitario", "Descripcion", "rutaImagen"
							}
					));
					repintarTabla();
					rellenarTabla();
					filtroCB.setSelectedIndex(0);
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
		btnArticulos.setBounds(0, 108, 197, 43);
		MenuConBotonesPanel.add(btnArticulos);
		
		JButton btnDireccion = new JButton("DIRECCI\u00D3N");
		btnDireccion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addEventoBotonEnteredAndExitedMenu(btnDireccion);
		btnDireccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modo != 2) {
					modo = 2;
					columnaPK = 0;
					eliminarDatosTabla();
					lblTitulo.setText("Direccion");
					buscadorTextField.setText("");
					DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>( new String[] {"Seleccione...","Rut", "Region", "Numero Domicilio", "Nombre Calle", "Ciudad","Comuna"});
					filtroCB.setModel(model);
					tabla.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"Rut", "Region", "Numero Domicilio", "Nombre Calle", "Ciudad","Comuna"
							}
					));
					repintarTabla();
					rellenarTabla();
					filtroCB.setSelectedIndex(0);
				}
				if(!panelPrincipal.isVisible()) {
					reacomodarPaneles();
				}
			}	
		});
		btnDireccion.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/location-icon-white.png")));
		btnDireccion.setForeground(Color.WHITE);
		btnDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnDireccion.setFocusPainted(false);
		btnDireccion.setBorder(null);
		btnDireccion.setBackground(new Color(34, 34, 34));
		btnDireccion.setBounds(0, 54, 197, 43);
		MenuConBotonesPanel.add(btnDireccion);
		
		JButton btnMedidaGeneral = new JButton("MEDIDA GENERAL");
		btnMedidaGeneral.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMedidaGeneral.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/ruler-white.png")));
		addEventoBotonEnteredAndExitedMenu(btnMedidaGeneral);
		btnMedidaGeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modo != 4) {
					modo = 4;
					columnaPK = 0;
					eliminarDatosTabla();
					lblTitulo.setText("Medida General");
					buscadorTextField.setText("");
					DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>( new String[] {"Seleccione...","ID Articulo", "Tipo de articulo","Alto", "Ancho", "Largo"});
					filtroCB.setModel(model);
					tabla.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"ID Articulo","Tipo de articulo", "Alto", "Ancho", "Largo"
							}
					));
					repintarTabla();
					rellenarTabla();
					filtroCB.setSelectedIndex(0);
				}
				if(!panelPrincipal.isVisible()) {
					reacomodarPaneles();
				}
			}
		});
		btnMedidaGeneral.setForeground(Color.WHITE);
		btnMedidaGeneral.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnMedidaGeneral.setFocusPainted(false);
		btnMedidaGeneral.setBorder(null);
		btnMedidaGeneral.setBackground(new Color(34, 34, 34));
		btnMedidaGeneral.setBounds(0, 162, 197, 43);
		MenuConBotonesPanel.add(btnMedidaGeneral);
		
		JButton btnMedidaEspecifica = new JButton("MEDIDA ESPECIFICA");
		btnMedidaEspecifica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMedidaEspecifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modo != 5) {
					modo = 5;
					columnaPK = 0;
					eliminarDatosTabla();
					lblTitulo.setText("Medida Especifica");
					buscadorTextField.setText("");
					DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>( new String[] {"Seleccione...","ID Articulo","Tipo de articulo","Medida Especifica"});
					filtroCB.setModel(model);
					tabla.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"ID Articulo","Tipo de articulo", "Medida Especifica"
							}
					));
					repintarTabla();
					rellenarTabla();
					filtroCB.setSelectedIndex(0);
				}
				if(!panelPrincipal.isVisible()) {
					reacomodarPaneles();
				}
			}
		});
		addEventoBotonEnteredAndExitedMenu(btnMedidaEspecifica);
		btnMedidaEspecifica.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/Measure-tape-white.png")));
		btnMedidaEspecifica.setForeground(Color.WHITE);
		btnMedidaEspecifica.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnMedidaEspecifica.setFocusPainted(false);
		btnMedidaEspecifica.setBorder(null);
		btnMedidaEspecifica.setBackground(new Color(34, 34, 34));
		btnMedidaEspecifica.setBounds(0, 216, 197, 43);
		MenuConBotonesPanel.add(btnMedidaEspecifica);
		
		JButton btnRegistroVenta = new JButton("REGISTRO VENTA");
		btnRegistroVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modo != 6) {
					modo = 6;
					columnaPK = 0;
					eliminarDatosTabla();
					lblTitulo.setText("Registro venta");
					buscadorTextField.setText("");
					DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>( new String[] {"Seleccione...","ID Articulo","RUT","Fecha venta","Cantidad vendida","ID venta"});
					filtroCB.setModel(model);
					tabla.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
									"ID Articulo","RUT","Fecha venta","Cantidad vendida","ID venta"
							}
					));
					repintarTabla();
					rellenarTabla();
					filtroCB.setSelectedIndex(0);
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
		btnRegistroVenta.setBounds(0, 270, 197, 43);
		MenuConBotonesPanel.add(btnRegistroVenta);
		
		btnRegistroCompra = new JButton("REGISTRO COMPRA");
		btnRegistroCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegistroCompra.setForeground(Color.WHITE);
		btnRegistroCompra.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnRegistroCompra.setFocusPainted(false);
		btnRegistroCompra.setBorder(null);
		btnRegistroCompra.setBackground(new Color(34, 34, 34));
		btnRegistroCompra.setBounds(0, 324, 197, 43);
		MenuConBotonesPanel.add(btnRegistroCompra);
		
		btnMarcas = new JButton("MARCAS");
		btnMarcas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modo != 8) {
					modo = 8;
					columnaPK = 0;
					eliminarDatosTabla();
					lblTitulo.setText("Marca");
					buscadorTextField.setText("");
					DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>( new String[] {"Seleccione...","ID Marca","Nombre Marca"});
					filtroCB.setModel(model);
					tabla.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
									"ID Marca","Nombre Marca"							}
					));
					repintarTabla();
					rellenarTabla();
					filtroCB.setSelectedIndex(0);
				}
				if(!panelPrincipal.isVisible()) {
					reacomodarPaneles();
				}
			
			}
		});
		btnMarcas.setForeground(Color.WHITE);
		btnMarcas.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnMarcas.setFocusPainted(false);
		btnMarcas.setBorder(null);
		btnMarcas.setBackground(new Color(34, 34, 34));
		btnMarcas.setBounds(0, 378, 197, 43);
		MenuConBotonesPanel.add(btnMarcas);
		
		btnTiposObjeto = new JButton("TIPOS DE OBJETO");
		btnTiposObjeto.setForeground(Color.WHITE);
		btnTiposObjeto.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnTiposObjeto.setFocusPainted(false);
		btnTiposObjeto.setBorder(null);
		btnTiposObjeto.setBackground(new Color(34, 34, 34));
		btnTiposObjeto.setBounds(0, 432, 197, 43);
		MenuConBotonesPanel.add(btnTiposObjeto);
	}
	
	private void reacomodarPaneles() {
		panelPrincipal.setVisible(true);
		funcionesLayeredPane.setBounds(929,39,732,558);
	}	
	
	public void eliminarDatosTabla() {
		int rowCount = modeloTabla.getRowCount();
		System.out.println(rowCount);
		for (int i = rowCount - 1; i >= 0; i--) {
			modeloTabla.removeRow(i);
		}
	}
	
	public void rellenarTabla() {
		elementosTabla = new ArrayList<ArrayList<String>>();
		switch(modo) {
		case 1:
			elementosTabla = consulta.getUsuarios("nombreusuario");
			break;
		case 2:
			elementosTabla = consulta.getDirecciones();
			break;
		case 3:
			elementosTabla = consulta.getListaArticulo("idarticulo");
			break;
		case 4:
			elementosTabla = consulta.getListaMedidaG("idarticulo");
			break;
		case 5:
			elementosTabla = consulta.getListaMedidaE("idarticulo");
			break;
			
		case 6:
			elementosTabla = consulta.getRegistrosVenta("idventa");
			break;
		case 8:
			System.out.println("ESTAMOS AQUI EN CASE 8 XD");
			elementosTabla = consulta.getMarca();
			System.out.println("SALIENDO DE CASE 8 DX - " + elementosTabla.get(1).get(1));
			break;
		default:
			
		}
		Vector elementos = new Vector();
		for (int i = 0; i < elementosTabla.size(); i++) {
			elementos = new Vector();
			for (int j = 0; j < elementosTabla.get(i).size(); j++) {
				elementos.add(elementosTabla.get(i).get(j));
			}
			modeloTabla.addRow(elementos);
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
		lblIcono.setBounds(new Rectangle(4, 2, 187, 186));
		ImageIcon iloveny_icon = new ImageIcon(Administracion.class.getResource("/imagenes/iloveny-icon.png"));
		IconoIlovenyPanel.setLayout(null);
		lblIcono.setIcon(new ImageIcon(iloveny_icon.getImage().getScaledInstance(lblIcono.getWidth(), lblIcono.getHeight(), Image.SCALE_SMOOTH)));
		IconoIlovenyPanel.add(lblIcono);
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
