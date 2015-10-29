package br.com.fabricadeprogramador.fdpapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private final String TAG = "MainActivity";

    @Override
    protected void onResume() {
        Log.i(TAG,"CHAMOU ON RESUME");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG,"CHAMOU ON PAUSE");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG,"CHAMOU ON DESTROY");
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        Log.i(TAG,"CHAMOU ON START");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.i(TAG,"CHAMOU ON STOP");
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"CHAMOU ONCREATE");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button bt1 = (Button)findViewById(R.id.btSomar);
//        Button bt2 = (Button)findViewById(R.id.btSubtrair);
//        Button bt3 = (Button)findViewById(R.id.btMultiplicar);
//        Button bt4 = (Button)findViewById(R.id.btDividir);

        Button bt1 = (Button)findViewById(R.id.btCalc);

        final EditText gasolina = (EditText) findViewById(R.id.gasolina);
        final EditText gKmLitro = (EditText) findViewById(R.id.gKmLitro);
        final EditText valorG = (EditText) findViewById(R.id.valorGasolina);

        final EditText alcool = (EditText) findViewById(R.id.alcool);
        final EditText aKmLitro = (EditText) findViewById(R.id.aKmLitro);
        final EditText valorA = (EditText) findViewById(R.id.valorAlcool);



        bt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Double g1 = Double.parseDouble(gasolina.getText().toString());
                Double g2 = Double.parseDouble(gKmLitro.getText().toString());
                Double g3 = Double.parseDouble(valorG.getText().toString());

                Double a1 = Double.parseDouble(alcool.getText().toString());
                Double a2 = Double.parseDouble(aKmLitro.getText().toString());
                Double a3 = Double.parseDouble(valorA.getText().toString());



//        TextView valorGasolina = new TextView("");
                Double result1 = (g3 / g1) * g2;
                Double result2 = (a3 / a1) * a2;


                TextView resultado1 = (TextView) findViewById(R.id.resultado1);
                resultado1.setText("Gasolina: " + result1.toString());
                TextView resultado2 = (TextView) findViewById(R.id.resultado2);
                resultado2.setText("Álcool: " + result2.toString());

                Double econo = new Double(0);


//        valorGasolina.setText(result.toString());

                if (result1 > result2){
                    Toast.makeText(MainActivity.this, "Compensa Gasolina: ", Toast.LENGTH_SHORT).show();
                    econo = ((result1/result2) -1)*100;
                    Toast.makeText(MainActivity.this, "Economia de  " + econo.toString() + "%", Toast.LENGTH_SHORT).show();
                }
                else if(result1 < result2) {
                    Toast.makeText(MainActivity.this, "Compensa Álcool: ", Toast.LENGTH_SHORT).show();
                    econo = ((result2/result1) -1)*100;
                    Toast.makeText(MainActivity.this, "Economia de  " + econo.toString() + "%", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, "Mesmo Desempenho em Ambos: ", Toast.LENGTH_SHORT).show();



//                Toast.makeText(MainActivity.this,"Gasolina: " + result1,Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this,"Álcool: " + result2,Toast.LENGTH_SHORT).show();


                Intent irParaResultado =  new Intent(MainActivity.this, ResultadoActivity.class);
                Bundle bundle =  new Bundle();
                bundle.putDouble("calculo1", result1);
                bundle.putDouble("calculo2", result2);
                bundle.putDouble("porcentagem", econo);
                irParaResultado.putExtras(bundle);
                startActivity(irParaResultado);
//                Toast.makeText(MainActivity.this,"Soma: " + soma,Toast.LENGTH_SHORT).show();


            }
        });
//
//        bt2.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                Double a1 = Double.parseDouble(alcool.getText().toString());
//                Double a2 = Double.parseDouble(aKmLitro.getText().toString());
//                Double a3 = Double.parseDouble(valorA.getText().toString());
//
//                Double valorAlcool = (a3 / a1) * a2;
//                Intent irParaResultado =  new Intent(MainActivity.this, ResultadoActivity.class);
//                Bundle bundle =  new Bundle();
//                bundle.putDouble("calculo", valorAlcool);
//                irParaResultado.putExtras(bundle);
//                startActivity(irParaResultado);
////                Toast.makeText(MainActivity.this,"Soma: " + soma,Toast.LENGTH_SHORT).show();
//            }
//        });

//        bt3.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                Double n1 = Double.parseDouble(ed1.getText().toString());
//                Double n2 = Double.parseDouble(ed2.getText().toString());
//
//                Double multiplicacao = n1 * n2;
//
////                Toast.makeText(MainActivity.this,"Multiplicacao: " + multiplicacao,Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        bt4.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                Double n1 = Double.parseDouble(ed1.getText().toString());
//                Double n2 = Double.parseDouble(ed2.getText().toString());
//
//                Double divisao = n1 / n2;
//
////                Toast.makeText(MainActivity.this,"Divisao: " + divisao,Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
