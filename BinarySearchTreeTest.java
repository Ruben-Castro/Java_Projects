import student.*;
import java.util.*;
/** 
 *  @author  Mark Schafer
 *  @version 2017.04.21
 */
public class BinarySearchTreeTest extends student.TestCase {
    
    private BinarySearchTree<Integer> bst;
   
    /**
     * Creates a new test object.
     */
    public BinarySearchTreeTest()
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
        bst = new BinarySearchTree<Integer>();
        bst.insert(3);
        bst.insert(1);
        bst.insert(4);
        bst.insert(2);
        bst.insert(16);
        bst.insert(8);
        bst.insert(9);
    }
    

    /**
     * tests insert
     */
    public void testInsert() {
//      System.out.println(bst.toInOrderString());
        assertEquals(2, (int)bst.find(2));
        assertEquals(9, (int)bst.find(9));
        assertEquals(4, (int)bst.find(4));
        Exception thrown = null;
        try
        {
            bst.insert(4);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
//        assertTrue(thrown instanceof DuplicateItemException);
    }
    
    
//    /**
//     * tests remove
//     */
//    public void testRemove() {
////        System.out.println(bst.toInOrderString());
//      bst.remove(3);
////        System.out.println(bst.toInOrderString());
//      assertNull(bst.find(3));    
//    }
        
    
//    /**
//     * tests findMin findMax
//     */
//    public void testFindMinMax() {
//      assertEquals(1, (int)bst.findMin());
//      assertEquals(16, (int)bst.findMax());
//    }
    
    
    /**
     * tests find
     */
    public void testFind() {
        assertEquals(4, (int)bst.find(4));
        assertEquals(9, (int)bst.find(9));
    }
    
    
    /**
     * tests isEmpty
     */
    public void testEmpty() {
        assertFalse(bst.isEmpty());
        bst.makeEmpty();
        assertTrue(bst.isEmpty());
    }

}