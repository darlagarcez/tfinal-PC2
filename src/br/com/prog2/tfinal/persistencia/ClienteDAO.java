package br.com.prog2.tfinal.persistencia;

import java.util.List;
import br.com.prog2.tfinal.model.Cliente;

public interface ClienteDAO {
	public String inserir(Cliente cliente);
	public String alterar(Cliente cliente);
	public String excluir(Cliente cliente);
	public List<Cliente> listarTodos();
	public Cliente pesquisarPorCodigo(String codigoCliente);
}
