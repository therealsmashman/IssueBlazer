package com.example.smaishman.blaiseissues;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class NewIssueWizardObjective extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_issue_wizard_objective);
    }
    public void gotToNextScreen(View view){
        Intent intent = new Intent(this, NewIssueWizardReasons.class);
        startActivity(intent);
    }
}
