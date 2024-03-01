package ru.sharphurt.cronrssreader.constants;

public class AliasConstants {
    public static final String EXCEPTION_MESSAGE_BASE = "Exception during request execution: %s | ";
    public static final String EXCEPTION_RSS_FEED_UNAVAILABLE = EXCEPTION_MESSAGE_BASE + "Cannot get RSS by url : %s";

    public static final String LOG_SERVICE_PREFIX = "Called service [%s] | ";
    public static final String LOG_RSS_REQUEST = LOG_SERVICE_PREFIX + "Requested RSS feed. URL: [%s]";
    public static final String LOG_RSS_GOT_FEED = LOG_SERVICE_PREFIX + "Got RSS feed. Items count: [%s]";
    public static final String LOG_FEIGN_CLIENT_GET_LAST_PUBLICATION = LOG_SERVICE_PREFIX + "Requested last publication";
    public static final String LOG_FEIGN_CLIENT_GOT_LAST_PUBLICATION = LOG_SERVICE_PREFIX + "Got last publication: [%s]";
    public static final String LOG_FEIGN_CLIENT_LAST_PUBLICATION_NOT_FOUND = LOG_SERVICE_PREFIX + "Last publication not found. Used today's midnight time. Internal error: [%s]";
    public static final String LOG_CRON_SERVICE_START = LOG_SERVICE_PREFIX + "Start fetching news";
    public static final String LOG_CRON_SERVICE_UPLOADING_NEWS = LOG_SERVICE_PREFIX + "Uploading %s news";

    public static final String LOG_WARN_ITEM_NOT_PARSED = "Item's publication date [%s] cannot be parsed. Item skipped";

}
