package com.cos.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";

    private TextView tvCount; // 전역변수로
    private Button btnAdd;
    private Button btnMinus;

    private int count; // 상태 데이터


    @Override
    protected void onCreate(Bundle savedInstanceState) {
//      디버그의 d, warning w, error e
        Log.d(TAG, "onCreate: Start");
        super.onCreate(savedInstanceState);
//        try {
//            Thread.sleep(3000); // 로딩 시간 -> 로딩 화면
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        setContentView(R.layout.activity_main); // inflate (부풀리다)

        // 통신 -> 다운로드 -> 그림그릴 예정!!!
        // 통신이 아무리 무거워도 그림은 한번만 그려짐


        init();
        initData(); // 데이터를 다운받고
        initListener(); // init 전에 실행하면 버튼이 null이므로 실행 자체가 되지 않음


    } // onCreate 함수가 종료될 때 그림이 그려진다. -> 종료되기 전에는 그림이 그려지지 않는다. 왜?


    // 메모리에 로드 된 애들 찾을 거야. 힙의 주소만 찾으면 됨
    // init : 초기화 -> 전역변수로 관리해야함
    // view를 찾는 함수 not make!!!!
    private void init(){
        // 타입만 알면 됨
        tvCount = findViewById(R.id.tvCount);
        btnAdd = findViewById(R.id.btnAdd);
        btnMinus = findViewById(R.id.btnMinus);


    }

    private void initData(){
        CountProvider countProvider = new CountProvider();
        new Thread(()->{
            count = countProvider.download();
            tvCount.setText(count+"");
        }).start();
        tvCount.setText("로딩중..");
    }


    // 리스너 등록
    private void initListener(){
        // 함수의 목적을 알면 쉽다
        btnAdd.setOnClickListener((View v)-> {
            count = count + 1;
            tvCount.setText(count+"");
        });

        btnMinus.setOnClickListener((View v)-> {
            count = count - 1;
            tvCount.setText(count+"");
        });


    }


}