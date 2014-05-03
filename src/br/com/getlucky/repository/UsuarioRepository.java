package br.com.getlucky.repository;

public class UsuarioRepository {
	
	private static final String tabela = "tb_usuario";
	
	public static final String create = "CREATE TABLE " + tabela + " " + 
			"(id INT PRIMARY KEY, " +
			"nome TEXT, " +
			"data_de_nascimento DATE)";
	
}
