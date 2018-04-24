public class Coin {
	private static int[] coin={2,2,2,2,2,2,2,2,2,2};
	private static int index=-1;


	public static void main(String[] args) {
		int len=coin.length;
		check(coin,0,len-1);
		System.out.println(index);
	}

	private static void check(int[] arr,int start,int end) {
		int len=end-start+1;
		if(len==2){
			if(arr[start]!=arr[end])
				index=start;
		}
		
		if(len==1){
			if(arr[0]!=arr[start])
				index=start;
		}
		if(len>2){
			boolean temp=(arr[start]==arr[start+1]);
			if(temp){
				check(arr,start+2,end);
			}else{
				check(arr,start,start+1);
			}
		}
	}
}
