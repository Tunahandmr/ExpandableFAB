package com.tunahan.expandablefab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.tunahan.expandablefab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this,R.anim.rotate_open_anim) }
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(this,R.anim.rotate_close_anim) }
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(this,R.anim.from_bottom_anim) }
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(this,R.anim.to_bottom_anim) }

    private var clicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addFab.setOnClickListener {
            onAddButtonClicked()
        }
    }

    private fun onAddButtonClicked(){

        setVisibility(clicked)
        setAnimation(clicked)
        setClickable(clicked)
        clicked = !clicked

    }

    private fun setAnimation(clicked: Boolean) {

        if (!clicked){
            binding.calendarFab.startAnimation(fromBottom)
            binding.personFab.startAnimation(fromBottom)
            binding.editFab.startAnimation(fromBottom)
            binding.addFab.startAnimation(rotateOpen)

        }else{
            binding.calendarFab.startAnimation(toBottom)
            binding.personFab.startAnimation(toBottom)
            binding.editFab.startAnimation(toBottom)
            binding.addFab.startAnimation(rotateClose)
        }
    }

    private fun setVisibility(clicked: Boolean) {
        if (!clicked){
            binding.calendarFab.visibility = View.VISIBLE
            binding.personFab.visibility = View.VISIBLE
            binding.editFab.visibility = View.VISIBLE
        }else{
            binding.calendarFab.visibility = View.INVISIBLE
            binding.personFab.visibility = View.INVISIBLE
            binding.editFab.visibility = View.INVISIBLE
        }

    }

    private fun setClickable(clicked: Boolean){
        if(!clicked){
            binding.calendarFab.isClickable = true
            binding.editFab.isClickable = true
            binding.personFab.isClickable = true
        }else{
            binding.calendarFab.isClickable = false
            binding.editFab.isClickable = false
            binding.personFab.isClickable = false
        }
    }

}