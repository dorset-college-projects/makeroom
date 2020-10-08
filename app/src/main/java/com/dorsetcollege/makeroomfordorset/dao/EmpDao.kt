package com.dorsetcollege.makeroomfordorset.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dorsetcollege.makeroomfordorset.models.EmployeeEntity


@Dao
interface EmpDao {

    @Insert
    fun saveEmp(emp: EmployeeEntity);

    @Query("select * from EmployeeEntity")
    fun readEmp() : List<EmployeeEntity>;

}