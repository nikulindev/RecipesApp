package com.nikulindev.recipesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nikulindev.recipesapp.databinding.FragmentListCategoriesBinding
import androidx.recyclerview.widget.LinearLayoutManager


class CategoriesListFragment : Fragment() {

    private var _binding: FragmentListCategoriesBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("Binding for FragmentListCategoriesBinding must not be null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListCategoriesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler() // Вызов вспомогательного метода
    }

    private fun initRecycler() {

        val categories = STUB.getCategories()
        val adapter = CategoriesListAdapter(categories)

        binding.rvCategories.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = adapter
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}