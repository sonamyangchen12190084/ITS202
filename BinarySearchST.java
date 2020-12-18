import java.util.*;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	Node root;

	class Node{
		Key  key;
		Value val;
		Node left, right;
		int size;

		public Node(Key key, Value val, int size){
			this.key = key;
			this.val = val;
			this.size = 1;
		}
	}

	 public BinarySearchST(){
		root = null;
	
	}

	public boolean isEmpty(){
		if(size()==0){
			return true;
		}
			return false;
	}

	public int size(){
		return size(root);
	}

	private int size(Node x){
		if(x==null){
			return 0;
		}
		else{
			return x.size;
		}


	}
	public Value get(Key key){
		if(key == null) throw new IllegalArgumentException("key cannot be null!");
		return get(root, key);

	 }
	private Value get(Node x, Key key){
		if(x == null){
			return null;
		}
		int cmp = key.compareTo(x.key);
		if(cmp < 0)
		{
			return get(x.left, key);
		}
		else if(cmp > 0){
			return get(x.right, key);
		}
		else{
			return x.val;
		}

	}
	
		
	

	public void put(Key key, Value val){
		if(key == null) throw new IllegalArgumentException("key cannot be null!");
		root = put(root, key,val);
	
	}

	private Node put(Node x, Key key, Value val){
		if(x == null) return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if(cmp < 0) x.left = put(x.left, key, val);
		else if(cmp > 0) x.right = put(x.right, key, val);
		else{
			x.val = val;
		}
		x.size = size(x.left) + size(x.right) + 1;
		return x;
		
		

	}
	public Key min(){
		return min(root).key;
	}
	private Node min(Node x){
		if(x.left == null) return x;
		return min(x.left);
	}

	public Key floor(Key key) {
		Node x = floor(root, key);

		if(x==null) return null;
		return x.key;

        
    } 
    public void deleteMin() {
        
        root = deleteMin(root);
        
    }

    private Node deleteMin(Node x) {
        
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size= size(x.left) + size(x.right) + 1;
        return x;
    }
   
    public void delete(Key key) {
        root = delete(root, key);
        
    }

    private Node delete(Node x, Key key) {
       
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    } 



    private Node floor(Node x, Key key) {
     	if(x==null) return null;

     	int temp = key.compareTo(x.key);

     	if(temp==0) return x;
     	if(temp<0) return floor(x.left, key);

     	Node t =floor(x.right, key);
     	if(t !=null) return t;
     	else return x;
    }
       
     

    public Key select(int k) {
      	if(k < 0 || k >=size()) return null;
      	Node x = select(root, k);
        return x.key;
    }

    // Return key of rank k. 
    private Node select(Node x, int k) {
    	if(x == null) return null;
    	int t = size(x.right);
    	if (t>k) return select(x.right, k);
    	else if( t < k) return select(x.left, k-t-1);
    	else return x;
        
         
    } 

    public Iterable<Key> keys(Key lo, Key hi) {
     LinkedList<Key> link = new LinkedList<Key>();
        keys(root, link, lo, hi);
        return link;
    } 

     private void keys(Node x,LinkedList<Key> link, Key lo, Key hi) { 
         if (x == null) return; 
        int cmplo = lo.compareTo(x.key); 
        int cmphi = hi.compareTo(x.key); 
        if (cmplo < 0) keys(x.left, link, lo, hi); 
        if (cmplo <= 0 && cmphi >= 0) link.add(x.key); 
        if (cmphi > 0) keys(x.right, link, lo, hi);  
    } 




	public static void main(String[] args) {
		BinarySearchST<String, Integer> obj = new BinarySearchST<>();
		obj.put("Ada",1);
		obj.put("Ballerina",3);
		obj.put("Html",5);
		obj.put("Java",7);
		//obj.put("Java",8);
		obj.put("Dart",9);

		//System.out.println(obj.isEmpty());
		System.out.println(obj.get("Ada"));
		System.out.println(obj.get("Java"));
		System.out.println(obj.size());
		System.out.println(obj.min());
		System.out.println(obj.floor("Ballerina"));
		System.out.println(obj.select(3));
		System.out.println(obj.keys("Ada","Java"));
		//System.out.println(obj.get("Java"));
		System.out.println(obj.size());
		//System.out.println(obj.deleteMin());
		System.out.println(obj.keys("Ballerina","Java"));
		//System.out.println(obj.delete("Java"));

	}
}