import java.util.ArrayList;

/**
 * 
 * @author Mark Schafer 45%
 * @author Ruben Castro Espinoza 35%
 * @author Reyhan Guleryuz 20%
 * @version 2017.04.28
 * Here we can store the TFIDF and IDF values for a term. 
 */
public class Tag {
    private String term;
    private double TFIDF;
    private double IDF;


    /**
     * constructors for tag 
     * @param term the term
     * @param IDF the inverse document frequency
     * constructor for tag with only IDF
     * O(1)
     */
    public Tag(String term, double IDF) {
       this.term = term;
       this.IDF = IDF;
    
    }


    /**
     * @param term the term
     * @param TFIDF the term frequency-inverse document frequency
     * @param IDF the inverse document frequency
     * constructor for a tag with both TFIDF and IDF
     * O(1)
     */
    public Tag(String term, double TFIDF, double IDF) {
        this.term = term;
        this.TFIDF = TFIDF;
        this.IDF = IDF;
    }


    /**
     * @param tag the tag to compare against
     * @return a lexographic comparison
     * O(n)
     */
    public int compareTo(Tag tag) {
        return term.compareTo(tag.getTerm());
    }
    
    
    /**
     * @param tag the tag to compare against
     * @return a boolean
     */
    public boolean equals(Tag tag) {
        return ((Math.abs(TFIDF - tag.getTFIDF()) <= 0.000001));
    }


    /**
     * @return term the term
     * O(1)
     */
    public String getTerm() {
        return term;
    }


    /**
     * @return TFIDF the TFIDF
     * O(1)
     */
    public double getTFIDF() {
        return TFIDF;
    }

    
    /**
     * @param TFIDF the new TFIDF
     * O(1)
     */
    public void setTFIDF(double tFIDF) {
        TFIDF = tFIDF;
    }
    

    /**
     * @return IDF the IDF
     * O(1)
     */
    public double getIDF() {
        return IDF;
    }

}

