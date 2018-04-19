String findProfession(int level, int pos) {
    double nodes = Math.pow(2, level - 1);
    boolean engineer = true; 
    while (nodes > 1) {
        if (pos > nodes / 2) {
            engineer = engineer ? false : true;
            pos -= nodes / 2;
        }
        nodes /= 2;
    }
    
    return engineer ? "Engineer" : "Doctor";
}
