package com.example.team1_comp304_lab5

import androidx.lifecycle.MutableLiveData

class MedicineRepository(private val medicinedao : MedicineDao) {

    val allMedicine : MutableLiveData<ArrayList<Medicine>> = medicinedao.liveMedicineList

    fun insert(medicine : Medicine){

        medicinedao.insert(medicine)


    }

    fun update(medicine : Medicine){
        medicinedao.update(medicine)
    }

    fun delete(medicine : Medicine){
        medicinedao.delete(medicine)

    }




}