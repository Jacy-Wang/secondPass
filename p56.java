/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0)
            return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                if (a.start > b.start) {
                    return 1;
                } else if (a.start < b.start) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        ArrayList<Interval> res = new ArrayList<>();
        Interval cur = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start > cur.end) {
                res.add(cur);
                cur = intervals.get(i);
            } else {
                cur = new Interval(cur.start, Math.max(cur.end, intervals.get(i).end));
            }
        }
        res.add(cur);
        return res;
    }
}
