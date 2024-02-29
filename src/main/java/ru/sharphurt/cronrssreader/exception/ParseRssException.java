package ru.sharphurt.cronrssreader.exception;

import com.apptasticsoftware.rssreader.Item;

import static ru.sharphurt.cronrssreader.constants.AliasConstants.EXCEPTION_PARSE_RSS_FEED;

public class ParseRssException extends BaseException {

    public ParseRssException(String serviceName, Item item) {
        super(EXCEPTION_PARSE_RSS_FEED.formatted(serviceName, item), new Throwable());
    }
}
