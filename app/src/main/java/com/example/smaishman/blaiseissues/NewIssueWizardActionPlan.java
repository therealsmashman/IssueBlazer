package com.example.smaishman.blaiseissues;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by smaishman on 12/14/2015.
 */
public class NewIssueWizardActionPlan extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_issue_wizard_action_plan);
    }
    public void gotToNextScreen(View view){
        Intent intent = new Intent(this, NewIssueWizardResults.class);
        startActivity(intent);
    }
}
