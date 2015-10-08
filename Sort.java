package com.java.whut.domain;

public class Sort {
	/*
	 * 简单排序:冒泡，选择，插入。
	*/
	
	//O(N^2)最慢
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
	
	//O(N^2)比冒泡略块。
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
	
	//O(N^2),比冒泡块一半。
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
	
	//高级排序:希尔排序。基于插入排序，步长为1时等同于插入排序。
	public static void ShellSort(int[] arr){
		
		int len=arr.length;
		int index,flag,temp;
		
		//h为步长，每次while循环后步长递减直至为1.各步长之间应满足互质。
		int h=1;
		while(h<len/3)
			h=3*h+1;
		while(h>0){
			for(flag=h;flag<len;flag++){
				temp=arr[flag];
				index=flag;
				//while循环找到标志位arr[flag]的位置index
				while(index-h>=0&&arr[index-h]>=temp){
					//如果index减去步长>=0,且步长数组逆序。
					arr[index]=arr[index-h];
					index=index-h;
				}
				//将arr[flag]插入index处
				arr[index]=temp;
			}
			h=(h-1)/3;
		}
		for(int i=0;i<len;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	
	//快速排序
	public static void FastSort(int[] arr,int left,int right){
		int flag;
		if(left<right){
			flag=Parttion(arr,left,right);
			FastSort(arr, left, flag-1);
			FastSort(arr, flag+1, right);
		}
		
	}

	private static int Parttion(int[] arr, int left, int right) {
		while(left<right){
			int flag=arr[left];
			while(left<right){
				while(left<right&&arr[right]>=flag)
					right--;
				arr[left]=arr[right];
				while(left<right&&arr[left]<=flag)
					left++;
				arr[right]=arr[left];
			}
			arr[left]=flag;
		}
		return left;
	}
}
