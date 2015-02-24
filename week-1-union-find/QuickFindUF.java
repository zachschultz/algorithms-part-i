import java.util.*;

// COST MODEL ================================
//  Initialize: N
//  Union:      N
//  Find:       N 

// Quick-Find defect:
//  - Union too expensive (N array accesses)
//  - Trees flat, but it is expensive keeping them flat

public class QuickFindUF {

    int N;
    int[] id;

    public QuickFindUF(int n) {
        N = n;
        id = new int[N];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {

        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = qid;
        }


    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter size of graph: ");
        int N = in.nextInt();
        QuickFindUF quf = new QuickFindUF(N);
        int count = N-1;
        while (count >=0) {
            count--;
            int p = in.nextInt();
            int q = in.nextInt();
            if (!quf.connected(p, q)) {
                quf.union(p, q);
                System.out.println(p + " " + q);
            }
        }
        System.out.println(Arrays.toString(quf.id));
    }
}