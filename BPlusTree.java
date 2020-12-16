import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

// The BPlusTree class. You'll need to fill the methods in. DO NOT change the
// function signatures of these methods. Our checker relies on these methods and
// assume these function signatures.

public class BPlusTree {

    // A tree has a root node, and an order
    public Node root;
    public Integer order_;
 
    // Required methods to implement. DO NOT change the function signatures of
    // these methods.

    // Instantiate a BPlusTree with a specific order
    public BPlusTree(Integer order) {
        this.root = new LNode(order);
        this.order_= order;
       
        
      

     }

    // Given a key, returns the value associated with that key or null if doesnt
    // exist
    public Integer get(Integer key) { 
     Integer res=   root.get(key);
    // System.out.println("complcared");
     return res;
     
     }

    // Insert a key-value pair into the tree. This tree does not need to support
    // duplicate keys
    public void insert(Integer key, Integer value) {

       
       Split r_spl;
      // System.out.println("what stuff"+key);
     r_spl=root.insert(key,value);
     //System.out.println("what stuff"+r_spl.key);
        if(r_spl!=null){
            System.out.println("received"+order_);
            INode newroot = new INode(order_);
            newroot.keys[0]=r_spl.key;
            newroot.children[0]=r_spl.left;
           newroot.children[1]=r_spl.right;
           root = newroot;
         root.numChildren=2;
         for(int i=0;i<order_;i++){
         //System.out.println("nleft"+r_spl.left.keys[i]);
         
         }
         for(int i=0;i<order_;i++){
          
           // System.out.println("nright"+r_spl.right.keys[i]);
            }
        }
     

     }

    // Delete a key and its value from the tree
    public void delete(Integer key) { 
        root.delete(key);
    }

    // Optional methods to write
    // This might be a helpful function for your debugging needs
      public void print() {
     for(int i=0;i<this.order_;i++){
     System.out.println("rr"+root.keys[i]+"order"+order_);
     }
      }
}

// DO NOT change this enum. There are two types of nodes; an Internal node, and
// a Leaf node
enum NodeType {
    LEAF,
    INTERNAL,
}

// This class encapsulates the pair of left and right nodes after a split
// occurs, along with the key that divides the two nodes. Both leaf and internal
// nodes split. For this reason, we use Java's generics (e.g. <T extends Node>).
// This is a helper class. Your implementation might not need to use this class
class Split<T extends Node> {
    public Integer key;
    public T left;
    public T right;

    public Split(Integer k, T l, T r) {
        key = k;
        right = r;
        left = l;
    }
}

// An abstract class for the node. Both leaf and internal nodes have the a few
// attributes in common.
abstract class Node {

    // DO NOT edit this attribute. You should use to store the keys in your
    // nodes. Our checks for correctness rely on this attribute. If you change
    // it, your tree will not be correct according to our checker. Values in
    // this array that are not valid should be null.
    public Integer[] keys;
    public Integer degree;
    public Integer order;

    // Do NOT edit this attribute. You should use it to keep track of the number
    // of CHILDREN or VALUES this node has. Our checks for correctness rely on
    // this attribute. If you change it, your tree will not be correct according
    // to our checker.
    public Integer numChildren;

    // DO NOT edit this method.
    abstract NodeType nodeType();
 


    // You may edit everything that occurs in this class below this line.
    // *********************************************************************

    // Both leaves and nodes need to keep track of a few things:
    //      their parent
    //      a way to tell another class whether it is a leaf or a node

    // A node is instantiated by giving it an order, and a node type
    public Node(Integer order, NodeType nt) {
        
        
        this.keys=new Integer[order];
   
        
        this.order=order;
    
        this.numChildren=0;
     }

    // A few things both leaves and internal nodes need to do. You are likely
    // going to need to implement these functions. Our correctness checks rely
    // on the structure of the keys array, and values and children arrays in the
    // leaf and child nodes so you may choose to forgo these functions.

    // You might find that printing your nodes' contents might be helpful in
    // debugging. The function signature here assumes spaces are used to
    // indicate the level in the tree.
    // abstract void print(Integer nspaces);

