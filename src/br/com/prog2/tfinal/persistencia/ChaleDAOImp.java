package br.com.prog2.tfinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.prog2.tfinal.model.Chale;

public class ChaleDAOImp implements ChaleDAO {

	@Override
	public String inserir(Chale chale) {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "insert into chale(codchale,localizacao,capacidade,valoraltaestacao,valorbaixaestacao) values (?,?,?,?,?)";
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, chale.getCodigo());
			pst.setString(2, chale.getLocalizacao());
			pst.setInt(3, chale.getCapacidade());
			pst.setDouble(4, chale.getValorAltaEstacao());
			pst.setDouble(5, chale.getValorBaixaEstacao());
			
			int retorno = pst.executeUpdate();
			
			if (retorno > 0) {
				return "Inserido com sucesso!";
			} else {
				return "Erro ao inserir!";
			}
		} catch(SQLException e) {
			return "[SQL Exception] " + e.getMessage();
		} finally {
			ConnectionFactory.close(conexao);
		}
	}

	@Override
	public String alterar(Chale chale) {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "update chale set localizacao=?,capacidade=?,valoraltaestacao=?,valorbaixaestacao=? where codchale=?";
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, chale.getLocalizacao());
			pst.setInt(2, chale.getCapacidade());
			pst.setDouble(3, chale.getValorAltaEstacao());
			pst.setDouble(4, chale.getValorBaixaEstacao());
			pst.setString(5, chale.getCodigo());
			
			int retorno = pst.executeUpdate();
			
			if (retorno > 0) {
				return "Alterado com sucesso!";
			} else {
				return "Erro ao alterar!";
			}
		} catch(SQLException e) {
			return "[SQL Exception] " + e.getMessage();
		} finally {
			ConnectionFactory.close(conexao);
		}
	}

	@Override
	public String excluir(Chale chale) {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "delete from chale where codchale=?";
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, chale.getCodigo());
			
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
	public List<Chale> listarTodos() {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "select * from chale";
		
		List<Chale> lista = new ArrayList<>();
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Chale chale = new Chale();
					chale.setCodigo(rs.getString(1));
					chale.setLocalizacao(rs.getString(2));
					chale.setCapacidade(rs.getInt(3));
					chale.setValorAltaEstacao(rs.getDouble(4));
					chale.setValorBaixaEstacao(rs.getDouble(5));
					lista.add(chale);
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
	public Chale pesquisarPorCodigo(String codigoChale) {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "select * from chale where codchale=?";
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, codigoChale);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Chale chale = new Chale();
				chale.setCodigo(rs.getString(1));
				chale.setLocalizacao(rs.getString(2));
				chale.setCapacidade(rs.getInt(3));
				chale.setValorAltaEstacao(rs.getDouble(4));
				chale.setValorBaixaEstacao(rs.getDouble(5));
				return chale;
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
