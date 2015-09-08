/*
 *  生命游戏的规则可简化为以下:
 *	邻居个数为0、1、4、5、6、7、8时，则该细胞下次状态为死亡。
 *	邻居个数为2时，则该细胞下次状态为复活。
 *	邻居个数为3时，则该细胞下次状态为稳定。
 * 
*/
public class Cell {
	//1:存在  0:空
	private static int[][] mat={{0, 0, 0, 1, 1, 1, 0, 1, 0, 1},
								{0, 0, 0, 1, 0, 1, 0, 1, 0, 0},
								{0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
								{0, 1, 0, 1, 1, 1, 0, 1, 0, 0},
								{0, 0, 1, 1, 0, 0, 1, 1, 1, 1},
								{0, 1, 0, 0, 1, 1, 0, 0, 0, 1},
								{0, 0, 0, 1, 1, 1, 0, 1, 1, 0},
								{0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
								{0, 1, 0, 1, 1, 1, 0, 1, 0, 0},
								{1, 0, 0, 1, 1, 1, 0, 1, 0, 1},
								};
	private static int len=mat.length;
	//0:死亡  1:复活  2:稳定
	private static int[][] state={{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
								  {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
								  {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
								  {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
								  {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
								  {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
								  {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
								  {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
								  {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
								  {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
								};
	
	public static int getState(int x,int y){
		int count=0;
		int state=-1;
		if(x>0&&x<len-1){
			if(y==0){
				count=check(x,y,1,1,0,1,0,1,1,0);
			}else if(y==len-1){
				count=check(x,y,1,1,1,0,1,0,0,1);
			}else{
				count=check(x,y,1,1,1,1,1,1,1,1);
			}
		}
		if(x==0){
			if(y==0){
				count=check(x,y,0,1,0,1,0,1,0,0);
			}else if(y==len-1){
				count=check(x,y,0,1,1,0,0,0,0,1);
			}else{
				count=check(x,y,0,1,1,1,0,1,0,1);
			}
		}
		
		if(x==len-1){
			if(y==0){
				count=check(x,y,1,0,0,1,0,0,1,0);
			}else if(y==len-1){
				count=check(x,y,1,0,1,0,1,0,0,0);
			}else{
				count=check(x,y,1,0,1,1,1,0,1,0);
			}
		}
		
		if(count==2)
			state=1;
		else if(count==3)
			state=2;
		else
			state=0;
		
		return state;
	}
	
	private static int check(int m,int n,int w,int x,int a,int d,int q,int c,int e,int z){
		int count=0;
		if(w==1&&mat[m-1][n]==1)
			count++;
		if(x==1&&mat[m+1][n]==1)
			count++;
		if(a==1&&mat[m][n-1]==1)
			count++;
		if(d==1&&mat[m][n+1]==1)
			count++;
		if(q==1&&mat[m-1][n-1]==1)
			count++;
		if(c==1&&mat[m+1][n+1]==1)
			count++;
		if(e==1&&mat[m-1][n+1]==1)
			count++;
		if(z==1&&mat[m+1][n-1]==1)
			count++;
		
		return count;
	}
	
	private static void run(int[][] arr) {
		
		
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				state[i][j]=getState(i, j);
			}
		}
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				if(state[i][j]==0)
					mat[i][j]=0;
				if(state[i][j]==1)
					mat[i][j]=1;
			}
		}
		showMat();
		System.out.println();
	}
	
	private static void showMat(){
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				if(mat[i][j]==1)
					System.out.print("●");
				else
					System.out.print("○");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		showMat();
		System.out.println();
		for(int i=0;i<1000;i++)
			run(mat);
	}
	
}
