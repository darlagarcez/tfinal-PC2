package br.com.prog2.tfinal.model;

import java.io.Serializable;

public class Telefone implements Serializable {
    private static final long serialVersionUID = 1L;
    private String telefone;
    private String codCliente;
    private String tipo;
    
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
