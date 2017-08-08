package com.travelbudget.travelbudget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;


public class addition extends AppCompatActivity {

    Integer int1;
    Integer int2;
    Integer int3;
    Integer int4;
    Integer int5;
    Button btn;
    Button btn2;

    public static final String SharedPrefManager = "PrefFile";

    public class pieChart {

        public Intent execute(Context context) {

            SharedPreferences preferences1 = getSharedPreferences(SharedPrefManager, Context.MODE_PRIVATE);
            Integer finalMPGS = preferences1.getInt("Final", 0);

            SharedPreferences preferences2 = getSharedPreferences(SharedPrefManager, Context.MODE_PRIVATE);
            String food = preferences2.getString("Food", "default food");

            SharedPreferences preferences4 = getSharedPreferences(SharedPrefManager, Context.MODE_PRIVATE);
            String hotelPrice = preferences4.getString("Hotel price", "default price");

            SharedPreferences preferences5 = getSharedPreferences(SharedPrefManager, Context.MODE_PRIVATE);
            String misc = preferences5.getString("Extra spending", "default spending");

            int3 = new Integer(Integer.parseInt(food));
            int4 = new Integer(Integer.parseInt(hotelPrice));
            int5 = new Integer(Integer.parseInt(misc));

            int [] colors = new int [] {Color.RED, Color.CYAN, Color.BLUE, Color.MAGENTA};
            DefaultRenderer renderer = buildCategoryRenderer(colors);

            CategorySeries categorySeries = new CategorySeries("Expense Chart");
            categorySeries.add("Gas", finalMPGS);
            categorySeries.add("Food", int3);
            categorySeries.add("MISC", int5);
            categorySeries.add("Hotel Price", int4);


            renderer.setMargins(new int[]{0, 0, 0, 0});
            renderer.setApplyBackgroundColor(true);
            renderer.setBackgroundColor(Color.GREEN);
            renderer.setZoomButtonsVisible(false);
            renderer.setChartTitleTextSize(70);
            renderer.setLabelsTextSize(65);
            renderer.setChartTitle("Your Expenses");
            renderer.setChartTitleTextSize(90);
            renderer.setExternalZoomEnabled(true);
            renderer.setLabelsColor(Color.BLACK);
            renderer.setShowLegend(false);
            renderer.setScale(1.00f);


            return ChartFactory.getPieChartIntent(context, categorySeries, renderer, null);


        }

        protected DefaultRenderer buildCategoryRenderer(int[] colors) {
            DefaultRenderer renderer = new DefaultRenderer();
            for (int color : colors) {
                SimpleSeriesRenderer r = new SimpleSeriesRenderer();
                r.setColor(color);
                renderer.addSeriesRenderer(r);
            }
            return renderer;
        }



    }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);


        SharedPreferences preferences6 = getSharedPreferences(SharedPrefManager, Context.MODE_PRIVATE);
        final String total = preferences6.getString("Totals", "default total");
        final TextView to = (TextView) this.findViewById(R.id.t);

        to.setText("$" + total);


        to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.t) {
                    Intent aChartIntent = new pieChart().execute(addition.this);
                    startActivity(aChartIntent);
                }

                to.setText("$" + total);
            }
        });

        btn = (Button)findViewById(R.id.clear);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(addition.this);
                dlgAlert.setMessage("This will clear all of your data and take you back to start");
                dlgAlert.setTitle("Travel Budget");
                dlgAlert.setPositiveButton("Continue?",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                //dismiss the dialog
                                startActivity(new Intent(addition.this, homeScreen.class));
                                Toast.makeText(addition.this, "Data cleared", Toast.LENGTH_SHORT).show()
                                ;
                            }

                        });
                dlgAlert.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(addition.this, addition.class));
                            }
                        }
                );
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();

                SharedPreferences settings = getSharedPreferences(SharedPrefManager, Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = settings.edit();
                editor.clear();
                editor.commit();
            }
        });

        btn2 = (Button)findViewById(R.id.yelp);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addition.this, MapsActivity.class);
                startActivity(intent);
            }
        });



    }

        public void onClick (View v) {
            if (v.getId() == R.id.ok1) {
                Intent intent = new Intent(addition.this, finalPage.class);
                startActivity(intent);}
            else if (v.getId() == R.id.next) {
                Intent intent = new Intent(addition.this, optionsScreen1.class);
                startActivity(intent);}
            }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_addition, menu);
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
