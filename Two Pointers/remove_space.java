//Repeatedly remove all adjacent, repeated characters in a given string from left to right.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "I   from  usc   wf     sadfs";
		//on the left of l are the satisfiable strings. r is the current traverse index
		int l=0,r=0;
		char[] c = s.toCharArray();
		while(r<s.length()){
			if(r!=0 && c[r-1]==' ' && c[r]==' '){
				while(c[r]==' ')
					r++;
				c[l++]=c[r++];
			}
			else
				c[l++]=c[r++];
		}
		String s2 = "";
		for(int i=0;i<l;i++){
			s2+=c[i];
		}
		System.out.println(s2);
	}
