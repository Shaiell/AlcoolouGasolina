package br.ici.treinamento.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText alcool;
    private EditText gasolina;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alcool = findViewById(R.id.tvAlcool);
        gasolina = findViewById(R.id.tvGasolina);
        resultado = findViewById(R.id.textViewResultado);

    }

    public void melhorConsumo(View view){

        // recuperar valores
        String precoAlcool = alcool.getText().toString();
        String precoGasolina = gasolina.getText().toString();

        //validar campos
        Boolean camposValidados = this.validarCampos(precoAlcool,precoGasolina);

        if (camposValidados){

            this.calcularMelhorPreco(precoAlcool,precoGasolina);

        }else {
            resultado.setText("Preencha os campos primeiro.");
        }

    }

    public void calcularMelhorPreco(String pAlcool, String pGasolina){

        Double precoAlcool = Double.parseDouble(pAlcool);
        Double precoGasolina = Double.parseDouble(pGasolina);

        /* Fáz calculo (precoAlcool/precoGasolina)
            * Se resultado for >=0.7  melhor usar gasolina
            * Senão melhor usar alcool.
         */

        if(precoAlcool/precoGasolina >= 0.7){
            resultado.setText("Melhor utilizar Gasolina");
        }else {
            resultado.setText("Melhor utilizar Álcool");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina){

        Boolean camposValidados = true;

        //validar campos.
        if (pAlcool==null || pAlcool.equals("")){
            camposValidados=false;
        }else if (pGasolina==null ||pGasolina.equals("")){
            camposValidados=false;
        }

        return camposValidados;
    }
}
