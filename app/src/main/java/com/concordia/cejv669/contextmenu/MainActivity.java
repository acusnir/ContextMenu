package com.concordia.cejv669.contextmenu;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = findViewById(R.id.button1);
        Button b2 = findViewById(R.id.button2);

        registerForContextMenu(b1);
        registerForContextMenu(b2);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.button1){
            menu.setHeaderTitle("Two Letters Menu");
            menu.add(0, v.getId(), 0, "A");
            menu.add(0, v.getId(), 0, "B");
        }
        else{
            menu.setHeaderTitle("Two Colours Menu");
            menu.add(0, v.getId(), 0, "Red");
            menu.add(0, v.getId(), 0, "Blue");
        }


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.button1) {
            if (item.getGroupId() ==0){
                Toast.makeText(this, "You selected A", Toast.LENGTH_LONG).show();
            }
            if (item.getGroupId() ==1){
                Toast.makeText(this, "You selected B", Toast.LENGTH_LONG).show();
            }

        }
        if (item.getItemId() == R.id.button2) {
            Toast.makeText(this, "You selected colour" + item.getTitle(), Toast.LENGTH_LONG).show();
        }
        return true;
    }
}
