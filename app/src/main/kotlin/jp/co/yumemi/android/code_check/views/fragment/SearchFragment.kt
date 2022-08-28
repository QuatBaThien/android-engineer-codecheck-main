/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.code_check.views.fragment

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.*
import jp.co.yumemi.android.code_check.OneViewModel
import jp.co.yumemi.android.code_check.R
import jp.co.yumemi.android.code_check.views.adapter.SearchAdapter
import jp.co.yumemi.android.code_check.databinding.FragmentSearchBinding

class SearchFragment: Fragment(R.layout.fragment_search){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        val _binding= FragmentSearchBinding.bind(view)

        val _viewModel= OneViewModel(requireContext())

        val adapterSearch = SearchAdapter()
        _binding.tietSearchFragmentSearchBar
            .setOnEditorActionListener{ editText, action, _ ->
                if (action== EditorInfo.IME_ACTION_SEARCH){
                    editText.text.toString().let {
                        _viewModel.searchResults(it).apply{
                            adapterSearch.listSearch=this
                        }
                    }
                    return@setOnEditorActionListener true
                }
                return@setOnEditorActionListener false
            }
        _binding.rvSearchFragmentSearchList.apply {
            adapter = adapterSearch
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }
}

