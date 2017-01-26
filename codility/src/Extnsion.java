import java.util.*;
import java.io.*;
import java.math.*;

class Extension {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        HashMap<String,String> hm = new HashMap<String,String>();
        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.
            hm.put(EXT.toLowerCase(), MT);
        }
        in.nextLine();
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine().toLowerCase(); // One file name per line.
            System.err.println(FNAME + " " + FNAME.lastIndexOf('.'));
            
            int idx = FNAME.lastIndexOf('.');
            if (idx >= 0){
                String value = hm.get(FNAME.substring(idx+1));
                System.err.println(FNAME.substring(idx+1) + " " + value);
                if (value != null) {
                    System.out.println(value);
                } else {
                    System.out.println("UNKNOWN");
                }
            }else {
                System.out.println("UNKNOWN");
            }
        }
    }
}
