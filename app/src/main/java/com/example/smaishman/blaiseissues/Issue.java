package com.example.smaishman.blaiseissues;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by smaishman on 12/5/2015.
 */
public class Issue implements Parcelable {

    private String _issueName;
    private String _issueDescription;
    private String _reasons;
    private String _objective;
    private String _actionPlan;
    private String _results;
    private int _id;
    private int _completenessAsPercent;

    /*
    Basic constructor
     */
    public Issue(String inIssueName, String inReason,
                 String inObjective, String inActionPlan,
                 String inResults) {
        _issueName = inIssueName;
        _reasons = inReason;
        _objective = inObjective;
        _actionPlan = inActionPlan;
        _results = inResults;
    }

    public Issue(String inIssueName, String inDescription){
        _issueName = inIssueName;
        _issueDescription = inDescription;
    }

    public Issue() {
        _issueName = "";
        _reasons = "";
        _objective = "";
        _actionPlan = "";
        _results = "";
    }

    public String get_actionPlan() {
        return _actionPlan;
    }

    public void set_actionPlan(String inActionPlan) { _actionPlan = inActionPlan; }

    public String get_issueName() {
        return _issueName;
    }

    public void set_issueName(String inIssueName) { _issueName = inIssueName; }

    public String get_objective() {
        return _objective;
    }

    public void set_objective(String inObjective) { _objective = inObjective; }

    public String get_reasons() {
        return _reasons;
    }

    public void set_reasons(String inResaons) { _reasons = inResaons; }

    public String get_results() {
        return _results;
    }

    public void set_results(String inResults) { _results = inResults; }

    public int get_id() {
        return _id;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(_issueName);
        out.writeString(_issueDescription);
        out.writeString(_reasons);
        out.writeString(_objective);
        out.writeString(_actionPlan);
        out.writeString(_results);
    }

    public static final Parcelable.Creator<Issue> CREATOR
            = new Parcelable.Creator<Issue>() {
        public Issue createFromParcel(Parcel in) {
            return new Issue(in);
        }

        public Issue[] newArray(int size) {
            return new Issue[size];
        }
    };

    public Issue(Parcel in) {
        _issueName = in.readString();
        _issueDescription = in.readString();
        _reasons = in.readString();
        _objective = in.readString();
        _actionPlan = in.readString();
        _results = in.readString();
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        String NEW_LINE = System.getProperty("line.separator");

        result.append(this.getClass().getName());
        result.append(" Name "+ _issueName + NEW_LINE);
        result.append("Description "+ _issueDescription + NEW_LINE);
        result.append("Reasons "+ _reasons + NEW_LINE);
        result.append("Objects "+ _objective + NEW_LINE);
        result.append("Actions "+ _actionPlan + NEW_LINE);
        result.append("Results "+ _results + NEW_LINE);
        return result.toString();
    }

    public int getProgressPercent(){
        int percentCompleted = 0;
        if(!_issueName.isEmpty()){
            percentCompleted+=20;
        }
        if(!_reasons.isEmpty()){
            percentCompleted+=20;
        }
        if(!_objective.isEmpty()){
            percentCompleted+=20;
        }
        if(!_actionPlan.isEmpty()){
            percentCompleted+=20;
        }
        if(!_results.isEmpty()){
            percentCompleted+=20;
        }
        return percentCompleted;
    }
}
