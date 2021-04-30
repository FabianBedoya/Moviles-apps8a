package com.example.mycalcv12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText n1;
    private EditText n2;
    private TextView ans;
    private Spinner sp1;
    private String sm;
    private String rm;
    private String mm;
    private String dm;
    private String ll;
    private String l1;
    private String l2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = (EditText)findViewById(R.id.txtn1);
        n2 = (EditText)findViewById(R.id.txtn2);
        sp1 = (Spinner)findViewById(R.id.spinner);
        ans = (TextView)findViewById(R.id.lblAns);

        sm = getString(R.string.ope1);
        rm = getString(R.string.ope2);
        mm = getString(R.string.ope3);
        dm = getString(R.string.ope4);
        ll = getString(R.string.tc);
        l1 = getString(R.string.c1);
        l2 = getString(R.string.c2);

        String[] options={sm, rm, mm, dm};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>( this, android.R.layout.simple_spinner_item, options);

        sp1.setAdapter(adapter);

    }

    public void calc (View view){

        if (n1.getText().toString().isEmpty() & n2.getText().toString().isEmpty()){
            Toast.makeText(this, ll, Toast.LENGTH_LONG).show();
        }else{
            if (n1.getText().toString().isEmpty() ){
                Toast.makeText(this, l1, Toast.LENGTH_LONG).show();
            }else{
                if (n2.getText().toString().isEmpty()){
                    Toast.makeText(this, l2, Toast.LENGTH_LONG).show();
                }else{
                    int num1 = Integer.parseInt(n1.getText().toString());
                    int num2 = Integer.parseInt(n2.getText().toString());
                    int  add, subtract, multiply;
                    Float divide;
                    String select = sp1.getSelectedItem().toString();


                    if (select == sm){
                        add = num1 + num2;
                        ans.setText(String.valueOf(add));
                    }else{
                        if (select == rm){
                            subtract = num1 - num2;
                            ans.setText(String.valueOf(subtract));
                        }else{
                            if (select == mm){
                                multiply = num1 * num2;
                                ans.setText(String.valueOf(multiply));
                            }else{
                                if (select == dm){
                                    divide = (float) num1 / (float) num2;
                                    ans.setText(String.valueOf(divide));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}