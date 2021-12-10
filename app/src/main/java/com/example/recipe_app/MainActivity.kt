package com.example.recipe_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.recipe_app.databinding.ActivityMainBinding
import com.example.recipe_app.view.BreakfastFragment
import com.example.recipe_app.view.DessertFragment
import com.example.recipe_app.view.VegetarianFragment

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        supportActionBar?.hide()
        setCurrentFragment(BreakfastFragment())
        mainBinding.navMain.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.breakfast_menu -> setCurrentFragment(BreakfastFragment())
                R.id.dessert_menu -> setCurrentFragment(DessertFragment())
                R.id.vegetarian_menu -> setCurrentFragment(VegetarianFragment())
            }
            true
        }
    }
    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_main,fragment)
            commit()
        }
}