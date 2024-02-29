package ru.sharphurt.cronrssreader.exception;

import static ru.sharphurt.cronrssreader.constants.AliasConstants.EXCEPTION_RSS_FEED_UNAVAILABLE;

public class RssFeedUnavailable extends BaseException {

    public RssFeedUnavailable(String serviceName, String url) {
        super(EXCEPTION_RSS_FEED_UNAVAILABLE.formatted(serviceName, url), new Throwable());
    }
}
