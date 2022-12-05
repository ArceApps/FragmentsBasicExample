package com.arceapps.fragmentsbasicexample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            addSecondFragment()
            addFragmentWithParams()
        }
    }

    private fun addSecondFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<SecondFragment>(R.id.fragment_container2)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun addFragmentWithParams() {
        val bundle: Bundle = bundleOf(FragmentWithParams.ARG_PARAM1 to "FragmentParam1",
        FragmentWithParams.ARG_PARAM2 to "FragmentParam2")
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<FragmentWithParams>(R.id.fragment_container3, args = bundle)
        }
        val textView = findViewById<TextView>(R.id.textView)
        val parameter1 = bundle.getString("param1").orEmpty()
        val parameter2 = bundle.getString("param2").orEmpty()
        textView.text = "$parameter1 - $parameter2"
    }
}