import java.util.*;

// COST MODEL ================================
//  Initialize: N
//  Union:      N
//  Find:       N 

// Quick-Union defect:
//  - Trees can get tall
//  - Find too expensive (could be N array accesses)

public class QuickUnionUF {

    int N;
    int[] id;

    public QuickUnionUF(int n) {
        N = n;
        id = new int[N];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i])
            i = id[i];
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {

        int i = root(p);
        int j = root(q);
        id[i] = j;


    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter size of graph: ");
        int N = in.nextInt();
        QuickUnionUF quuf = new QuickUnionUF(N);
        int count = N-1;
        while (count >=0) {
            count--;
            int p = in.nextInt();
            int q = in.nextInt();
            if (!quuf.connected(p, q)) {
                quuf.union(p, q);
                System.out.println(p + " " + q);
            }
        }
        System.out.println(Arrays.toString(quuf.id));
    }
}