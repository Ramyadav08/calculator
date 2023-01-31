package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtrslt;
        LinearLayout llmain;
        EditText wt,htf,hti;
        Button btncal;
        wt=findViewById(R.id.wt);
        htf=findViewById(R.id.htf);
        hti=findViewById(R.id.hti);
        btncal=findViewById(R.id.btncal);
        txtrslt=findViewById(R.id.txtrslt);
        llmain=findViewById(R.id.llmain);
        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int weight=Integer.parseInt(wt.getText().toString());
               int height_f=Integer.parseInt(htf.getText().toString());
               int height_i=Integer.parseInt(hti.getText().toString());
               int totalIn=height_f*12 +height_i;
               double totalCm=totalIn*2.53;
               double totalM=totalCm/100;
               double  bmi=weight/(totalM*totalM);
               if(bmi>25){
                   txtrslt.setText("you are overweighted");
                   llmain.setBackgroundColor(getResources().getColor(R.color.overwt));
               }else if(bmi<18){
                   txtrslt.setText("you are underweighted");
                   llmain.setBackgroundColor(getResources().getColor(R.color.underwt));
               }
               else{
                   txtrslt.setText("you are healthy");
                   llmain.setBackgroundColor(getResources().getColor(R.color.healthywt));
               }
            }
        });
    }
}