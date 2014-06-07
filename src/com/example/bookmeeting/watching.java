
package com.example.bookmeeting;




import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
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

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import android.widget.EditText;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.EditText;



public class watching extends Activity {
	private static final String TAG = "MainActivity";
	JSONArray jArray;
    /** Called when the activity is first created. */
  static String result = "";
  ListView list; 
  public String user;
  ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>(); 
  

  @SuppressLint("NewApi")
  @Override
  public void onCreate(Bundle savedInstanceState) {

      super.onCreate(savedInstanceState);     
        
      setContentView(R.layout.shuhui);

      if (Build.VERSION.SDK_INT >= 11) {
          StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads     ().detectDiskWrites().detectNetwork().penaltyLog().build());
       StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());
      }
      Bundle b = getIntent().getExtras();
      user = b.getString("name");
    	
    	
    	
				
		    	
		    	
		    	String url = "http://1.tsthelo.sinaapp.com/meeting_result.php";
		        HttpPost httpRequest = new HttpPost(url);
		        
		        List<NameValuePair> params = new ArrayList<NameValuePair>();
		        
		        
		        try {
					HttpEntity httpEntity = new UrlEncodedFormEntity(params,"utf-8");
					httpRequest.setEntity(httpEntity);
					
					HttpClient httpClient = new DefaultHttpClient();
					HttpResponse httpResponse = httpClient.execute(httpRequest);
					
					if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
						result = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
						String bookname;
						String time;
						String add;
						String other;
						String username;
						int num;
						int meetingId;
						
				              try {
	
					                  jArray = new JSONArray(result);
		
					                  JSONObject json_data = null;
		
					                  for (int i = 0; i < jArray.length(); i++) {
		
					                     json_data = jArray.getJSONObject(i);
		                                 meetingId = json_data.getInt("meetingId");
					                     bookname = json_data.getString("bookname");
					                     time = json_data.getString("time");
					                     add = json_data.getString("add");
					                     other = json_data.getString("other");
					                     username = json_data.getString("username");
					                     num = json_data.getInt("num");
					                     HashMap<String, String> map = new HashMap<String, String>();  
					            	      map.put("Time", time);  
					            	      map.put("Pos", add); 
					            	      map.put("Topic", bookname);
					            	      map.put("us", username);
					            	      map.put("note", other);
					            	      map.put("Num", num+"");
					            	      map.put("meetingId", meetingId+"");
					            	      mylist.add(map);  
					                    }
					                  
					            	  SimpleAdapter mSchedule = new SimpleAdapter(this, mylist, R.layout.shuhuilistview,  new String[] {"Time", "Pos", "Topic"}, new int[] {R.id.Time,R.id.Pos,R.id.Topic});  
					            	  
					            	  list = (ListView) findViewById(R.id.ShuhuiListView);  
					            	  list.setAdapter(mSchedule); 
	
				              } catch (JSONException e1) {
	
				                  // Toast.makeText(getBaseContext(), "No City Found"
	
				                  // ,Toast.LENGTH_LONG).show();
	
				              } catch (ParseException e1) {
	
				                  e1.printStackTrace();
	
				              }
						}
						
					
					
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    	
			
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){   
  		  @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {   
                //���ѡ�����HashMap����    
                HashMap<String,String> map=(HashMap<String,String>)list.getItemAtPosition(arg2);   
                String time=map.get("Time");   
                String pos=map.get("Pos");  
                
                final String topic=map.get("Topic");
                String us=map.get("us");
                String num=map.get("Num");
                String note=map.get("note");
                final String meetingId = map.get("meetingId");
                Toast.makeText(getApplicationContext(), "��ѡ���˵�"+arg2+"��Item��Time��ֵ�ǣ�"+time+"Pos��ֵ��:"+pos+"�������ǣ�"+topic, Toast.LENGTH_SHORT).show();   
                setContentView(R.layout.xiangqing);
                TextView SpecificTime = (TextView)findViewById(R.id.SpecificTime);
                TextView SpecificPos = (TextView)findViewById(R.id.SpecificPos);
                TextView SpecificTopic = (TextView)findViewById(R.id.SpecificTopic);
                TextView Faqiren = (TextView)findViewById(R.id.Faqiren);
                TextView PeopleNum = (TextView)findViewById(R.id.PeopleNum);
                TextView Note = (TextView)findViewById(R.id.Note);
                Button Attend = (Button)findViewById(R.id.Attend);
                SpecificTime.setText(time);
                SpecificPos.setText(pos);
                SpecificTopic.setText(topic);
                Faqiren.setText(us);
                Note.setText(note);
                PeopleNum.setText(num);
                Attend.setOnClickListener(new OnClickListener() {
        			@Override
        			public void onClick(View v) {
        				String url = "http://1.tsthelo.sinaapp.com/meeting_attend.php";
        		        HttpPost httpRequest = new HttpPost(url);
        		        
        		        List<NameValuePair> params = new ArrayList<NameValuePair>();
        		        params.add(new BasicNameValuePair("meetingId", meetingId));
        		        
        		        try {
        					HttpEntity httpEntity = new UrlEncodedFormEntity(params,"utf-8");
        					httpRequest.setEntity(httpEntity);
        					
        					HttpClient httpClient = new DefaultHttpClient();
        					HttpResponse httpResponse = httpClient.execute(httpRequest);
        					//showDialog(topic);
        					if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
        						result = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
        						
						
						
					
        						Intent first2Intent=new Intent(watching.this,main_page.class);
                           	 Bundle data = new Bundle();
                           	 data.putString("name", user);
                           	 first2Intent.putExtras(data);
                				startActivity(first2Intent);
        						}
        						
        					
        					
        				} catch (UnsupportedEncodingException e) {
        					// TODO Auto-generated catch block
        					e.printStackTrace();
        				} catch (ClientProtocolException e) {
        					// TODO Auto-generated catch block
        					e.printStackTrace();
        				} catch (IOException e) {
        					// TODO Auto-generated catch block
        					e.printStackTrace();
        				}
        					
        				
        			}
        			
        				
        		});
  		  }   
               
        });	  	
        
    }
  private void showDialog(String msg){
	  	if(msg == null)
	  	{
	  		msg = "123";
	  	}
	  	AlertDialog.Builder builder = new AlertDialog.Builder(this);
	  	
	  	builder.setMessage(msg)
	  	.setCancelable(false)
	  	.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int id) {
					// TODO Auto-generated method stub
					
				}
			});
	  	AlertDialog alert = builder.create();
	  	alert.show();
	  }
  
}