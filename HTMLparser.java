import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// -------------------------------------------------------------------------
/**
 * This class parses HTML files and and creates
 *  a HashMap with the URL of the page as key and an ArrayList of all the
 *  terms in the files as key
 *
 * @author ericfouh
 * @version Mar 12, 2017
 */
public class HTMLparser
{

    private HashMap<String, ArrayList<String>> hm;


    // ----------------------------------------------------------
    /**
     * Create a new HTMLparser object.
     */
    public HTMLparser()
    {
        hm = new HashMap<String, ArrayList<String>>();
    }


    // ----------------------------------------------------------
    /**
     * getter for the hashmap
     *
     * @return a hashmap containing the URL of the article as key and an
     *         ArrayList of all the words in the document as value.
     */
    public HashMap<String, ArrayList<String>> getContent()
    {
        return hm;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @param web_url
     * @throws Exception
     */
    public void parse(String web_url)
        throws Exception
    {


        ArrayList<String> al = null;

        Document doc = Jsoup.connect(web_url).get();

        Elements links = doc.getElementsByTag("body");
        for (Element link : links)
        {
            String linkText = link.text();

            // remove punctuation
            linkText =
                linkText.replaceAll("[^a-zA-Z\\s]", "").replaceAll("\\s+", " ").toLowerCase();

            al = new ArrayList<String>(Arrays.asList(linkText.split(" ")));

        }
        hm.put(web_url, al);

    }



}
