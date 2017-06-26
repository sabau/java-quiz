class Tree<T> {
  Tree(T x) {
    value = x;
  }
  T value;
  Tree<T> left;
  Tree<T> right;
  
  boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
    if (t == null){
        return s == 0;
    }
    s -= t.value;    
    return hasPathWithGivenSum(t.left, s) || hasPathWithGivenSum(t.right, s);
  }
}


