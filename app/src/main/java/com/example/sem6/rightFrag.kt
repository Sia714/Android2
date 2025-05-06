package com.example.sem6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [rightFrag.newInstance] factory method to
 * create an instance of this fragment.
 */
class rightFrag : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_right, container, false)
        // Find the button and set a click listener
        view.findViewById<View>(R.id.btnfrag2).setOnClickListener {
            // Get the instance of FragmentA
            val fragmentA = parentFragmentManager.findFragmentById(R.id.fragmentleft) as leftFrag
            // Send data back to FragmentA
            fragmentA.recieveData("Data is coming from FragmentB")
        }
        return view
    }



    fun recieveData(data: String) {
        view?.findViewById<TextView>(R.id.textdata)?.text = data
    }
}