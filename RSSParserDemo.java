import java.util.ArrayList;
import java.util.HashMap;

// -------------------------------------------------------------------------
/**
 * This class shows how to parse a RSS feed and use the HashMap created by the
 * FilesParser class HashMap javadoc at
 * https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
 *
 * @author ericfouh
 * @version Apr 15, 2017
 */
public class RSSParserDemo
{

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args)
        throws Exception
    {
        HTMLparser hp = new HTMLparser();
        // Create a RSS feed parser object , the URL is passed as argument
        // in this case CBS News feed
        RSSFeedParser parser =
            new RSSFeedParser("http://feeds.slate.com/slate");
        // read the feed and parse each link
        Feed feed = parser.readFeed();
        for (FeedMessage message : feed.getMessages())
        {
            hp.parse(message.getLink());

        }

        // The getContent method of the FilesParser returns the HashMap created
        // hm references the HashMap created by the FilesParser object fp.
        HashMap<String, ArrayList<String>> hm = hp.getContent();

        // HashMap traversal: we print the key and the values
        // The for loop iterates through all the keys stored:
        // keySet() returns a Set view of the keys contained in the hashmap.
        // the key is of type String
        // hm.get(key) returns the value (an ArrayList in this case) associated
        // with key
        for (String key : hm.keySet())
        {
            // We print the key
            System.out.print(key + "\t-\t[");
            for (int i = 0; i < hm.get(key).size(); i++)
            {
                // we go through the arraylist and
                // print all the terms in the document
                System.out.print(hm.get(key).get(i) + ",");
            }
            System.out.println("]");
        }
        

    }

}
