package com.manishkpr.autotextviewexample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParse {
	 double current_latitude,current_longitude;
	 public JsonParse(){}
	 public JsonParse(double current_latitude,double current_longitude){
		 this.current_latitude=current_latitude;
		 this.current_longitude=current_longitude;
	 }
	 public List<SuggestGetSet> getParseJsonWCF(String sName)
		{
		 List<SuggestGetSet> ListData = new ArrayList<SuggestGetSet>();
		 try {
			String temp=sName.replace(" ", "%20");
			URL js = new URL("http://webheavens.com/suggestion.php?name="+temp);
			URLConnection jc = js.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(jc.getInputStream()));
            String line = reader.readLine();
            JSONObject jsonResponse = new JSONObject(line);
            JSONArray jsonArray = jsonResponse.getJSONArray("results");
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject r = jsonArray.getJSONObject(i);
                ListData.add(new SuggestGetSet(r.getString("id"),r.getString("name")));
        	}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 return ListData;
		 
		}
	 
}
