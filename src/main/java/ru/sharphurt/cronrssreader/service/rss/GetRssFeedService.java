package ru.sharphurt.cronrssreader.service.rss;

import com.apptasticsoftware.rssreader.Item;

import java.util.List;

public interface GetRssFeedService {

    List<Item> getRssFeed();
}
