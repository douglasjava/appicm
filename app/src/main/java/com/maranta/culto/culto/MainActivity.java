package com.maranta.culto.culto;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.maranta.culto.culto.enums.NameFragments;
import com.maranta.culto.culto.fragments.CadastrosFragment;
import com.maranta.culto.culto.fragments.PesquisarFragment;
import com.maranta.culto.culto.fragments.RelatorioCultoFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content_main, new MainFragment(), NameFragments.MAIN)
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.culto) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(NameFragments.MAIN)
                    .replace(R.id.content_main, new RelatorioCultoFragment(), NameFragments.RELATORIO)
                    .commit();

        } else if (id == R.id.cadastros) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(NameFragments.MAIN)
                    .replace(R.id.content_main, new CadastrosFragment(), NameFragments.CADASTROS)
                    .commit();

        } else if (id == R.id.pesquisa) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(NameFragments.MAIN)
                    .replace(R.id.content_main, new PesquisarFragment(), NameFragments.PESQUISA)
                    .commit();


        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
