package hackjoe.com.myapplication.parser;

import java.util.List;

public interface ParseFeedCallback {
    public void finishedLoadingFeeds(List<Rss> feeds);
}