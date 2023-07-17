package br.com.prog2.tfinal.persistencia;

import java.util.List;
import br.com.prog2.tfinal.model.Item;

public interface ItemDAO {
	public String inserir(Item item);
	public String alterar(Item item);
	public String excluir(Item item);
	public List<Item> listarTodos();
	public Item pesquisarPorNome(String nomeItem);
}
