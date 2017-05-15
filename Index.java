import java.util.*;
/**
 * @author Mark Schafer 45%
 * @author Ruben Castro Espinoza 35%
 * @author Reyhan Guleryuz 20%
 * @version 2017.04.28
 * Creates objects to be used in Handler.IndexBST
 */
public class Index implements Comparable<Index> {
    private String term;
    private  ArrayList<String> articleList;
    
    
    /**
     * @param term the term
     * @param list the article list
     * O(1)
     */
    public Index(String term, ArrayList<String> list) {
        this.term = term;
        articleList = list;
    }
    
    
    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     * @param i the other index
     * @return the comparison
     * O(n)
     */
    public int compareTo(Index i) {
        return term.compareTo(i.getTerm());
    }
    
    
    /**
     * @return the term
     * O(1)
     */
    public String getTerm() {
        return term;
    }
    
    
    /**
     * @return the article list
     * O(1)
     */
    public  ArrayList<String> getArticleList() {
        return articleList;
    }
   public  String toString(){
    return term;
        
    }
     
}

