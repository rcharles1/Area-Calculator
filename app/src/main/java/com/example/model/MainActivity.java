package com.example.model;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Method;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    double radius;
    double a;

    EditText radius_input;

    Button button_submit;




    public MainActivity() {
        calculateArea();
    }

    private void calculateArea() {
        a = 3.14 * this.radius * this.radius;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        radius_input =  findViewById(R.id.radius_input);
        button_submit = findViewById(R.id.button_submit);

        button_submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        radius = Double.parseDouble(radius_input.getText().toString());


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("The Area of the circle is"  + a + "square units");
        builder.setTitle("Area Calculated");

        builder.setPositiveButton(android.R.string.ok, (dialogInterface, id) -> {
            //user clicks ok button
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }


    public static void main(String[] args) throws Exception {


        MainActivity obj = new MainActivity();
        Method method = obj.getClass().getDeclaredMethod(" calculateArea");

        //Set accessible
        method.setAccessible(true);

        //Invoke method
        method.invoke( obj );
    }

}



