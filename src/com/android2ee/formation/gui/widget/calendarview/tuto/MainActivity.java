package com.android2ee.formation.gui.widget.calendarview.tuto;

import java.util.Locale;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	CalendarView cView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cView = (CalendarView) findViewById(R.id.calendarView1);
		cView.setOnDateChangeListener(new OnDateChangeListener() {

			@Override
			public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
				dateChanghed(year, month, dayOfMonth);

			}

		});
	}

	/**
	 * @param year
	 * @param month
	 * @param dayOfMonth
	 */
	private void dateChanghed(int year, int month, int dayOfMonth) {
		Toast.makeText(this, "new date selected" + year + "//" + month + "//" + dayOfMonth, Toast.LENGTH_SHORT).show();
		 changeLocale();
	}
	
	public  void changeLocale()
	{
	    final Resources res = getResources();
	    final Configuration conf = res.getConfiguration();
	    
	    {
	        int orientation=conf.orientation;
	        if(orientation==Configuration.ORIENTATION_LANDSCAPE) {
	        	conf.orientation=Configuration.ORIENTATION_PORTRAIT;
	        }else if(orientation==Configuration.ORIENTATION_PORTRAIT) {
	        	conf.orientation=Configuration.ORIENTATION_LANDSCAPE;
	        }else {
	        	//Do nothing the configuration is either Configuration.ORIENTATION_SQUARE; Configuration.ORIENTATION_UNDEFINED;
	        	
	        }
	    }

	    res.updateConfiguration(conf, null);
	    onConfigurationChanged(conf);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
