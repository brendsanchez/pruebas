package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup grupo;
    private RadioButton radioButton, lastButtom;
    private EditText editText;
    private String stringQueSeEnvia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button2);

        lastButtom = findViewById(R.id.rbtOtraAgresion);
        grupo = findViewById(R.id.radioGrup);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*int radioid = grupo.getCheckedRadioButtonId();
                radioButton = findViewById(radioid);
                */
                checkea();
                //Toast.makeText(MainActivity.this, stringQueSeEnvia, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @SuppressLint("ResourceType")
    private void checkea() {

        if (grupo.getCheckedRadioButtonId() != -1) {
            Toast.makeText(MainActivity.this, grupo.getCheckedRadioButtonId(), Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(MainActivity.this, "selecione radio buttom", Toast.LENGTH_SHORT).show();
            // pls select at-least one radio button.. since id is -1 means no button is check
        }


        RadioButton aux = findViewById(R.id.rbtVerbales);
        aux.setChecked(false);

        radioButton = findViewById(grupo.getCheckedRadioButtonId());
        String algo = radioButton.getText().toString().trim();

        if (algo.equals("Otro:")) {
            editText = findViewById(R.id.edtOtraAgresion);
            stringQueSeEnvia = editText.getText().toString().trim();
            if (stringQueSeEnvia.isEmpty()) {
                editText.setError("completar");
            }
        } else {
            stringQueSeEnvia = algo;
        }


        //((RadioButton)grupo.getChildAt(lastChildPos)).setError("Your error");
    }
}
