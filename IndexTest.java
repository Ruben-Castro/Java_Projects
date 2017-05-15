import student.*;
import java.util.*;

/** 
 * 
 * @author Mark Schafer 45%
 * @author Ruben Castro Espinoza 35%
 * @author Reyhan Guleryuz 20%
 * @version 2017.04.28
 */

public class IndexTest extends student.TestCase {

    Index index;
    ArrayList<String> list;
    
    
    /**
     * Creates a new test object.
     */
    public IndexTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        list = new ArrayList<String>();
        list.add("test");
        list.add("list");
        index = new Index("testList", list);
    }


    /**
     * tests getters
     */
    public void testGetters() {
        assertEquals("testList", index.getTerm());
        assertEquals(list, index.getArticleList());
    }
    
    
    /**
     * tests compareTo
     */
    public void testCompareTo() {
        Index i2 = new Index("sterm", list);
        assertTrue(0 < index.compareTo(i2));
    }


}
