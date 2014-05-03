package br.com.getlucky.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import br.com.getlucky.R;

public class ErrorDialog extends DialogFragment {
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		AlertDialog.Builder alertDiaBuilder = new AlertDialog.Builder(getActivity());
		
		alertDiaBuilder.setMessage(getArguments().getInt("id_mensagem"))
				.setNeutralButton(R.string.label_ok, new OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {

			}
			
		});
		
		return alertDiaBuilder.create();
		
	}

}
