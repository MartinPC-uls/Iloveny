package vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import mongodb.Consulta;
import mongodb.RegistroVenta;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DetallesRegistroVenta {

private JFrame frame;
	
	private JLabel fechaDeVenta, cantidadVendida, marca, tipo, descripcion, precioUnitario;

	String _id;
	String rut;
	
	public DetallesRegistroVenta(String _id) {
		this._id = _id;
		setLabels(fechaDeVenta, cantidadVendida, marca, tipo, descripcion, precioUnitario);
		initialize();
		frame.setVisible(true);
	}
	
	private void setLabels(JLabel fechaDeVenta, JLabel cantidadVendida, JLabel marca, JLabel tipo, JLabel descripcion, JLabel precioUnitario) {
		Consulta consulta = new Consulta();
		RegistroVenta registroVenta = consulta.getRegistroVenta(_id);
		this.fechaDeVenta = new JLabel(registroVenta.get_fechaventa());
		this.cantidadVendida = new JLabel(String.valueOf(registroVenta.get_cantidadvendida()));
		this.marca = new JLabel(registroVenta.get_articulo().get_nombremarca());
		this.tipo = new JLabel(String.valueOf(registroVenta.get_articulo().get_nombretipo()));
		this.descripcion = new JLabel(registroVenta.get_articulo().get_descripcion());
		this.precioUnitario = new JLabel(String.valueOf(registroVenta.get_articulo().get_preciounitario()));
		this.rut = registroVenta.get_usuario().get__id();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 508, 438);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFechaDeVenta = new JLabel("Fecha de Venta");
		lblFechaDeVenta.setBounds(25, 28, 150, 14);
		frame.getContentPane().add(lblFechaDeVenta);
		
		fechaDeVenta.setBounds(25, 44, 150, 14);
		frame.getContentPane().add(fechaDeVenta);
		
		JLabel lblCantidadVendida = new JLabel("Cantidad Vendida");
		lblCantidadVendida.setBounds(185, 28, 150, 14);
		frame.getContentPane().add(lblCantidadVendida);
		
		cantidadVendida.setBounds(185, 44, 150, 14);
		frame.getContentPane().add(cantidadVendida);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(332, 28, 58, 14);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblInformacionDelArticulo = new JLabel("Informaci\u00F3n del Art\u00EDculo");
		lblInformacionDelArticulo.setBounds(25, 92, 150, 14);
		frame.getContentPane().add(lblInformacionDelArticulo);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(25, 117, 150, 14);
		frame.getContentPane().add(lblMarca);
		
		marca.setBounds(25, 133, 150, 14);
		frame.getContentPane().add(marca);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(185, 117, 150, 14);
		frame.getContentPane().add(lblTipo);
		
		tipo.setBounds(185, 133, 297, 14);
		frame.getContentPane().add(tipo);
		
		JButton btnDetallesUsuario = new JButton("< Detalles");
		btnDetallesUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DetallesUsuario(rut);
			}
		});
		btnDetallesUsuario.setBounds(378, 24, 89, 23);
		frame.getContentPane().add(btnDetallesUsuario);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(25, 158, 150, 14);
		frame.getContentPane().add(lblDescripcion);
		
		descripcion.setBounds(25, 174, 150, 14);
		frame.getContentPane().add(descripcion);
		
		JLabel lblPrecioUnitario = new JLabel("Precio Unitario");
		lblPrecioUnitario.setBounds(185, 158, 150, 14);
		frame.getContentPane().add(lblPrecioUnitario);
		
		precioUnitario.setBounds(185, 174, 150, 14);
		frame.getContentPane().add(precioUnitario);
	}
}
