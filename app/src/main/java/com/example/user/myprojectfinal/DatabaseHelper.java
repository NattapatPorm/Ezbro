package com.example.user.myprojectfinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "BTS";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "Symptom";
    public static final String COL_NAME = "SymptomName";
    public static final String COL_DETAIL = "Detail";
    public static final String COL_RISK = "Risk";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " TEXT, " + COL_DETAIL + " TEXT, "
                + COL_RISK + " TEXT);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_DETAIL
                + ", " + COL_RISK + ") VALUES ('ปวดหัว', 'ปวดหัว ตัวร้อน มีไข้', 'ทุกวัย');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_DETAIL
                + ", " + COL_RISK + ") VALUES ('ท้องเสีย', 'ท้องเสีย ถ่ายเหลว', 'ทุกวัย');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_DETAIL
                + ", " + COL_RISK + ") VALUES ('ปวดข้อ', 'ปวดข้อ ปวดกระดูก', '40-50ปี');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_DETAIL
                + ", " + COL_RISK + ") VALUES ('กรดไหลย้อน', 'กรดไหลย้อน แสบหน้าอก แน่นหน้าอก', '20 ปี ขึ้นไป');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_DETAIL
                + ", " + COL_RISK + ") VALUES ('ไมเกรน', 'ปวดศีรษะเกิดจากความเครียด ปวดไมเกรน', 'ทุกวัย');");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
