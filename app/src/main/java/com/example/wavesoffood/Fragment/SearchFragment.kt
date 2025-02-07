package com.example.wavesoffood.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.R
import com.example.wavesoffood.adapter.MenuAdapter
import com.example.wavesoffood.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var bindings: FragmentSearchBinding

    private lateinit var adapter: MenuAdapter

    private val originalMenuFoodName: List<String> = listOf(
        "Burger",
        "SandWich",
        "Momo",
        "item",
        "SandWich",
        "Momo",
        "SandWich",
        "Momo",
        "item",
        "SandWich",
        "Momo"
    )

   private  val originalMenuItemPrice = listOf("$5","$6","$8","$10","$10","$9","$6","$8","$10","$10","$9")
    private val originalMenuImage = listOf(
        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5,
        R.drawable.menu6,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5,
        R.drawable.menu6,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuItemPrice = mutableListOf<String>()
    private val filteredMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindings = FragmentSearchBinding.inflate(inflater, container, false)
        adapter = MenuAdapter(filteredMenuFoodName,filteredMenuItemPrice,filteredMenuImage,requireContext())

        bindings.MenuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        bindings.MenuRecyclerView.adapter = adapter

        setupSearchView()

        showAllMenu()

        return bindings.root
    }

    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()


        filteredMenuFoodName.addAll(originalMenuFoodName)
        filteredMenuItemPrice.addAll(originalMenuItemPrice)
        filteredMenuImage.addAll(originalMenuImage)

        adapter.notifyDataSetChanged()


    }

    private fun setupSearchView() {
        bindings.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })

    }
    private fun filterMenuItems(query:String) {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

            originalMenuFoodName.forEachIndexed { index, foodName ->

                if (foodName.contains(query, ignoreCase = true)){
                    filteredMenuFoodName.add(foodName)
                    filteredMenuItemPrice.add(originalMenuItemPrice[index])
                    filteredMenuImage.add(originalMenuImage[index])
                }
            }
        adapter.notifyDataSetChanged()
    }

    companion object {
    }
}