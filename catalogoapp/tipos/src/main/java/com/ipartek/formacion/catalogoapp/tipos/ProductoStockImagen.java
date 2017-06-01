package com.ipartek.formacion.catalogoapp.tipos;

public class ProductoStockImagen extends Productos {
	private String stock;
	private String rutaImagen;

	// Constructor.
	public ProductoStockImagen(String id, String nombre, String descripcion, String precio, String stock,
			String rutaImagen) {
		super(id, nombre, descripcion, precio);
		this.stock = stock;

		if (rutaImagen == null || rutaImagen == "") {
			this.rutaImagen = "img/sinfoto.jpg";
		} else {
			this.rutaImagen = rutaImagen;
		}
	}

	public ProductoStockImagen() {
		super();
		this.stock = "0";
		this.rutaImagen = "img/sinfoto.jpg";
	}

	public ProductoStockImagen(String id, String nombre, String descripcion, String precio) {
		super(id, nombre, descripcion, precio);

		this.stock = "0";
		this.rutaImagen = "img/sinfoto.jpg";
	}

	// Getters y setters.

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	// Otras funciones.

	@Override
	public String toString() {
		return "ProductoStockImagen [stock=" + stock + ", rutaImagen=" + rutaImagen + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((rutaImagen == null) ? 0 : rutaImagen.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoStockImagen other = (ProductoStockImagen) obj;
		if (rutaImagen == null) {
			if (other.rutaImagen != null)
				return false;
		} else if (!rutaImagen.equals(other.rutaImagen))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		return true;
	}

}



