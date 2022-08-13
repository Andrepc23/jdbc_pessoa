package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	}

	@Override
	public List<Pessoa> findAll() throws Exception {

		return null;
	}

}
