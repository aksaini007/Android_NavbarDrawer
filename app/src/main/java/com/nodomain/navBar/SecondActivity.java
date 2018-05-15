package com.nodomain.navBar;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_second );

        toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        Toast.makeText( this, "This is Second activity.", Toast.LENGTH_SHORT ).show();
        mDrawerLayout = (DrawerLayout) findViewById( R.id.drawer_layout );
        navigationView = (NavigationView) findViewById( R.id.nav_view );

        navigationView.setNavigationItemSelectedListener( new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // set item as selected to persist highlight
                item.setChecked( true );
                // close drawer when item is tapped
                mDrawerLayout.closeDrawers();
                // Add code here to update the UI based on the item selected
                // For example, swap UI fragments here
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Intent intent = new Intent(SecondActivity.this, MainActivity.class );
                        startActivity( intent );
                        return true;
                    case R.id.nav_2ndAC:
                        Intent intent2 = new Intent( SecondActivity.this, SecondActivity.class );
                        startActivity( intent2 );
                        return true;
                    case R.id.nav_3rdAC:
                        Intent intent3 = new Intent( SecondActivity.this, ThirdActivity.class );
                        startActivity( intent3 );
                        return true;
                }
                return true;
            }
        } );
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer( GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
