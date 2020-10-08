package com.dorsetcollege.makeroomfordorset

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.dorsetcollege.makeroomfordorset.dao.AppDb
import com.dorsetcollege.makeroomfordorset.models.EmployeeEntity

class MainActivity : AppCompatActivity() {

    fun getRandomString(length: Int) : String {
        val charset = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz0123456789"
        return (1..length)
                .map { charset.random() }
                .joinToString("")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("ROOM-DEMO","APP HAS LAUNCHED")
        Log.i("ROOM-DEMO","Building Database")

        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "EmployeeDB" ).build();

        Thread {
            Log.i("ROOM-DEMO", "Starting Thread 1")
            var emp = EmployeeEntity();

            emp.emp_id = 1
            emp.emp_name =  getRandomString(10)
            emp.emp_post = "Developer"

            Log.i("ROOM-DEMO", emp.emp_name)


        }.start()


        Thread {
            Log.i("ROOM-DEMO", "Starting Thread 2")

            for(emp in db.empDao().readEmp()) {

                Log.i("ROOM-DEMO", emp.emp_id)
                Log.i("ROOM-DEMO", emp.emp_name)
                Log.i("ROOM-DEMO", emp.emp_post)

            }



        }.start()


    }
}