package com.muhammedazman.wordsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muhammedazman.wordsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var isLinierLAyoutManager = true
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bindig = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindig.root)

        //recyclerView = bindig.recyclerView

        chooseLayout()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)

        val layoutButton = menu?.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                isLinierLAyoutManager = !isLinierLAyoutManager

                chooseLayout()
                setIcon(item)

                return true
            } else -> super.onOptionsItemSelected(item)
        }
    }

    private fun chooseLayout() {
        if (isLinierLAyoutManager) {
            recyclerView.layoutManager = LinearLayoutManager(this)
        } else {
            recyclerView.layoutManager = GridLayoutManager(this, 4)
        }
        recyclerView.adapter = LetterAdapter()
    }

    private fun setIcon(menuItem:MenuItem?){
        if (menuItem == null)
            return

        menuItem.icon =
            if (isLinierLAyoutManager)
                ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)
    }
}