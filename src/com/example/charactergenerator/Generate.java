package com.example.charactergenerator;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

public class Generate extends Activity {

	private Characteristics characteristics;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.characteristics = new Characteristics(getResources());
		// setContentView(R.layout.activity_generate);
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.activity_generate, null);

		// Find the ScrollView
		ScrollView scrollView = (ScrollView) view
				.findViewById(R.id.scrollView1);

		// Create a LinearLayout element
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);

		for (Group group : characteristics.getGroups()) {
			LinearLayout groupListView = new LinearLayout(this);
			groupListView.setOrientation(LinearLayout.VERTICAL);

			TextView groupLabel = new TextView(this);
			groupLabel.setText(group.getName());
			groupListView.addView(groupLabel);

			for (Attribute attribute : group.getAttributes()) {

				TextView attributeLabel = new TextView(this);
				attributeLabel.setText(attribute.getName());

				Spinner optionsSpinner = new Spinner(this);
				ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						attribute.getOptionsAsStringList());
				optionsSpinner.setAdapter(adp);
				optionsSpinner.setVisibility(View.VISIBLE);

				groupListView.addView(attributeLabel);
				groupListView.addView(optionsSpinner);
			}

			layout.addView(groupListView);
		}

		// Add the LinearLayout element to the ScrollView
		scrollView.addView(layout);

		// Display the view
		setContentView(view);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.generate, menu);
		return true;
	}

}
