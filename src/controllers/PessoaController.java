package controllers;

import java.util.List;

import javax.swing.JOptionPane;

import entities.Pessoa;
import repositories.PessoaRepository;

public class PessoaController {
	
	private static PessoaRepository pr = new PessoaRepository();
	
	public static void cadastrarPessoa() {
		
		try {
			JOptionPane.showMessageDialog(null, "CADASTRO DE PESSOA");
			Pessoa pessoa = new Pessoa();
			pessoa.setNome(JOptionPane.showInputDialog("Digite o nome: "));
			pessoa.setCpf(JOptionPane.showInputDialog("Digite o Cpf: "));
			pessoa.setEmail(JOptionPane.showInputDialog("Digite o email: "));
		
			pr.create(pessoa);
			JOptionPane.showMessageDialog(null, "CADASTRO EFETUADO COM SUCESSO");
		}
		catch(Exception e) {
			
			System.out.println("\nError: " + e.getMessage());
		}
	}
	
	public static void atualizarPessoa() {
		
		try {
			JOptionPane.showMessageDialog(null, "ATUALIZAR PESSOA");
			Pessoa pessoa = pr.getById(Integer.parseInt(JOptionPane.showInputDialog("Digite o id")));
			
			if(pessoa!=null) {
			pessoa.setNome(JOptionPane.showInputDialog("Digite o nome: "));
			pessoa.setCpf(JOptionPane.showInputDialog("Digite o Cpf: "));
			pessoa.setEmail(JOptionPane.showInputDialog("Digite o email: "));
			
			pr.update(pessoa);
			JOptionPane.showMessageDialog(null, "ATUALIZAÇÃO FEITA COM SUCESSO");
			}
			
		}
		catch(Exception e) {
			
			System.out.println("\nError: " + e.getMessage());
		}
		
	}
	
	public static void excluirPessoa() {
		
		try {
			JOptionPane.showMessageDialog(null, "DELETAR PESSOA");
			Pessoa pessoa = pr.getById(Integer.parseInt(JOptionPane.showInputDialog("Digite o id")));
			
			if(pessoa != null) {
				
				pr.delete(pessoa.getIdPessoa());
				JOptionPane.showMessageDialog(null, "DELETADO COM SUCESSO");

			}
			
			
		}
		catch(Exception e) {
			
			System.out.println("\nError: " + e.getMessage());
		}
	}
	
	
	public static void consultarPessoas() {
		
		try {
			
			System.out.println("\n *** CONSULTA DE PESSOAS *** \n");
			
			List<Pessoa> lista = pr.findAll();
			
			for(Pessoa p : lista) {
				
				System.out.println(p);
				
				
			}
			
			
			
		}
		catch(Exception e){
			
			System.out.println("\nError: " + e.getMessage());

		}
	}
	
	
	
	public static void getById() {
		
		try {
			
			Pessoa pessoa = pr.getById(Integer.parseInt(JOptionPane.showInputDialog("Digite o id")));
			
			System.out.println(pessoa);
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
}
