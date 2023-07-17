package br.com.prog2.tfinal.controller;

import java.util.List;
import br.com.prog2.tfinal.model.Cliente;
import br.com.prog2.tfinal.persistencia.ClienteDAOImp;

public class ClienteController {
	public String inserir(Cliente cliente) {
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.inserir(cliente);
	}
	
	public String alterar(Cliente cliente) {
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.alterar(cliente);
	}
	
	public String excluir(Cliente cliente) {
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.excluir(cliente);
	}
	
	public List<Cliente> listarTodos() {
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.listarTodos();
	}
	
	public Cliente pesquisarPorCodigo(String codigoCliente) {
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.pesquisarPorCodigo(codigoCliente);
	}
}