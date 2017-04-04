package com.example.rok.myapplication;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    void init(){
        b1 = (Button)findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        e1 = (EditText)findViewById(R.id.editText);
        e2 = (EditText)findViewById(R.id.editText2);

    }


    public void onmyclick(View view) {
        String a = e1.getText().toString();
        String b= e2.getText().toString();
        switch(view.getId()){
            case R.id.button1:
                makeText(getApplicationContext(),"일반 메세지 창입나다",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                Toast toastview = Toast.makeText(getApplicationContext(),"위치 지정 메세지입니다",Toast.LENGTH_SHORT);
                toastview.setGravity(Gravity.CENTER,Integer.parseInt(a),Integer.parseInt(b));
                toastview.show();
                break;
            case R.id.button3:
                View view1 = getLayoutInflater().inflate(R.layout.layout,null);
                TextView tv = (TextView)view1.findViewById(R.id.tst1) ;
                tv.setText("레이아웃으로 만든 토스트 창입니다");
                Toast toastview1 = new Toast(getApplicationContext());
                toastview1.setDuration(Toast.LENGTH_SHORT);
                toastview1.setGravity(Gravity.CENTER,0,100);
                toastview1.setView(view1);
                toastview1.show();
                break;
            case R.id.button4:
                Snackbar.make(view,"SnackBar로 보여주는 메세지에요(확인을 누르면 대화상자에대해서 넘어가요",Snackbar.LENGTH_SHORT).setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(intent);                    }
                }).show();
                break;


        }

    }
}
