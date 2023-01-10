package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragment.fragment.Fragment1
import com.example.fragment.fragment.Fragment2

class MainActivity : AppCompatActivity(), Fragment1.Fragment1Listener,Fragment2.Fragment2Listener {
    lateinit var fragment1: Fragment1
    lateinit var fragment2: Fragment2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragment1 = Fragment1()
        fragment2 = Fragment2()

        supportFragmentManager.beginTransaction().replace(R.id.container_a,fragment1).replace(R.id.container_b,fragment2).commit()
    }

    override fun onInput1Sent(input: CharSequence) {
        fragment2.updateEditText(input)
    }

    override fun onInput2Sent(input: CharSequence) {
        fragment1.updateEditText(input)
    }
}