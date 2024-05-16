package com.example.a;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import androidx.core.view.GravityCompat;

import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.a.databinding.ActivityMainBinding;
import com.example.a.ui.aboutus.AboutUsFragment;
import com.example.a.ui.connect.ConnectFragment;
import com.example.a.ui.home.HomeFragment;
import com.example.a.ui.profile.ProfileFragment;
import com.example.a.ui.savedproduct.SavedProductsFragment;
import com.example.a.ui.settings.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private int currentFragmentId;
    private String frag="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        Toolbar toolbar = findViewById(R.id.toolbarmain);
        setSupportActionBar(toolbar);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            currentFragmentId = destination.getId();
            updateToolbarBasedOnFragment(currentFragmentId);
        });

        NavigationUI.setupWithNavController(navView, navController);

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_account) {
                getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_keyboard_backspace_24);
                frag="co";
                openYourFragment(new ProfileFragment());
            } else if (id == R.id.nav_aboutus) {
                getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_keyboard_backspace_24);
                frag="co";
                openYourFragment(new AboutUsFragment());
            } else if (id == R.id.nav_savedproducts) {
                getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_keyboard_backspace_24);
                frag="co";
                openYourFragment(new SavedProductsFragment());
            } else if (id == R.id.nav_settings) {
                getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_keyboard_backspace_24);
                frag="co";
                openYourFragment(new SettingsFragment());
            } else if (id == R.id.nav_logout) {
                // Implement your logout logic here
            } else {
                // Default case
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }



    private void updateToolbarBasedOnFragment(int fragmentId) {
        // You can perform actions based on the current fragment ID
        // For example, you can update the title or handle other UI changes
        if (fragmentId == R.id.navigation_home) {
            // Handle actions for the Home fragment
            getSupportActionBar().setTitle(R.string.title_home);

            getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_dehaze_24);
        } else if (fragmentId == R.id.navigation_location) {
            // Handle actions for the Location fragment
            getSupportActionBar().setTitle(R.string.title_Location);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_keyboard_backspace_24);

        } else if (fragmentId == R.id.navigation_charging) {
            // Handle actions for the Charging fragment
            getSupportActionBar().setTitle(R.string.title_charging);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_keyboard_backspace_24);
        } else if (fragmentId == R.id.navigation_stats) {
            // Handle actions for the Stats fragment
            getSupportActionBar().setTitle(R.string.title_Stats);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_keyboard_backspace_24);
        } else if (fragmentId == R.id.navigation_shop) {
            // Handle actions for the Shop fragment
            getSupportActionBar().setTitle(R.string.title_Shop);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_keyboard_backspace_24);
        } else if (fragmentId == R.id.navigation_connect) {
            // Handle actions for the Shop fragment
            getSupportActionBar().setTitle(R.string.title_Connect);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_keyboard_backspace_24);
        } else if (fragmentId == R.id.navigation_notification) {
            // Handle actions for the Shop fragment
            getSupportActionBar().setTitle(R.string.title_notifications);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_keyboard_backspace_24);
        } else {
            // Handle the default case or leave it empty
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private int getCurrentFragmentId() {
        // This method should return the ID of the current fragment.
        // You can use the NavController to get the current destination.
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        return navController.getCurrentDestination().getId();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        int currentFragmentIds = getCurrentFragmentId();

        if (currentFragmentIds == R.id.navigation_home) {
            getSupportActionBar().setTitle(R.string.title_home);
        } else if (currentFragmentIds == R.id.navigation_location) {
            getSupportActionBar().setTitle(R.string.title_Location);
        } else {
            // Add if-else statements for other fragments
        }

        // Inflate the common menu for all fragments
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {



            if (currentFragmentId== R.id.navigation_home & !frag.equals("co") & !frag.equals("no")) {
                // If on the home fragment, open the navigation drawer
                drawerLayout.openDrawer(GravityCompat.START);
            } else if( frag.equals("no") | frag.equals("co") ){


                Log.d("MenuItemClicked", "connect : " + itemId);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                HomeFragment homeFragment = new HomeFragment();
                fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, homeFragment);
                getSupportActionBar().setTitle(R.string.title_home);
                getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_dehaze_24);
                // fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                // Set the corresponding menu item in the bottom navigation view as selected
                BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
                bottomNavigationView.getMenu().findItem(R.id.navigation_home).setChecked(true);
                frag="";


            }else{
                onBackPressed();


            }
            return true;
        } else if (itemId == R.id.syncmenu) {
            //Handle syncmenu action
            frag="co";
            getSupportActionBar().setTitle(R.string.title_Connect);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_keyboard_backspace_24);
            openYourFragment(new ConnectFragment());




            return true;
        } else if (itemId == R.id.notification) {
            frag="no";
            getSupportActionBar().setTitle(R.string.title_notifications);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_keyboard_backspace_24);
            openYourFragment(new com.example.a.ui.notification.NotificationFragment());

            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }







    private void openYourFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment_activity_main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }



}

