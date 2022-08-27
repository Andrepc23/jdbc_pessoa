package principal;

import java.util.Scanner;

import controllers.PessoaController;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			System.out.println("(1) Cadastrar pessoa");
			System.out.println("(2) Atualizar pessoa");
			System.out.println("(3) Excluir pessoa");
			System.out.println("(4) Consultar pessoa");
			System.out.println("(5) Listar pessoas");
			
			System.out.print("\n Entre com a opção desejada:");
			Integer opcao = Integer.parseInt(scanner.nextLine());
			
			
			switch(opcao) {
			
			case 1:
				PessoaController.cadastrarPessoa();
				
				break;
			case 2:
				PessoaController.atualizarPessoa();
				
				break;
			case 3:
				PessoaController.excluirPessoa();
				
				break;
			case 4:
				PessoaController.getById();
				
				break;
			case 5:
				PessoaController.consultarPessoas();
				
				break;
			default:
				System.out.println("\nOpção inválida");	
			}
			
			
		}
		catch(Exception e) {
			
			System.out.println("\nError: " + e.getMessage());
		}
		finally {
			
			System.out.print("\nDeseja continuar?  (S,N).....");
			String opcao = scanner.nextLine();
			
			if(opcao.equalsIgnoreCase("S")) {
				main(args);
			}
			else {
				System.out.println("\nAdeus");
				scanner.close();
			}
		}
		
	}
	
}
