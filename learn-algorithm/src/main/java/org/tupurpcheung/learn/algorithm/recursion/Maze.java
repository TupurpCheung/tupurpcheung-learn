package org.tupurpcheung.learn.algorithm.recursion;

/**
 * @description: 使用递归回溯解决迷宫问题
 * @author: tupurp
 * @create: 2020-06-08 01:28
 */
public class Maze {

    public static void mainTest(String[] args){
        int[][] maze = initMaze(8, 7);
        showMaze(maze);
        setWay(maze,1,1);
        showMaze(maze);
    }

    /**
     * @param maze 数组地图
     * @param startRowIndex 起点 横坐标
     * @param startColumnIndex 起点 纵坐标
     * @description 约定
     *                 0：未走过；1：墙；2：已走过，3：走过但走不通
     *                 走的顺序：下--》右--》上--》左
     * @return
     */
    public static boolean setWay(int[][] maze,int startRowIndex,int startColumnIndex){
        int endRowIndex = maze.length -2 ;
        int endColumnIndex = maze[0].length -2 ;


        //已走到终点
        if(maze[endRowIndex][endColumnIndex] == 2){
            return true;
        }else{
            //该点还没有走过
            if(maze[startRowIndex][startColumnIndex] == 0){
                //假设该点可以走通
                maze[startRowIndex][startColumnIndex] = 2;
                //向下走
                if(setWay(maze,startRowIndex + 1,startColumnIndex)){
                    return true;
                    //向右走
                }else if(setWay( maze,startRowIndex,startColumnIndex + 1)){
                    return true;
                    //向上走
                }else if(setWay( maze,startRowIndex - 1,startColumnIndex)){
                    return true;
                    //向左走
                }else if(setWay( maze,startRowIndex,startColumnIndex - 1)){
                    return true;
                }

                //该点走不通
                maze[startRowIndex][startColumnIndex] = 3;

                return false;

            }else{
                return false;
            }
        }


    }

    /**
     * @param height 数组一维大小 >= 6
     * @param width 数组二维大小 >= 6
     * @return
     */
    public static int[][]  initMaze(int height,int width){
        if(height < 6 )height = 6;
        if(width < 6 )width = 6;
        int[][] maze = new int[height][width];

        //构建墙
        for(int i =0;i<height;i++){
            maze[i][0] = 1;
            maze[i][width - 1] = 1;
        }

        for(int i =0;i<width;i++){
            maze[0][i] = 1;
            maze[height -1 ][i] = 1;
        }

        //构建障碍
        maze[5][5] = 1;
        maze[5][3] = 1;
        maze[5][4] = 1;
        maze[3][1] = 1;
        maze[3][2] = 1;


        return maze;
    }

    /**
     * 查看迷宫
     * @param maze
     */
    public static void showMaze(int[][] maze){
        int height = maze.length;
        int width = maze[0].length;
        for(int i = 0;i<height;i++){
            for(int j=0;j<width;j++){
                System.out.print(maze[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

    }
}