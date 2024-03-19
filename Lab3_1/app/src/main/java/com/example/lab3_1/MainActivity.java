package com.example.lab3_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.lab3_1.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private Button btn_fragment1, btn_fragment2;
    private FrameLayout frameLayout;
    private FirstFragment firstFragment = new FirstFragment();
    private ActivityMainBinding binding;
    private FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_fragment1 = findViewById(R.id.btn_fragment1);
        btn_fragment2 = findViewById(R.id.btn_fragment2);
        frameLayout = findViewById(R.id.frame_layout);
        floatingActionButton = findViewById(R.id.floatingActionButton3);

//        BottomNavigationView navView = findViewById(R.id.nav_view);

//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();
//        NavController navController1 = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(binding.navView, navController);

        setNewFragment(firstFragment);

        btn_fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewFragment(firstFragment);
            }
        });

        btn_fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment secondFragment = new SecondFragment();
                setNewFragment(secondFragment);
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment homeFragment = new HomeFragment();
                setNewFragment(homeFragment);
            }
        });
    }

    private void setNewFragment(Fragment fragment) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}