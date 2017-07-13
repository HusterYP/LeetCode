/*
题目：
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. 
Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, 
and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" 
(water inside that isn't connected to the water around the island). One cell is a square with side length 1.
 The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]
Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:
*/

public class Solution {
    public int islandPerimeter(int[][] grid) {
     int sum = 0;
        int flag = 0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]==1)
                {
                    flag = sum;
                    if(i==0&&j==0&&grid[i+1][j]==1&&grid[i][j+1]==1)
                        sum+=2;
                    else
                        sum+=3;

                    if(i==grid.length-1&&j==grid[i].length-1&&grid[i][j-1]==1&&grid[i-1][j]==1)
                        sum+=2;
                    else
                        sum+=3;

                    if(i==0&&j==grid[i].length-1&&grid[i+1][j]==1&&grid[i][j-1]==1)
                        sum+=2;
                    else
                        sum+=3;

                    if(i==grid.length-1&&j==0&&grid[i-1][j]==1&&grid[i][j+1]==1)
                    sum+=2;
                    else
                        sum+=3;

                    if(flag<sum)
                        continue;

                    if(i==0&&j!=0&&j!=grid[i].length-1)
                        sum+=4-grid[i][j-1]-grid[i][j+1]-grid[i+1][j];
                    else if(j==0&&i!=0&&i!=grid.length-1)
                        sum+=4-grid[i-1][j]-grid[i+1][j]-grid[i][j+1];
                    else if(i==grid.length-1&&j!=0&&j!=grid[i].length-1)
                        sum+=4-grid[i][j-1]-grid[i][j+1]-grid[i-1][j];
                    else if(j==grid[i].length-1&&i!=0&&i!=grid.length-1)
                        sum+=4-grid[i-1][j]-grid[i+1][j]-grid[i][j-1];
                    else
                        sum+=4-grid[i][j-1]-grid[i][j+1]-grid[i-1][j]-grid[i+1][j];
                }
            }
        }
        return sum;
    }
}