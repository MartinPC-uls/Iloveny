package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;

public class Administracion {

	public JFrame frame;
	public JLayeredPane layeredPane_1 = new JLayeredPane();
	private JTable table;

	public Administracion() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(34, 34, 34));
		panel.setBounds(0, 0, 197, 559);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(196, 0, 731, 559);
		frame.getContentPane().add(layeredPane_1);
		layeredPane_1.setLayout(new CardLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		layeredPane_1.add(panel_1, "name_54251509904100");
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 51, 51));
		layeredPane_1.add(panel_2, "name_54256623111200");
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 51, 51));
		layeredPane_1.add(panel_3, "name_54331093143100");
		panel_3.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 203, 711, 345);
		panel_3.add(table);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(445, 11, 89, 23);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("USUARIOS");
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(panel_1);
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
		btnNewButton.setBounds(0, 151, 197, 43);
		panel.add(btnNewButton);
		
		JButton btnArtculos = new JButton("ART\u00CDCULOS");
		btnArtculos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnArtculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(panel_2);
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
		btnArtculos.setBounds(0, 205, 197, 43);
		panel.add(btnArtculos);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(panel_3);
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
		btnNewButton_2.setBounds(0, 259, 197, 43);
		panel.add(btnNewButton_2);
		
		frame.setBounds(100, 100, 943, 598);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void switchPanels(JPanel panel) {
		layeredPane_1.removeAll();
		layeredPane_1.add(panel);
		layeredPane_1.repaint();
		layeredPane_1.revalidate();
	}
}
