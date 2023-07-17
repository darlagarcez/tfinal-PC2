package br.com.prog2.tfinal.persistencia;

import java.util.List;
import br.com.prog2.tfinal.model.Telefone;

public interface TelefoneDAO {
	public String inserir(Telefone telefone);
	public String alterar(Telefone telefone);
	public String excluir(Telefone telefone);
	public List<Telefone> listarTodos();
	public Telefone pesquisarPorCliente(String codCliente);
}
