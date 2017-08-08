package com.travelbudget.travelbudget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class taxes extends AppCompatActivity {

    public static final String SharedPrefManager = "PrefFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxes);
        initDisplayButton();
    }

    private void initDisplayButton() {
        Button displayButton = (Button)
                findViewById(R.id.button10);
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                EditText mis = (EditText)
                        findViewById(R.id.taxed);
                TextView textDisplay = (TextView)
                        findViewById(R.id.textView);
                String misc = mis.getText().toString();
                System.out.println(misc);

                SharedPreferences preferences = getSharedPreferences(SharedPrefManager, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Extra spending", misc); // value to store
                editor.commit();

                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(taxes.this);
                dlgAlert.setMessage("Is this the right information: " + misc);
                dlgAlert.setTitle("Travel Budget");
                dlgAlert.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                //dismiss the dialog
                                startActivity(new Intent(taxes.this, optionsScreen1.class));
                                Toast.makeText(taxes.this, "Data saved", Toast.LENGTH_SHORT).show();
                            }

                        });
                dlgAlert.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(taxes.this, taxes.class));
                            }
                        }
                );
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_taxes, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
