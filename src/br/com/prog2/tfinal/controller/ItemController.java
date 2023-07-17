package br.com.prog2.tfinal.controller;

import java.util.List;
import br.com.prog2.tfinal.model.Item;
import br.com.prog2.tfinal.persistencia.ItemDAOImp;

public class ItemController {
	public String inserir(Item item) {
		ItemDAOImp dao = new ItemDAOImp();
		return dao.inserir(item);
	}
	public String alterar(Item item) {
		ItemDAOImp dao = new ItemDAOImp();
		return dao.alterar(item);
	}
	public String excluir(Item item) {
		ItemDAOImp dao = new ItemDAOImp();
		return dao.excluir(item);
	}
	public List<Item> listarTodos() {
		ItemDAOImp dao = new ItemDAOImp();
		return dao.listarTodos();
	}
	public Item pesquisarPorNome(String nomeItem) {
		ItemDAOImp dao = new ItemDAOImp();
		return dao.pesquisarPorNome(nomeItem);
	}
}
