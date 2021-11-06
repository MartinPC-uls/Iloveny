/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author ghanv
 */
public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPasswordField pwdJpasswordfield;
	private JTextField txtJtextfield;
	
    public Login() {
    	getContentPane().setBackground(new Color(51,51,51));
        initialize();
    }

    private void initialize() {
        
        setBounds(100, 100, 473, 652);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);
        
        JLabel lblLogin = new JLabel();
        lblLogin.setVerticalAlignment(SwingConstants.CENTER);
        lblLogin.setText("INICIO DE SESI\u00D3N");
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin.setForeground(Color.WHITE);
        lblLogin.setFont(new Font("Roboto Light", Font.PLAIN, 24));
        lblLogin.setBounds(10, 170, 441, 35);
        getContentPane().add(lblLogin);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(51,51,51));
        panel.setBounds(72, 216, 314, 346);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        txtJtextfield = new JTextField();
        txtJtextfield.setCaretColor(Color.WHITE);
        txtJtextfield.setBounds(41, 66, 273, 21);
        panel.add(txtJtextfield);
        txtJtextfield.setText("jTextField1");
        txtJtextfield.setOpaque(false);
        txtJtextfield.setForeground(Color.WHITE);
        txtJtextfield.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtJtextfield.setBorder(null);
        txtJtextfield.setBackground(new Color(51, 51, 51));
        
        JPanel downPanelUser = new JPanel();
        downPanelUser.setBounds(-89, 98, 441, 3);
        panel.add(downPanelUser);
        downPanelUser.setPreferredSize(new Dimension(0, 3));
        downPanelUser.setBackground(new Color(51, 255, 204));
        GroupLayout gl_downPanelUser = new GroupLayout(downPanelUser);
        gl_downPanelUser.setHorizontalGroup(
        	gl_downPanelUser.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 441, Short.MAX_VALUE)
        		.addGap(0, 441, Short.MAX_VALUE)
        );
        gl_downPanelUser.setVerticalGroup(
        	gl_downPanelUser.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 3, Short.MAX_VALUE)
        		.addGap(0, 3, Short.MAX_VALUE)
        );
        downPanelUser.setLayout(gl_downPanelUser);
        
        pwdJpasswordfield = new JPasswordField();
        pwdJpasswordfield.setCaretColor(Color.WHITE);
        pwdJpasswordfield.setBounds(41, 112, 273, 21);
        panel.add(pwdJpasswordfield);
        pwdJpasswordfield.setText("jPasswordField1");
        pwdJpasswordfield.setForeground(Color.WHITE);
        pwdJpasswordfield.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        pwdJpasswordfield.setBorder(null);
        pwdJpasswordfield.setBackground(new Color(51, 51, 51));
        
        JPanel downPanelPassword = new JPanel();
        downPanelPassword.setBounds(-67, 144, 441, 3);
        panel.add(downPanelPassword);
        downPanelPassword.setPreferredSize(new Dimension(0, 3));
        downPanelPassword.setBackground(new Color(51, 255, 204));
        GroupLayout gl_downPanelPassword = new GroupLayout(downPanelPassword);
        gl_downPanelPassword.setHorizontalGroup(
        	gl_downPanelPassword.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 441, Short.MAX_VALUE)
        		.addGap(0, 441, Short.MAX_VALUE)
        );
        gl_downPanelPassword.setVerticalGroup(
        	gl_downPanelPassword.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 3, Short.MAX_VALUE)
        		.addGap(0, 3, Short.MAX_VALUE)
        );
        downPanelPassword.setLayout(gl_downPanelPassword);
        
        JButton btnLogin = new JButton();
        btnLogin.setBounds(0, 271, 314, 40);
        panel.add(btnLogin);
        btnLogin.setText("INGRESAR");
        btnLogin.setBorderPainted(false);
        btnLogin.setBorder(null);
        btnLogin.setBackground(new Color(0, 153, 153));
        
        JLabel lblImagen_1 = new JLabel("");
        lblImagen_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagen_1.setIcon(new ImageIcon("C:\\Users\\ghanv\\OneDrive\\Escritorio\\images for work\\person.png"));
        lblImagen_1.setBounds(0, 60, 24, 41);
        panel.add(lblImagen_1);
        
        JLabel lblImagen_1_1 = new JLabel("");
        lblImagen_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagen_1_1.setIcon(new ImageIcon("C:\\Users\\ghanv\\OneDrive\\Escritorio\\images for work\\lock.png"));
        lblImagen_1_1.setBounds(0, 106, 24, 41);
        panel.add(lblImagen_1_1);
        
        JLabel lblImagen = new JLabel("");
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagen.setIcon(new ImageIcon("C:\\Users\\ghanv\\OneDrive\\Escritorio\\images for work\\person-icon.png"));
        lblImagen.setBounds(0, 31, 457, 128);
        getContentPane().add(lblImagen);

        //pack();
    }
}
