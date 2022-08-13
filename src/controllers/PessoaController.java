package controllers;

import javax.swing.JOptionPane;

import entities.Pessoa;
import repositories.PessoaRepository;

public class PessoaController {
	
	public static void cadastrarPessoa() {
		
		try {
			JOptionPane.showMessageDialog(null, "CADASTRO DE PESSOA");
			Pessoa pessoa = new Pessoa();
			pessoa.setNome(JOptionPane.showInputDialog("Digite o nome: "));
			pessoa.setCpf(JOptionPane.showInputDialog("Digite o Cpf: "));
			pessoa.setEmail(JOptionPane.showInputDialog("Digite o email: "));
			
			PessoaRepository pr = new PessoaRepository();
			pr.create(pessoa);
			JOptionPane.showMessageDialog(null, "CADASTRO EFETUADO COM SUCESSO");
		}
		catch(Exception e) {
			
			System.out.println("\nError: " + e.getMessage());
		}
	}
	

}
