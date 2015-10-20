package com.vara.learningapp;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Vara.Pakalapati on 30/09/2015.
 */
public class LoginActivity extends AppCompatActivity {

    private Button loginButton;
    private EditText username;
    private EditText password;
    private CheckBox rememberMe;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.editUsername);
        password = (EditText) findViewById(R.id.editPassword);
        rememberMe = (CheckBox) findViewById(R.id.chkRememberme);
        loginButton = (Button) findViewById(R.id.btnLogin);

        // Creates items on action bar
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        // Adds parent activity navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       View.OnClickListener btnLoginClick = new View.OnClickListener(){
           @Override
           public void onClick(View v) {
               Toast.makeText(LoginActivity.this, "Clicked on login button", Toast.LENGTH_LONG).show();
           }
       };

        loginButton.setOnClickListener(btnLoginClick);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast toastMessage = Toast.makeText(this, "The settings menu got tapped", Toast.LENGTH_LONG);
            toastMessage.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
