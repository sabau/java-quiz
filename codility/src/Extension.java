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
            String EXT = in.next().toLowerCase(); // file extension
            String MT = in.next(); // MIME type.
            hm.put(EXT, MT);
        }
        in.nextLine();
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine().toLowerCase(); 
            int idx = FNAME.lastIndexOf('.');
            String ext = idx == -1 ? "" : FNAME.substring(idx+1);
            System.out.println(hm.containsKey(ext) ?  hm.get(ext) : "UNKNOWN");
        }
    }
}
