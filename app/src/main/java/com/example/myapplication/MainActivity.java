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
    private RadioGroup grupo, grupo2, grupo3;
    private EditText editText, editText3;
    private String stringQueSeEnvia, stringQueSeEnvia2, stringQueSeEnvia3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button2);

        editText = findViewById(R.id.edtOtraAgresion);
        grupo = findViewById(R.id.radioGrup);

        grupo2 = findViewById(R.id.radioGrup2);

        editText3 = findViewById(R.id.edtOtraAgresion3);
        grupo3 = findViewById(R.id.radioGrup3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkeoRadioGroupMasOpciones(grupo, editText, stringQueSeEnvia, new StringBuffer("Seleccione agresion"));
                checkeoRadioGroup2opciones(grupo2, stringQueSeEnvia2, new StringBuffer("seleccione numero"));
                checkeoRadioGroupMasOpciones(grupo3,editText3,stringQueSeEnvia3, new StringBuffer("Seleccione Si/No"));
            }
        });
    }

    //metodo para que el el radio grupo si no han seleccionado para que muestre y no rompa
    private void checkeoRadioGroupMasOpciones(RadioGroup grupoGroup, EditText text, String stringEspecifica, StringBuffer mensajeError) {
        final RadioButton algo;

        if (seSeleccionoAlmenosUnoEn(grupoGroup)) {
            algo = findViewById(grupoGroup.getCheckedRadioButtonId());

            if (algo.getText().toString().equals("Otro:") || algo.getText().toString().equals("Si")) {
                stringEspecifica = text.getText().toString().trim();
                if (stringEspecifica.isEmpty()) {
                    stringEspecifica = "Seleccionó la opcion " + algo.getText().toString() + ", especifique";
                    text.setError("completar");
                }
            } else {
                stringEspecifica = algo.getText().toString().trim();
            }
            makeTxt(new StringBuffer(stringEspecifica));
        } else {
            makeTxt(mensajeError);
        }
    }

    private void checkeoRadioGroup2opciones(RadioGroup radioGroup, String stringEspecifica, StringBuffer mensajeError) {
        final RadioButton algo;

        if (this.seSeleccionoAlmenosUnoEn(radioGroup)) {
            algo = findViewById(radioGroup.getCheckedRadioButtonId());
            stringEspecifica = algo.getText().toString().trim();
            makeTxt(new StringBuffer(stringEspecifica));
        } else {
            makeTxt(mensajeError);
        }
    }

    private void makeTxt(StringBuffer mensaje) {
        Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
    }

    private boolean seSeleccionoAlmenosUnoEn(RadioGroup grupo) {
        int id = grupo.getCheckedRadioButtonId();
        return id != -1;
    }

}
