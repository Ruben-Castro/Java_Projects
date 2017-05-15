import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// -------------------------------------------------------------------------
/**
 * This class parses all the files in a directory and creates a HashMap with the
 * file name as key and an ArrayList of all the terms in the files as key
 *
 * @author ericfouh
 * @version Apr 15, 2017
 */
public class FilesParser
{
    private HashMap<String, ArrayList<String>> hm;


    // ----------------------------------------------------------
    /**
     * Create a new HTMLparser object.
     */
    public FilesParser()
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
     * @param folder
     *            The absolute path to the folder containing the files
     * @throws Exception
     *             thrown if there is a problem when reading the file
     */
    public void parse(final File folder)
        throws Exception
    {

        String line;

        for (final File fileEntry : folder.listFiles())
        {
            ArrayList<String> al = new ArrayList<String>();
            if (fileEntry.isDirectory())
            {
                parse(fileEntry); // recursive call on subfolder
            }
            else
            {
                // process the file
                try (
                    InputStream fis =
                        new FileInputStream(fileEntry.getAbsolutePath());
                    InputStreamReader isr =
                        new InputStreamReader(fis, Charset.forName("UTF-8"));
                    BufferedReader br = new BufferedReader(isr);)
                {
                    while ((line = br.readLine()) != null)
                    {

                        // remove punctuation
                        line = line.replaceAll("[^a-zA-Z\\s]", "")
                            .replaceAll("\\s+", " ");

                        al.addAll(Arrays.asList(line.split(" ")));
                    }

                }
                hm.put(fileEntry.getName(), al);
            }

        }

    }

}
