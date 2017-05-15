import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author rubencastroespinoza
 * 
 * this class demonstrates how the handler class would behave with a real
 * RSS FEED 
 *
 */
public class HandlerDemo {
    
    /**
     * @param args
     */
    public static void main(String []args) throws Exception {
       
        HTMLparser hp = new HTMLparser();
       
        RSSFeedParser parser =
            new RSSFeedParser("http://feeds.slate.com/slate");
        
        Feed feed = parser.readFeed();
        for (FeedMessage message : feed.getMessages())
        {
            hp.parse(message.getLink());

        }
       

        
        HashMap<String, ArrayList<String>> hm = hp.getContent();
      
        Handler handler = new Handler();
        handler.TFIDF(hm);
        handler.createIndex();
        System.out.println( "this is the index for slate RSS ");
        handler.toInOrderIndex();
        System.out.println( " ");
        System.out.println( "This is search result for 'trump' in Slate ");
        ArrayList<String> h = handler.search("trump");
        for (String articles2 : h) {
            System.out.println(articles2);
        }
        System.out.println( " ");
        System.out.println( " ");
        
      // this commented out section was used to determine the impact of using
        // different RSS feeds in your news agregator. 
        
        
         
        HTMLparser hp2 = new HTMLparser();
        
        RSSFeedParser parser2 =
            new RSSFeedParser("http://feeds.foxnews.com/foxnews/latest");
        
        Feed feed2 = parser2.readFeed();
        for (FeedMessage message2 : feed2.getMessages())
        {
            hp2.parse(message2.getLink());

        }
        HashMap<String, ArrayList<String>> hm2 = hp2.getContent();
        Handler handler2 = new Handler();
       
        System.out.println( " ");
        handler2.TFIDF(hm2);
        handler2.createIndex();
        System.out.println( "this is the index for Fox RSS  ");
        handler2.toInOrderIndex();
        System.out.println( " ");
        System.out.println( "This is search result for 'trump' in Fox ");
        ArrayList<String> y = handler2.search("trump");
        for (String articles3 : y) {
            System.out.println(articles3);
        }
     
   
        
       
       
    }
        
}       
    







