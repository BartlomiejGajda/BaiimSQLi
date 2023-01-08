package com.example.baiimsqli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button signin;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.usernameLogin);
        password=findViewById(R.id.passwordLogin);
        signin=findViewById(R.id.signinLogin);
        databaseHelper = new DatabaseHelper(this);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user=username.getText().toString();
                String pass=password.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(LoginActivity.this,"All fields required", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = databaseHelper.checkusernamepassword(user, pass);
                    if(checkuserpass){
                        Toast.makeText(LoginActivity.this,"Login Succesful", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    } else {Toast.makeText(LoginActivity.this,"Login failed", Toast.LENGTH_SHORT).show();}
                }
            }
        });

    }
}