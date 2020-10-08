package com.dorsetcollege.makeroomfordorset.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dorsetcollege.makeroomfordorset.models.EmployeeEntity

@Database(entities = [EmployeeEntity::class], version =1 )
abstract class AppDb : RoomDatabase() {

    abstract fun empDao() : EmpDao
}