package com.example.droidcafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



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
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                String data = getString(R.string.google_mtw_coord_zoom12);
                intent.setData(Uri.parse(data));
                if(intent.resolveActivity(getPackageManager())!=null)
                    startActivity(intent);
                Snackbar.make(view, R.string.snackbar_text, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
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
        switch (item.getItemId())
        {
            case R.id.action_order:
                displayToast(getString(R.string.action_order_message));
                break;
            case R.id.action_status:
                displayToast(getString(R.string.action_status_message));
                break;
            case R.id.action_favorites:
                displayToast(getString(R.string.action_favorites_message));
                break;
            case R.id.action_contact:
                displayToast(getString(R.string.action_contact_message));
                break;
            default:
                // do nothing for now
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Shows a message that the donut image was clicked.
     */
    public void showDonutOrder(View view)
    {
        showFoodOrder(getString(R.string.donut_order_message));
    }

    public void showIcecreamOrder(View view)
    {
        showFoodOrder(getString(R.string.ice_cream_order_message));
    }

    public void showFroyoOrder(View view)
    {
        showFoodOrder(getString(R.string.froyo_order_message));
    }

    /**
     * Display a toast message and open order activity
     * @param message message to display
     */
    public void showFoodOrder(String message){
        displayToast(message);
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
    }

}
