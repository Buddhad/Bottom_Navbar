package com.example.bottomnavbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {
    private final int ID_Home=1;
    private final int ID_Message=2;
    private final int ID_Notification=3;
    private final int ID_Account=4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.page_title);
        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.add(new MeowBottomNavigation.Model(ID_Home , R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_Message , R.drawable.ic_message));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_Notification , R.drawable.ic_notifications));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_Account , R.drawable.ic_account));

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                //navigate user

            }
        });

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {

                String name;
                switch (item.getId()){
                    case ID_Home:
                        name="Home";
                        break;
                    case ID_Message:
                        name="Message";
                        break;
                    case ID_Notification:
                        name ="Notification";
                        break;
                    case ID_Account:
                        name="Account";
                        break;
                    default:
                        name="";
                }
                textView.setText(getString(R.string.page_title, name));
            }
        });

        bottomNavigation.show(ID_Home, true);
    }
}