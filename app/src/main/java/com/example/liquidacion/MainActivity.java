package com.example.liquidacion;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txth, txtdias;
    private CheckBox chbxPago, chbxDcto;
    private RadioGroup rgRedondeo;
    private RadioButton rbRedondeo, rbNoRedondeo;
    Button btnLimpiar, btnCalcular;
    private TextView lbl_pago, lbl_dcto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txth = (EditText) findViewById(R.id.txthora);
        txtdias = (EditText)findViewById(R.id.txtdia);
        chbxPago = (CheckBox)findViewById(R.id.chpago);
        chbxDcto = (CheckBox)findViewById(R.id.chdesc);
        rgRedondeo = (RadioGroup)findViewById(R.id.rgredon);
        rbNoRedondeo = (RadioButton)findViewById(R.id.rbredon);
        btnLimpiar = (Button)findViewById(R.id.limpiar);
        btnCalcular = (Button)findViewById(R.id.calcular);
        lbl_dcto = (TextView)findViewById(R.id.lb_desc);
        lbl_pago = (TextView)findViewById(R.id.lb_pago);

    }
    public void calcular (View view){

        int horas = Integer.parseInt(txth.getText().toString());
        int dias = Integer.parseInt(txtdias.getText().toString());
        int horas_mensuales = horas*dias;
        double pago = horas_mensuales*10;
        double descuento = 0.00;
        double sueldo_base = 1000.00;

        if(chbxPago.isChecked() == true){
            lbl_pago.setText(String.valueOf(pago));
        }
        if(chbxDcto.isChecked() == true && pago >1000){

            descuento = pago - (pago*0.1);
            lbl_dcto.setText(String.valueOf(descuento));
        }
        if (rgRedondeo.getCheckedRadioButtonId() == R.id.rbredon) {
            int pago_redondeo = (int)Math.round(pago);
            lbl_pago.setText(String.valueOf(pago_redondeo));
            int dcto_redondeo = (int)Math.round((descuento));
            lbl_dcto.setText(String.valueOf(dcto_redondeo));
        }
    }

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.limpiar:
                    txtdias.setText("");
                    txth.setText("");
                    break;
                case R.id.calcular:
                    break;
            }


    }
}
