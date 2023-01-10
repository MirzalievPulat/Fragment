package com.example.fragment.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.fragment.R

class Fragment2:Fragment() {
    var listener:Fragment2Listener? = null
    lateinit var editText: EditText
    lateinit var button: Button

    interface Fragment2Listener{
        fun onInput2Sent(input:CharSequence)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment2,container,false)
        editText = view.findViewById(R.id.edit_text)
        button = view.findViewById(R.id.button_ok)
        button.setOnClickListener {
            var input = editText.text
            listener?.onInput2Sent(input)
        }
        return view
    }

    fun updateEditText(newText:CharSequence){
        editText.setText(newText)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Fragment2Listener){
            listener = context
        }else
            throw RuntimeException("$context must implement Fragment2Listener")
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}