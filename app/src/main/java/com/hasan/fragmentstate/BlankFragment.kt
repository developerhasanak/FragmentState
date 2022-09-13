package com.hasan.fragmentstate

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hasan.fragmentstate.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {

    private lateinit var binding: FragmentBlankBinding
    private var number: Int = 0

    companion object {
        const val SCORE_KEY = "score_key"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.v("PATIKADEV", "onAttach called.")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("PATIKADEV", "onCreate called.")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.v("PATIKADEV", "onCreateView called.")
        binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.v("PATIKADEV", "onViewCreated called.")

        binding.button.setOnClickListener {
            number += 1
            binding.textView.text = number.toString()
        }
    }

    /*This method fetches the data held by
      the application's onSaveInstanceState method.
     */
    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.v("PATIKADEV", "onViewStateRestored called.")

        if (savedInstanceState != null) {
            number = savedInstanceState.getInt("NUMBER")
            binding.textView.text = number.toString()

            val storedData = savedInstanceState.getCharSequence("STRING")
            binding.editTextTextPersonName.setText(storedData)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.v("PATIKADEV", "onStart called.")
    }

    override fun onResume() {
        super.onResume()
        Log.v("PATIKADEV", "onResume called.")
    }

    override fun onPause() {
        super.onPause()
        Log.v("PATIKADEV", "onPause called.")
    }

    override fun onStop() {
        super.onStop()
        Log.v("PATIKADEV", "onStop called.")
    }

    /*This method keeps the data of the application when the back button is pressed
     or the screen goes to landscape mode.
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.v("PATIKADEV", "onSaveInstanceState called.")

        val writedData = binding.editTextTextPersonName.text

        // The data from the edittext is kept with the key specified in the CharSequence type.
        outState.putCharSequence("STRING", writedData)

        // The data from the edit text is kept with the key specified of type Int.
        outState.putInt("NUMBER", number)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.v("PATIKADEV", "onDestroyView called.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("PATIKADEV", "onDestroy called.")
    }

    override fun onDetach() {
        super.onDetach()
        Log.v("PATIKADEV", "onDetach called.")
    }
}