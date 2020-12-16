import java.util.*;
import java.lang.*;
import java.util.Random; 

public class BPlusTreeTests {
   BPlusTree tree2;
    BPlusTree tree;
    Integer degree;
    Random generator;
    Integer seeder;
    Integer count;
    HashSet<Integer> values;
    List<Integer> lis = new ArrayList<Integer>(); 
   // System.out.println("nihao  hello world ");

    public BPlusTreeTests(Integer d, Integer seed) {
       
        tree = new BPlusTree(d);
        tree2 = new BPlusTree(4);
        
        //int howmany=0;
        //d=3;
        degree = d;
        System.out.println("eed for random generator: " + seeder);
        generator = new Random();
        if (seed != null) {
            seeder = seed;
        } else {
            seeder = (new Random()).nextInt();
        }
        seeder=2;
        System.out.println("Seed for random generator: " + seeder);
        generator.setSeed(seeder);
        count = 0;
        values = new HashSet<Integer>();
    }
    
    Integer insert() {
        //System.out.println(" hello world ");
        
        //tree2 = new BPlusTree(10);
        //tree2.insert(1,1);
     
        //tree2.insert(2,1);
        //tree2.insert(3,1);
        //tree2.insert(4,1);
        //tree2.insert(5,1);
        //tree2.print();
        //System.out.println("popopo"+tree2.root.children[0]);
         Random rand = new Random(); 
        Integer ins;
        
    // //     //  //Integer[] lm={869,781,739,128,504,246,506,244,327,414};
      // Integer[] lm={180,185,145,111,142,2,0,125,52,90,27,92,8,133,175,16,110,60,87,101};
    //   // List<Integer> l2 = new ArrayList<Integer>(); 
        // Integer k =1;
        // Integer stran;
   
        // while(k!=200){
        //    // ins = k;
        //   int min=-1000000000;
        //   int max = 1000000000;
        //     ins = rand.nextInt(max-min)+min; 
        //     ins=k;
        //     //l2.add(ins);
        //     //ins = lm[k];
        //    //System.out.println("************");
        //    System.out.println("************insert what"+ins);
        //       tree2.insert(ins,ins);
          
              
               
        //       if (ins != tree2.get(ins)) {
        //         throw new RuntimeException("Bad insertion! Can't find value "
        //                                    +ins
        //                                    + " after insert");
        //     }
        
        //       k++;
        // }

       // System.out.println("67777**"+tree2.get(128));
        //  tree2.print();
        //  Integer s=1;
        // while(s!=200){
        //     System.out.println("************why ???is that"+tree2.get(s)+"  "+s);
          
        // if (s != tree2.get(s) ) {
        //         throw new RuntimeException("Bad delete! Can't find value "
        //                                    + s
        //                                    + " before removing ");
        //     }
        // tree2.delete(s);
        // System.out.println("************delete what"+s);
        // if (null != tree2.get(s)) {
        //     throw new RuntimeException("Bad delete! value "
        //                                + s
        //                                + " after removing is not null");
        // }
    //     s++;
    // }

    //  for(Integer in: l2){
    //      tree2.delete(in);
    //     //l2.remove(in);
    //     if (null != tree2.get(in)) {
    //                 throw new RuntimeException("Bad delete! value "
    //                                             + in
    //                                             + " after removing is not null");

    //  }
    // }
        
        
        
        
        
        
        
        
      
        Integer x = generator.nextInt();
        count++;
        
        values.add(x);
        //howmany++;
        //System.out.println(x);
    if(x==tree.get(x)){
        System.out.println("deplicated "+x);
    }
        System.out.println("insert "+x);
        tree.insert(x, x);
        // if(lis.contains(1)){
        //     System.out.println("deplicate keys bad bad");
        // }
        // lis.add(x);
        // lis.add(1);
        
        if (x != tree.get(x)) {
            throw new RuntimeException("Bad insert! Can't find value "
                                       + x
                                       + " after inserting ");
        }
        //tree.print();
       return x;
       
    //return 0;
        
       
    }



    

    void delete() {

        Integer v = values.iterator().next();
        System.out.println("system delete"+v);

        if (v != tree.get(v)) {
            throw new RuntimeException("Bad delete! Can't find value "
                                       + v
                                       + " before removing ");
        }

        tree.delete(v);
        System.out.println("finish delete"+v);
        if (null != tree.get(v)) {
            throw new RuntimeException("Bad delete! value "
                                       + v
                                       + " after removing is not null");
        }

        values.remove(v);
    }

    void get() {
        Integer v = values.iterator().next();
        if (v != tree.get(v)) {
            throw new RuntimeException("Bad get! Can't find value "
                                       + v
                                       + " but is in insert set");
        }
    }

    public void testGet() {
        for (Integer i=0; i<values.size(); i++) {
            this.get();
        }
        System.out.println("Successfully got all "
                           + values.size()
                           + " expected values");
    }

    public void testDelete(Integer n) {
        Integer counter = 0;
        for (Integer i = 0; i < n; i++) {
            this.delete();
            counter++;
            if (values.isEmpty()) {
                break;
            }
        }
        System.out.println("Successfully deleted: "
                           + counter
                           + " items with "
                           + values.size()
                           + " items remaining");
    }

