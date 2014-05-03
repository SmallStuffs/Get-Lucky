package br.com.getlucky.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import br.com.getlucky.R;
import br.com.getlucky.activity.usuario.CadastrarUsuarioActivity;
import br.com.getlucky.adapter.UsuarioArrayAdapter;
import br.com.getlucky.entity.Usuario;
import br.com.getlucky.repository.UsuarioRepository;

public class MainActivity extends Activity {

	private Button buttonCadastrarUsuario;
	private ListView listView;
	
	private UsuarioRepository usuarioRepository;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {

    	super.onCreate(savedInstanceState);
    	
        setContentView(R.layout.activity_main);
        
        buttonCadastrarUsuario = (Button) findViewById(R.id.button_cadastrar_usuario);
        listView = (ListView) findViewById(R.id.listView_usuarios_cadastrados);
        
        cadastrarUsuario();
        popularListaDeUsuarios();

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
    
    @Override
    protected void onRestart() {
    	
    	popularListaDeUsuarios();
    	super.onRestart();
    	
    }
    
    public void cadastrarUsuario() {
   	 
    	buttonCadastrarUsuario.setOnClickListener(new OnClickListener() {
 
			public void onClick(View view) {
				
				Intent intentCadastrarUsuarioActivity = new Intent(MainActivity.this, CadastrarUsuarioActivity.class);
				startActivity(intentCadastrarUsuarioActivity);
                
			}
 
		});
 
	}
    
    public void popularListaDeUsuarios() {
    	
    	usuarioRepository = new UsuarioRepository(this);
    	
    	List<Usuario> usuarios = usuarioRepository.consultar();
    	
    	if(usuarios == null)
    		usuarios = new ArrayList<Usuario>();
    	
    	ArrayAdapter<Usuario> arrayAdapter = new UsuarioArrayAdapter(this, android.R.layout.simple_list_item_1, usuarios);
    	
    	listView.setAdapter(arrayAdapter);
    	
    }

}