package com.example.sklaiber.keedit.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.sklaiber.keedit.R
import com.example.sklaiber.keedit.commons.adapter.ViewType
import com.example.sklaiber.keedit.commons.adapter.ViewTypeDelegateAdapter
import com.example.sklaiber.keedit.commons.extensions.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {

    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.news_item_loading))
}