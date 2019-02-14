package com.example.user.myprojectfinal;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Activity2 extends Activity implements  AdapterView.OnItemClickListener {

    SQLiteDatabase mDb;
    DatabaseHelper mHelper;
    Cursor mCursor;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_2);

        ListView listView1 = (ListView) findViewById(R.id.listView1);

        mHelper = new DatabaseHelper(this);
        mDb = mHelper.getWritableDatabase();
        mCursor = mDb.rawQuery("SELECT " + DatabaseHelper.COL_NAME + ", " + DatabaseHelper.COL_DETAIL
                + ", " + DatabaseHelper.COL_RISK + " FROM " + DatabaseHelper.TABLE_NAME, null);

        ArrayList<String> dirArray = new ArrayList<String>();
        mCursor.moveToFirst();

        while (!mCursor.isAfterLast()) {
            dirArray.add(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COL_NAME)) + "\n"
                    + "รายละเอียด : " + mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COL_DETAIL)) + "\t\t"
                    + "ความเสี่ยง : " + mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COL_RISK)));
            mCursor.moveToNext();
        }

        ArrayAdapter<String> adapterDir = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dirArray);
        listView1.setAdapter(adapterDir);
        listView1.setOnItemClickListener(this);
    }

    public void onPause() {
        super.onPause();
        mHelper.close();
        mDb.close();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View v, int position, long l) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String url;
        switch (position) {
            case 0:
                url = "http://haamor.com/th/%E0%B8%A2%E0%B8%B2%E0%B9%81%E0%B8%81%E0%B9%89%E0%B8%9B%E0%B8%A7%E0%B8%94-%E0%B8%A2%E0%B8%B2%E0%B8%9E%E0%B8%B2%E0%B8%A3%E0%B8%B2%E0%B9%80%E0%B8%8B%E0%B8%95%E0%B8%B2%E0%B8%A1%E0%B8%AD%E0%B8%A5/";
                intent.setData(Uri.parse(url));
                startActivity(intent);
                break;
            case 1:
                url = "http://haamor.com/th/%E0%B9%82%E0%B8%AD%E0%B8%AD%E0%B8%B2%E0%B8%A3%E0%B9%8C%E0%B9%80%E0%B8%AD%E0%B8%AA/";
                intent.setData(Uri.parse(url));
                startActivity(intent);
                break;
            case 2:
                url = "http://haamor.com/th/%E0%B8%A2%E0%B8%B2%E0%B8%99%E0%B8%B2%E0%B8%9E%E0%B8%A3%E0%B8%AD%E0%B8%81%E0%B9%80%E0%B8%8B%E0%B8%99/";
                intent.setData(Uri.parse(url));
                startActivity(intent);
                break;
            case 3:
                url = "http://haamor.com/th/%E0%B8%81%E0%B8%A3%E0%B8%94%E0%B9%81%E0%B8%AD%E0%B8%A5%E0%B8%88%E0%B8%B4%E0%B8%99%E0%B8%B4%E0%B8%81/";
                intent.setData(Uri.parse(url));
                startActivity(intent);
                break;
            case 4:
                url = "http://haamor.com/th/%E0%B9%84%E0%B8%AD%E0%B8%9A%E0%B8%B9%E0%B9%82%E0%B8%9B%E0%B8%A3%E0%B9%80%E0%B8%9F%E0%B8%99/";
                intent.setData(Uri.parse(url));
                startActivity(intent);
                break;
        }
    }
}
