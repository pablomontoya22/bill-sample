package principal;

public class Item {
	public Integer cantidad;
	public String nombre;
	public Double precio;
	public Double IVA;
	public Item(Integer cantidad, String nombre, Double precio, Double iVA) {
		super();
		this.cantidad = cantidad;
		this.nombre = nombre;
		this.precio = precio;
		IVA = iVA;
	}
	public Item() {
		super();
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Double getIVA() {
		return IVA;
	}
	public void setIVA(Double iVA) {
		IVA = iVA;
	}

}
