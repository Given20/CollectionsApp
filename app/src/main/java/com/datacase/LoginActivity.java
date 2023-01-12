package com.datacase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_PERMISSION = 100;
    EditText etUsername;
    EditText etPassword;
    Button LogInbutton;
    TextView registerLink;
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://datacase-73dc4-default-rtdb.firebaseio.com/");
    DatabaseReference datacaseRef = database.getReference("LogIn");
    List<LogIn> List;
    private String appName = "DataCase";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        List = new ArrayList<>();

        LogInbutton = findViewById(R.id.btnLogIn);
        registerLink = findViewById(R.id.txtRegisterLink);

        etUsername = findViewById(R.id.etLogInUsername);
        etPassword = findViewById(R.id.etLogInPassword);

        LogInbutton.setOnClickListener(this);
        registerLink.setOnClickListener(this);

        // Read from the database
        datacaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //
                for(DataSnapshot pulledAccounts: dataSnapshot.getChildren() ){
                    LogIn details = pulledAccounts.getValue(LogIn.class);
                    List.add(details);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                //
                Toast.makeText(LoginActivity.this, "Error Reading From Database", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnLogIn:
                LogIn();
                break;
            case R.id.txtRegisterLink:
                OpenRegisterActivity();
                break;
        }

    }

    private void LogIn()
    {
        String Username = etUsername.getText().toString() ;
        String Password = etPassword.getText().toString();
        Boolean LogedIn = false;

        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERMISSION);



        for(LogIn Account: List){
            if(TextUtils.equals(Username, Account.getUsername()) && TextUtils.equals(Password, Account.getPassword())){
                if(ActivityCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    createFile();
                    IntentHelper.openIntent(this, MainActivity.class);
                    Toast.makeText(LoginActivity.this, "Log In Successful", Toast.LENGTH_LONG).show();
                    LogedIn = true;
                }

            }
        }

        if (LogedIn == false){
            Toast.makeText(LoginActivity.this, "Log In Failed", Toast.LENGTH_LONG).show();
        }

    }

    private void createFile() {
        //Initialize file
        File file = new File(Environment.getExternalStorageDirectory(),appName);

        //Check condition
        if(file.exists()){
            Toast.makeText(LoginActivity.this, "File Already exists", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            //When file does not exits
            //Create a new File
            file.mkdirs();

            if(file.isDirectory()){
                Toast.makeText(LoginActivity.this, "File Created", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void OpenRegisterActivity(){
        IntentHelper.openIntent(this, RegisterActivity.class);
    }
}