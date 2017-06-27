public class Solutions{
  int firstDuplicate(int[] a) {
      for (int i = 0; i < a.length; i++){
          if (a[Math.abs(a[i])-1] >= 0){
              a[Math.abs(a[i])-1] = -a[Math.abs(a[i])-1];
          }else{
              return Math.abs(a[i]);
          }
      }

      return -1;
  }
  
  // Definition for singly-linked list:
  // class ListNode<T> {
  //   ListNode(T x) {
  //     value = x;
  //   }
  //   T value;
  //   ListNode<T> next;
  // }
  //
  ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
      while(l != null && l.value == k){
          l = l.next;
      }

      ListNode<Integer> n = l;

      while(n != null){
          while(n.next != null && n.next.value == k){
              n.next = n.next.next;
          }
          n = n.next;
      }
      return l;

  }
  
  boolean isListPalindrome(ListNode<Integer> l) {
    ListNode<Integer> h = l, 
        reverse_end,
        slow = l, 
        fast = l, 
        prev_slow = l; 
        
        
        //middle = null;
    
    if(l != null && l.next != null){
        //go to the middle with slow, fast will have twice his speed
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            prev_slow = slow;
            slow = slow.next;
        } //O(N/2) ~ O(N)
        
        //fast is null if #elements in l is even, not null if odd
        //let's store the middle element
        if (fast != null){
            //middle = slow;
            slow = slow.next;
        }
        
        reverse_end = slow;
        prev_slow.next = null; //close first half
          
        //Reverse the second half
        ListNode<Integer> 
            prev = null, 
            cur = reverse_end, 
            next;
        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        reverse_end = prev;
        
        //Compare them
        ListNode<Integer> t1 = l, t2 = reverse_end;
        while (t1 != null && t2 != null){
            if (t1.value.equals(t2.value)) {
                t1 = t1.next;
                t2 = t2.next;
            }else{
                return false;
            }
        }
        //we should restore the oroginal list..naaah        
        if (t1 == null && t2 == null)
            return true;
        return false;
    }
    
    
    ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    ListNode<Integer> i1 = l1, i2 = l2, mi = null, m = null;
    if (i1.value <= i2.value){
        m = i1;
        i1 = i1.next;
    }else{
        m = i2;
        i2 = i2.next;
    }
    mi = m;
    
    while (i1 != null && i2 != null){
        if (i1.value <= i2.value){
            mi.next = i1;
            i1 = i1.next;
        }else{
            mi.next = i2;
            i2 = i2.next;
        }
        mi = mi.next;
    }
    if (i1 != null) mi.next = i1;
    if (i2 != null) mi.next = i2;
    
    return m;
}
    
    
    ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> head, int k) {
    if (head == null || k < 2) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode cur = head;
    while(cur != null) {
        ListNode pilot = pre.next;
        int remaining = k;
        while (pilot != null && remaining > 0) {
            remaining--;
            pilot = pilot.next;
        }
        if (remaining > 0) {
            break;
        }
        while(cur.next != pilot) {
            ListNode nt = cur.next.next;
            cur.next.next = pre.next;
            pre.next = cur.next;
            cur.next = nt;
        }
        pre = cur;
        cur = cur.next;
    }
    return dummy.next;
}
    ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n) {
    if (n == 0 || l == null || l.next == null) return l;
    ListNode cur = l, head = null, tmp;
    int count = 0;
    while (cur != null){
        cur = cur.next;
        count += 1;
    }
    if (n == count) return l;
    tmp = l;
    cur = l;
    while (count > n){
        tmp = cur;
        cur = cur.next;
        count -= 1;
    }
    head = cur;
    tmp.next = null;
    while (cur.next != null){
        cur = cur.next;
    }
    cur.next = l;
    return head;
}

void debug(ListNode<Integer> l){
    ListNode<Integer> tmp = l;
    System.out.println("\nNew List");
    while (tmp != null){
        System.out.format("->%d", tmp.value);
        tmp = tmp.next;
    }
}
  

}