    // You might want to implement a search method to search for the
    // corresponding position of a given key in the node
    Integer search(Integer key){
    //  for(int i=0;i<numChildren;i++){
    //      if(keys[i]>key){
    //          return i;
    //      }
    //  }

        
    //     return numChildren;
    return null;
     }

    // You might want to implement a split method for nodes that need to split.
    // We use the split class defined above to encapsulate the information
    // resulting from the split.
    Split split(){
       
       
        
        return null;}          // Note the use of split here

    // You might want to implement an insert method. We use the Split class to
    // indicate whether a node split as a result of an insert because splits in
    // lower levels of the tree may propagate upward.
    Split insert(Integer key, Integer value){
        return null;
    }
    
    
    //abstract Split insert(Integer key, Integer value);
      //  return null;} // And split here

    // You might want to implement a delete method that traverses down the tree
    // calling a child's delete method until you hit the leaf.
    void delete(Integer key){}

    // You might want to implement a get method that behaves similar to the
    // delete method. Here, the get method recursively calls the child's get
    // method and returns the integer up the recursion.
    Integer get(Integer key){return -1;}

    // You might want to implement a helper function that cleans up a node. Note
    // that the keys, values, and children of a node should be null if it is
    // invalid. Java's memory manager won't garbage collect if there are
    // references hanging about.
    void cleanEntries(){}
}

// A leaf node (LNode) is an instance of a Node
class LNode extends Node {

    // DO NOT edit this attribute. You should use to store the values in your
    // leaf node. Our checks for correctness rely on this attribute. If you
    // change it, your tree will not be correct according to our checker. Values
    // in this array that are not valid should be null.
    public Integer[] values;
    public LNode right_sibling ;

    // DO NOT edit this method;
    public NodeType nodeType() { return NodeType.LEAF; };
    
   public Integer search(Integer key){
     //  System.out.println("search index LNODE"+"num children"+numChildren+"keys length"+keys.length);
    for(int i=0;i<numChildren;i++){
        if(keys[i]==null){
            break;
        }
        if(keys[i]>=key){
            return i;
        }
        
    }
    return numChildren;
   }




   Integer get(Integer key){
      LNode cur= this;
     //System.out.println("almost here"+this.keys[2]);
 while(cur!=null){
    for(int i=0;i<cur.numChildren;i++){
        //System.out.println("ikkk"+cur.keys[i]);
        if(cur.keys[i]==key){
            return cur.values[i];
        }
    }
   cur=cur.right_sibling;
}
   //System.out.println("touuu"+this.right_sibling.keys[0]+this.keys[0]+this.right_sibling.right_sibling.keys[0]);

    //System.out.println("touchdeddeeded");
    return null;
   }
   
    public Split split(){
       
        Integer mid = this.order/2;
        LNode new_right = new LNode(order);
       // System.out.println("teeded"+this.keys[0]);
        int j=0;
        int save=keys[mid];
         for(int i=mid;i<order;i++){
             new_right.keys[j]=this.keys[i];
             new_right.values[j]=this.values[i];
             j++;
             this.keys[i]=null;
             this.values[i]=null;
         }
         new_right.numChildren=j;
         this.numChildren=order-j;
         new_right.right_sibling=this.right_sibling;
         this.right_sibling=new_right;
         
         Split sli = new Split(save,this,new_right);
        //  for(int s=0;s<this.numChildren;s++){
        //   // System.out.println("touchdeddeeded"+this.numChildren+" "+save+"this key"+this.keys[1]);
        //  }
        //  for(int  ss=0;ss<new_right.numChildren;ss++){
        //    // System.out.println("touchdeddeeded"+keys[mid]+"new right key"+new_right.keys[ss]);
        //  }
        //  //System.out.println("touchdeddeeded"+keys[mid]+this.keys[3]);
        return sli;
       
    }


