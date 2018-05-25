


//比较难，需记忆。 主要参考乘法的原则。每次更新res数组时都有可能产生新的carrier用于下一次iteration
public class Q12 {

	private static String multiply(String s1, String s2){
		int len1=s1.length();
		int len2=s2.length();
	    if (len1 == 0 || len2 == 0)
	        return "0";
		char[] nums1=s1.toCharArray();
		char[] nums2=s2.toCharArray();
		
	    // will keep the result number in this array
	    // in reverse order
		int[] res = new int[len1+len2];  //len1+len2保证数组的位数足够。
	    // Below two indexes are used to find positions
	    // in result. 
		int pos1=0;
		int pos2=0;
		
		for(int i=len1-1;i>=0;i--){
			int carry=0;
			int n1=nums1[i]-'0';
	        // To shift position to left after every
	        // multiplication of a digit in num2
			pos2=0;
			
			// Go from right to left in num2  
			for(int j=len2-1;j>=0;j--){
				// Take current digit of second number
				int n2=nums2[j]-'0';
				
		        // Multiply with current digit of first number
	            // and add result to previously stored result
	            // at current position. 
				int sum=n1*n2+res[pos1+pos2]+carry;  //！！！记忆
				
				// Carry for next iteration
				carry=sum/10;
				
				// Store result
				res[pos1+pos2]=sum%10;
				
				pos2++;
			}
			if(carry>0)
				res[pos1+pos2]+=carry;
			// To shift position to left after every
	        // multiplication of a digit in num1.
			pos1++;
		}
		System.out.println("paassin");
		int i = res.length - 1;
		while (i>=0 && res[i] == 0)
			i--;
		
		System.out.println("paassin2");
		if (i == -1)
		       return "0";
		StringBuilder buffer = new StringBuilder();
		while(i>=0){
			System.out.println(res[i]);
			buffer.append(res[i--]);
			
			
		}
		System.out.println("this is ersult   "+buffer.toString());
		return buffer.toString();

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(multiply("1500000","2035"));


	}

}
