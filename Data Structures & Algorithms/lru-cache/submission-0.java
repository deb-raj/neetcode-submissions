class LRUCache {
    HashMap<Integer,Node>map ;
    Node head;
    Node tail;
    int capacity;
    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key , int val , Node prev , Node next){
            this.key=key;
            this.val=val;
            this.prev=prev;
            this.next=next;
            
        }
    }
    public LRUCache(int capacity) {
        this.capacity=capacity;
         map = new HashMap<>();
         
         head=new Node(0,0,null , null);
         tail=new Node(0,0,null , null);
         head.next=tail;
         tail.prev=head;
    }
        void remove(Node node ){
            Node a = node .prev;
            a.next=node.next;
            node.next.prev=a;
        }
        void addToHead(Node node){
            Node a = head.next;
            head.next=node; 
            node.prev=head;
            a.prev=node;
            node.next=a;
        }
    
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        addToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {

    if(map.containsKey(key)){
        Node node = map.get(key);

        node.val = value;

        remove(node);
        addToHead(node);
         return ;
        }
        Node node = new Node(key, value, null, null);
        if(map.size()==capacity){
            Node lru=tail.prev;
            map.remove(lru.key);
            remove(lru);
        }
         map.put(key, node);
         addToHead(node);
    }
}
