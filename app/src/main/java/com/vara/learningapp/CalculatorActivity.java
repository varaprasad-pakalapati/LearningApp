package com.vara.learningapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Vara.Pakalapati on 02/10/2015.
 */
public class CalculatorActivity extends AppCompatActivity {

    private EditText editOperandOne;
    private EditText editOperandTwo;
    private Button btnAddition;
    private Button btnSubtraction;
    private Button btnMultipication;
    private Button btnDivision;
    private TextView txtResult;
    private Button btnClear;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        editOperandOne = (EditText) findViewById(R.id.editOperandOne);
        editOperandTwo = (EditText) findViewById(R.id.editOperandTwo);
        btnAddition = (Button) findViewById(R.id.btnAddition);
        btnSubtraction = (Button) findViewById(R.id.btnSubtraction);
        btnMultipication = (Button) findViewById(R.id.btnMultipication);
        btnDivision = (Button) findViewById(R.id.btnDivision);
        txtResult = (TextView) findViewById(R.id.txtResult);
        btnClear = (Button) findViewById(R.id.btnClear);

        // Creates items on action bar
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate(Operator.Addition);
            }
        });

        btnSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate(Operator.Subtraction);
            }
        });

        btnMultipication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate(Operator.Multiplication);
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate(Operator.Division);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editOperandOne.setText("");
                editOperandTwo.setText("");
                txtResult.setText("0.00");
                editOperandOne.requestFocus();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast toastMessage = Toast.makeText(this, "The settings menu got tapped", Toast.LENGTH_LONG);
            toastMessage.show();
            return true;
        } else if(id == R.id.action_login) {
            Intent loginActivity = new Intent(this, LoginActivity.class);
            startActivity(loginActivity);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public enum Operator {
        Addition,
        Subtraction,
        Multiplication,
        Division
    }

    private void Calculate(Operator op) {
        double result = 0;
        double opera1 = 0 ;
        double opera2 = 0;

        if ((editOperandOne.getText().length() > 0) && (editOperandTwo.getText().length() > 0)) {
            opera1 = Double.parseDouble(editOperandOne.getText().toString());
            opera2 = Double.parseDouble(editOperandTwo.getText().toString());
        }
        else {
            Toast.makeText(CalculatorActivity.this, "Please enter both the values", Toast.LENGTH_LONG).show();
            return;
        }

        switch (op)
        {
            case Addition:
            {
                result = opera1 + opera2;
                break;
            }
            case Subtraction:
            {
                result = opera1 - opera2;
                break;
            }
            case Multiplication:
            {
                result = opera1 * opera2;
                break;
            }
            case Division:
            {
                result = opera1 / opera2;
                break;
            }
        }

        txtResult.setText(Double.toString(result));
    }
}
