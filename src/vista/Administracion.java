package vista;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class Administracion extends JFrame {

	//public JFrame frame;
	public JLayeredPane layeredPane_1 = new JLayeredPane();
	Consulta consulta = new Consulta();
	public JTable table;
	public JTable table2;
	public DefaultTableModel model2;
	public DefaultTableModel model;
	public ArrayList<ArrayList<String>> usuarios; 
	public ArrayList<ArrayList<String>> articulos; 
	public JButton btnNewButton_1;
	public JPanel panelArticulos;

	public Administracion() {
		initialize();
	}

	private void initialize() {
		//new JFrame();
		getContentPane().setBackground(new Color(51, 51, 51));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(34, 34, 34));
		panel.setBounds(0, 0, 197, 559);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(196, 0, 731, 559);
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
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				String nombre = table.getValueAt(row, 0).toString();
				String apellidos = table.getValueAt(row, 1).toString();
				String rut = table.getValueAt(row, 2).toString();
				String telefonos = table.getValueAt(row, 3).toString();
				String email = table.getValueAt(row, 4).toString();
				AgregarUsuario agregarUsuario = new AgregarUsuario(btnNewButton_1);
				agregarUsuario.setElements(nombre, apellidos, rut, telefonos, email);
			}
		});
		btnModificar.setBounds(344, 18, 119, 37);
		panelUsuarios.add(btnModificar);
		
		JButton btnAgregar = new JButton("Agregar...");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarUsuario agregarUsuario = new AgregarUsuario(btnNewButton_1);
			}
		});
		btnAgregar.setBounds(473, 18, 119, 37);
		panelUsuarios.add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				String value = table.getValueAt(row, 2).toString(); // RUT
				System.out.println(value);
				int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro que quiere eliminar " + value + "?");
				if (JOptionPane.YES_OPTION == confirm) {
					consulta.delUsuario(value);
					refresh();
				}
			}
		});
		btnEliminar.setBounds(602, 18, 119, 37);
		panelUsuarios.add(btnEliminar);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nombre", "Apellidos", "Rut", "Telefonos", "Email"
				}
		));
		model = (DefaultTableModel)table.getModel();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setForeground(new Color(255, 255, 255));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		//table.setBackground(SystemColor.menu);
		//scrollPane.getViewport().setBackground(SystemColor.menu);
		//scrollPane.setBackground(SystemColor.menu);
		//scrollPane.getViewport().setBackground(SystemColor.menu);
		//scrollPane.getViewport().setBackground(new Color(51,51,51));
		scrollPane.setBounds(10, 226, 711, 322);
		table.setBounds(0, 0, scrollPane.getWidth(), scrollPane.getHeight());
		
		table.getTableHeader().setBackground(new Color(51,51,51));
		
		panelUsuarios.add(scrollPane);
		
		JButton btnNewButton = new JButton("USUARIOS");
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(panelUsuarios);
				//consulta.getUsuarios(orden)
			}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new Color(221, 30, 38));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(34, 34, 34));
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(34,34,34));
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(0, 195, 197, 43);
		panel.add(btnNewButton);
		
		JButton btnArtculos = new JButton("ART\u00CDCULOS");
		btnArtculos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnArtculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(panelArticulos);
			}
		});
		btnArtculos.setFocusPainted(false);
		btnArtculos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnArtculos.setBackground(new Color(221, 30, 38));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnArtculos.setBackground(new Color(34, 34, 34));
			}
		});
		btnArtculos.setForeground(Color.WHITE);
		btnArtculos.setBackground(new Color(34,34,34));
		btnArtculos.setBorder(null);
		btnArtculos.setBounds(0, 249, 197, 43);
		panel.add(btnArtculos);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(panelUsuarios);
			}
		});
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_2.setBackground(new Color(221, 30, 38));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_2.setBackground(new Color(34, 34, 34));
			}
		});
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
		
		setBounds(100, 100, 943, 598);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		
		btnNewButton_1 = new JButton("Actualizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refresh();
			}
		});
		btnNewButton_1.setBounds(632, 192, 89, 23);
		panelUsuarios.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Usuarios");
		lblNewLabel.setFont(new Font("Roboto Light", Font.PLAIN, 41));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 13, 175, 42);
		panelUsuarios.add(lblNewLabel);
		
		panelArticulos = new JPanel();
		panelArticulos.setLayout(null);
		panelArticulos.setBackground(new Color(51, 51, 51));
		layeredPane_1.add(panelArticulos, "name_47993813931900");
		
		JButton btnModificar_1 = new JButton("Modificar");
		btnModificar_1.setBounds(344, 18, 119, 37);
		panelArticulos.add(btnModificar_1);
		
		JButton btnAgregar_1 = new JButton("Agregar...");
		btnAgregar_1.setBounds(473, 18, 119, 37);
		panelArticulos.add(btnAgregar_1);
		
		JButton btnEliminar_1 = new JButton("Eliminar");
		btnEliminar_1.setBounds(602, 18, 119, 37);
		panelArticulos.add(btnEliminar_1);
		
		table2 = new JTable();
		table2.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nombre", "Apellidos", "Rut", "Telefonos", "Email"
				}
		));
		model2 = (DefaultTableModel)table.getModel();
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table2.setPreferredScrollableViewportSize(table.getPreferredSize());
		table2.getColumnModel().getColumn(0).setPreferredWidth(150);
		table2.getColumnModel().getColumn(1).setPreferredWidth(150);
		table2.getColumnModel().getColumn(2).setPreferredWidth(150);
		table2.getColumnModel().getColumn(3).setPreferredWidth(150);
		table2.getColumnModel().getColumn(4).setPreferredWidth(150);
		table2.getTableHeader().setOpaque(false);
		table2.getTableHeader().setForeground(new Color(255, 255, 255));
		JScrollPane scrollPane1 = new JScrollPane(table2);
		scrollPane1.getViewport().setOpaque(false);
		scrollPane1.setOpaque(false);
		//table.setBackground(SystemColor.menu);
		//scrollPane.getViewport().setBackground(SystemColor.menu);
		//scrollPane.setBackground(SystemColor.menu);
		//scrollPane.getViewport().setBackground(SystemColor.menu);
		//scrollPane.getViewport().setBackground(new Color(51,51,51));
		scrollPane1.setBounds(10, 226, 711, 322);
		table2.setBounds(0, 0, scrollPane1.getWidth(), scrollPane1.getHeight());
		
		table2.getTableHeader().setBackground(new Color(51,51,51));
		
		panelUsuarios.add(scrollPane1);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(632, 192, 89, 23);
		panelArticulos.add(btnActualizar);
		
		JLabel lblArticulos = new JLabel("Usuarios");
		lblArticulos.setForeground(Color.WHITE);
		lblArticulos.setFont(new Font("Roboto Light", Font.PLAIN, 41));
		lblArticulos.setBounds(10, 13, 175, 42);
		panelArticulos.add(lblArticulos);
		
		List<RowSorter.SortKey> sortKeys = new ArrayList<>(100);
		sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
		
		addUsuarios();
	}
	
	public void refresh() {
		int rowCount = model.getRowCount();
		System.out.println(rowCount);
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		addUsuarios();
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
		articulos = new ArrayList<ArrayList<String>>();
		articulos = consulta.getListaArticulo("nombrearticulo");
		ArrayList<String> elementos;
		for (int i = 0; i < articulos.size(); i++) {
			elementos = new ArrayList<String>();
			for (int j = 0; j < articulos.get(i).size(); j++) {
				elementos.add(articulos.get(i).get(j));
			}
			model.addRow(new Object[] {elementos.get(0), elementos.get(1), elementos.get(2), elementos.get(3), elementos.get(4), elementos.get(5)});
		}
	}
	
	public void switchPanels(JPanel panel) {
		layeredPane_1.removeAll();
		layeredPane_1.add(panel);
		layeredPane_1.repaint();
		layeredPane_1.revalidate();
	}
}
