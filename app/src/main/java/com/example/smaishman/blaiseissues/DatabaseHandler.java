package com.example.smaishman.blaiseissues;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smaishman on 12/6/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "issueManager";

    // Contacts table name
    private static final String TABLE_ISSUES = "issue";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String ISSUE_COLUMN_ISSUE_NAME = "issue_name";
    private static final String ISSUE_COLUMN_REASONS = "reasons";
    private static final String ISSUE_COLUMN_OBJECTIVE = "objective";
    private static final String ISSUE_COLUMN_ACTION_PLAN = "action_plan";
    private static final String ISSUE_COLUMN_RESULTS = "results";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_ISSUES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + ISSUE_COLUMN_ISSUE_NAME + " TEXT,"
                + ISSUE_COLUMN_REASONS + " TEXT," + ISSUE_COLUMN_OBJECTIVE + " TEXT,"
                + ISSUE_COLUMN_ACTION_PLAN + " TEXT," + ISSUE_COLUMN_RESULTS + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ISSUES);

        // Create tables again
        onCreate(db);
    }

    public void addIssue(Issue issue) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ISSUE_COLUMN_ISSUE_NAME, issue.get_issueName());
        values.put(ISSUE_COLUMN_REASONS, issue.get_reasons());
        values.put(ISSUE_COLUMN_OBJECTIVE, issue.get_objective());
        values.put(ISSUE_COLUMN_ACTION_PLAN, issue.get_actionPlan());
        values.put(ISSUE_COLUMN_REASONS, issue.get_reasons());
        values.put(ISSUE_COLUMN_RESULTS, issue.get_results());

        // Inserting Row
        db.insert(TABLE_ISSUES, null, values);
        db.close(); // Closing database connection
    }

    public void updateIssue(Issue editedIssue){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ISSUE_COLUMN_ISSUE_NAME, editedIssue.get_issueName());
        values.put(ISSUE_COLUMN_REASONS, editedIssue.get_reasons());
        values.put(ISSUE_COLUMN_OBJECTIVE, editedIssue.get_objective());
        values.put(ISSUE_COLUMN_ACTION_PLAN, editedIssue.get_actionPlan());
        values.put(ISSUE_COLUMN_REASONS, editedIssue.get_reasons());
        values.put(ISSUE_COLUMN_RESULTS, editedIssue.get_results());
        db.update(TABLE_ISSUES, values, ISSUE_COLUMN_ISSUE_NAME + " = ? ", new String[]{editedIssue.get_issueName()});

    }

    public Issue getIssue(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ISSUES, new String[] { KEY_ID,
                        ISSUE_COLUMN_ISSUE_NAME, ISSUE_COLUMN_REASONS,
                        ISSUE_COLUMN_OBJECTIVE, ISSUE_COLUMN_ACTION_PLAN,
                        ISSUE_COLUMN_RESULTS}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Issue issue = new Issue(
                cursor.getString(cursor.getColumnIndex(ISSUE_COLUMN_ISSUE_NAME)),
                cursor.getString(cursor.getColumnIndex(ISSUE_COLUMN_REASONS)),
                cursor.getString(cursor.getColumnIndex(ISSUE_COLUMN_OBJECTIVE)),
                cursor.getString(cursor.getColumnIndex(ISSUE_COLUMN_ACTION_PLAN)),
                cursor.getString(cursor.getColumnIndex(ISSUE_COLUMN_RESULTS))
        );
        // return contact
        return issue;
    }

    public List<Issue> getAllContacts() {
        List<Issue> issueList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ISSUES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Issue newIssue = new Issue(
                        cursor.getString(cursor.getColumnIndex(ISSUE_COLUMN_ISSUE_NAME)),
                        cursor.getString(cursor.getColumnIndex(ISSUE_COLUMN_REASONS)),
                        cursor.getString(cursor.getColumnIndex(ISSUE_COLUMN_OBJECTIVE)),
                        cursor.getString(cursor.getColumnIndex(ISSUE_COLUMN_ACTION_PLAN)),
                        cursor.getString(cursor.getColumnIndex(ISSUE_COLUMN_RESULTS))
                );
                // Adding contact to list
                issueList.add(newIssue);
            } while (cursor.moveToNext());
        }

        // return contact list
        return issueList;
    }

    public List<String> getAllIssueNames(){
        List<String> issueNameList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ISSUES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                issueNameList.add(cursor.getString(cursor.getColumnIndex(ISSUE_COLUMN_ISSUE_NAME)));
            } while (cursor.moveToNext());
        }

        return issueNameList;
    }

    public int getIssuesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_ISSUES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    public void clearTable()   {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ISSUES, null,null);
    }

    public void deleteIssue(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ISSUES, KEY_ID + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
    }
}
