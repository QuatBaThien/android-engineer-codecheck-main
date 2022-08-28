/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.code_check.views.fragment

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import jp.co.yumemi.android.code_check.TopActivity.Companion.lastSearchDate
import jp.co.yumemi.android.code_check.base.BaseFragment
import jp.co.yumemi.android.code_check.data.Item
import jp.co.yumemi.android.code_check.databinding.FragmentDetailsBinding


class DetailsFragment(//private val args: DetailsFragmentArgs by navArgs()
    val item: Item
) :BaseFragment<FragmentDetailsBinding>() {

    @SuppressLint("SetTextI18n")
    override fun init() {
        Log.d("検索した日時", lastSearchDate.toString())
        binding.apply {
            ivDetailsOwnerIconView.load(item.ownerIconUrl)
            tvDetailsRepoName.text=item.name
            tvDetailsLanguage.text = item.language;
            tvDetailsStars.text = "${item.stargazersCount} stars";
            tvDetailsWather.text = "${item.watchersCount} watchers";
            tvDetailsForks.text = "${item.forksCount} forks";
            tvDetailsOpenIssues.text = "${item.openIssuesCount} open issues";
        }
    }
    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailsBinding {
        return FragmentDetailsBinding.inflate(inflater, container, false)
    }
}
