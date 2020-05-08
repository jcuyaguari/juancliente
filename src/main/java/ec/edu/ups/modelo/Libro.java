package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Libro implements Serializable {
	private static  final long serialVersionUID =1L;
	
	private int id;
	private String codigo;
	private String nombre;
	private String aniopublicacion;
	
	@OneToMany(mappedBy = "libro", cascade = CascadeType.ALL)
	private List<Detalle>detalle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAniopublicacion() {
		return aniopublicacion;
	}

	public void setAniopublicacion(String aniopublicacion) {
		this.aniopublicacion = aniopublicacion;
	}

	public List<Detalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<Detalle> detalle) {
		this.detalle = detalle;
	}
	
	
}
