package com.rs.demo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rs.demo.basemvp.widght.Demo2Activity;
import com.rs.demo.demoactivity.DemoActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "TAG";

    private ImageButton m_oImaage;
    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private ImageView imageView;
    private List<MainBean> list = new ArrayList<>();
    float[] mColorMatrix = new float[20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        m_oImaage = findViewById(R.id.image);
        imageView = findViewById(R.id.imageview);
        m_oImaage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Demo2Activity.class);
                startActivity(intent);
            }
        });
        getData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainAdapter(list);
        ColorMatrix colorMatrix = new ColorMatrix();
        mColorMatrix[1] = 4;
        colorMatrix.set(mColorMatrix);

        Messenger messenger = new Messenger(handler1);
        Message message = new Message();
        Looper looper = handler1.getLooper();
        message.obj = "sdafdsgds";
        try {
            messenger.send(message);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }



    Handler handler1 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    Handler handler2 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    private void getData() {
        int i = -1;
        i >>>= 10;
        System.out.println(i);
        long l = -1;
        l >>>= 10;
        System.out.println(l);
        short s = -1;
        s >>>= 10;
        System.out.println(l);
        byte b = -1;
        b >>>= 10;
        System.out.println(b);
        Log.e(TAG, "getData: "+i+"s:"+s+"b:"+b );
/*        for (int i = 0; i < 5; i++) {
            MainBean bean;
            if(i%2==0){
              bean = new MainBean(MainBean.TEXT);
            }else {
                bean = new MainBean(MainBean.IMG);
            }
              bean.setName("数据"+i);
              bean.setPosition(i);
              list.add(bean);
        }
    }*/
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("TAG", "dispatchTouchEvent: " + "main_Down");

                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                Log.e("TAG", "dispatchTouchEvent: " + "main_up");
                break;
        }
      return super.dispatchTouchEvent(ev);
   //  return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
     switch (event.getAction()){
         case MotionEvent.ACTION_DOWN:
             Log.e("TAG", "onTouchEvent: "+"main_Down" );

             break;
         case MotionEvent.ACTION_MOVE:
             break;
         case MotionEvent.ACTION_UP:
             Log.e("TAG", "onTouchEvent: "+"main_up" );
             break;
     }

        return super.onTouchEvent(event);
       // return true;
    }

}
