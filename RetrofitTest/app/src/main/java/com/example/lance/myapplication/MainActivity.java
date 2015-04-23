package com.example.lance.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends Activity {
    ListView mListView;
    Callback<List<MyClient.User>> callback = new Callback<List<MyClient.User>>() {
        @Override
        public void success(List<MyClient.User> users, Response response) {
            ArrayAdapter<MyClient.User> arrayAdapter = new ArrayAdapter<MyClient.User>(MainActivity.this, android.R.layout.simple_list_item_1, users);
            mListView.setAdapter(arrayAdapter);
        }

        @Override
        public void failure(RetrofitError retrofitError) {
            Log.e("Retrofit", retrofitError.toString());
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);
        MyClient.getUsers(callback);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
