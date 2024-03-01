package ru.sharphurt.cronrssreader.service.rss;

import com.apptasticsoftware.rssreader.Item;
import ru.sharphurt.cronrssreader.dto.NewsInformationDto;

import java.util.List;

public interface RelevantNewsFilterService {
    List<NewsInformationDto> filterRelevantNews(List<Item> rssFeed);
}
