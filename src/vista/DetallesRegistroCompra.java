package vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import mongodb.Consulta;
import mongodb.RegistroCompra;

public class DetallesRegistroCompra {

private JFrame frame;
	
	private JLabel usuario, unidadesAdquiridas, costoUnitario, descripcion, tipo, fechaPedida, fechaRecibo, proveedor, marca, 
				precioUnitario, alto, ancho, largo, medidaEspecifica;

	String _id;
	
	boolean medida_especifica;
	
	public DetallesRegistroCompra(String _id) {
		this._id = _id;
		setLabels(usuario, unidadesAdquiridas, costoUnitario, descripcion, tipo, fechaPedida, fechaRecibo, proveedor, marca, precioUnitario, alto,
				ancho, largo, medidaEspecifica);
		initialize();
		frame.setVisible(true);
	}
	
	private void setLabels(JLabel usuario, JLabel unidadesAdquiridas, JLabel costoUnitario, JLabel descripcion, JLabel tipo, JLabel fechaPedida,
			JLabel fechaRecibo, JLabel proveedor, JLabel marca, JLabel precioUnitario, JLabel alto, JLabel ancho, JLabel largo, JLabel medidaEspecifica) {
		Consulta consulta = new Consulta();
		RegistroCompra registroCompra = consulta.getRegistroCompra(_id);
		this.usuario = new JLabel(registroCompra.get_usuario());
		this.unidadesAdquiridas = new JLabel(String.valueOf(registroCompra.get_unidadesadquiridas()));
		this.costoUnitario = new JLabel(String.valueOf(registroCompra.get_costounitario()));
		this.descripcion = new JLabel(registroCompra.get_articulo().get_descripcion());
		this.tipo = new JLabel(registroCompra.get_articulo().get_nombretipo());
		this.fechaPedida = new JLabel(registroCompra.get_fechapedida());
		this.fechaRecibo = new JLabel(registroCompra.get_fecharecibo());
		this.proveedor = new JLabel(registroCompra.get_nombreprov());
		this.marca = new JLabel(registroCompra.get_articulo().get_nombremarca());
		this.precioUnitario = new JLabel(String.valueOf(registroCompra.get_articulo().get_preciounitario()));
		this.alto = new JLabel(String.valueOf(registroCompra.get_articulo().get_medida().get_alto()));
		this.ancho = new JLabel(String.valueOf(registroCompra.get_articulo().get_medida().get_ancho()));
		this.largo = new JLabel(String.valueOf(registroCompra.get_articulo().get_medida().get_largo()));
		this.medidaEspecifica = new JLabel(registroCompra.get_articulo().get_medida().get_medidaespecifica());
		
		if (registroCompra.get_articulo().get_medida().get_alto() == 0 && registroCompra.get_articulo().get_medida().get_ancho() == 0 &&
				registroCompra.get_articulo().get_medida().get_largo() == 0) {
			medida_especifica = false;
		} else {
			medida_especifica = true;
		}
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 508, 438);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(25, 28, 150, 14);
		frame.getContentPane().add(lblUsuario);
		
		usuario.setBounds(25, 44, 150, 14);
		frame.getContentPane().add(usuario);
		
		JLabel lblUnidadesAdquiridas = new JLabel("Unidades Adquiridas");
		lblUnidadesAdquiridas.setBounds(185, 28, 150, 14);
		frame.getContentPane().add(lblUnidadesAdquiridas);
		
		unidadesAdquiridas.setBounds(185, 44, 150, 14);
		frame.getContentPane().add(unidadesAdquiridas);
		
		JLabel lblCostoUnitario = new JLabel("Costo Unitario");
		lblCostoUnitario.setBounds(332, 28, 150, 14);
		frame.getContentPane().add(lblCostoUnitario);
		
		costoUnitario.setBounds(332, 44, 150, 14);
		frame.getContentPane().add(costoUnitario);
		
		JLabel lblInformacionDelArticulo = new JLabel("Informaci\u00F3n del Art\u00EDculo");
		lblInformacionDelArticulo.setBounds(25, 144, 150, 14);
		frame.getContentPane().add(lblInformacionDelArticulo);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(25, 169, 150, 14);
		frame.getContentPane().add(lblDescripcion);
		
		descripcion.setBounds(25, 185, 150, 14);
		frame.getContentPane().add(descripcion);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(185, 169, 150, 14);
		frame.getContentPane().add(lblTipo);
		
		tipo.setBounds(185, 185, 138, 14);
		frame.getContentPane().add(tipo);
		
		JLabel lblFechaPedida = new JLabel("Fecha Pedida");
		lblFechaPedida.setBounds(25, 69, 150, 14);
		frame.getContentPane().add(lblFechaPedida);
		
		fechaPedida.setBounds(25, 85, 150, 14);
		frame.getContentPane().add(fechaPedida);
		
		JLabel lblFechaRecibo = new JLabel("Fecha Recibo");
		lblFechaRecibo.setBounds(185, 69, 150, 14);
		frame.getContentPane().add(lblFechaRecibo);
		
		fechaRecibo.setBounds(185, 85, 150, 14);
		frame.getContentPane().add(fechaRecibo);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setBounds(332, 69, 150, 14);
		frame.getContentPane().add(lblProveedor);
		
		proveedor.setBounds(332, 85, 150, 14);
		frame.getContentPane().add(proveedor);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(332, 169, 150, 14);
		frame.getContentPane().add(lblMarca);
		
		marca.setBounds(332, 185, 150, 14);
		frame.getContentPane().add(marca);
		
		JLabel lblPrecioUnitario = new JLabel("Precio Unitario");
		lblPrecioUnitario.setBounds(25, 210, 150, 14);
		frame.getContentPane().add(lblPrecioUnitario);
		
		precioUnitario.setBounds(25, 226, 150, 14);
		frame.getContentPane().add(precioUnitario);
		
		JLabel lblMedidas = new JLabel("Medidas");
		lblMedidas.setBounds(25, 282, 150, 14);
		frame.getContentPane().add(lblMedidas);
		
		JLabel lblAlto = new JLabel("Alto");
		lblAlto.setBounds(25, 307, 150, 14);
		frame.getContentPane().add(lblAlto);
		
		alto.setBounds(25, 323, 150, 14);
		frame.getContentPane().add(alto);
		
		JLabel lblAncho = new JLabel("Ancho");
		lblAncho.setBounds(185, 307, 150, 14);
		frame.getContentPane().add(lblAncho);
		
		ancho.setBounds(185, 323, 150, 14);
		frame.getContentPane().add(ancho);
		
		JLabel lblLargo = new JLabel("Largo");
		lblLargo.setBounds(332, 307, 150, 14);
		frame.getContentPane().add(lblLargo);
		
		largo.setBounds(332, 323, 150, 14);
		frame.getContentPane().add(largo);
		
		JLabel lblMedidaEspecifica = new JLabel("Medida espec\u00EDfica");
		lblMedidaEspecifica.setBounds(25, 307, 150, 14);
		frame.getContentPane().add(lblMedidaEspecifica);

		medidaEspecifica.setBounds(25, 323, 150, 14);
		frame.getContentPane().add(medidaEspecifica);
		
		lblAlto.setVisible(medida_especifica);
		lblAncho.setVisible(medida_especifica);
		lblLargo.setVisible(medida_especifica);
		alto.setVisible(medida_especifica);
		ancho.setVisible(medida_especifica);
		largo.setVisible(medida_especifica);
		
		lblMedidaEspecifica.setVisible(!medida_especifica);
		medidaEspecifica.setVisible(!medida_especifica);
		
	}

}
