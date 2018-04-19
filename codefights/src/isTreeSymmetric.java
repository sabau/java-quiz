//
// Definition for binary tree:
// class Tree<T> {
//   Tree(T x) {
//     value = x;
//   }
//   T value;
//   Tree<T> left;
//   Tree<T> right;
// }

boolean isTreeSymmetric(Tree<Integer> t) {
    if (t == null) return true;
    return symmetricTrees(t.left, t.right);
}

boolean symmetricTrees(Tree<Integer> l, Tree<Integer> r) {
    if (l == null && r == null) {
        return true;
    }
    if (l == null || r == null || l.value != r.value) {
        return false;
    }
    if (symmetricTrees(l.left, r.right) == false) {
        return false;
    } 
    
    return symmetricTrees(l.right, r.left);
}
