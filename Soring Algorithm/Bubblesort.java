
//    Best complexity is O(n)
//    Worse is O(n^2)
//   space O(1)

   // An optimized version of Bubble Sort. 
    static void bubbleSort(int arr[], int n)
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++)    //只需要排n-1次。  Every loop we can make sure that last number will not change in the future.
        {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) //n-i-1通过举例就能方便记住
            {
                if (arr[j] > arr[j + 1]) 
                {
                    // swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
 
            // IF no two elements were 
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }
