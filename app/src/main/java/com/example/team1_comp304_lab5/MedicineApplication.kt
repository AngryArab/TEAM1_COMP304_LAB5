package com.example.team1_comp304_lab5
import android.app.Application

class MedicineApplication: Application() {


    val repository by lazy { MedicineRepository(MedicineDao) }


}