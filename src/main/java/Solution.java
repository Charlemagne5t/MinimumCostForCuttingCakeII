import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        PriorityQueue<Integer> pqH = new PriorityQueue<>(Comparator.comparingInt((Integer a) -> -a));

        PriorityQueue<Integer> pqV = new PriorityQueue(Comparator.comparingInt((Integer a) -> -a));

        for (int i = 0; i < horizontalCut.length; i++) {
            pqH.offer(horizontalCut[i]);
        }
        for (int i = 0; i < verticalCut.length; i++) {
            pqV.offer(verticalCut[i]);
        }
        int hP = 1;
        int vP = 1;
        long res = 0;
        while (!pqH.isEmpty() || !pqV.isEmpty()) {
            if (pqH.isEmpty()) {
                res += pqV.poll() * hP;
                vP++;
            } else if (pqV.isEmpty()) {
                res += pqH.poll() * vP;
                hP++;
            } else {
                if (pqH.peek() > pqV.peek()) {
                    res += pqH.poll() * vP;
                    hP++;
                } else {
                    res += pqV.poll() * hP;
                    vP++;
                }
            }
        }

        return res;
    }
}