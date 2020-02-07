package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup grupo, grupo2;
    private EditText editText, editText2;
    private String stringQueSeEnvia, stringQueSeEnvia2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button2);

        editText = findViewById(R.id.edtOtraAgresion);
        grupo = findViewById(R.id.radioGrup);

        editText2 = findViewById(R.id.edtOtraAgresion2);
        grupo2 = findViewById(R.id.radioGrup2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkea(grupo, editText, stringQueSeEnvia,"Seleccione agresion");
                checkea(grupo2,editText2,stringQueSeEnvia2,"seleccione numero");
            }
        });
    }

    //metodo para que el el radio grupo si no han seleccionado para que muestre y no rompa
    private void checkea(RadioGroup grupo, EditText text, String stringEspecifica, String mensajeError) {
        final RadioButton algo;
        int id = grupo.getCheckedRadioButtonId();

        if(id != -1){
            algo = findViewById(id);

            if (algo.getText().toString().equals("Otro:")) {
                stringEspecifica = text.getText().toString().trim();
                if (stringEspecifica.isEmpty()) {
                    stringEspecifica = "seleciono otro complete";
                    text.setError("completar");
                }
            } else {
                stringEspecifica = algo.getText().toString().trim();
            }
            Toast.makeText(MainActivity.this, stringEspecifica, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, mensajeError, Toast.LENGTH_SHORT).show();
        }
    }

}
