package com.example.sklaiber.keedit.commons

import com.example.sklaiber.keedit.commons.adapter.AdapterConstants
import com.example.sklaiber.keedit.commons.adapter.ViewType

data class RedditNewsItem(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String ): ViewType {
    override fun getViewType() = AdapterConstants.NEWS
}