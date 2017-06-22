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

}
