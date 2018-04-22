int kthSmallestInBST(Tree<Integer> t, int k) {
    int kth = 0;
    int val = Integer.MIN_VALUE;
    Tree<Integer> cur = t;
    Stack<Tree<Integer>> s = new Stack<Tree<Integer>>();
    
    while (cur != null) {
        s.push(cur);
        cur = cur.left;
    }
    
    while (s.size() > 0) {
        cur = s.pop();
        kth++;
        if (kth == k) return cur.value;
        if (cur.right != null) {
            cur = cur.right;
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
        }
        
       
    }
    
    return val;
}
