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

}
