import student.*;
import java.util.*;
import java.io.File;
/** 
 * @author Mark Schafer 45%
 * @author Ruben Castro Espinoza 35%
 * @author Reyhan Guleryuz 20%
 * @version 2017.04.28
 */
public class HandlerTest extends student.TestCase {
    Handler handler;
    HashMap<String, ArrayList<String>> hm;
   

    /**
     * Creates a new test object.
     */
    public HandlerTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    /**
     * Sets up the test fixture.
     * Called before every test case method.
     * @throws Exception 
     */
    public void setUp() throws Exception
    {
        FilesParser fp = new FilesParser();
        final File folder = new File("/Users/rubencastroespinoza/Downloads/Testfiles");
        fp.parse(folder);
        hm = fp.getContent();
        handler = new Handler();
         
    }


    /**
     * tests TFIDF 
     */
    public void testTFIDF() {
         handler.TFIDF(hm);
         HashMap<String, ArrayList<Tag>> j = handler.getTFIDF();
         ArrayList<Tag> w = j.get("testcopy2.txt");
         Tag r = w.get(0);
         assertEquals(r.getTerm(),"Hello");
         assertEquals(r.getIDF(),1.0986,0.1);
         assertEquals(r.getTFIDF(),0.549306,0.1);
      
    }


    /**
     * tests createIndex
     */
    public void testCreateIndex() {
        handler.aggregateTermList(hm);
        handler.createIndex();
        assertNotNull(handler.search("Dogs"));
    }


    /**
     * tests toInOrderString
     */
    public void testToInOrderString() {
        handler.TFIDF(hm);
        handler.createIndex();
        handler.toInOrderIndex();
    }
    /**
     *  tests the GetTFIDF method 
     */
    public void testGetTFIDF() {
        assertTrue(handler.getTFIDF() != null);
        
    }
    
    /**
     * Tests the get ArticleList method
     */
    public void testGetArticleList() {
    
      handler.TFIDF(hm);
      HashMap<String, ArrayList<Tag>> X = handler.TFIDFlist;
      ArrayList<String> x = handler.getArticleList("is");
      assertTrue(x.contains("testcopy1.txt"));
      assertTrue(x.contains("testcopy3.txt"));
       
        
        
    }
    /**
     *  tests the IDF method 
     */
    public void testIDF() {
       ArrayList<Tag> x = handler.IDF(hm);
        Tag tag1 = x.get(1);
        double y=  tag1.getIDF();
        String term1 = tag1.getTerm();
       assertEquals(y,1.098,.01);
       assertEquals(term1,"awesome");
      
       
      
       
           
       
       
        
    }
    
   
    /**
     *  test the TF method. 
     */
    
    public void testTF() {
        
      
      double x =  handler.TF("is", "testcopy3.txt", hm);
       assertEquals( x, 0.33,0.1);
        
    }
    
    /**
     *  tests the aggregate termlist method. 
     */
    public void testAraggregateTermList() {
        
        ArrayList<String> x = handler.aggregateTermList(hm);
        assertTrue( x.contains("Dogs"));
        
       
        }
        
        
    }


 
