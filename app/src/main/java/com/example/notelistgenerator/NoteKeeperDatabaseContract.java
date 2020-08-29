package com.example.notelistgenerator;

import android.provider.BaseColumns;

public final class NoteKeeperDatabaseContract {
    private NoteKeeperDatabaseContract(){}

    public static final class CourseEntry implements BaseColumns {
        public static final String TABLE_NAME="course_info";
        public static final String COLUMNS_COURSE_ID="course_id";
        public static final String COLUMNS_COURSE_TITLE="course_title";

        //CREATE TABLE course_info(course_id,course_title)

       public static final String SQL_CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+_ID+" INTEGER PRIMARY KEY,"+COLUMNS_COURSE_ID+" TEXT UNIQUE NOT NULL,"+COLUMNS_COURSE_TITLE+" )";
    }
    public static final class NoteInfoEntry implements BaseColumns{
        public static final String TABLE_NAME="note_info";
        public static final String COLUMNS_NOTE_TITLE="note_title";
        public static final String COLUMNS_NOTE_TEXT="note_text";
        public static final String COLUMN_COURSE_ID="course_id";

       public static final String SQL_CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+_ID+" INTEGER PRIMARY KEY ,"+COLUMNS_NOTE_TITLE+" TEXT,"+COLUMNS_NOTE_TEXT+" TEXT,"+COLUMN_COURSE_ID+" NOT NULL )";
    }
}
