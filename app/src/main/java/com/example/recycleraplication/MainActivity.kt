package com.example.recycleraplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object{
        val basicList = arrayListOf("Ala","Ola","Ewa","Jan")
        val redoList = arrayListOf<String>()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        refreshRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_details,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
     /*   if(item.itemId == R.id.InfoBT){
            var info = Toast.makeText(applicationContext,getString(R.string.textForInfoBt),Toast.LENGTH_SHORT)
                .show()

        }
        else if (item.itemId ==R.id.closeBT){
            var info =Toast.makeText(applicationContext,"wybrano przycisk zamykania aplikacji", Toast.LENGTH_SHORT)
                .show()
        }*/
        //switch w kotlinie
        when(item.itemId){
            R.id.InfoBT -> Toast.makeText(applicationContext,getString(R.string.textForInfoBt),Toast.LENGTH_SHORT).show()
            R.id.closeBT->  Toast.makeText(applicationContext,getString(R.string.textForCloseBt), Toast.LENGTH_SHORT).show()

        }
        return super.onOptionsItemSelected(item)
    }

    fun deleteLast(view: View) {
        if (basicList.size>0){
            redoList.add(basicList.last())
            basicList.remove(basicList.last())
        }
        else Toast.makeText(applicationContext, "tablica jest już pusta", Toast.LENGTH_SHORT).show()
        refreshRecyclerView()
    }
    fun redo(view: View){
        if(redoList.size>0){
            basicList.add(redoList.last())
            redoList.remove(basicList.last())
            refreshRecyclerView()
        }

    }

    private fun refreshRecyclerView(){
        val recyclerView= findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = RecyclerAdapter(applicationContext)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

}