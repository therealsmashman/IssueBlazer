package com.example.smaishman.blaiseissues;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<Issue> issueList;
    DatabaseHandler mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new DatabaseHandler(this);
        //populateDB();

        List<String> values = mydb.getAllIssueNames();

        issueList = mydb.getAllContacts();

        // We get the ListView component from the layout
        listView = (ListView) findViewById(R.id.listView);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter);
        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Issue selectedIssue = issueList.get(position);
                goToNewScreen(selectedIssue);
            }
        });
    }

    private void goToNewScreen(Issue inIssue){
        Intent intent1 = new Intent(this, issueActivity.class);
        intent1.putExtra("inIssue", inIssue);
        startActivity(intent1);
    }

    public void gotToNewScreen(View view){
        Intent intent = new Intent(this, newIssueScreen.class);
        startActivity(intent);
    }

    private void populateDB(){
        for(Issue iss :  populateList()){
            mydb.addIssue(iss);
        }
    }

    private ArrayList<Issue> populateList(){
        ArrayList<Issue> newIssueList =  new ArrayList<>();
        newIssueList.add(new Issue(
                "Some identified issue",
                "Some issue reason",
                "Some issuue objective",
                "Some issuue action",
                "Some issuue results"));

        newIssueList.add(new Issue("Identified 2",
                "Reason 2",
                "Objective 2",
                "Action plan 2",
                "Results 2"));

        newIssueList.add(new Issue("Identified 3",
                "Reason 3",
                "Objective 3",
                "Action plan 3",
                "Results 3"));

        newIssueList.add(new Issue("Identified 4",
                "Reason 4",
                "Objective 4",
                "Action plan 4",
                "Results 4"));

        newIssueList.add(new Issue("Identified 5",
                "Reason 5",
                "Objective 5",
                "Action plan 5",
                "Results 5"));


        newIssueList.add(new Issue("Issue 6",
                "Conmpany don't see my value",
                "Get paid more",
                "Prove my worth to the company",
                "Not going so well so far"));

        newIssueList.add(new Issue("Issue 7",
                "Conmpany don't see my value",
                "Get paid more",
                "Prove my worth to the company",
                "Not going so well so far"));

        newIssueList.add(new Issue("Identified 8",
                "Reason 8",
                "Objective 8",
                "Action plan 8",
                "Results 8"));

        newIssueList.add(new Issue("Identified 9",
                "Reason 9",
                "Objective 9",
                "Action plan 9",
                "Results 9"));

        newIssueList.add(new Issue("Identified 10",
                "Reason 10",
                "Objective 10",
                "Action plan 10",
                "Results 10"));

        return newIssueList;
    }
}
