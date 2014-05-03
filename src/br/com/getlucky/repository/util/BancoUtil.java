package br.com.getlucky.repository.util;

import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoUtil extends SQLiteOpenHelper {

	private static final String database = "db_getlucky";
	private static final int versao = 1;
	
	private List<String> creates;
	
	public BancoUtil(Context context, List<String> creates) {
		super(context, database, null, versao);
		this.creates = creates;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {

		for (String create : creates) {
			db.execSQL(create);
		}
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
