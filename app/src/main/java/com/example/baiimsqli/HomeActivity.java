package com.example.baiimsqli;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HomeActivity extends AppCompatActivity {

    AutoCompleteTextView movieSearchView;
    Button movieSearchButton;
    TextView movieTextDisplay;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        movieTextDisplay = findViewById(R.id.movieTextDisplay);
        movieSearchButton = findViewById(R.id.movieSearchButton);
        databaseHelper = new DatabaseHelper(this);
        movieTextDisplay.setMovementMethod(new ScrollingMovementMethod());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, databaseHelper.getMoviesList());
        movieSearchView = (AutoCompleteTextView) findViewById(R.id.movieSearchTextView);
        movieSearchView.setAdapter(adapter);

        movieSearchButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String title = movieSearchView.getText().toString();
                ArrayList<HashMap<String, String>> data = databaseHelper.getTitle(title);
                movieTextDisplay.setText(Arrays.toString(data.toArray()));
            }
        });

    }


}