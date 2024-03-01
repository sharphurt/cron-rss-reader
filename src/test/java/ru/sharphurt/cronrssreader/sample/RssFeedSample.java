package ru.sharphurt.cronrssreader.sample;

import com.apptasticsoftware.rssreader.DateTime;
import com.apptasticsoftware.rssreader.Item;
import ru.sharphurt.cronrssreader.dto.NewsInformationDto;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import static ru.sharphurt.cronrssreader.mapper.NewsInformationMapper.NEWS_INFORMATION_MAPPER;

public class RssFeedSample {

    public static final ZonedDateTime initialTime = ZonedDateTime.now();

    public static final List<Item> rssFeed = new ArrayList<>();

    public static final List<NewsInformationDto> parsedRssFeed = new ArrayList<>();

    static {
        for (var i = 0; i < 5; i++) {
            var item = createItem(initialTime.plusMinutes(i));
            rssFeed.add(item);
            parsedRssFeed.add(NEWS_INFORMATION_MAPPER.map(item));
        }
    }

    private static Item createItem(ZonedDateTime publicationTime) {
        var item = new Item(new DateTime());
        var uuid = UUID.randomUUID().toString();
        item.setGuid(uuid);
        item.setTitle("title_%s".formatted(uuid));
        item.setDescription("description_%s".formatted(uuid));
        item.setPubDate(publicationTime.format(DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US)));
        return item;
    }
}

