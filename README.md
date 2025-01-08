# Shortest-Path-in-a-Grid-with-Obstacles
You are given a grid where each cell can either be empty (0) or contain an obstacle (1). You can move up, down, left, or right. Your task is to find the shortest path from the top-left corner to the bottom-right corner, where you are allowed to remove up to k obstacles.
Explanation:
Node Class: Represents each position in the grid with its coordinates, current number of steps, and remaining obstacles that can be removed.
BFS:
Start from (0,0) with k obstacle removals.
Visit neighbors and check if obstacles can be removed.
Use a 3D visited array to track states (x, y, remainingObstacles).
Return the steps once the bottom-right corner is reached. Return -1 if no path exists.
