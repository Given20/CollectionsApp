package com.datacase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WalcomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button logIn;
    Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walcome);

        logIn = findViewById(R.id.btnWalcomeLogIn);
        Register = findViewById(R.id.btnWalcomeRegister);

        logIn.setOnClickListener(this);
        Register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnWalcomeLogIn:
                IntentHelper.openIntent(this, LoginActivity.class);
                break;
            case R.id.btnWalcomeRegister:
                IntentHelper.openIntent(this, RegisterActivity.class);
                break;
        }
    }
}