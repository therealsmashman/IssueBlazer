package com.example.smaishman.blaiseissues;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by smaishman on 12/11/2015.
 */
public class issueEditorActivity extends AppCompatActivity {
        DatabaseHandler mydb;

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.issue_editor);
            Bundle b = getIntent().getExtras();
            int thisIssueID = b.getParcelable("inIssueID");
            Issue issueForThisScreen = getIssueFromDB(thisIssueID);
            setIssueFields(issueForThisScreen);

            mydb = new DatabaseHandler(this);
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

        public void saveChangedIssue(View view){
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

            Issue issueFromDB = getIssueFromDB(view.getId());


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
    public void cancel(View view){
        this.finish();
    }

    public Issue getIssueFromDB(int issueID){

        return mydb.getIssue(issueID);

    }

}

