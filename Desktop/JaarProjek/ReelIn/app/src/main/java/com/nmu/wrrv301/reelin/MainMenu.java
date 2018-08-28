package com.nmu.wrrv301.reelin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.manageAccount:
                Intent manageAccountIntent = new Intent(MainMenu.this, ManageAccount.class);
                startActivity(manageAccountIntent);
                break;
            // action with ID action_settings was selected
            case R.id.logout:
                Intent loginIntent = new Intent(MainMenu.this, Login.class);
                startActivity(loginIntent);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
