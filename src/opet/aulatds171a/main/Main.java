package opet.aulatds171a.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Vector;

import opet.aulatds171a.pessoa.Pessoa;
import opet.aulatds171a.utilitario.Leitor;

public class Main {
	
	private static final int LIMITE_PESSOAS = 2000000;
	
	public static void main(String[] args) {
		
		// Informa aqui quantos objetos Pessoa deseja criar
		
		
		Pessoa[] arrPessoa = new Pessoa[LIMITE_PESSOAS];
		
		/**
		 * 
		 * Modelo anterior, utilizando Array
		 */
		
		/*for(int i=0;i<LIMITE_PESSOAS;i++) {
			arrPessoa[i] = montarPessoa();
		}
		// Listando todos os objetos Pessoa 
		for(int i=0;i<arrPessoa.length;i++) {

			System.out.println("Nome:"+arrPessoa[i].getNome());
			System.out.println("Sexo:"+arrPessoa[i].getSexo());
			System.out.println("Nome:"+arrPessoa[i].getDataNascimento()); 
		} */
		
		
		/**
		 * Exemplo usando ArrayList
		 */ 		 
		  
		long tInicio = System.currentTimeMillis();
		//ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		
		/* Utilizando Vector */
		Vector<Pessoa> listaPessoas = new Vector<Pessoa>(); // tempo add=327 ms  tempo remove 15ms
		
		/* Utilizando LinkedList */
		//LinkedList<Pessoa> listaPessoas = new LinkedList<Pessoa>(); // tempo add=272ms  tempo remove 17ms
		
		/* Insere pessoas na lista*/
		for(int i=0; i<LIMITE_PESSOAS;i++) {
			
			//listaPessoas.add(montarPessoa() );  
			listaPessoas.add(new Pessoa("Tiago", "M", new Date("12/31/2017")));
		}
		long tFim = System.currentTimeMillis();
		System.out.println("ArrayList.add() :: " +(tFim - tInicio)+" ms");
		
		/* Lista as pessoas constantes no ArrayList */
		tInicio = System.currentTimeMillis();
		for (Pessoa pessoa : listaPessoas) {
			//System.out.println("Nome: "+pessoa.getNome());
			//System.out.println("Sexo: "+pessoa.getSexo());
			//System.out.println("Data: "+pessoa.getDataNascimento());
		}
		tFim = System.currentTimeMillis();
		System.out.println("ArrayList.get() :: " +(tFim - tInicio)+" ms");
		
		/**
		 * Remove elementos do ArrayList
		 */
		long tInicioRemove = System.currentTimeMillis();
		for(int i=listaPessoas.size()-1; i >- 1;i--) {
			
			listaPessoas.remove(i);  
		}
		long tFimRemove = System.currentTimeMillis();
		System.out.println("ArrayList.remove() :: " +(tFimRemove - tInicioRemove)+" ms");
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
