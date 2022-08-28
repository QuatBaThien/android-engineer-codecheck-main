package jp.co.yumemi.android.code_check.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Item(
    val name: String? = "",
    val ownerIconUrl: String? = "",
    val language: String? = "",
    val stargazersCount: Long? = 0,
    val watchersCount: Long? = 0,
    val forksCount: Long? = 0,
    val openIssuesCount: Long? = 0,
) : Parcelable
