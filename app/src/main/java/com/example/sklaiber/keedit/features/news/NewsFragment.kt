package com.example.sklaiber.keedit.features.news

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sklaiber.keedit.features.news.NewsManager
import com.example.sklaiber.keedit.R
import com.example.sklaiber.keedit.commons.RxBaseFragment
import com.example.sklaiber.keedit.commons.extensions.inflate
import com.example.sklaiber.keedit.features.news.adapter.NewsAdapter
import kotlinx.android.synthetic.main.news_fragment.*
import rx.schedulers.Schedulers

class NewsFragment : RxBaseFragment() {

    private val newsMananger by lazy { NewsManager() }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return  container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        news_list.setHasFixedSize(true)
        news_list.layoutManager = LinearLayoutManager(context)

        initAdapter()

        if (savedInstanceState == null) {
            requestNews()
        }
    }

    private fun requestNews() {
        val subsciption = newsMananger.getNews()
            .subscribeOn(Schedulers.io())
            .subscribe(
                    { retrievedNews ->
                        (news_list.adapter as NewsAdapter).addNews(retrievedNews)
                    },
                    { e ->
                        Snackbar.make(news_list, e.message ?: "", Snackbar.LENGTH_LONG).show()
                    }
            )
        subscriptions.add(subsciption)
    }

    private fun initAdapter() {
        if (news_list.adapter == null) {
            news_list.adapter = NewsAdapter()
        }
    }
}