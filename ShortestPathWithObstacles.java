import java.util.*;

public class ShortestPathWithObstacles {
    static class Node {
        int x, y, steps, obstaclesLeft;

        public Node(int x, int y, int steps, int obstaclesLeft) {
            this.x = x;
            this.y = y;
            this.steps = steps;
            this.obstaclesLeft = obstaclesLeft;
        }
    }

    public static int shortestPath(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][][] visited = new boolean[rows][cols][k + 1];

        // BFS queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0, k));
        visited[0][0][k] = true;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // If we reached the bottom-right corner, return the steps
            if (current.x == rows - 1 && current.y == cols - 1) {
                return current.steps;
            }

            // Explore neighbors
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < rows && ny < cols) {
                    int remainingObstacles = current.obstaclesLeft - grid[nx][ny];

                    if (remainingObstacles >= 0 && !visited[nx][ny][remainingObstacles]) {
                        visited[nx][ny][remainingObstacles] = true;
                        queue.add(new Node(nx, ny, current.steps + 1, remainingObstacles));
                    }
                }
            }
        }

        return -1; // If no path exists
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0}
        };
        int k = 1;
        System.out.println("Shortest Path: " + shortestPath(grid, k));
    }
}
