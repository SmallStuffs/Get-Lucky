package br.com.getlucky.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import br.com.getlucky.R;
import br.com.getlucky.activity.aposta.GerarApostaActivity;

public class MenuActivity extends Activity {

	private TextView textViewNomeDoUsuario;
	
	private Button buttonTrocarApostador;
	private Button buttonNovaAposta;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {

    	super.onCreate(savedInstanceState);
    	
        setContentView(R.layout.activity_menu);
        
        textViewNomeDoUsuario = (TextView) findViewById(R.id.textView_usuario_nome);
        textViewNomeDoUsuario.setText(getIntent().getExtras().getString("usuario_nome"));
        
        novaAposta();
        trocarApostador();
        
    }

	public void novaAposta() {
		
		buttonNovaAposta = (Button) findViewById(R.id.button_nova_aposta);
		buttonNovaAposta.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Intent intentGerarApostaActivity = new Intent(MenuActivity.this, GerarApostaActivity.class);
				
				startActivity(intentGerarApostaActivity);
				
			}
		});
		
	}
	
    public void trocarApostador() {
    	
    	buttonTrocarApostador = (Button) findViewById(R.id.button_trocar_apostador);
    	buttonTrocarApostador.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
			}
			
		});
    	
    }

}
