package opet.aulatds171a.main;

import java.util.Date;

import opet.aulatds171a.pessoa.Pessoa;
import opet.aulatds171a.utilitario.Leitor;

public class Main {
	
	private static final int LIMITE_PESSOAS = 2;
	
	public static void main(String[] args) {
		
		// Informa aqui quantos objetos Pessoa deseja criar
		
		
		Pessoa[] arrPessoa = new Pessoa[LIMITE_PESSOAS];
		for(int i=0;i<LIMITE_PESSOAS;i++) {
			arrPessoa[i] = montarPessoa();
		}
		
		/* Listando todos os objetos Pessoa */
		for(int i=0;i<arrPessoa.length;i++) {

			System.out.println("Nome:"+arrPessoa[i].getNome());
			System.out.println("Sexo:"+arrPessoa[i].getSexo());
			System.out.println("Nome:"+arrPessoa[i].getDataNascimento()); 
		}

	}
	
	static Pessoa montarPessoa()
	{
		String nome = Leitor.readString("Entre com o nome:");
		String sexo = Leitor.readString("Entre com o sexo:");
		String dataNascimento = Leitor.readString("Entre com oa data de nascimento:");
		
		Pessoa novaPessoa = new Pessoa(nome, sexo,
				new Date(dataNascimento) );
		
		return novaPessoa;
	}

}
