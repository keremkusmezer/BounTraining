package hackjoe.com.myapplication.parser;

import android.os.AsyncTask;

import java.util.List;

public class ParseFeedAsyncTask extends AsyncTask<Void, Void, List<Rss>> {
    private String feedUrl = "http://www.iphoneturkey.com/feed/";
    private ParseFeedCallback   callback;
    public ParseFeedAsyncTask(ParseFeedCallback callback,String feedUrl) {
        this.callback = callback;
        this.feedUrl = feedUrl;
    }
    @Override
    protected List<Rss> doInBackground(Void... params) {
        String xmlContent = Downloader.getContent(feedUrl);
        return RssParser.parseFeed(xmlContent);
    }
    @Override
    protected void onPostExecute(List<Rss> result) {
        super.onPostExecute(result);
        callback.finishedLoadingFeeds(result);
    }
}