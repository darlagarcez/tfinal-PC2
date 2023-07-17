package br.com.prog2.tfinal.controller;

import java.util.List;
import br.com.prog2.tfinal.model.Telefone;
import br.com.prog2.tfinal.persistencia.TelefoneDAOImp;

public class TelefoneController {
	public String inserir(Telefone telefone) {
		TelefoneDAOImp dao = new TelefoneDAOImp();
		return dao.inserir(telefone);
	}
	public String alterar(Telefone telefone) {
		TelefoneDAOImp dao = new TelefoneDAOImp();
		return dao.alterar(telefone);
	}
	public String excluir(Telefone telefone) {
		TelefoneDAOImp dao = new TelefoneDAOImp();
		return dao.excluir(telefone);
	}
	public List<Telefone> listarTodos() {
		TelefoneDAOImp dao = new TelefoneDAOImp();
		return dao.listarTodos();
	}
	public Telefone pesquisarPorCliente(String codCliente) {
		TelefoneDAOImp dao = new TelefoneDAOImp();
		return dao.pesquisarPorCliente(codCliente);
	}
}
