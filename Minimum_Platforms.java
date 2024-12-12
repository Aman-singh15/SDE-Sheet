/*You are given the arrival times arr[] and departure times dep[] of all trains that arrive at a railway station on the same day. Your task is to determine the minimum number of platforms required at the station to ensure that no train is kept waiting.
At any given time, the same platform cannot be used for both the arrival of one train and the departure of another. Therefore, when two trains arrive at the same time, or when one arrives before another departs, additional platforms are required to accommodate both trains.
Examples:
Input: arr[] = [900, 940, 950, 1100, 1500, 1800], dep[] = [910, 1200, 1120, 1130, 1900, 2000]
Output: 3
Explanation: There are three trains during the time 9:40 to 12:00. So we need a minimum of 3 platforms.*/

  
class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // Step 1: Sort both arrival and departure times
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platCount = 0; // Current platforms needed
        int result = 0;    // Maximum platforms required
        int i = 0, j = 0;  // Pointers for arrival and departure times

        while (i < arr.length && j < dep.length) {
            // If a train arrives before the previous one departs
            if (arr[i] <= dep[j]) {
                platCount++; // Increment platform count
                i++;         // Move to the next train's arrival
            } else {
                platCount--; // Decrement platform count as a train departs
                j++;         // Move to the next train's departure
            }
            result = Math.max(result, platCount); // Update maximum platforms required
        }

        return result;
    }
}
