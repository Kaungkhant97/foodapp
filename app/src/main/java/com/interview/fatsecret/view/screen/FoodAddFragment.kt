package com.interview.fatsecret.view.screen

import android.os.Bundle
import android.text.InputType
import android.view.*
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.textfield.TextInputLayout
import com.interview.fatsecret.util.FOOD_VIEWSTATE
import com.interview.fatsecret.R
import com.interview.fatsecret.util.RECEIPE_VIEWSTATE
import com.interview.fatsecret.viewmodel.FoodAddViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodAddFragment(var viewstate: Int?) : Fragment() {


    private var textinput3: TextInputLayout? = null
    private var textinput2: TextInputLayout? = null

    private var edtxt3: TextView? = null
    private var edtxt2: TextView? = null
    private var edtxt1: TextView? = null


    companion object {
        fun newInstance(viewstate: Int?) = FoodAddFragment(viewstate)
    }

    private val foodAddViewModel: FoodAddViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_foodadd, container, false)
        edtxt1 = view.findViewById<EditText>(R.id.foodadd_edtxt1);


        edtxt2 = view.findViewById<EditText>(R.id.foodadd_edtxt2);


        edtxt3 = view.findViewById<EditText>(R.id.foodadd_edtxt3);

        setHasOptionsMenu(true)

        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //default view state is FOOD;
        bindView();
    }


    private fun bindView() {

        when (viewstate) {
            FOOD_VIEWSTATE -> {
                edtxt1!!.hint = getText(R.string.foodadd_edtxt_name);
                edtxt2!!.hint = getText(R.string.foodadd_edittxt_description);

                edtxt3!!.hint = getText(R.string.foodadd_edittxt_amount);

                edtxt3!!.inputType = InputType.TYPE_CLASS_NUMBER;


            }

            RECEIPE_VIEWSTATE -> {

                edtxt1!!.hint = getText(R.string.foodadd_edtxt_name);
                edtxt2!!.hint = getText(R.string.foodadd_edittxt_quantity);
                edtxt3!!.hint = getText(R.string.foodadd_edittxt_cookingTime);

                edtxt2!!.inputType = InputType.TYPE_CLASS_NUMBER;
                edtxt3!!.inputType = InputType.TYPE_CLASS_NUMBER;
            }


        }


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_foodadd, menu);
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.foodadd_menuitem_save) {
            when (viewstate) {
                FOOD_VIEWSTATE -> {
                    foodAddViewModel.insertFood(
                        edtxt1?.text.toString(), edtxt2?.text.toString(), Integer.parseInt(
                            edtxt3?.text.toString()
                        )
                    );
                }
                RECEIPE_VIEWSTATE -> {
                    foodAddViewModel.insertReceipe(
                        edtxt1?.text.toString(),
                        Integer.parseInt(edtxt2?.text.toString()),
                        Integer.parseInt(
                            edtxt3?.text.toString()
                        )

                    );
                }

            }

        }

        Toast.makeText(context,"Item has been added",Toast.LENGTH_SHORT).show()

        return super.onOptionsItemSelected(item)
    }


}