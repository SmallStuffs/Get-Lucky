package br.com.getlucky.activity.usuario;

import java.util.Date;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import br.com.getlucky.R;
import br.com.getlucky.dialog.ErrorDialog;
import br.com.getlucky.dialog.InfoDialog;
import br.com.getlucky.entity.Usuario;

public class CadastrarUsuarioActivity extends Activity {

	private EditText editTextNome;
	private DatePicker datePickerDataDeNascimento;
	private Button buttonSalvar;
	
	private Usuario usuario;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {

    	super.onCreate(savedInstanceState);
    	
        setContentView(R.layout.activity_usuario_cadastro);
        
        editTextNome = (EditText) findViewById(R.id.editText_usuario_nome);
		datePickerDataDeNascimento = (DatePicker) findViewById(R.id.datePicker_usuario_dataDeNascimento);
		buttonSalvar = (Button) findViewById(R.id.button_salvar);

		cadastrar();
		
    }

    public void cadastrar() {
		
		buttonSalvar.setOnClickListener(new OnClickListener() {
			
			@SuppressWarnings("deprecation")
			public void onClick(View view) {
				
				Date dataAtual = new Date();
				Date dataSelecionada;
				
				dataSelecionada = new Date(datePickerDataDeNascimento.getYear() - 1900,
						datePickerDataDeNascimento.getMonth(), 
						datePickerDataDeNascimento.getDayOfMonth() -1);
						
			    long tempoDaDataAtual = dataAtual.getTime();
			    long tempoDaDataSelecionada = dataSelecionada.getTime();
			    long tempoDaIdade = (tempoDaDataAtual - tempoDaDataSelecionada);
				 
			    long segundos = tempoDaIdade / 1000;
			    long minutos = segundos / 60;
			    long horas = minutos / 60;
			    long dias = horas / 24;
			    long anos = dias / 365;
			    
			    if(anos >= 18) {
			    	
			    	setUsuario(new Usuario());
					getUsuario().setNome(editTextNome.getText().toString());
					getUsuario().setDataDeNascimento(dataSelecionada);
					
					showUsuarioCadastradoDialog();
					
			    } else
			    	showUsuarioNaoCadastradoDialog();
		    
			}
			
		});
		
	}
	
	public void showUsuarioCadastradoDialog() {
		
		DialogFragment usuarioCadastrado = new InfoDialog();
		
		Bundle bundleUsuarioCadastrado = new Bundle();
		bundleUsuarioCadastrado.putInt("id_mensagem", R.string.mensagem_usuario_cadastrado);
		
		usuarioCadastrado.setArguments(bundleUsuarioCadastrado);
		usuarioCadastrado.show(getFragmentManager(), "usuarioCadastradoDialog");
		
	}
	
	public void showUsuarioNaoCadastradoDialog() {
		
		DialogFragment usuarioNaoCadastrado = new ErrorDialog();
		
		Bundle bundleUsuarioNaoCadastrado = new Bundle();
		bundleUsuarioNaoCadastrado.putInt("id_mensagem", R.string.mensagem_usuario_nao_cadastrado);
		
		usuarioNaoCadastrado.setArguments(bundleUsuarioNaoCadastrado);
		usuarioNaoCadastrado.show(getFragmentManager(), "usuarioCadastradoDialog");
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
}
