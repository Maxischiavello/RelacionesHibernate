package es.conexionHibernate;

import javax.persistence.*;

@Entity
@Table(name="detalles_cliente")
public class DetallesCliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="web")
	private String web;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="comentarios")
	private String comentarios;
	
	@OneToOne(mappedBy="detallesCliente")
	private Cliente cliente;

	
	public DetallesCliente() {
	}

	
	public DetallesCliente(String web, String telefono, String comentarios) {
		this.web = web;
		this.telefono = telefono;
		this.comentarios = comentarios;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "DetallesCliente [id=" + id + ", web=" + web + ", telefono=" + telefono + ", comentarios=" + comentarios
				+ "]";
	}

}
