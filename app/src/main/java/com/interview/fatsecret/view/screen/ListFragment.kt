package com.interview.fatsecret.view.screen


import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.interview.fatsecret.util.FOODADD_EXTRA_DATA
import com.interview.fatsecret.util.FOOD_VIEWSTATE
import com.interview.fatsecret.viewmodel.ListViewModel
import com.interview.fatsecret.R
import com.interview.fatsecret.util.RECEIPE_VIEWSTATE
import com.interview.fatsecret.view.FoodListViewObject
import com.interview.fatsecret.view.component.FoodRecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()

    }

    private lateinit var foodadapter: FoodRecyclerAdapter
    private val listViewModel: ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true);

        val view: View = inflater.inflate(R.layout.fragment_list, container, false);

        return view;

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_foodlist);
        foodadapter = FoodRecyclerAdapter(ArrayList<FoodListViewObject>(),
            { food -> Toast.makeText(context, food.name, Toast.LENGTH_LONG) });
        recyclerView.adapter = foodadapter;
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);

        listViewModel._allFoodViewObject.observe(viewLifecycleOwner,
            { foodlist -> foodadapter.addnewdata(foodlist) })


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.list_menu, menu);
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.list_menu_add) {
            AlertDialog.Builder(requireContext())
                .setTitle(getString(R.string.option))
                .setPositiveButton(getString(R.string.btn_food)) { _, _ ->
                    openNewActivity(FOOD_VIEWSTATE);

                }
                .setNeutralButton(getString(R.string.btn_receipe), { _, _ ->

                    openNewActivity(RECEIPE_VIEWSTATE)

                })
                .create().show()


        }
        return super.onOptionsItemSelected(item);
    }

    private fun openNewActivity(foodViewstate: Int) {
        startActivity(Intent(activity, FoodAddActivity::class.java).apply {
            putExtra(
                FOODADD_EXTRA_DATA,
                foodViewstate
            )
        })
    }

}