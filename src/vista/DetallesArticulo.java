package vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import mongodb.Articulo;
import mongodb.Consulta;

public class DetallesArticulo {

	private JFrame frame;
	
	private JLabel tipo, marca, descripcion, alto, stock, precioUnitario, ancho, largo, medidaEspecifica;

	String _id;
	
	boolean medida_especifica;
	
	public DetallesArticulo(String _id) {
		this._id = _id;
		setLabels(tipo, marca, descripcion, alto, stock, precioUnitario, ancho, largo, medidaEspecifica);
		initialize();
		frame.setVisible(true);
	}
	
	private void setLabels(JLabel tipo, JLabel marca, JLabel descripcion, JLabel alto, JLabel stock, JLabel precioUnitario, JLabel ancho,
			JLabel largo, JLabel medidaEspecifica) {
		Consulta consulta = new Consulta();
		Articulo articulo = consulta.getArticulo(_id);
		this.tipo = new JLabel(articulo.get_nombretipo());
		this.marca = new JLabel(articulo.get_nombremarca());
		this.descripcion = new JLabel(articulo.get_descripcion());
		this.alto = new JLabel(String.valueOf(articulo.get_medida().get_alto()));
		this.stock = new JLabel(String.valueOf(articulo.get_stock()));
		this.precioUnitario = new JLabel(String.valueOf(articulo.get_preciounitario()));
		this.ancho = new JLabel(String.valueOf(articulo.get_medida().get_ancho()));
		this.largo = new JLabel(String.valueOf(articulo.get_medida().get_largo()));
		this.medidaEspecifica = new JLabel(articulo.get_medida().get_medidaespecifica());
		
		if (articulo.get_medida().get_alto() == 0 && articulo.get_medida().get_ancho() == 0 && articulo.get_medida().get_largo() == 0) {
			medida_especifica = false;
		} else {
			medida_especifica = true;
		}
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 508, 438);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(25, 28, 150, 14);
		frame.getContentPane().add(lblTipo);
		
		tipo.setBounds(25, 44, 150, 14);
		frame.getContentPane().add(tipo);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(185, 28, 150, 14);
		frame.getContentPane().add(lblMarca);
		
		marca.setBounds(185, 44, 150, 14);
		frame.getContentPane().add(marca);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(332, 28, 150, 14);
		frame.getContentPane().add(lblDescripcion);
		
		descripcion.setBounds(332, 44, 150, 14);
		frame.getContentPane().add(descripcion);
		
		JLabel lblMedidas = new JLabel("Medidas");
		lblMedidas.setBounds(25, 124, 150, 14);
		frame.getContentPane().add(lblMedidas);
		
		JLabel lblAlto = new JLabel("Alto");
		lblAlto.setBounds(25, 153, 150, 14);
		frame.getContentPane().add(lblAlto);
		
		alto.setBounds(25, 169, 150, 14);
		frame.getContentPane().add(alto);
		
		stock.setBounds(25, 85, 150, 14);
		frame.getContentPane().add(stock);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(25, 69, 150, 14);
		frame.getContentPane().add(lblStock);
		
		precioUnitario.setBounds(185, 85, 150, 14);
		frame.getContentPane().add(precioUnitario);
		
		JLabel lblPrecioUnitario = new JLabel("Precio Unitario");
		lblPrecioUnitario.setBounds(185, 69, 150, 14);
		frame.getContentPane().add(lblPrecioUnitario);
		
		JLabel lblAncho = new JLabel("Ancho");
		lblAncho.setBounds(25, 194, 150, 14);
		frame.getContentPane().add(lblAncho);
		
		ancho.setBounds(25, 210, 150, 14);
		frame.getContentPane().add(ancho);
		
		JLabel lblLargo = new JLabel("Largo");
		lblLargo.setBounds(25, 235, 150, 14);
		frame.getContentPane().add(lblLargo);
		
		largo.setBounds(25, 251, 150, 14);
		frame.getContentPane().add(largo);
		
		JLabel lblMedidaEspecifica = new JLabel("Medida espec\u00EDfica");
		lblMedidaEspecifica.setBounds(25, 153, 150, 14);
		frame.getContentPane().add(lblMedidaEspecifica);
		
		medidaEspecifica.setBounds(25, 169, 150, 14);
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
