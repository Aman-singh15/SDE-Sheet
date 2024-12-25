/*You are given three arrays: id, deadline, and profit, where each job is associated with an ID, a deadline, and a profit. Each job takes 1 unit of time to complete, and only one job can be scheduled at a time. You will earn the profit associated with a job only if it is completed by its deadline.
Your task is to find:
The maximum number of jobs that can be completed within their deadlines.
The total maximum profit earned by completing those jobs.
Examples :
Input: id = [1, 2, 3, 4], deadline = [4, 1, 1, 1], profit = [20, 1, 40, 30]
Output: [2, 60]
Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40).
Input: id = [1, 2, 3, 4, 5], deadline = [2, 1, 2, 1, 1], profit = [100, 19, 27, 25, 15]
Output: [2, 127]
Explanation: Job1 and Job3 can be done with maximum profit of 127 (100+27).
Input: id = [1, 2, 3, 4], deadline = [3, 1, 2, 2], profit = [50, 10, 20, 30]
Output: [3, 100]
Explanation: Job1, Job3 and Job4 can be completed with a maximum profit of 100 (50 + 20 + 30).*/
  
  class Solution {
    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        int n = id.length;

        // Create a list of jobs (id, deadline, profit)
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(id[i], deadline[i], profit[i]);
        }

        // Sort the jobs in descending order of profit
        Arrays.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job a, Job b) {
                return b.profit - a.profit;
            }
        });

        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i].deadline);
        }

        int[] slots = new int[maxDeadline + 1];
        Arrays.fill(slots, -1);

        int jobCount = 0;
        int totalProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = jobs[i].deadline; j > 0; j--) {
                if (slots[j] == -1) {
                    slots[j] = jobs[i].id;
                    jobCount++;
                    totalProfit += jobs[i].profit;
                    break;
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(jobCount);
        ans.add(totalProfit);

        return ans;
    }
  
    static class Job {
        int id, deadline, profit;

        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        
        }
    }
}
