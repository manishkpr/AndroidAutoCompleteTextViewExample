package com.manishkpr.autotextviewexample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import com.manishkpr.autocompletetextview.example.R;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.autoComplete);
		acTextView.setAdapter(new SuggestionAdapter(this,acTextView.getText().toString()));
	}
}
