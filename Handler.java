import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections; 

/**
 * @author Mark Schafer 45%
 * @author Ruben Castro Espinoza 35%
 * @author Reyhan Guleryuz 20%
 * @version 2017.04.28 
 * The handler will take care of term/article related computations
 */
public class Handler {
    
    public  HashMap<String, ArrayList<Tag>> TFIDFlist;
    public  BinarySearchTree<Index> IndexBST;
    private ArrayList<String> termList;
  
    
    /**
     * default constructor
     * O(1)
     */
    public Handler() {
        TFIDFlist = new HashMap<String, ArrayList<Tag>>();
        IndexBST = new BinarySearchTree<Index>();
        termList = new ArrayList<String>();
    }
    
    
    /**
     * @param hm the hashmap of raw term lists
     * @return a HashMap of articles and their tag ArrayLists
     * Computes the TFIDF values of each term, keeping
     * those whose TFIDF values are greater than zero.
     * Calls IDF() once at beginning and TF() for every term.
     * O(n^2)
     */
    public void TFIDF(HashMap<String, ArrayList<String>> hm) {
            ArrayList<Tag> IdfTags = IDF(hm); // returns tag ArrayList
            //aggregateTermList(hm);
            for (String currentKey :hm.keySet()) {
                
                ArrayList<Tag> tags = new ArrayList<Tag>();
                for (Tag tag: IdfTags ) {
                    String term = tag.getTerm();
                    double tf = TF(term ,currentKey ,hm);
                    double tfidf = tf * tag.getIDF();
                    if (Double.compare(tfidf, 0) > 0) {
                        tags.add(new Tag(term, tfidf, tag.getIDF()));                        
                    }
                    TFIDFlist.put(currentKey, tags);
                    
                }
            }
            
            
          
    }
    
    
    /**
     * @param term the term
     * calls getArticleList(), creates new Index with term and list.
     * O(n^2)
     */
    public void createIndex() {
        
      for (String x :termList) { 
      ArrayList<String> articleList = getArticleList(x);
      Index index = new Index(x, articleList);
      IndexBST.insert(index);
    
      }
    }
    
    
    /**
     * prints in order representation of IndexBST
     * O(n)
     */
    public void toInOrderIndex() {
        String s = IndexBST.toInOrderString();
        System.out.println(s);
           
    }
    
    
    /**
     * @param key the term to search for
     * @return the list of articles mentioning the term
     * O(logn)
     * 
     */
    public ArrayList<String> search(String term) {
       
      
       Index index = IndexBST.find(new Index(term, null));
       if (index == null) {
           return null; 
       }
      
       return index.getArticleList();
       
       }
      
    
    
    /**
     * @return the TFIDF list
     */
    public HashMap<String, ArrayList<Tag>> getTFIDF() {
        return TFIDFlist;
    }
    
    
    /**
     * @param term the term
     * @return an array list containing all articles
     * aggregates article list for a term from raw data set
     * O(n^3)
     */
    public ArrayList<String> getArticleList(String term) {
       ArrayList<Tag> x = new ArrayList<Tag>();
       ArrayList<String> articleList = new ArrayList<String>();
       
       for (String currentKey: TFIDFlist.keySet()) {
           ArrayList<Tag>  tags = TFIDFlist.get(currentKey);
           for (Tag tag : tags) {
               if(tag.getTerm().equals(term)) {
                   boolean insert = false;
                   if(x.isEmpty()) {
                       articleList.add(currentKey);
                       x.add(tag);
                       break;
                       
                   }
                   for (int i = 0; i<x.size(); i++) {
                       if (x.get(i).getIDF() < tag.getTFIDF()) {
                           articleList.add(i, currentKey);
                           insert = true;
                           break;
                       }
                   }
                   if(insert == false) {
                       articleList.add(currentKey);
                       x.add(tag);
                   }
                   
                   break;
               }
           }
       }
       
       return articleList;
       
    }
    /**
     * @param hm the hashmap of raw term lists
     * @return a list of tags; which contain terms and IDFs, of all the articles.
     * Computes the IDFs for every term. First aggregate a list (calls aggregateTermList()),
     * then compute for each term.
     * O(n^2)
     */
    public ArrayList<Tag> IDF(HashMap<String,ArrayList<String>> hm) {
         ArrayList<String> uniqueTerms = aggregateTermList(hm);
         ArrayList<Tag> tags = new ArrayList<Tag>();
          double numberOfDocuments = hm.keySet().size() -1;// returns the number of keys aka article urls aka  the number of documents in hashmap
          double termIDF =0; // hows to be a double or math log would'nt work 
          for (String object : uniqueTerms) {
              int counter =0;
                  for (String currentKey : hm.keySet()) {
                       ArrayList<String> x = hm.get(currentKey); // contains arraylist of all terms in article
                      if ( x.contains(object)) {  // is the term inside this article.
                          counter = counter +1; // number of documents containing term.  
                      } 
                       
                  }
                 
                  termIDF= java.lang.Math.log(numberOfDocuments/counter); // computes idf for that term 
                  Tag y = new Tag(object, termIDF); // creates a tag. tag contains term and termIDF
                  tags.add(y);     // adds tag to arraylist of tags.
              }
            return  tags; 
        
    }
    
    
    /**
     * @param term the term
     * @param article the article containing the instance
     * @param hm the hashmap of raw term lists
     * @return the TF value of the term in that specific article. 
     * Computes term frequency. Counts number of instances,
     * divides by number of words.
     * O(n)
     */
    public double TF(String term, String article, HashMap<String, ArrayList<String>> hm) {
               ArrayList<String> terms = hm.get(article); // returns  arraylist of all the words in the article. 
               double frequency = Collections.frequency(terms, term); // number of time term appears in article. 
               double tf= frequency/terms.size();   // computes the term frequency. 
               return tf;
        }


    /**
     * @param hm the hashmap of raw term lists
     * @return an array list containing one entry of all terms listed in all articles
     * Goes through entire raw HashMap, goes unique term list 
     * O(n^3)
     */
    public ArrayList<String> aggregateTermList(HashMap<String, ArrayList<String>> hm) {
        ArrayList<String> uniqueTerms = new ArrayList<String>();
        for (String currentKey: hm.keySet()) {
            uniqueTerms.addAll(hm.get(currentKey)); // adds all of the terms in a hashmap to the list.
            
        }
        Set<String> hs = new HashSet<>(); // create Hash set because it doesn't allow duplicates.
        hs.addAll(uniqueTerms);  // add elements to hash set which removes duplicates 
        uniqueTerms.clear();
        uniqueTerms.addAll(hs); // add elements back to terms array list.
        termList.addAll(uniqueTerms);
        return uniqueTerms;    // arraylist that contains one entry of all the terms in a aritcle.
        
    
        
    }


    public BinarySearchTree<Index> getIndex() {
        
        return IndexBST;
    }
   

}
