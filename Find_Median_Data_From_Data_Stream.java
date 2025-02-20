/*The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:
MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
Example 1:
Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]
Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0   */



// class MedianFinder {
//       ArrayList<Integer>ans;
//     public MedianFinder() {
//         ans=new ArrayList<>();
//     }
    
//     public void addNum(int num) {
//         ans.add(num);
//          Collections.sort(ans);
//     }
    
//     public double findMedian() {
//       if(ans.size()>0){
//          int size = ans.size();
//        if(ans.size()%2!=0){
//          int median=(size/2);
//           return (double)ans.get(median);
//        }else{
         
//           double median= ans.get(size / 2 - 1) + ans.get(size / 2);
//           return median/2.0;
//        }
//       }
//       return 0.0;
//     }
// }
import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> low;  // Max Heap
    private PriorityQueue<Integer> high; // Min Heap

    public MedianFinder() {
        low = new PriorityQueue<>((a, b) -> b - a); // Max Heap
        high = new PriorityQueue<>(); // Min Heap
    }
    
    public void addNum(int num) {
        low.offer(num);
        high.offer(low.poll());

        if (low.size() < high.size()) {
            low.offer(high.poll());
        }
    }
    
    public double findMedian() {
        if (low.size() > high.size()) {
            return low.peek();
        }
        return (low.peek() + high.peek()) / 2.0;
    }
}// class MedianFinder {
//       ArrayList<Integer>ans;
//     public MedianFinder() {
//         ans=new ArrayList<>();
//     }
    
//     public void addNum(int num) {
//         ans.add(num);
//          Collections.sort(ans);
//     }
    
//     public double findMedian() {
//       if(ans.size()>0){
//          int size = ans.size();
//        if(ans.size()%2!=0){
//          int median=(size/2);
//           return (double)ans.get(median);
//        }else{
         
//           double median= ans.get(size / 2 - 1) + ans.get(size / 2);
//           return median/2.0;
//        }
//       }
//       return 0.0;
//     }
// }
import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> low;  // Max Heap
    private PriorityQueue<Integer> high; // Min Heap

    public MedianFinder() {
        low = new PriorityQueue<>((a, b) -> b - a); // Max Heap
        high = new PriorityQueue<>(); // Min Heap
    }
    
    public void addNum(int num) {
        low.offer(num);
        high.offer(low.poll());

        if (low.size() < high.size()) {
            low.offer(high.poll());
        }
    }
    
    public double findMedian() {
        if (low.size() > high.size()) {
            return low.peek();
        }
        return (low.peek() + high.peek()) / 2.0;
    }
}
