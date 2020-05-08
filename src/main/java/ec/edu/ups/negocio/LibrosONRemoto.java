package ec.edu.ups.negocio;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.modelo.Autor;
import ec.edu.ups.modelo.Detalle;
import ec.edu.ups.modelo.Libro;

@Remote
public interface LibrosONRemoto {
	public void guardarLibro(List<Detalle> detalleLibro);
	//public void listarLibro(int codigo);
	public List<Libro> getDetalles(String codigo);
	public List<Autor> getAutoresAll();
}