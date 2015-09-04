public class Maze {
	private static int[][] maze = { {2, 2, 2, 2, 2, 2, 2},
									{2, 0, 0, 0, 0, 0, 2},
									{2, 0, 0, 0, 2, 0, 2},
									{2, 0, 0, 0, 0, 2, 2},
									{2, 2, 0, 0, 0, 2, 2},
									{2, 0, 0, 0, 0, 0, 2},
									{2, 2, 2, 2, 2, 2, 2}
									};
	private static int size=maze.length;
	private static boolean flag=false;
	
	public static void showMaze(){
		for(int i=0;i<maze.length;i++){
			for(int j=0;j<maze[i].length;j++){
				//System.out.print(maze[i][j]+" ");
				if(maze[i][j]==2)
					System.out.print("█");
				else if(maze[i][j]==1)
					System.out.print("●");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		
	}
	
	public static void showMat(){
		for(int i=0;i<maze.length;i++){
			for(int j=0;j<maze[i].length;j++){
				System.out.print(maze[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void visit(int i,int j){
		//标记路径
		maze[i][j]=1;
		
		//判断是否到终点
		if(i==size-2&&j==size-2)
			showMaze();
		
		//递归
		if(maze[i][j+1]==0)     //向右移动一格
			visit(i,j+1);
		if(maze[i+1][j]==0)		//向下移动一格
			visit(i+1,j);
		if(maze[i-1][j]==0)		//向上移动一格
			visit(i-1,j);
		if(maze[i][j-1]==0)		//向左移动一格
			visit(i,j-1);
		
		//回溯，恢复路径初始值。
		maze[i][j]=0;
	}
	
	public static void main(String[] args) {
		showMaze();
		visit(1,1);
	}
	
}
