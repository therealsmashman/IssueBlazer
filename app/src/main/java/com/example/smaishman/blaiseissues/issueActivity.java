package com.example.smaishman.blaiseissues;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by smaishman on 12/5/2015.
 */
public class issueActivity extends AppCompatActivity {
    Issue issueForThisScreen;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.issue_veiwer);

        Bundle b = getIntent().getExtras();
        issueForThisScreen = b.getParcelable("inIssue");
        setIssueFields(issueForThisScreen);
    }

    private void setIssueFields(Issue inIssue){
        TextView identify_content_TextView = (TextView) findViewById(
                R.id.identivy_content_textView);
        identify_content_TextView.setText(inIssue.get_issueName());

        TextView reason_content_TextView = (TextView) findViewById(
                R.id.resons_content_textView);
        reason_content_TextView.setText(inIssue.get_reasons());

        TextView objective_content_TextView = (TextView) findViewById(
                R.id.objective_content_textView);
        objective_content_TextView.setText(inIssue.get_objective());

        TextView action_plan_content_TextView = (TextView) findViewById(
                R.id.actions_content_textView);
        action_plan_content_TextView.setText(inIssue.get_actionPlan());

        TextView results_content_TextView = (TextView) findViewById(
                R.id.monitor_content_textView);
        results_content_TextView.setText(inIssue.get_results());
    }

    public void goToEditScreen(View view){
        Log.d("issueActivity"," goToEditScreen : with issue: "+ issueForThisScreen.toString());
        Log.d("issueActivity"," goToEditScreen : with issue ID : "+ issueForThisScreen.get_id());
        Intent intent = new Intent(this, EditIssueActivity.class);
        intent.putExtra("inIssue", issueForThisScreen);
        startActivity(intent);
    }


}
