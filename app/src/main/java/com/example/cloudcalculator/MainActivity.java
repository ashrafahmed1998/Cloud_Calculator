package com.example.cloudcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button pls;
    Button min;
    Button mul;
    Button div;
    Button pow;
    Button clr;
    EditText basenumber1;
    EditText basenumber2;
    TextView answer;
    final Context context=this;
    public static final String RESULT = "answers";
    public static final String TIMESTAMP = "timestamp";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pls = findViewById(R.id.button_plus);
        min = findViewById(R.id.button_minus);
        mul = findViewById(R.id.button_mul);
        div = findViewById(R.id.button_div);
        pow = findViewById(R.id.button_pow);
        clr = findViewById(R.id.clr);
        answer =  findViewById(R.id.answer);
        basenumber1 =  findViewById(R.id.a0);
        basenumber2 =  findViewById(R.id.a1);


        pls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1 = Float.parseFloat(basenumber1.getText().toString());
                float num2 = Float.parseFloat(basenumber2.getText().toString());
                float Ans = num1 + num2;
                answer.setText(String.valueOf(Ans));
                String answer = String.valueOf(Ans);
                Map<String, Object> myresult = new HashMap<>();
                myresult.put(RESULT, answer);
                myresult.put(TIMESTAMP, FieldValue.serverTimestamp());

                db.collection("num1 + num2").document("calculation").set(myresult);

            }
        });

        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1 = Float.parseFloat(basenumber1.getText().toString());
                float num2 = Float.parseFloat(basenumber2.getText().toString());
                float Ans = num1 - num2;
                answer.setText(String.valueOf(Ans));
                String answer = String.valueOf(Ans);
                Map<String, Object> myresult = new HashMap<>();
                myresult.put(RESULT, answer);
                myresult.put(TIMESTAMP, FieldValue.serverTimestamp());

                db.collection("num1 - num2").document("calculation").set(myresult);


            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1 = Float.parseFloat(basenumber1.getText().toString());
                float num2 = Float.parseFloat(basenumber2.getText().toString());
                float Ans = num1 * num2;
                answer.setText(String.valueOf(Ans));
                String answer = String.valueOf(Ans);
                Map<String, Object> myresult = new HashMap<>();
                myresult.put(RESULT, answer);
                myresult.put(TIMESTAMP, FieldValue.serverTimestamp());

                db.collection("num1 * num2").document("calculation").set(myresult);


            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1 = Float.parseFloat(basenumber1.getText().toString());
                float num2 = Float.parseFloat(basenumber2.getText().toString());
                float Ans = num1 / num2;
                answer.setText(String.valueOf(Ans));
                String answer = String.valueOf(Ans);
                Map<String, Object> myresult = new HashMap<>();
                myresult.put(RESULT, answer);
                myresult.put(TIMESTAMP, FieldValue.serverTimestamp());

                db.collection("num1 / num2").document("calculation").set(myresult);


            }
        });

        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1 = Float.parseFloat(basenumber1.getText().toString());
                float num2 = Float.parseFloat(basenumber2.getText().toString());
                float Ans = (float) Math.pow(num1, num2);
                answer.setText(String.valueOf(Ans));
                String answer = String.valueOf(Ans);
                Map<String, Object> myresult = new HashMap<>();
                myresult.put(RESULT, answer);
                myresult.put(TIMESTAMP, FieldValue.serverTimestamp());

                db.collection("power").document("calculation").set(myresult);


            }
        });
    }
}
