package com.example.smaishman.blaiseissues;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by smaishman on 12/17/2015.
 */
public class EditIssueActivity  extends newIssueScreen{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_issue_screen);

        mydb = new DatabaseHandler(this);
        Bundle b = getIntent().getExtras();
        Issue issueForThisScreen = b.getParcelable("inIssue");
        getTextViews();
        setIssueFields(issueForThisScreen);
    }

    private void setIssueFields(Issue inIssue){
        Log.d("EditIssueActivity", " setting fields with issue: "+inIssue.toString());
        identifyText.setText(inIssue.get_issueName());
        reasonsText.setText(inIssue.get_reasons());
        objectiveText.setText(inIssue.get_objective());
        actionPlanText.setText(inIssue.get_actionPlan());
        resultsText.setText(inIssue.get_results());
    }
}
