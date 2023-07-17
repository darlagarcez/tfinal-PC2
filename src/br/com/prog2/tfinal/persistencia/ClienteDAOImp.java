package br.com.prog2.tfinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import br.com.prog2.tfinal.model.Cliente;

public class ClienteDAOImp implements ClienteDAO {

	@Override
	public String inserir(Cliente cliente) {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "insert into cliente(codcliente,rgcliente,nomecliente,enderecocliente,bairrocliente,cidadecliente,estadocliente,cepcliente,nascimentocliente) values (?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, cliente.getCodigo());
			pst.setString(2, cliente.getRg());
			pst.setString(3, cliente.getNome());
			pst.setString(4, cliente.getEndereco());
			pst.setString(5, cliente.getBairro());
			pst.setString(6, cliente.getCidade());
			pst.setString(7, cliente.getEstado());
			pst.setString(8, cliente.getCep());
			pst.setObject(9, cliente.getNascimento());
			
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
	public String alterar(Cliente cliente) {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "update cliente set rgcliente=?,nomecliente=?,enderecocliente=?,bairrocliente=?,cidadecliente=?,estadocliente=?,cepcliente=?,nascimentocliente=? where codcliente=?";
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, cliente.getRg());
			pst.setString(2, cliente.getNome());
			pst.setString(3, cliente.getEndereco());
			pst.setString(4, cliente.getBairro());
			pst.setString(5, cliente.getCidade());
			pst.setString(6, cliente.getEstado());
			pst.setString(7, cliente.getCep());
			pst.setObject(8, cliente.getNascimento());
			pst.setString(9, cliente.getCodigo());
			
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
	public String excluir(Cliente cliente) {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "delete from cliente where codcliente=?";
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, cliente.getCodigo());
			
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
	public List<Cliente> listarTodos() {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "select * from cliente";
		
		List<Cliente> lista = new ArrayList<>();
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setCodigo(rs.getString(1));
					cliente.setRg(rs.getString(2));
					cliente.setNome(rs.getString(3));
					cliente.setEndereco(rs.getString(4));
					cliente.setBairro(rs.getString(5));
					cliente.setCidade(rs.getString(6));
					cliente.setEstado(rs.getString(7));
					cliente.setCep(rs.getString(8));
					cliente.setNascimento(rs.getObject(9, LocalDate.class));
					lista.add(cliente);
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
	public Cliente pesquisarPorCodigo(String codigoCliente) {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "select * from cliente where codcliente=?";
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, codigoCliente);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setCodigo(rs.getString(1));
				cliente.setRg(rs.getString(2));
				cliente.setNome(rs.getString(3));
				cliente.setEndereco(rs.getString(4));
				cliente.setBairro(rs.getString(5));
				cliente.setCidade(rs.getString(6));
				cliente.setEstado(rs.getString(7));
				cliente.setCep(rs.getString(8));
				cliente.setNascimento(rs.getObject(9, LocalDate.class));
				return cliente;
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
