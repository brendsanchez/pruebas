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
    private EditText editText, editText2, editText3;
    private String stringQueSeEnvia, stringQueSeEnvia2, stringQueSeEnvia3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button2);

        //editText = findViewById(R.id.edtOtraAgresion);
        //grupo = findViewById(R.id.radioGrup);
        editText = findViewById(R.id.edtDondeDenuncia);
        editText2 = findViewById(R.id.edtPorQueNoDenuncia);
        grupo = findViewById(R.id.rgDenuncia);

        grupo2 = findViewById(R.id.radioGrup2);

        editText3 = findViewById(R.id.edtOtraAgresion3);
        grupo3 = findViewById(R.id.radioGrup3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringQueSeEnvia = checkRadioGroup(grupo, editText, editText2, "seleccione denuncia");
                stringQueSeEnvia2 = checkeoRadioGroup2opciones(grupo2, "selencione numero");
                stringQueSeEnvia3 = checkRadioGroup(grupo3, editText3, "seleccione Si/no");


                /*makeTxt(stringQueSeEnvia);
                makeTxt(stringQueSeEnvia2);
                makeTxt(stringQueSeEnvia3);*/
            }
        });
    }

    //metodo para que el el radio grupo si no han seleccionado para que muestre y no rompa
    private String checkRadioGroup(RadioGroup grupoGroup, EditText text, String mensajeError) {
        final RadioButton algo;

        if (seSeleccionoAlmenosUnoEn(grupoGroup)) {
            algo = findViewById(grupoGroup.getCheckedRadioButtonId());

            if (algo.getText().toString().equals("Otro:") || algo.getText().toString().equals("Si")) {
                return this.chooseSeleccion(text, algo);
            } else {
                return algo.getText().toString().trim();
            }

        } else {
            makeTxt(mensajeError);
            return "";
        }
    }

    private String checkeoRadioGroup2opciones(RadioGroup radioGroup, String mensajeError) {
        final RadioButton algo;

        if (this.seSeleccionoAlmenosUnoEn(radioGroup)) {
            algo = findViewById(radioGroup.getCheckedRadioButtonId());
            return algo.getText().toString().trim();
        } else {
            makeTxt(mensajeError);
            return "";
        }
    }

    private void makeTxt(String mensaje) {
        Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
    }

    private boolean seSeleccionoAlmenosUnoEn(RadioGroup grupo) {
        int id = grupo.getCheckedRadioButtonId();
        return id != -1;
    }

    private String checkRadioGroup(RadioGroup grupoGroup, EditText text, EditText text2, String mensajeError) {
        final RadioButton algo;

        if (seSeleccionoAlmenosUnoEn(grupoGroup)) {
            algo = findViewById(grupoGroup.getCheckedRadioButtonId());

            if (algo.getText().toString().equals("Si")) {
                text2.setText("");
                return this.chooseSeleccion(text, algo);
            } else if (algo.getText().toString().equals("No")) {
                text.setText("");
                return this.chooseSeleccion(text2, algo);
            } else {
                return algo.getText().toString().trim();
            }
        } else {
            return "";
        }
    }

    private String chooseSeleccion(EditText text, RadioButton algo) {
        if (text.getText().toString().isEmpty()) {
            makeTxt("Seleccionó la opcion " + algo.getText().toString() + ", especifique");
            text.setError("completar");
            return "";
        } else {
            text.requestFocus();
            return algo.getText().toString().trim() + ": "+ text.getText().toString().trim();
        }
    }
}
