package com.example.smaishman.blaiseissues;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by smaishman on 12/6/2015.
 */
public class issueAdderActivity extends AppCompatActivity {
    DatabaseHandler mydb;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.issue_adder);

        mydb = new DatabaseHandler(this);
    }

    public void saveNewIssue(View view){
        EditText name_content_TextView = (EditText) findViewById(
                R.id.enter_name_editText);
        EditText reasons_content_TextView = (EditText) findViewById(
                R.id.enter_reasons_editText);
        EditText objective_content_TextView = (EditText) findViewById(
                R.id.enter_objective_editText);
        EditText actions_content_TextView = (EditText) findViewById(
                R.id.enter_action_plane_editText);
        EditText actions_results_TextView = (EditText) findViewById(
                R.id.enter_results_editText);

        Issue issueFromThisScreen = new Issue(
                name_content_TextView.getText().toString(),
                reasons_content_TextView.getText().toString(),
                objective_content_TextView.getText().toString(),
                actions_content_TextView.getText().toString(),
                actions_results_TextView.getText().toString());

        mydb.addIssue(issueFromThisScreen);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
