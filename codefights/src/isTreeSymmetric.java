boolean isTreeSymmetric(Tree<Integer> t) {
    if (t == null) return true;
    return symmetricTrees(t.left, t.right);
}

boolean symmetricTrees(Tree<Integer> l, Tree<Integer> r) {
    if (l == null && r == null) {
        return true;
    }
    if (l == null || r == null || l.value.intValue() != r.value.intValue()) {
        return false;
    }
    if (symmetricTrees(l.left, r.right) == false) {
        return false;
    } 
    
    return symmetricTrees(l.right, r.left);
}
