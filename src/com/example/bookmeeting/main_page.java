package com.example.bookmeeting;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ExpandableListView.ExpandableListContextMenuInfo;




import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;


import java.io.InputStream;

import java.io.InputStreamReader;

import java.util.ArrayList;

 

import org.apache.http.HttpEntity;

import org.apache.http.HttpResponse;

import org.apache.http.NameValuePair;

import org.apache.http.client.HttpClient;

import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.DefaultHttpClient;

import org.json.JSONArray;

import org.json.JSONException;

import org.json.JSONObject;

 

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;

import android.net.ParseException;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;

import android.util.Log;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;

import android.widget.EditText;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.EditText;


public class main_page extends Activity{
	public String user;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_main);
        Bundle b = getIntent().getExtras();
        user = b.getString("name");
        showView();
        Button newOneBtn = (Button)findViewById(R.id.newOneBtn);
    	Button whtchingAllBtn = (Button)findViewById(R.id.whtchingAllBtn);
    	Button finish = (Button)findViewById(R.id.finish);
    	Button myshuhuiBtn = (Button)findViewById(R.id.myshuhuiBtn);
    	Button myAttenBtn = (Button)findViewById(R.id.myAttenBtn);
    	newOneBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
                Intent findIntent=new Intent(main_page.this,finding.class);
                Bundle data = new Bundle();
           	    data.putString("name", user);
           	    findIntent.putExtras(data);
				 startActivity(findIntent);
			}
			
				
		});
    	whtchingAllBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
                Intent watchIntent=new Intent(main_page.this,watching.class);
                Bundle data = new Bundle();
           	    data.putString("name", user);
           	    watchIntent.putExtras(data);
				 startActivity(watchIntent);
			}
			
				
		});
    	myshuhuiBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
                Intent findIntent=new Intent(main_page.this,myshuhui.class);
                Bundle data = new Bundle();
           	    data.putString("name", user);
           	    findIntent.putExtras(data);
				 startActivity(findIntent);
			}
			
				
		});
    	myAttenBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
                Intent findIntent=new Intent(main_page.this,Atten.class);
                Bundle data = new Bundle();
           	    data.putString("name", user);
           	    findIntent.putExtras(data);
				 startActivity(findIntent);
			}
			
				
		});
    	finish.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				while(true){
				    System.exit(0);
				}
			}
			
				
		});

        
    }
    public void showView(){	
        
        
        TextView tv1 = (TextView)findViewById(R.id.textView1);
        tv1.setText("ÄúºÃ£¡"+user);
    }

}

	