//Recursively remove all adjacent duplicates
//Given a string, recursively remove adjacent duplicate characters from string. 
//The output string should not have any adjacent duplicates. See following examples.
public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s2 = "acaaabbbacdddd";
		String s ="caaabbbaacdddd";
		char[] c = s.toCharArray();
		
		//l is the first position in the stack;
		int l=-1,r=0;
		while(r<s.length()){
			if(l==-1 || c[r]!=c[l]){
				c[++l]=c[r++];   //模拟进栈的过程
			}
			else if(l!=-1 && c[r]==c[l]){
				while(r<s.length() && c[r]==c[l])
					r++;
				l--;
			}
		}
		String res = "";
		for(int i=0;i<=l;i++)
			res+=c[i];
		System.out.println(res);
	}
