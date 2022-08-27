package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Pessoa;
import factories.ConnectionFactory;
import interfaces.IRepository;

public class PessoaRepository implements IRepository<Pessoa> {

	@Override
	public void create(Pessoa obj) throws Exception {

		// abriu
		Connection connection = ConnectionFactory.getConnection();

		// execução
		PreparedStatement statement = connection.prepareStatement("INSERT INTO PESSOA(NOME, CPF, EMAIL) VALUES(?,?,?)");
		statement.setString(1, obj.getNome());
		statement.setString(2, obj.getCpf());
		statement.setString(3, obj.getEmail());
		statement.execute();

		// fechou
		statement.close();
		connection.close();

	}

	@Override
	public void update(Pessoa obj) throws Exception {

		// abriu
		Connection connection = ConnectionFactory.getConnection();

		// execução
		PreparedStatement statement = connection
				.prepareStatement("UPDATE PESSOA SET NOME = ?, CPF = ?, EMAIL = ? WHERE IDPESSOA = ?");
		statement.setString(1, obj.getNome());
		statement.setString(2, obj.getCpf());
		statement.setString(3, obj.getEmail());
		statement.setInt(4, obj.getIdPessoa());

		statement.execute();

		// fechou
		statement.close();
		connection.close();

	}

	@Override
	public void delete(Integer id) throws Exception {

		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection
				.prepareStatement("DELETE FROM PESSOA WHERE IDPESSOA = ?");
		
		statement.setInt(1, id);
		
		statement.execute();
		
		statement.close();
		connection.close();
		
	}

	@Override
	public List<Pessoa> findAll() throws Exception {

		List<Pessoa> lista = new ArrayList<>();
		
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection
				.prepareStatement("SELECT * FROM PESSOA");
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			
			Pessoa pessoa = new Pessoa();
			pessoa.setIdPessoa(rs.getInt("IDPESSOA"));
			pessoa.setNome(rs.getString("NOME"));
			pessoa.setCpf(rs.getString("CPF"));
			pessoa.setEmail(rs.getString("EMAIL"));
			
			lista.add(pessoa);
			
		}
		
		statement.close();
		rs.close();
		connection.close();
		
		return lista;
	}

	@Override
	public Pessoa getById(Integer id) throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection
				.prepareStatement("SELECT * FROM PESSOA WHERE IDPESSOA = ?");
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		
		Pessoa pessoa = null;
		
		if(rs.next()) {
			
			pessoa = new Pessoa();
			pessoa.setIdPessoa(rs.getInt("IDPESSOA"));
			pessoa.setNome(rs.getString("NOME"));
			pessoa.setCpf(rs.getString("CPF"));
			pessoa.setEmail(rs.getString("EMAIL"));
			
		}
		
		if(pessoa!=null) {
			return pessoa;
		}else {
			throw new Exception("PESSOA NÃO ENCONTRADA");
		}
		
	}

}
