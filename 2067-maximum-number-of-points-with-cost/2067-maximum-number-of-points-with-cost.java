class Solution {
    public long maxPoints(int[][] points) {
        int rows = points.length;
        int cols = points[0].length;

        long[] prevMax = new long[cols];

        // 첫 번째 행 초기화
        for (int j = 0; j < cols; j++) {
            prevMax[j] = points[0][j];
        }

        // 두 번째 행부터 마지막 행까지 반복
        for (int i = 1; i < rows; i++) {
            long[] leftMax = new long[cols];
            long[] rightMax = new long[cols];
            long[] currMax = new long[cols];

            // 왼쪽에서 오른쪽으로 이동할 때의 최대 값 계산
            leftMax[0] = prevMax[0];
            for (int j = 1; j < cols; j++) {
                leftMax[j] = Math.max(leftMax[j - 1] - 1, prevMax[j]);
            }

            // 오른쪽에서 왼쪽으로 이동할 때의 최대 값 계산
            rightMax[cols - 1] = prevMax[cols - 1];
            for (int j = cols - 2; j >= 0; j--) {
                rightMax[j] = Math.max(rightMax[j + 1] - 1, prevMax[j]);
            }

            // 현재 행의 최대 값 계산
            for (int j = 0; j < cols; j++) {
                currMax[j] = points[i][j] + Math.max(leftMax[j], rightMax[j]);
            }

            // 다음 행 계산을 위해 현재 행의 최대 값을 prevMax로 업데이트
            prevMax = currMax;
        }

        // 마지막 행의 최대 값을 반환
        long maxPoints = 0;
        for (long val : prevMax) {
            maxPoints = Math.max(maxPoints, val);
        }
        return maxPoints;
    }
}