  public void delete(Integer key){
      int index = search(key);
     System.out.println("delte process"+index+" "+numChildren+keys[index]);
      if(keys[index]!=key || index == numChildren){
          return;
      }else{
        for(int i=index;i<numChildren;i++){
          //  System.out.println("de process"+keys[i]+" "+keys[i+1]);
            keys[i]=keys[i+1];
            values[i]=values[i+1];
           
        }
        numChildren--;
        for(int u=0;u<numChildren;u++){
           // System.out.println("read"+keys[u]);
        }
        return ;
      }
      

  }
    public Split insert(Integer key, Integer value){
    int index = search(key);
   //System.out.println("ins"+index+" "+numChildren+" "+this.order);
   for(int k =0;k<10;k++){
    //System.out.println("ok"+keys[k]+values[k]);
    }
        if(index==numChildren){
            keys[index]=key;
            values[index]=value;
            numChildren++;
        }else if(keys[index]==key){
            this.values[index]=value;
        }else{
            // for(int i=numChildren-1;i>=index;i--){
            //     keys[i+1]=keys[i];
            //     values[i+1]=values[i];
            // }
           // for(int k =0;k<10;k++){
               // System.out.println("ppppp"+not a keys[k]);
            //    Integer shift = this.numChildren-index;
            //    System.arraycopy(keys,index,keys,index+1,shift-1);
            //    System.arraycopy(children,index+1,children,index+2,shift-1);
            Integer shift = this.keys.length-index;
            System.arraycopy(keys,index,keys,index+1,shift-1);
            System.arraycopy(values,index,values,index+1,shift-1);
   
               // }
            keys[index]=key;
            values[index]=value;
            numChildren++;

        }
        for(int k =0;k<order;k++){
         //System.out.println("mid"+keys[k]);
            }
        if(numChildren==this.order){
           // System.out.println("you need to split");
            return split();
        }
        return null;

    }
    // You may edit everything that occurs in this class below this line.
    // *************************************************************************

    // A leaf has siblings on the left and on the right.

    // A leaf node is instantiated with an order
    
    public LNode(Integer order) {

        // Because this is also a Node, we instantiate the Node (abstract)
        // superclass, identifying itself as a leaf.
        super(order, NodeType.LEAF);
        values = new Integer[order];
        right_sibling=null;
        order=order;

        // A leaf needs to instantiate the values array.
    }
}

// An internal node (INode) is an instance of a Node
class INode extends Node {

    // DO NOT edit this attribute. You should use to store the children of this
    // internalnode. Our checks for correctness rely on this attribute. If you
    // change it, your tree will not be correct according to our checker. Values
    // in this array that are not valid should be null.
    // An INode (as opposed to a leaf) has children. These children could be
    // either leaves or internal nodes. We use the abstract Node class to tell
    // Java that this is the case. Using this abstract class allows us to call
    // abstract functions regardless of whether it is a leaf or an internal
    // node. For example, children[x].get() would work regardless of whether it
    // is a leaf or internal node if the get function is an abstract method in
    // the Node class.
    public Node[] children;

    
    
    

    // DO NOT edit this method;
    public NodeType nodeType() { return NodeType.INTERNAL; };


    public Integer search(Integer key){
        for(int s =0;s<numChildren;s++){
          //  System.out.println("searchhhhhhhhhhhhhhhhhhhhhhh"+keys[s]+"----"+numChildren);
        }
        for(int i=0;i<numChildren-1;i++){
            if(keys[i]==null){
                break;
            }
           //System.out.println("searchhhhhhhhhhhhhhhhhhhhhhh"+this.keys[0]+"----"+numChildren);
            if( keys[i]>=key){
                return i;
            }
        }
        return numChildren-1;
       }

       Integer get(Integer key){
       // System.out.println("what the heck is this"+keys[0]+keys[1]);
         return children[0].get(key);
      //System.out.println("what the heck is this"+keys[0]+keys[1]);
        
       }
      





       public void delete(Integer key){

        int index = search(key);
         System.out.println("what the delete is this"+index+" "+numChildren+" "+key+keys[index]);
        if(index==numChildren-1 ||key<keys[index]){
            this.children[index].delete(key);

        }else if(key.intValue()==keys[index].intValue()){
            System.out.println("go here");
            this.children[index+1].delete(key);
        }
        return;
       }


