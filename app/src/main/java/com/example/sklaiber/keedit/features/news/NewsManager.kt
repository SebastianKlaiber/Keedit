package com.example.sklaiber.keedit.features.news

import com.example.sklaiber.keedit.commons.RedditNewsItem
import rx.Observable

class NewsManager {
    fun getNews(): Observable<List<RedditNewsItem>> {
        return Observable.create {
            subscriper ->
            val news = mutableListOf<RedditNewsItem>()
            for (i in 1..10) {
                news.add(RedditNewsItem(
                        "author$i",
                        "Title$i",
                        i,
                        147207701L - 1 * 200,
                        "http://lorempixel.com/200/200/technics/",
                        "url"
                ))
            }
            subscriper.onNext(news)
        }
    }
}