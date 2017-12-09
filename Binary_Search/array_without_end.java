

//Search In a Big Sorted Array


public int searchBigSortedArray(ArrayReader reader, int target){
		int index=1;
		while(reader.get(index-1)<target){    //inorder to find the end bound.
			index=index*2;
		}
		
		//rest part is the binary search
	}
