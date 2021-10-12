package com.example.netcheckapp;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private List<DataModel> dataModels;
    private ApiInterface apiInterface;
    private Adapter adapter;

    private BroadcastReceiver MyReceiver = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv=(RecyclerView)findViewById(R.id.recyclerview);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        MyReceiver = new MyReceiver();

        broadcastIntent();

    }

    public void CallData()
    {
        apiInterface=RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
        Call<List<DataModel>> call=apiInterface.getDataModels();
        call.enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                dataModels=response.body();
                adapter=new Adapter(dataModels,MainActivity.this);
                rv.setAdapter(adapter);

            }
            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Error1", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void broadcastIntent() {
        registerReceiver(MyReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(MyReceiver);

    }

    @Override
    protected void onStart() {
        super.onStart();
        CallData();

    }
    @Override
    protected void onResume() {
        super.onResume();
        CallData();

    }

}