package com.example.sqlitedbex

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context) : SQLiteOpenHelper(context,DB_NAME,null, DB_VERSION)
{
    companion object
    {
        var DB_NAME="Tops.db"
        var TABLE_NAME="Info"
        var ID="id"
        var NAME="name"
        var NUMBER="number"
        var DB_VERSION=1

    }



    override fun onCreate(db: SQLiteDatabase?)
    {
       var query ="CREATE TABLE " + TABLE_NAME + "("+ ID + " INTEGER PRIMARY KEY," + NAME + " TEXT,"+ NUMBER + " TEXT" + ")"

        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    {
            var upquery ="DROP TABLE IF EXISTS "+ TABLE_NAME
            db!!.execSQL(upquery)
            onCreate(db)
    }

    fun insertdata(m:Model) :Long
    {

        var db = writableDatabase
        var values = ContentValues()
        values.put(NAME,m.name)//get
        values.put(NUMBER,m.num)//get
        var id = db.insert(TABLE_NAME,ID,values)
        return id
    }
    fun viewdata():MutableList<Model>
    {
        var db = readableDatabase
        var list :MutableList<Model> = ArrayList()
        var colarray = arrayOf(ID, NAME, NUMBER)
        var cursor:Cursor = db.query(TABLE_NAME,colarray,null,null,null,null,null)

        while(cursor.moveToNext())
        {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var number = cursor.getString(2)

            var m = Model()
            m.id=id
            m.name=name
            m.num=number
            list.add(m)

        }

            return list
    }

    fun deletedata(id:Int)
    {
        var db = writableDatabase
        var deletequery = ID+" = "+id
        db.delete(TABLE_NAME,deletequery,null)
    }

    fun updatedata(m:Model)
    {

        var db = writableDatabase
        var values = ContentValues()
        values.put(ID,m.id)
        values.put(NAME,m.name)//get
        values.put(NUMBER,m.num)//get
        var updatequery = ID+" = "+m.id
        db.update(TABLE_NAME,values,updatequery,null)


    }


}