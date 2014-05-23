package br.com.getlucky.activity.aposta;

import android.app.Activity;
import android.os.Bundle;
import br.com.getlucky.R;

public class GerarApostaActivity extends Activity {
	
	private static final int quantidadeDeNumeros = 60;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_aposta_gerar_aposta);

	}

}