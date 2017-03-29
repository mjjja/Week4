package com.example.kmj.week4;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.TextView;

import static com.example.kmj.week4.R.id.BMI;

public class Calcs extends AppCompatActivity implements TabHost.OnTabChangeListener {
    FrameLayout fl;
    TabHost th;
    EditText et1,et2,et3;
    Button bt1,bt2,bt3;
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcs);
        setTitle("각종 계산기");
        init();
    }

    void tabInit(){
        th.setup();
        TabHost.TabSpec tab1 = th.newTabSpec("BMI").setContent(
            BMI
        ).setIndicator("BMI 계산기");
        th.addTab(tab1);

        TabHost.TabSpec tab2 = th.newTabSpec("AREA").setContent(
                R.id.AREA
        ).setIndicator("각종 계산기");
        th.addTab(tab2);
    }

    void init(){
        fl=(FrameLayout)findViewById(android.R.id.tabcontent);
        th=(TabHost)findViewById(R.id.TH);
        et1=(EditText)findViewById(R.id.Height);
        et2=(EditText)findViewById(R.id.Weight);
        et3=(EditText)findViewById(R.id.Area);
        bt1=(Button)findViewById(R.id.BMICalc);
        bt2=(Button)findViewById(R.id.P2SQ);
        bt3=(Button)findViewById(R.id.SQ2P);
        tv1=(TextView)findViewById(R.id.BMIResult);
        tv2=(TextView)findViewById(R.id.AREAResult);

        tabInit();
        th.setOnTabChangedListener(this);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String height = et1.getText().toString();
                float Height = Float.parseFloat(height);
                String weight = et2.getText().toString();
                float Weight = Float.parseFloat(weight);
                float bmi = Weight/((Height/100)*(Height/100));

                if (bmi<18.5){
                    tv1.setText("체중부족 입니다.");
                }else{
                    if (bmi<23){
                        tv1.setText("정상 입니다");
                    }else{
                        if (bmi<25){
                            tv1.setText("과체중 입니다");
                        }else{
                            tv1.setText("비만 입니다");
                        }
                    }
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String areainput = et3.getText().toString();
                int area = Integer.parseInt(areainput);
                tv2.setText(3.305785*area+" 제곱미터");
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String areainput = et3.getText().toString();
                int area = Integer.parseInt(areainput);
                tv2.setText(0.3025*area+" 평");
            }
        });
    }


    @Override
    public void onTabChanged(String tabId) {
        switch (tabId) {
            case "BMI":
                fl.setBackgroundColor(Color.YELLOW);
                break;
            case "AREA":
                fl.setBackgroundColor(Color.rgb(81,177,209));
                break;
        }
    }
}
