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
  

}
