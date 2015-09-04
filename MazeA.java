/*
 *迷宫问题
 *迷宫是一个二维矩阵,其中1为墙,0为路,3为入口,4为出口.要求从入口开始,从出口结束,
 *按照 下,左,上,右 的顺序来搜索路径.
 * 
*/
public class Maze {
	private static int[][] maze={ {1, 1, 1, 1, 1, 1, 1, 1},
						   		  {1, 3, 1, 1, 0, 1, 0, 1},
						   		  {1, 0, 0, 0, 0, 1, 0, 1},
						   		  {1, 1, 0, 0, 1, 0, 1, 1},
						   		  {1, 0, 0, 1, 0, 0, 1, 1},
						   		  {1, 0, 0, 0, 0, 1, 1, 1},
						   		  {1, 0, 1, 0, 0, 1, 0, 1},
						   		  {1, 0, 1, 0, 0, 0, 1, 1},
						   		  {1, 1, 1, 1, 0, 0, 4, 1},
						   		  {1, 1, 1, 1, 1, 1, 1, 1}
								};
	private static int startX;
	private static int startY;
	private static int endX;
	private static int endY;
	
	
	//获取入口出口坐标
	static{
		for(int i=0;i<maze.length;i++){
			for(int j=0;j<maze[i].length;j++){
				if(maze[i][j]==3){
					startX=i;
					startY=j;
					maze[i][j]=0;
				}
				if(maze[i][j]==4){
					endX=i;
					endY=j;
					maze[i][j]=0;
				}
			}
		}
	}
	
	
	private static boolean flag=false;
	
	private static void showMaze(){
		for(int i=0;i<maze.length;i++){
			for(int j=0;j<maze[i].length;j++){
				if(maze[i][j]==1)
					System.out.print("█");
				else if(maze[i][j]==2)
					System.out.print("●");
				else if(i==startX&&j==startY)
					System.out.print("¤");
				else if(i==endX&&j==endY)
					System.out.print("□");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	private static boolean visit(int i,int j){
		maze[i][j]=2;
		
		if(i==endX&&j==endY)
			flag=true;
		
		if(flag!=true&&maze[i+1][j]==0)
			visit(i+1,j);
		if(flag!=true&&maze[i][j+1]==0)
			visit(i,j+1);
		if(flag!=true&&maze[i-1][j]==0)
			visit(i-1,j);
		if(flag!=true&&maze[i][j-1]==0)
			visit(i,j-1);
		
		if(!flag)
			maze[i][j]=0;
		
		return flag;
	}
	
	public static void main(String[] args) {
		showMaze();
		System.out.println();
		visit(startX,startY);
		showMaze();
	}
}
