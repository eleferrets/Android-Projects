package com.example.dicegame;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView rollResult;

    Button rollButton;


    int score;

    Random rand;

    int dice1;
    int dice2;
    int dice3;
    ArrayList<Integer> dice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        score = 0;
        // Casting and linking the element  to our code
        rollResult = (TextView) findViewById(R.id.rollResult);
        rollButton = (Button) findViewById(R.id.rollButton);
        // Quick message at start
        Toast.makeText(getApplicationContext(), "Welcome to the Dice Game", Toast.LENGTH_SHORT).show();

        rand = new Random();

        dice = new ArrayList<Integer>();
    }

    public void rollDice(View view) {
        rollResult.setText("Button Clicked");
        dice1 = rand.nextInt(6)+1;
        dice2 = rand.nextInt(6)+1;
        dice3 = rand.nextInt(6)+1;

        dice.clear();
        dice.add(dice1);
        dice.add(dice2);
        dice.add(dice3);
        String msg = "You rolled a " + dice1 + ", a" + dice2 + ", a" + dice3;
        // update text
        rollResult.setText(msg);
        //int num = rand.nextInt(6)+1;
        //String randomValue = "Number generated: " + num;
        //Toast.makeText(getApplicationContext(), randomValue, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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