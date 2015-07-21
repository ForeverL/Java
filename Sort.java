public class Sort {
	
	public static void BubbleSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
	
	public static void SelectSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			int minIndex=i;
			for(int j=i+1;j<arr.length-1;j++){
				if(arr[j]<arr[minIndex])
					minIndex=j;
			}
			int temp=arr[i];
			arr[i]=arr[minIndex];
			arr[minIndex]=temp;
		}
	}
	
	public static void InsertSort(int[] arr){
		for(int i=1;i<arr.length;i++){
			int temp=arr[i];
			int flag=i;
			while(flag>0&&arr[flag-1]>temp){
				arr[flag]=arr[flag-1];
				flag--;
			}
			arr[flag]=temp;
		}
	}
}
