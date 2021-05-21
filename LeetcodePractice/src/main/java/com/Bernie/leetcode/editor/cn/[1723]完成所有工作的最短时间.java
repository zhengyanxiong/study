//给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
//
// 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你
//设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。 
//
// 返回分配方案中尽可能 最小 的 最大工作时间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：jobs = [3,2,3], k = 3
//输出：3
//解释：给每位工人分配一项工作，最大工作时间是 3 。
// 
//
// 示例 2： 
//
// 
//输入：jobs = [1,2,4,7,8], k = 2
//输出：11
//解释：按下述方式分配工作：
//1 号工人：1、2、8（工作时间 = 1 + 2 + 8 = 11）
//2 号工人：4、7（工作时间 = 4 + 7 = 11）
//最大工作时间是 11 。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= jobs.length <= 12 
// 1 <= jobs[i] <= 107 
// 
// Related Topics 递归 回溯算法 
// 👍 100 👎 0


package com.Bernie.leetcode.editor.cn;

class FindMinimumTimeToFinishAllJobs {
    public static void main(String[] args) {
        Solution solution = new FindMinimumTimeToFinishAllJobs().new Solution();
        System.out.println(solution.minimumTimeRequired(new int[]{3, 2,3}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] jobs;
        int jobNums, workerNums;
        int ans = Integer.MAX_VALUE;

        public int minimumTimeRequired(int[] jobs, int k) {
            this.jobs = jobs;
            jobNums = jobs.length;
            workerNums = k;

            // dfs递归处理
            // 工人的任务分配情况
            int[] workerSum = new int[k];
            dfs(0,0, workerSum, 0);

            return ans;
        }

        /**
         *
         * @param currJobs 当前处理job
         * @param workerSum 工人任务分配情况
         * @param max 当前最大任务时间
         */
        private void dfs(int currJobs,int used, int[] workerSum, int max) {
            // 当当前处理的最大时间大于目标时间，直接返回
            if (max >= ans) {
                return;
            }
            if (currJobs == jobNums) {
                ans = max;
                return;
            }

            // 优先处理未分配员工
            if (used < workerNums) {
                workerSum[used] += jobs[currJobs];
                dfs(currJobs + 1, used + 1, workerSum, Math.max(workerSum[used], max));
                workerSum[used] = 0;
            }

            for (int i=0; i<used; i++) {
                workerSum[i] += jobs[currJobs];
                dfs(currJobs + 1, used, workerSum, Math.max(workerSum[i], max));
                workerSum[i] -= jobs[currJobs];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}