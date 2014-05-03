package br.com.getlucky.repository.util;

import java.util.ArrayList;
import java.util.List;

import br.com.getlucky.repository.UsuarioRepository;

public class CreateUtil {
	
	public static List<String> prepararCreates() {
		
		List<String> creates = new ArrayList<String>();
		creates.add(UsuarioRepository.create);
		
		return creates;
		
	}

}
