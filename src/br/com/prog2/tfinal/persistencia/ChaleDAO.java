package br.com.prog2.tfinal.persistencia;

import java.util.List;
import br.com.prog2.tfinal.model.Chale;

public interface ChaleDAO {
	public String inserir(Chale chale);
	public String alterar(Chale chale);
	public String excluir(Chale chale);
	public List<Chale> listarTodos();
	public Chale pesquisarPorCodigo(String codigoChale);
}
