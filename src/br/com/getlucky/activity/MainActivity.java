package br.com.getlucky.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import br.com.getlucky.R;
import br.com.getlucky.activity.usuario.CadastrarUsuarioActivity;
import br.com.getlucky.repository.util.BancoUtil;
import br.com.getlucky.repository.util.CreateUtil;

public class MainActivity extends Activity {

	private Button buttonCadastrarUsuario;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {

    	super.onCreate(savedInstanceState);
    	
        setContentView(R.layout.activity_main);
        
        buttonCadastrarUsuario = (Button) findViewById(R.id.button_cadastrar_usuario);
        
        cadastrarUsuario();
        executarCreates();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        getMenuInflater().inflate(R.menu.main, menu);
        
        return true;
        
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

    	int id = item.getItemId();
    	
        if (id == R.id.action_settings)
            return true;

        return super.onOptionsItemSelected(item);
        
    }
    
    public void cadastrarUsuario() {
   	 
    	buttonCadastrarUsuario.setOnClickListener(new OnClickListener() {
 
			public void onClick(View view) {
				
				Intent intentCadastrarUsuarioActivity = new Intent(MainActivity.this, CadastrarUsuarioActivity.class);
				startActivity(intentCadastrarUsuarioActivity);
                
			}
 
		});
 
	}
    
    public void executarCreates() {
    	
    	new BancoUtil(this, CreateUtil.prepararCreates());
    	
    }

}
