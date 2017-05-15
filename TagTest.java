import student.*;
import java.util.*;
/** 
 * 
 * @author Mark Schafer 45%
 * @author Ruben Castro Espinoza 35%
 * @author Reyhan Guleryuz 20%
 * @version 2017.04.28
 */
public class TagTest extends student.TestCase {
    Tag tag;
    
   /**
    * creates a new test object.
    */
    public TagTest() {
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
        tag = new Tag("term", 0.234, 2.34);
    }
    /**
     * tests getters
     */
    public void testGetters() {
        assertEquals("term", tag.getTerm());
        assertEquals(.234, tag.getTFIDF(),0.01);
        assertEquals(.234, tag.getTFIDF(),0.01);
       assertEquals (.234,tag.getTFIDF(),0.01);
       assertEquals(2.34, tag.getIDF(),0.01);
    }
    /**
     * tests setTFIDF
     */
    public void testSetTFIDF() {
        Tag tag2 = new Tag("term", .123);
        tag2.setTFIDF(3.45);
        assertEquals(3.45, tag2.getTFIDF(),0.01);
    }
    
    /**
     * tests compareTo
     */
    public void testCompareTo() {
        Tag tag2 = new Tag("term2", 1.23, 1.23);
        Tag tag3 = new Tag("abcd", 1.23, 1.23);
        Tag tag4 = new Tag("term", 1.23, 1.23);
        assertTrue(tag.compareTo(tag2) != 0);
        assertTrue(tag.compareTo(tag3) != 0);
        assertEquals(0, tag.compareTo(tag4));
    }
    
    
    /**
     * tests equals
     */
    public void testEquals() {
        Tag tag2 = new Tag("term2", 1.23, 1.23);
        assertFalse(tag.equals(tag2));
        tag2 = new Tag("term", 0.234, 2.34);
        assertTrue(tag.equals(tag2));
    }





}

