package com.example.rok.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }
    void init(){
        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        b3 = (Button)findViewById(R.id.b3);
        b4 = (Button)findViewById(R.id.b4);


    }

    public void onmyclick2(View view) {

        switch (view.getId()){
            case R.id.b1:
                AlertDialog.Builder dlg= new AlertDialog.Builder(this);
                dlg.setTitle("기본대화상자");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setMessage("이것은 기본 대화상자입니다");
                dlg.setNegativeButton("닫기",null);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"확인 버튼을 눌렀습니다",Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
                break;
            case R.id.b2:
                final String data[] = {"치킨","스파게티"};
                AlertDialog.Builder dlg1 = new AlertDialog.Builder(this);
                dlg1.setTitle("라디오 대화상자");
                dlg1.setIcon(R.mipmap.ic_launcher);
                dlg1.setSingleChoiceItems(data, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),data[which],Toast.LENGTH_SHORT).show();
                    }
                });

                dlg1.show();
                break;
            case R.id.b3:
                final String checkstr[] = {"피아노","독서","영화보기"};
                final boolean checked[] = {false,true,false,false};
                AlertDialog.Builder dlg2 = new AlertDialog.Builder(this);
                dlg2.setTitle("취미를 고르세요");
                dlg2.setMultiChoiceItems(checkstr, checked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checked[which]= isChecked;
                    }
                });
                dlg2.setPositiveButton("선택완료", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String str = "";
                        for(int i=0; i<4;i++){
                            if(checked[i])str = str+","+checkstr[i];
                        }
                        Toast.makeText(getApplicationContext(),str.substring(1),Toast.LENGTH_LONG).show();
                    }
                });
                dlg2.show();
                break;
            case R.id.button4:
                View dlgview = View.inflate(this,R.layout.layout2,null);
                final EditText editText = (EditText)dlgview.findViewById(R.id.e2);
                AlertDialog.Builder dlg3 = new AlertDialog.Builder(this);
                dlg3.setPositiveButton("확인",null);
                dlg3.setTitle("사용자 정의 대화상자");
                dlg3.setView(dlgview);
                dlg3.show();
                break;
        }
    }
}
