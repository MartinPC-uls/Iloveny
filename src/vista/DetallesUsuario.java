package vista;

import javax.swing.JFrame;
import javax.swing.JLabel;

import mongodb.Consulta;
import mongodb.Usuario;

public class DetallesUsuario {

	private JFrame frame;
	
	private JLabel rut, nombre, apellidos, telefono, email, calle, numeroDeDomicilio, ciudad, comuna, region;
	String _id;
	
	public DetallesUsuario(String _id) {
		this._id = _id;
		setLabels(rut, nombre, apellidos, telefono, email, calle, numeroDeDomicilio, ciudad, comuna, region);
		initialize();
		frame.setVisible(true);
	}
	
	private void setLabels(JLabel rut, JLabel nombre, JLabel apellidos, JLabel telefono, JLabel email,
			JLabel calle, JLabel numeroDeDomicilio, JLabel ciudad, JLabel comuna, JLabel region) {
		Consulta consulta = new Consulta();
		Usuario usuario = consulta.getUsuario(_id);
		this.rut = new JLabel(usuario.get__id());
		this.nombre = new JLabel(usuario.get_nombreusuario());
		this.apellidos = new JLabel(usuario.get_apellidos());
		this.telefono = new JLabel(usuario.get_telefono());
		this.email = new JLabel(usuario.get_email());
		this.calle = new JLabel(usuario.get_direccion().get_calle());
		this.numeroDeDomicilio = new JLabel(String.valueOf(usuario.get_direccion().get_numerodomicilio()));
		this.ciudad = new JLabel(usuario.get_direccion().get_ciudad());
		this.comuna = new JLabel(usuario.get_direccion().get_comuna());
		this.region = new JLabel(usuario.get_direccion().get_nombreregion());
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 508, 438);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRut = new JLabel("Rut");
		lblRut.setBounds(25, 28, 150, 14);
		frame.getContentPane().add(lblRut);
		
		rut.setBounds(25, 44, 150, 14);
		frame.getContentPane().add(rut);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(185, 28, 150, 14);
		frame.getContentPane().add(lblNombre);
		
		nombre.setBounds(185, 44, 150, 14);
		frame.getContentPane().add(nombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(332, 28, 150, 14);
		frame.getContentPane().add(lblApellidos);
		
		apellidos.setBounds(332, 44, 150, 14);
		frame.getContentPane().add(apellidos);
		
		JLabel lblInformacionDeContacto = new JLabel("Informaci\u00F3n de Contacto");
		lblInformacionDeContacto.setBounds(25, 92, 150, 14);
		frame.getContentPane().add(lblInformacionDeContacto);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setBounds(25, 117, 150, 14);
		frame.getContentPane().add(lblTelefono);
		
		telefono.setBounds(25, 133, 150, 14);
		frame.getContentPane().add(telefono);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(185, 117, 150, 14);
		frame.getContentPane().add(lblEmail);
		
		email.setBounds(185, 133, 297, 14);
		frame.getContentPane().add(email);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(25, 195, 150, 14);
		frame.getContentPane().add(lblDireccion);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(25, 220, 150, 14);
		frame.getContentPane().add(lblCalle);
		
		calle.setBounds(25, 236, 150, 14);
		frame.getContentPane().add(calle);
		
		JLabel lblNumeroDeDomicilio = new JLabel("N\u00FAmero de domicilio");
		lblNumeroDeDomicilio.setBounds(185, 220, 150, 14);
		frame.getContentPane().add(lblNumeroDeDomicilio);
		
		numeroDeDomicilio.setBounds(185, 236, 150, 14);
		frame.getContentPane().add(numeroDeDomicilio);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setBounds(25, 265, 150, 14);
		frame.getContentPane().add(lblCiudad);
		
		ciudad.setBounds(25, 281, 150, 14);
		frame.getContentPane().add(ciudad);
		
		JLabel lblComuna = new JLabel("Comuna");
		lblComuna.setBounds(185, 265, 150, 14);
		frame.getContentPane().add(lblComuna);
		
		comuna.setBounds(185, 281, 150, 14);
		frame.getContentPane().add(comuna);
		
		JLabel lblRegion = new JLabel("Regi\u00F3n");
		lblRegion.setBounds(25, 306, 150, 14);
		frame.getContentPane().add(lblRegion);
		
		region.setBounds(25, 322, 150, 14);
		frame.getContentPane().add(region);
	}
}
