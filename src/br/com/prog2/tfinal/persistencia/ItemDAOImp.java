package br.com.prog2.tfinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.prog2.tfinal.model.Item;

public class ItemDAOImp implements ItemDAO {

	@Override
	public String inserir(Item item) {
		String sql = "insert into item(nome_item,descricao_item) values (?,?)";
		Connection conexao = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, item.getNome());
			pst.setString(2, item.getDescricao());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Inserido com sucesso!";
			} else {
				return "Erro ao inserir!";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(conexao);
		}
	}

	@Override
	public String alterar(Item item) {
		String sql = "update item set descricao_item=? where nome_item=?";
		Connection conexao = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, item.getDescricao());
			pst.setString(2, item.getNome());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Alterado com sucesso!";
			} else {
				return "Erro ao alterar!";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(conexao);
		}
	}

	@Override
	public String excluir(Item item) {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "delete from item where nome_item=?";
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, item.getNome());
			int retorno = pst.executeUpdate();
			
			if (retorno > 0) {
				return "Excluído com sucesso!";
			} else {
				return "Erro ao excluir!";
			}
		} catch(SQLException e) {
			return "[SQL Exception] " + e.getMessage();
		} finally {
			ConnectionFactory.close(conexao);
		}
	}

	@Override
	public List<Item> listarTodos() {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "select * from item";
		
		List<Item> lista = new ArrayList<>();
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Item item = new Item();
					item.setNome(rs.getString(1));
					item.setDescricao(rs.getString(2));
					lista.add(item);
				}
				return lista;
			} else {
			return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(conexao);
		}
	}

	@Override
	public Item pesquisarPorNome(String nomeItem) {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "select * from item where nome_item=?";
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, nomeItem);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Item item = new Item();
				item.setNome(rs.getString(1));
				item.setDescricao(rs.getString(2));
				return item;
			} else {
			return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(conexao);
		}
	}
}
