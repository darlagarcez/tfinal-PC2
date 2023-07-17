package br.com.prog2.tfinal.persistencia;

import java.util.List;
import br.com.prog2.tfinal.model.ChaleItem;

public interface ChaleItemDAO {
	public String inserir(ChaleItem item);
	public String excluir(ChaleItem item);
	public List<ChaleItem> listarTodos();
	public ChaleItem pesquisarPorChaleENome(String codChale, String nomeItem);
}
