package com.reserva;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad2 extends Activity {

	String nombre = "", fecha = "", hora = "";
	int personas = 0;
	TextView muestraDatos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actividad2);

		muestraDatos = (TextView) findViewById(R.id.muestraDatos);

		Bundle recibe = new Bundle();
		recibe = this.getIntent().getExtras();

		nombre = recibe.getString("nombre");
		personas = recibe.getInt("personas");
		fecha = recibe.getString("fecha");
		hora = recibe.getString("hora");

		muestraDatos.setText("Reservacion a nombre de:\n" + nombre + "\n" + personas
				+ " personas\nFecha: " + fecha + "\nHora: " + hora + "\n");

	}

	public void llamada(View v)
	{
		Intent llamar = new Intent(Intent.ACTION_CALL, Uri.parse("tel:5591307206"));
		startActivity(llamar);
	}

	public void correo(View vista)
	{

			Intent correos = new Intent(Intent.ACTION_SEND);
			correos.setType("text/plain");
			correos.putExtra(Intent.EXTRA_SUBJECT, "Asunto: Reservacion realizada");
			correos.putExtra(Intent.EXTRA_TEXT, "La fecha de  nuetra reunion será el día "+fecha+"a las "+hora + "el lugar es "
			);
			correos.putExtra(Intent.EXTRA_EMAIL, new String[] { "eoropezag@ipn.mx"} );
			startActivity(correos);

	}

    public void hacerOtraReserva(View v) {
        Intent envia = new Intent(this, MainActivity.class);
        finish();
        startActivity(envia);
    }

}
