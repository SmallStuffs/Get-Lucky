package br.com.getlucky.repository;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import br.com.getlucky.entity.Usuario;

public class UsuarioRepository extends SQLiteOpenHelper implements InterfaceRepository {

	public UsuarioRepository(Context context) {
		super(context, database, null, versao);
	}

	private static final String tabela = "tb_usuario";
	
	public static final String create = "CREATE TABLE " + tabela + " " + 
			"(id INT PRIMARY KEY, " +
			"nome TEXT, " +
			"data_de_nascimento TEXT);";
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(create);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	
	public List<Usuario> consultar() {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		Cursor cursor = getReadableDatabase().rawQuery("SELECT * from " + tabela + ";", null);
		
		while(cursor.moveToNext()) {

			Usuario usuario = recuperarUsuarioDoCursor(cursor);
			usuarios.add(usuario);
			
		}
		
		cursor.close();
		
		return usuarios;
		
	}
	
	public void inserir(Usuario usuario) {
		
		ContentValues contentValues = new ContentValues();
		contentValues.put("nome", usuario.getNome());
		contentValues.put("data_de_nascimento", usuario.getDataDeNascimento().toString());
		
		getWritableDatabase().insert(tabela, null, contentValues);
		
	}
	
	public Usuario recuperarUsuarioDoCursor(Cursor cursor) {
		
		Usuario usuario = new Usuario();
		
		usuario.setNome(cursor.getString(cursor.getColumnIndex("nome")));
		usuario.setDataDeNascimento(cursor.getString(cursor.getColumnIndex("data_de_nascimento")));
		
		return usuario;
		
	}

}
