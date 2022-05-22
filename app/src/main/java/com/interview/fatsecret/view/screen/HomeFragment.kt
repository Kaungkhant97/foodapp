package com.interview.fatsecret.view.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.interview.fatsecret.R
import com.interview.fatsecret.viewmodel.ListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }
    private val listViewModel: ListViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listViewModel._allFoodViewObject.observe(viewLifecycleOwner,{foodlist ->
            view.findViewById<TextView>(R.id.txt_foodcount).text = foodlist.size.toString()

        })

        view.findViewById<Button>(R.id.btn_viewfood).setOnClickListener({
            parentFragmentManager.commit {
                replace(R.id.home_container,ListFragment.newInstance())
                setReorderingAllowed(true)
                addToBackStack("home")
            }
        })
    }



}