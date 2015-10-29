package br.com.fabricadeprogramador.fdpapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by viniciuspodi on 22/10/15.
 */
public class ResultadoActivity extends Activity {

    private final String TAG = "ResultadoAtivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "CHAMOU ON CREATE");
        setContentView(R.layout.activity_main);

        Button bt1 = (Button) findViewById(R.id.btFinish);

        bt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                Double calculo1 = bundle.getDouble("calculo1");
                Double calculo2 = bundle.getDouble("calculo2");
                Double porcentagem = bundle.getDouble("porcentagem");

                TextView resultado1 = (TextView) findViewById(R.id.res1);
                resultado1.setText("Gasolina: " + calculo1.toString());
                TextView resultado2 = (TextView) findViewById(R.id.res2);
                resultado1.setText("Álcool: " + calculo2.toString());
                TextView resultado3 = (TextView) findViewById(R.id.res3);
                resultado1.setText("Porcentagem de Economia: " + porcentagem.toString());

                finish();


//        Toast.makeText(this, calculo.toString(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}
