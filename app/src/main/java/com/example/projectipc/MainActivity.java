package com.example.projectipc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public  class MainActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomView=(BottomNavigationView)findViewById(R.id.menu);
        bottomView.setOnNavigationItemSelectedListener(listener);
        loadFragment(new FragmentHome());

    }

private BottomNavigationView.OnNavigationItemSelectedListener listener=new BottomNavigationView.OnNavigationItemSelectedListener() {


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      Fragment fragment=null ;

        switch (item.getItemId()){
            case R.id.navigation_home:
                fragment = new FragmentHome();


               break;
            case R.id.navigation_user:
                fragment = new FragmentUser();
                break;


            case R.id.navigation_history:
                fragment = new FragmentHistory();
                break;


        }
        return loadFragment(fragment);
    }
};

    @SuppressLint("ResourceType")
    private boolean loadFragment(Fragment fragment){

if(fragment!=null) {
    getSupportFragmentManager().beginTransaction()
            .replace(R.id.fl_container, fragment)
            .commit();
    return true;
}

return false;
    }


}
