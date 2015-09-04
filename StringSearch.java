public class StringSearch {
	public static void main(String[] args) {
		search("adedertdert", "dert");
	}
	
	public static int search(String str1,String str2){
		int len1=str1.length();
		int len2=str2.length();
		
		if(len1<len2){
			System.out.println("No");
			return -1;
		}
		
		int dx;
		boolean flag;
		for(int i=0;i<len1;i+=dx){
			dx=1;
			flag=false;
			for(int j=0;j<len2;j++){
				char ch1=str1.charAt(i+j);
				char ch2=str2.charAt(j);
				
				if(j>0&&ch1==str2.charAt(0)&&(!flag)){
					dx=j;
					flag=true;
				}
				
				if(ch1==ch2){
					if(j==len2-1){
						System.out.println(i);
						return 1;
					}
				}else
					break;
			}
		}
		
		return 0;
	}
}