       public Split split(){
        Integer mid = this.numChildren/2;
       // System.out.println("mfay"+numChildren+mid);
        if(this.numChildren%2!=0){
        mid++;
        }
        Integer save = keys[mid-1];
        
        INode new_right = new INode(order);
     //  System.out.println("midddddd"+numChildren+mid);
        int j=0;
         for(int i=mid;i<numChildren-1;i++){
         //  System.out.println("noooo"+this.keys[i]+mid);
             new_right.keys[j]=this.keys[i];
             this.keys[i]=null;
             j++;
         }
       
         this.keys[mid-1]=null;
         int s=0;
         for(int l=mid;l<numChildren;l++){
            new_right.children[s]=this.children[l];
            this.children[l]=null;
            s++;

         }
    
         new_right.numChildren=s;
         this.numChildren=numChildren-s;
        
        //  System.out.println("check stop keys"+new_right.numChildren);
        //  System.out.println("check stop this"+this.keys[0]+this.keys[1]+this.keys[2]+" "+this.numChildren);
        //  System.out.println("check stop this children"+this.children[0].keys[0]+this.children[1].keys[0]);
        //  System.out.println("check stop newr"+new_right.keys[0]+new_right.keys[1]+new_right.keys[2]+" "+new_right.numChildren);
        // System.out.println("check stop newr children"+save);
          //this.right_sibling=new_right;
         Split sli = new Split(save,this,new_right);
         for(int qqq=0;qqq<order;qqq++){
           // System.out.println("3q"+this.keys[qqq]+save+" "+this.keys[4]);
         }
        return sli;
       
    }
    public Split insert_split(Split toinsert){
      //  System.out.println("ibefore"+keys[0]);
        Integer index = search(toinsert.key);
        for(int x=0;x<order;x++){
        //System.out.println("ibefore"+toinsert.left.keys[x]+toinsert.key);
        }
        if(index==numChildren-1){
          //  System.out.println("not heer?"+index+numChildren+toinsert.left.numChildren);
            keys[index]=toinsert.key;
            children[index+1]=toinsert.right;
          
        }else{
        
            Integer shift = this.numChildren-index;
            System.arraycopy(keys,index,keys,index+1,shift-1);
            System.arraycopy(children,index+1,children,index+2,shift-1);





            keys[index]=toinsert.key;
            children[index+1]=toinsert.right;


        }
      //  System.out.println("not possible"+this.children[2].keys[0]);
      
        numChildren++;
        if(numChildren>order){
         //  System.out.println("second xxxx");
            Split spl;
            spl=this.split();
          // System.out.println("second yyyy"+spl.key);
            //insert_split(spl);
           // System.out.println("second zzzzz"+spl.key);
            return spl;

        }else{
            return null;
        }

    }

       public Split insert(Integer key, Integer value){
          for (int h=0;h<3;h++){
           // System.out.println("key check"+" "+numChildren+" "+keys[h]);
          }
        Integer index = search(key);
        Split spl=null;
       // System.out.println("LNODE insertion"+index+numChildren);
        if(index==numChildren-1 || key<keys[index]){
          // System.out.println("here is the kind"+index+" "+numChildren);
            spl=this.children[index].insert(key,value);
          
        }else if(keys[index]==key){
            spl=this.children[index+1].insert(key,value);
            
        }
        if(spl==null){
            return null;
        }else{
        return insert_split(spl);
        }
       
       }

    // You may edit everything that occurs in this class below this line.
    // *************************************************************************

    // A leaf node is instantiated with an order
    public INode(Integer order) {

        // Because this is also a Node, we instantiate the Node (abstract)
        // superclass, identifying itself as a leaf.
        super(order, NodeType.INTERNAL);
        
        children= new Node[order+1];
        // children[0] = split.left;
        // children[1] = split.right;
        // keys[0] = split.key;
    
        // num_children = 2;
     

        // An INode needs to instantiate the children array
    }
}

// This is potentially encapsulates the resulting information after a node
// splits. This is might help when passing split information from the split
// child to the parent. Sea README for more details.
/*
class Split<T extends Node> {
    public Integer key;
    public T left;
    public T right; // always splits rightward

    public Split(Integer k, T l, T r) {
        key = k;
        right = r;
        left = l;
    }
}
*/

