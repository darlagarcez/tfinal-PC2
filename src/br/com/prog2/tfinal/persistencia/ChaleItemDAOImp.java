package br.com.prog2.tfinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.prog2.tfinal.model.ChaleItem;

public class ChaleItemDAOImp implements ChaleItemDAO {

	@Override
	public String inserir(ChaleItem item) {
		String sql = "insert into chale_item(codchale,nome_item) values (?,?)";
		Connection conexao = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, item.getCodChale());
			pst.setString(2, item.getNomeItem());
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
	public String excluir(ChaleItem item) {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "delete from chale_item where codchale=? and nome_item=?";
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, item.getCodChale());
			pst.setString(2, item.getNomeItem());
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
	public List<ChaleItem> listarTodos() {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "select * from chale_item";
		
		List<ChaleItem> lista = new ArrayList<>();
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					ChaleItem item = new ChaleItem();
					item.setCodChale(rs.getString(1));
					item.setNomeItem(rs.getString(2));
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
	public ChaleItem pesquisarPorChaleENome(String codChale, String nomeItem) {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "select * from chale_item where codchale=? and nome_item=?";
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, codChale);
			pst.setString(2, nomeItem);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				ChaleItem item = new ChaleItem();
				item.setCodChale(rs.getString(1));
				item.setNomeItem(rs.getString(2));
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
