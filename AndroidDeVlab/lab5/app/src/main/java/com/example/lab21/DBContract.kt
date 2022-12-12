package com.example.lab21

import android.provider.BaseColumns

object DBContract
{
    // Table contents are grouped together in an anonymous object.
    object UserEntry : BaseColumns {
        const val TABLE_NAME = "users"
        const val COLUMN_NAME_EMAIL = "email"
        const val COLUMN_NAME_PASSWORD = "password"
    }

    private const val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${UserEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${UserEntry.COLUMN_NAME_EMAIL} TEXT," +
                "${UserEntry.COLUMN_NAME_PASSWORD} TEXT)"

    private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${UserEntry.TABLE_NAME}"

    fun DBCreateStr(): String {
        return SQL_CREATE_ENTRIES
    }

    fun DBDeleteStr(): String {
        return SQL_DELETE_ENTRIES
    }
}