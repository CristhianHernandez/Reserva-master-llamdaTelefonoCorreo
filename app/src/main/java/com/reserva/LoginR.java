package com.reserva;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.EditText;

public class LoginR extends ActionBarActivity {

    EditText usuario, contra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }
}
