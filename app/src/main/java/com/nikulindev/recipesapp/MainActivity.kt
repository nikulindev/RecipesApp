package com.nikulindev.recipesapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.nikulindev.recipesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val fragment = CategoriesListFragment()

            val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()

            fragmentTransaction.replace(R.id.mainContainer, fragment)

            fragmentTransaction.commit()
        }
    }
}