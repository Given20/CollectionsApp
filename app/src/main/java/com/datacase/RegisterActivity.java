package com.datacase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    TextView LogInLink;
    Button registerButton;
    EditText etUsername;
    EditText etEmail;
    EditText etPhoneNumber;
    EditText etPassword;
    EditText etConfirmPassword;
    LogIn registerAccount;
    FirebaseDatabase database;
    DatabaseReference datacaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        LogInLink = findViewById(R.id.txtLogInLink);
        registerButton = findViewById(R.id.btnRegister);

        //
        etUsername = findViewById(R.id.etRegisterUsername);
        etEmail = findViewById(R.id.etRegisterEmail);
        etPhoneNumber = findViewById(R.id.etRegisterPhone);
        etPassword = findViewById(R.id.etRegisterPassword);
        etConfirmPassword = findViewById(R.id.etRegisterConfirmPassword);

        // Write a message to the database
        database = FirebaseDatabase.getInstance("https://datacase-73dc4-default-rtdb.firebaseio.com/");
        datacaseRef = database.getReference("LogIn");

        //datacaseRef.setValue("Hello, World!");


        registerButton.setOnClickListener(this);
        LogInLink.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegister:
                register();

                break;
            case R.id.txtLogInLink:
                openLogIn();
                break;
        }
    }

    private void openLogIn() {
        IntentHelper.openIntent(this, LoginActivity.class);
    }

    private void register(){
        registerAccount = new LogIn();

        String Username = etUsername.getText().toString() ;
        String Email = etEmail.getText().toString();
        String PhoneNumber = etPhoneNumber.getText().toString();
        String Password = etPassword.getText().toString();
        String ConfirmPassword = etConfirmPassword.getText().toString();

        if(!TextUtils.isEmpty(Username) && !TextUtils.isEmpty(Email) && !TextUtils.isEmpty(PhoneNumber) && !TextUtils.isEmpty(Password) && !TextUtils.isEmpty(ConfirmPassword)){

            if(TextUtils.equals(Password, ConfirmPassword)){
                registerAccount.setUsername(Username);
                registerAccount.setEmail(Email);
                registerAccount.setPassword(Password);
                registerAccount.setPhoneNumber(PhoneNumber);

                //Add the values to registerAccount
                datacaseRef.push().setValue(registerAccount);

                openLogIn();

            }
            else{
                Toast.makeText(RegisterActivity.this, "Please make sure that your password and confirm password match", Toast.LENGTH_LONG).show();
            }

        }
        else{
            Toast.makeText(RegisterActivity.this, "Please complate all feilds", Toast.LENGTH_LONG).show();
        }

        
    }
}