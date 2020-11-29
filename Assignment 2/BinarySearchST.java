import java.util.*;

public class BinarySearchST<Key extends Comparable<Key>, Value>{
	Node root;
	int nodeCount;

	class Node{
		Key key;
		Value val;
		Node left;
		Node right;
		int size;

		public Node(Key key, Value val, int size){
			this.key = key;
			this.val = val;
			this.size = size; 
			left = null;
			right = null;
		}
	}
	public BinarySearchST(){
		root = null; 
	}
	
	public boolean isEmpty(){
		if(root==null){
			return true;
		}
		return false;
	}

	public int size(){
		return root.size;
	}

	public int size(Node x){
		if(x == null) return 0;
		
		else return x.size;
	}

	public Value get(Key key){
		Node x = root;
		if (key == null) {
			throw new IllegalArgumentException("key caanot be null");
		}
		if (x == null) {
			return null;
			
		}
		while(x != key){
			int cmp = key.compareTo(x.key);
			if(cmp < 0){
				x = x.left;
			}
			else if(cmp > 0){
				x = x.right;
			}
			return x.val;
		}
		return x.val;

	}

	public void put(Key key, Value val){
		if(key == null){
			throw new IllegalArgumentException("key caanot be null");
		}
		else{
			Node newest = new Node(key,val,1);
			if(root == null){
				root = newest;
			}
			else{
				Node x = root;
				Node parent;
				while(x != null){
					parent = x;
					int cmp = key.compareTo(x.key);
					if(cmp < 0){
						x = x.left;
						if (x == null){
							parent.left = newest;
							root.size++;
							return;
						}
						else if(x.key == key){
							x.val = val;
							return;						
						}
					}
					else if(cmp > 0){
						x = x.right;
						if(x == null){
							parent.right = newest;
							root.size++;
							return;
						}
						else if(x.key==key){
							x.val=val;
							return;
						}
					}	
				}
			}
		}
	} 

	public Key floor(Key key){
		Node x = getNode(root, key);
		Node cmp = x;
		if(key == null){
			throw new IllegalArgumentException("key cannot be null");
		}
		else if(size() == 0){
			throw new NoSuchElementException("there is no such key");
		}
		if(x == null){
			return null;

		}
		if(x.left!=null){
			cmp = x.left;

			while(cmp.right!=null){
				cmp = cmp.right;
			}
		}
		return cmp.key;
	}

	public Node getNode(Node x, Key key){
		Node node = null;
		if(key == null){
			throw new IllegalArgumentException("key cannot be null");
		}
		while(x != null){
			int cmp = key.compareTo(x.key);
			if(cmp == 0){
				return x;
			}
			if(cmp > 0){
				node = x;
				x = x.right;
			}
			else{
				x = x.left;
			}
		}
		return node;
	}

	public Key min(){
		Node x = root;
		for(x = root; x.left != null; x = x.left){
			if(x == null)
				throw new NoSuchElementException("symbol table is Empty");
		}
		return x.key;
	}

	public Key select(int k){
		nodeCount = 0;
		if((k<0) || k>=size()){
			throw new IllegalArgumentException("rank should be between 0 and its size");

		}
		return select(root, k+1).key;
	}
	// return key of rank k.
	private Node select(Node x, int k){
		Stack<Node> stack = new Stack<Node>();
		Node curr = root;
		while (!stack.empty() || curr !=null){
			if(curr != null){
				stack.push(curr);
				curr = curr.left;
			}
			else{
				curr = stack.pop();
				nodeCount++;
				if(nodeCount == k)
					break;
				curr = curr.right;
			}

		}
		return curr;
	}

	public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null || hi == null) {
            throw new IllegalArgumentException("Argument is null!!!");
        }
        Queue<Key> queue = new LinkedList<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x,Queue<Key> queue, Key lo, Key hi) { 
        if (x == null) {
            return;
        }
        Node node1 = x;
        while (node1 != null){
            int cmp = node1.key.compareTo(hi);
            int cmp1 = node1.key.compareTo(lo);

            if (node1.left == null) {
                if (cmp <= 0 && cmp1 >= 0) queue.offer(node1.key);
                node1 = node1.right;
            }
            else {
                Node node2 = node1.left;
                while (node2.right != null && node2.right != node1)
                    node2= node2.right;
                if (node2.right == null) {
                    node2.right = node1;
                    node1 = node1.left;
                }
                else {
                    node2.right = null;
                    if (cmp <= 0 && cmp1>=0) queue.offer(node1.key);
                    node1 = node1.right;
                }
            }
        }
    }

	public static void main(String[] args) {
		BinarySearchST <String, Integer> obj = new BinarySearchST<String, Integer>();
		obj.put("ABDUL",1);
		System.out.println(obj.get("ABDUL"));
		obj.put("HRITHIK",2);
		obj.put("SAI",3);
		obj.put("SAMAL",6);
		System.out.println(obj.get("SAI"));
		obj.put("TASHI",4);


		System.out.println("size: " +obj.size());
		System.out.println("min: " +obj.min());
		System.out.println(obj.floor("HRITHIK"));
		System.out.println(obj.floor("HAHA"));
		System.out.println(obj.select(2));
		System.out.println(obj.keys("ABDUL","TASHI"));

		obj.put("CHIMI",5);
		obj.put("SAMAL",4);
		System.out.println(obj.get("SAMAL"));
		obj.put("NIMA",7);
		System.out.println(obj.size());
		System.out.println(obj.get("CHIMMI"));
		System.out.println(obj.floor("CHIMA"));
		obj.put("SONAM",8);
		System.out.println(obj.keys("ABDUL","TASHI"));
		
	}
}