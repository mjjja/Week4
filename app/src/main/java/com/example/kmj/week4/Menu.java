package com.example.kmj.week4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    LinearLayout ll1;
    TextView tv1;
    ImageView iv1,iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        tv1 = (TextView)findViewById(R.id.FlavorText);
        ll1 = (LinearLayout)findViewById(R.id.Linear1);
        iv1 = (ImageView)findViewById(R.id.Chicken);
        iv2 = (ImageView)findViewById(R.id.Spaghetti);

    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.ChangeRed) {
            ll1.setBackgroundColor(Color.RED);
        }
        else if (item.getItemId() == R.id.ChangeBlue) {
            ll1.setBackgroundColor(Color.BLUE);
        }
        else if (item.getItemId() == R.id.ChangeYellow) {
            ll1.setBackgroundColor(Color.YELLOW);
        }
        else if (item.getItemId() == R.id.Rotate) {
            if (iv1.getVisibility()==View.VISIBLE){
                iv1.setRotation(iv1.getRotation()+30);
            }else if (iv2.getVisibility()==View.VISIBLE){
                iv2.setRotation(iv2.getRotation()+30);
            }
        }
        else if (item.getItemId() == R.id.ShowTitle) {
            if (item.isChecked()==false){
                item.setChecked(true);
                tv1.setVisibility(View.VISIBLE);
            }else{
                item.setChecked(false);
                tv1.setVisibility(View.GONE);
            }
        }
        else if (item.getItemId() == R.id.Zoom) {
            if (item.isChecked()==false) {
                item.setChecked(true);
                iv1.setScaleX((float)1.4);
                iv1.setScaleY((float)1.4);
                iv2.setScaleX((float)1.4);
                iv2.setScaleY((float)1.4);
            }else{
                item.setChecked(false);
                iv1.setScaleX(1);
                iv1.setScaleY(1);
                iv2.setScaleX(1);
                iv2.setScaleY(1);
            }
        }
        else if (item.getItemId() == R.id.ChooseChicken) {
            item.setChecked(true);
            iv1.setVisibility(View.VISIBLE);
            iv2.setVisibility(View.GONE);
            tv1.setText("오늘야식치킨");
        }
        else if (item.getItemId() == R.id.ChooseSpaghetti) {
            item.setChecked(true);
            iv1.setVisibility(View.GONE);
            iv2.setVisibility(View.VISIBLE);
            tv1.setText("오늘야식스파게티");
        }
        return super.onOptionsItemSelected(item);
    }
}
