package com.rs.demo;

import android.content.Intent;
import android.graphics.ColorMatrix;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
public class MainActivity extends AppCompatActivity {
    public static final String TAG = "TAG";

    private ImageButton m_oImaage;
    private RecyclerView recyclerView;

    float[] mColorMatrix = new float[20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        m_oImaage = findViewById(R.id.image);
        m_oImaage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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

}