    public void testMix(Integer n, Integer writeRatio) {
        if ((writeRatio < 0) || (writeRatio > 100)) {
            throw new RuntimeException("Write ratio should be between 0 and 100");
        }

        Integer iCount = 0;
        Integer dCount = 0;

        Random rw = new Random();
        for (Integer i = 0; i < n; i++) {
            if ((rw.nextInt(100) < writeRatio) || (values.isEmpty())) {
                this.insert();
                iCount++;
            } else {
                this.delete();
                dCount++;
            }
        }

        System.out.println("Successfully written "
                           + iCount
                           + " and deleted "
                           + dCount
                           + " and "
                           + n
                           + " operations with writeRatio "
                           + writeRatio);
    }

    public void testInsert(Integer n) {
        for (int i = 0; i < n; ++i) {
            Integer inserted = insert();
        }
      for(Integer in: lis){
         // System.out.println("lis"+in);
      }
        System.out.println("Successfully inserted: " + n + " items");
    }

    public ValidationError testValidate() {
        if (tree.root.nodeType() == NodeType.INTERNAL) {
            INodeValidator v = new INodeValidator((INode)tree.root);
            ValidationError result = v.validate();
            if (result != null) { return result; }
        }
        System.out.println("Successfully validated tree");
        return null;
    }
}

class ValidationError {
    String msg;
    INode node;
    public ValidationError(String m, INode n) {
        msg = m;
        node = n;
    }

    public void printError() {
        System.out.println(msg);
    }
}

class INodeValidator {
    INode node;
    HashSet<Integer> seenKeys;
    Integer error;

    public INodeValidator(INode n) {
        node = n;
        seenKeys = new HashSet<Integer>();
        error = 0;
    }

    public INodeValidator(INode n, HashSet<Integer> k) {
        node = n;
        seenKeys = new HashSet<Integer>();
        error = 0;
    }

    public ValidationError validateKeys() {
        Boolean sawNull = false;
        Integer last = null;
        for (Integer i : this.node.keys) {
            if (i == null) { sawNull = true; }

            else if (sawNull == true) {
                return new ValidationError(
                        "Non-null keys after seeing a null",
                        node);
            }

            else if (seenKeys.contains(i)) {
                return new ValidationError(
                        "Duplicated keys in internal nodes",
                        node);
            }

            else if ((last != null) && (last >= i)) {
                return new ValidationError(
                        "Keys are not in sorted order",
                        node);
            }
            last = i;
            seenKeys.add(i);
        }
        return null;
    }

    public ValidationError validateChildKeys(Integer l, Integer h, Node c) {
        for (Integer k : c.keys) {
           // System.out.println("kp"+k+" ");
            if (k != null) {

                if ((l == null) && (h == null)) {
                    return new ValidationError(
                            "Something wrong happened",
                            node);
                }

                // First child will have null low bounds (defined from parent of
                // this node. Recursive check should catch this
                else if ((l == null) && (k >= h)) {
                    //System.out.println("k"+k+" "+h);
                    return new ValidationError(
                            "Purported first child keys don't match to high",
                            node);
                }
    
                // Last child will have null higher bound
                else if ((h == null) && (k < l)) {
                    //System.out.println("k"+k+" "+l);
                    return new ValidationError(
                            "Purported last child keys don't match to l",
                            node);
                }

                // Chldren are somewhere in between
                else if ((l != null) && (h != null) && ((k >= h) || (k < l))) {
                   // System.out.println("k"+k+" h"+h+"l"+l);
                    return new ValidationError(
                            "Child keys don't match to low high",
                            node);
                }

            }
        }
        return null;
    }

    public ValidationError validateChildren() {
        Integer counter = 0;
        Boolean seenNull = false;
        for (Node child : node.children) {

            if (child == null) { seenNull = true; }

            else if (seenNull == true) {
                return new ValidationError(
                        "Non null child after seeing a null child",
                        node);
            }

            else if (counter.equals(0)) {
                Integer h = node.keys[counter];
                for (int u =0;u<6;u++){
                //System.out.println("l +h"+"  "+h+"coun:");
                }
                ValidationError result = validateChildKeys(null, h, child);
                if (result != null) {
                    return result;
                }
            }

            else {
                Integer l = node.keys[counter-1];
                Integer h = node.keys[counter];

                if ((l == null) && (h == null)) {
                    return new ValidationError(
                            "A non-null child corresponding to a null keys",
                            node);
                }
               
                  // System.out.println("l +h"+l+"  "+h+"counter"+counter+child);
                ValidationError result = validateChildKeys(l, h, child);
                if (result != null) {
                    return result;
                }
            }

            counter++;
        }
        return null;
    }

    public NodeType childType() {
        if (node.children[0] == null) { return null; }
        return node.children[0].nodeType();
    }

    public ValidationError validate() {

        ValidationError result = null;

        result = validateKeys();
        if (result != null) {
            System.out.println("Error in internal node structure");
            result.printError();
            return result;
        }

        result = validateChildren();
        if (result != null) {
            System.out.println("Error in internal node structure");
            result.printError();
            return result;
        }

        if (childType() == NodeType.INTERNAL) {
            for (Node child: node.children) {
                if (child != null) {
                    INodeValidator v = new INodeValidator((INode)child, seenKeys);
                    result = v.validate();
                    if (result != null) {
                        System.out.println("Error in internal node structure");
                        result.printError();
                        //result.node.print(0);
                        return result;
                    }
                }
            }
        }

        return null;
    }

}

// Adding text to pull

