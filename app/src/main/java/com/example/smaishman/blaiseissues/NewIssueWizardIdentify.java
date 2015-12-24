package com.example.smaishman.blaiseissues;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class NewIssueWizardIdentify extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_issue_wizard_indentify);
    }

    public void gotToNextScreen(View view){
        Intent intent = new Intent(this, NewIssueWizardObjective.class);
        startActivity(intent);
    }
}
