package com.example.sem6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [leftFrag.newInstance] factory method to
 * create an instance of this fragment.
 */
class leftFrag : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_left,container, false)
        view.findViewById<Button>(R.id.btnfrag1).setOnClickListener{
            val inputData=view.findViewById<EditText>(R.id.edit).text.toString()
            val fragmentB=parentFragmentManager.findFragmentById(R.id.fragmentright) as rightFrag
            fragmentB.recieveData(inputData)
        }
        return view
    }

    fun recieveData(data: String) {
        view?.findViewById<EditText>(R.id.edit)?.setText(data)
    }

}