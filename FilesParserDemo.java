import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

// -------------------------------------------------------------------------
/**
 * This class shows how to parse a folder and use the HashMap created by the
 * FilesParser class It also shows how to traverse a HashMap, how to insert in a
 * HashMap, and how to retrieve data in a HashMap. Before running this code,
 * create a folder with a couple of plain (ASCII) text files. Do not use word
 * processing software created documents.
 * HashMap javadoc at
 * https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
 *
 * @author ericfouh
 * @version Apr 15, 2017
 */
public class FilesParserDemo
{

    // ----------------------------------------------------------
    /**
     * Main method
     *
     * @param args
     *            we will pass the arguments inside the method
     * @throws Exception,
     *             we must handle the exceptions since we are reading files and
     *             it is always possible that something wrong might happen
     *             including missing files, corrupted files, ...
     */
    public static void main(String[] args)
        throws Exception
    {
        // First create a FilesParser object
        FilesParser fp = new FilesParser();
        // Then create a File object pointing to the folder containing our files
        // pass the absolute path of the folder as an argument no trailing "/"
        final File folder = new File(
            "/Users/rubencastroespinoza/Downloads/Testfiles");
        // Finally we parse the folder by calling the parse method of the
        // FilesParser object
        fp.parse(folder);

        // The getContent method of the FilesParser returns the HashMap created
        // hm references the HashMap created by the FilesParser object fp.
        HashMap<String, ArrayList<String>> hm = fp.getContent();

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

        /**
         * HASHMAP USEFUL FUNCTIONS (1) declaration and creation (2) adding item
         * (3) retrieving items when the key is known, (4) updating the value
         * (5) checking if a key or a value is in the Hashmap
         */

        // (1) key:String, value: ArrayList
        HashMap<String, ArrayList<String>> theMap =
            new HashMap<String, ArrayList<String>>();
        // (2) add a key-value pair, the value is not known so we use null
        theMap.put("The #1 key", null);
        // (3) retrieving the value associated with the key "The #1 key":
        // here null
        ArrayList<String> aList = theMap.get("The #1 key");
        System.out.println(aList);
        // (4) updating the value
        ArrayList<String> theList = new ArrayList<String>();
        theList.add("One");
        theList.add("Two");
        theList.add("Three");
        theMap.put("The #1 key", theList);
        // (5)
        System.out.println(
            theMap.containsKey("The #1 key") + " the key is in the Map");
        System.out.println(
            theMap.containsKey("The #2 key") + " the key is not in the Map");
        System.out.println(
            theMap.containsValue(theList) + " the Value is in the Map");
        ArrayList<String> theotherList = new ArrayList<String>();
        System.out.println(
            theMap.containsValue(theotherList)
                + " the Value is not in the Map");

    }

}
