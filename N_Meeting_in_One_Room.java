// You are given timings of n meetings in the form of (start[i], end[i]) where start[i] is the start time of meeting i and end[i] is the finish time of meeting i. Return the maximum number of meetings that can be accommodated in a single meeting room, when only one meeting can be held in the meeting room at a particular time. 
// Note: The start time of one chosen meeting can't be equal to the end time of the other chosen meeting.
// Examples :
// Input: start[] = [1, 3, 0, 5, 8, 5], end[] =  [2, 4, 6, 7, 9, 9]
// Output: 4

class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // Add your code here 
        boolean visited[] = new boolean[start.length];
        int count = 0;
        int lastEndTime = -1; // Track the last meeting's end time

        for (int i = 0; i < start.length; i++) {
            int minEndTime = Integer.MAX_VALUE; // Find the earliest end time
            int selectedMeeting = -1;          // Index of the selected meeting
            
            for (int j = 0; j < end.length; j++) {
                // Check if the meeting is not visited and is valid
                if (!visited[j] && start[j] > lastEndTime && end[j] < minEndTime) {
                    minEndTime = end[j];
                    selectedMeeting = j;
                }
            }
            
            if (selectedMeeting != -1) { // If a valid meeting is found
                visited[selectedMeeting] = true;
                lastEndTime = end[selectedMeeting]; // Update last end time
                count++;
            }
        }
        return count;
    }
}
 
