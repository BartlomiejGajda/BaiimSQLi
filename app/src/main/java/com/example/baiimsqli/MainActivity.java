package com.example.baiimsqli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password, confpassword;
    Button signup, signin;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Boolean admin = databaseHelper.insertData("admin", "8937", 1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //8937
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        confpassword=findViewById(R.id.confpassword);
        signup=findViewById(R.id.signup);
        signin=findViewById(R.id.signin);
        databaseHelper = new DatabaseHelper(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= username.getText().toString();
                String pass = password.getText().toString();
                String confpass = confpassword.getText().toString();

                if(TextUtils.isEmpty((user)) || TextUtils.isEmpty(pass) | TextUtils.isEmpty(confpass))
                    Toast.makeText(MainActivity.this, "All fields required", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(confpass)){
                        Boolean checkuser = databaseHelper.checkusername(user);
                        if(!checkuser){
                            Boolean insert = databaseHelper.insertData(user,pass,0);
                            if(insert){
                                Toast.makeText(MainActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        } else { Toast.makeText(MainActivity.this, "User already exists", Toast.LENGTH_SHORT).show();}
                    } else {
                        Toast.makeText(MainActivity.this, "Passwords are not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}