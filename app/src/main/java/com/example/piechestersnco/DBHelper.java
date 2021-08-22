package com.example.piechestersnco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.piechestersnco.Models.CartModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    final static String DBName = "madproject.db";
    final static int DBversion=1;

    public DBHelper(@Nullable Context context) { //Constructor
        super(context, DBName, null, DBversion);//(context:loc of DB)
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table orders "+
                "(id integer primary key autoincrement,"+
                        "name text,"+
                        "phone text,"+
                        "price int,"+
                        "image int,"+
                        "quantity int,"+
                        "description text,"+
                        "foodname text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table if exists orders");
        onCreate(db);
    }

    public boolean insertOrder(String name, String phone, int price, int image, String desc, String foodName, int quantity) {
        SQLiteDatabase database=getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("name", name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("description",desc);
        values.put("foodname",foodName);
        values.put("quantity",quantity);
        long id=database.insert("orders", null, values);
        if(id<=0) //if no insertion occurs
            return false;
        else
            return true;

    }

    public boolean updateOrder(String name, String phone, int price, int image, String desc, String foodName, int quantity, int id) {
        SQLiteDatabase database=getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("name", name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("description",desc);
        values.put("foodname",foodName);
        values.put("quantity",quantity);
        long row=database.update("orders",values,"id="+id,null);
        if(row<=0) //if no insertion occurs
            return false;
        else
            return true;

    }

    public int deleteOrder(String id) {
        SQLiteDatabase database=this.getWritableDatabase();
        return database.delete("orders", "id="+id, null);
    }


    public ArrayList<CartModel> getOrders() {
        ArrayList<CartModel> orders = new ArrayList<>();
        SQLiteDatabase database= this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id,foodname,image,price from orders", null);
        if(cursor.moveToFirst()) {
            while(cursor.moveToNext()) {
                CartModel model = new CartModel();
                model.setOrderNumber(cursor.getInt(0)+"");
                model.setSoldItemName(cursor.getString(1));
                model.setCartImage(cursor.getInt(2));
                model.setPrice(cursor.getInt(3)+"");
                orders.add(model);
            }
        }

        cursor.close();
        database.close();
        return orders;
    }

    public Cursor getOrderById(int id) {
        SQLiteDatabase database= this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from orders where id = "+id, null);

        if(cursor!=null)
            cursor.moveToFirst();

        return cursor;

    }
}
