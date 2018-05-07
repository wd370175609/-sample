

Radix Sort:	time:Ω(nk)	space:O(n+k)
algorithm video: https://www.youtube.com/watch?v=YXFI4osELGU




public static void radixsort(int[] nums){
		//find the max value of the array.
		int max=0;
		for(int n:nums){
			max=Math.max(max, n);
		}
		
		//find the digit length of the maximum number
		int length_digit=0;
		while(max!=0){
			length_digit++;
			max/=10;
		}
		
		//initialize 10 buckets with queue.(each bucket has one queue)
		List<Queue<Integer>> list=new ArrayList<>();
		for(int i=0;i<10;i++)
			list.add(new LinkedList<Integer>());
		
		
		int pos=1;
		while(pos<=length_digit){  //times of loop is equal to the length_digit
			int temp=1;
			for(int i=0;i<pos-1;i++){
				temp*=10;
			}
			for(int i=0;i<nums.length;i++){     //get the digit and put it to the related queue.
				list.get(nums[i]/temp%10).add(nums[i]);
			}
			int j=0;
			for(int i=0;i<10;i++){         //poll out the number from bottom to top in the queue.
				Queue<Integer> sta=list.get(i);
				while(!sta.isEmpty())
					nums[j++]=sta.poll();
			}
			pos++;
		}
		
		
	}
