package ru.sharphurt.cronrssreader.constants;

public class AliasConstants {
    public static final String EXCEPTION_MESSAGE_BASE = "Exception during request execution: %s | ";
    public static final String EXCEPTION_EXTERNAL_SERVICE_ERROR = EXCEPTION_MESSAGE_BASE + "External service error: %s";
    public static final String EXCEPTION_RSS_FEED_UNAVAILABLE = EXCEPTION_MESSAGE_BASE + "Cannot get RSS by url : %s";
    public static final String EXCEPTION_PARSE_RSS_FEED = EXCEPTION_MESSAGE_BASE + "Cannot parse RSS item: %s";

    public static final String LOG_REQUEST_RECEIVED = "Request received: %s | ";


    public static final String LOG_REQUEST_PROCESSED = "Request processed: %s | ";


    public static final String LOG_WARN_ITEM_NOT_PARSED = "Item's publication date [%s] cannot be parsed. Item skipped";

}
