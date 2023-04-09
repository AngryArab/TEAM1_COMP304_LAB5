package com.example.team1_comp304_lab5

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

object MedicineDao {


    private val database = Firebase.database
    private val myRef = database.getReference("test")

    private val tag = "MedicineDao"

    var liveMedicineList = MutableLiveData<ArrayList<Medicine>>()

    init {
        myRef.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                var tempList = arrayListOf<Medicine>()
                if(snapshot.exists()){
                    for(MedicineSnap in snapshot.children){
                        val s = MedicineSnap.getValue<Medicine>()
                        tempList.add(s!!)

                    }
                }

                liveMedicineList.value = tempList

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }




    fun insert(medicine : Medicine){
        val key = myRef.push().key



        if (key != null) {
            medicine.name = key

            myRef.child(key!!).setValue(medicine)


        }

    }



    fun update(medicine : Medicine){

        myRef.child(medicine.name!!).setValue(medicine)


    }


    fun delete(medicine : Medicine){
        myRef.child(medicine.name!!).removeValue()
    }







}