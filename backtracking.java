import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class backtracking {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
//        System.out.println(maze(3,3));
//        mazepaths("",3,3);
//        System.out.println(mazepaths1("",3,3));
//        System.out.println(mazepathsdiagonal("",3,3));
        boolean[][] board = {
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
//        mazepathsobstacle("",board,0,0);
        boolean[][] board1 = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
//        mazeallpaths("",board1,0,0);
        int[][] path = new int[board1.length][board1[0].length];
        mazeallpathsprint("",board1,0,0,path,1);
    }

    static int maze(int r,int c) {  //no of ways to reach end of maze of row r and col c
        if (r==1 || c==1) return 1;
        int right = maze(r-1,c);
        int down = maze(r,c-1);
        return right+down;
    }
    static void mazepaths(String p,int r,int c) { //print paths to reach end of maze of row r and col c
        if (r==1 && c==1) {
            System.out.println(p);
            return;
        }
        if (r>1) mazepaths(p+'D',r-1,c);
        if (c>1) mazepaths(p+'R',r,c-1);

    }
    static ArrayList<String> mazepaths1(String p, int r, int c) { //print paths through to reach end of maze of row r and col c
        if (r==1 && c==1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if (r>1) list.addAll(mazepaths1(p+'D',r-1,c));
        if (c>1) list.addAll(mazepaths1(p+'R',r,c-1));
        return list;
    }
    static ArrayList<String> mazepathsdiagonal(String p, int r, int c) { //print paths through to reach end of maze of row r and col c and with diagonal too
        if (r==1 && c==1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if (r>1 && c>1) list.addAll(mazepathsdiagonal(p+'D',r-1,c-1));
        if (r>1) list.addAll(mazepathsdiagonal(p+'V',r-1,c));
        if (c>1) list.addAll(mazepathsdiagonal(p+'H',r,c-1));
        return list;
    }
    static void mazepathsobstacle(String p,boolean[][] maze,int r,int c) { //print paths to reach end of maze of row r and col c and an obstacle
        if (r==maze.length-1 && c==maze[0].length-1) {
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) return;
        if (r<maze.length-1) mazepathsobstacle(p+'D',maze,r+1,c);
        if (c<maze[0].length-1) mazepathsobstacle(p+'R',maze,r,c+1);

    }
    static void mazeallpaths(String p,boolean[][] maze,int r,int c) { //print paths to reach end of maze of row r and col c we can go to all direction through backtracking
        if (r==maze.length-1 && c==maze[0].length-1) {
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) return;

        maze[r][c]=false;

        if (r<maze.length-1) mazeallpaths(p+'D',maze,r+1,c);
        if (c<maze[0].length-1) mazeallpaths(p+'R',maze,r,c+1);
        if (r>0) mazeallpaths(p+'U',maze,r-1,c);
        if (c>0) mazeallpaths(p+'L',maze,r,c-1);

        maze[r][c]=true;

    }
    static void mazeallpathsprint(String p,boolean[][] maze,int r,int c,int[][] path,int step) { //print paths to reach end of maze of row r and col c we can go to all direction through backtracking
        if (r==maze.length-1 && c==maze[0].length-1) {
            path[r][c]=step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if (!maze[r][c]) return;

        maze[r][c]=false;
        path[r][c]=step;
        if (r<maze.length-1) mazeallpathsprint(p+'D',maze,r+1,c,path,step+1);
        if (c<maze[0].length-1) mazeallpathsprint(p+'R',maze,r,c+1,path,step+1);
        if (r>0) mazeallpathsprint(p+'U',maze,r-1,c,path,step+1);
        if (c>0) mazeallpathsprint(p+'L',maze,r,c-1,path,step+1);

        maze[r][c]=true;
        path[r][c]=0;
    }
}