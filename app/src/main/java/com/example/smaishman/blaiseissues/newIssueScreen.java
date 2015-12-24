package com.example.smaishman.blaiseissues;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by smaishman on 12/15/2015.
 */
public class newIssueScreen extends AppCompatActivity {
    protected static final String TAG = "newIssueScreen ";

    TextView identifyText;
    TextView reasonsText;
    TextView objectiveText;
    TextView actionPlanText;
    TextView resultsText;
    DatabaseHandler mydb;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_issue_screen);
        getTextViews();
        mydb = new DatabaseHandler(this);
    }

    public void createIssueDialog(View view){
        switch (view.getId()) {
            case (R.id.identify_button):
                createDialog(identifyText,
                        R.layout.new_issue_wizard_indentify,
                        R.string.wizard_title_issue,
                        R.id.indentify_editText,
                        R.id.ok_button_identify,
                        R.id.cancel_button_identify
                        );
                break;
            case (R.id.reasons_button):
                createDialog(reasonsText,
                        R.layout.new_issue_wizard_reasons,
                        R.string.wizard_title_reasons,
                        R.id.reasons_EditText,
                        R.id.ok_button_reasons,
                        R.id.cancel_button_reasons
                );
                break;
            case (R.id.objective_button):
                createDialog(objectiveText,
                        R.layout.new_issue_wizard_objective,
                        R.string.wizard_title_objective,
                        R.id.objective_editText,
                        R.id.ok_button_objective,
                        R.id.cancel_button_objective
                );
                break;
            case (R.id.action_plan_button):
                createDialog(actionPlanText,
                        R.layout.new_issue_wizard_action_plan,
                        R.string.wizard_title_action_plan,
                        R.id.action_plan_editText,
                        R.id.ok_button_action_plan,
                        R.id.cancel_button_action_plan
                );
                break;
            case (R.id.results_button):
                createDialog(resultsText,
                        R.layout.new_issue_wizard_results,
                        R.string.wizard_title_results,
                        R.id.results_editText,
                        R.id.ok_button_results,
                        R.id.cancel_button_results
                );
                break;
        }
    }

    protected void getTextViews(){
        identifyText = (TextView)findViewById(
                R.id.identivy_content_textView);
        reasonsText = (TextView)findViewById(
                R.id.resons_content_textView);
        objectiveText = (TextView)findViewById(
                R.id.objective_content_textView);
        actionPlanText = (TextView)findViewById(
                R.id.actions_content_textView);
        resultsText = (TextView)findViewById(
                R.id.monitor_content_textView);
    }

    private void createDialog(final TextView viewToEdit,
                              int dialogLayoutID,
                              int dialogTitleID,
                              final int textFieldToChangeID,
                              final int okButtonID,
                              final int cancelButtonID){
        final Dialog dialog = new Dialog(this);
        //set resources depending on issueTypeIDs
        dialog.setContentView(dialogLayoutID);
        dialog.setTitle(getResources().getString(dialogTitleID));
        Button cancelButton = (Button) dialog.findViewById(cancelButtonID);
        Button okButton = (Button) dialog.findViewById(okButtonID);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText message_Edit_Text = (EditText) dialog.findViewById(textFieldToChangeID);
                String dialogMessage = message_Edit_Text.getText().toString();
                viewToEdit.setText(dialogMessage);;
                dialog.dismiss();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void exit(View view){
        this.finish();
    }

    public void saveNewIssue(View view){

        Issue issueFromThisScreen = new Issue();
        TextView name_content_TextView = (TextView) findViewById(
                R.id.identivy_content_textView);

        if(name_content_TextView.getText() != null){
            issueFromThisScreen.set_issueName(name_content_TextView.getText().toString());
        }
        if(objectiveText.getText() != null){
            issueFromThisScreen.set_objective(objectiveText.getText().toString());
        }
        if(reasonsText.getText() != null){
            issueFromThisScreen.set_reasons(reasonsText.getText().toString());
        }
        if(actionPlanText.getText() != null){
            issueFromThisScreen.set_actionPlan(actionPlanText.getText().toString());
        }
        if(resultsText.getText() != null){
            issueFromThisScreen.set_results(resultsText.getText().toString());
        }
        Log.d(TAG, "saveNewIssue: about to right the issue:\n" + issueFromThisScreen.toString());
        mydb.addIssue(issueFromThisScreen);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
