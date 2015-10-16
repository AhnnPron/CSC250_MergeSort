
public class MergeInClass {


		public static void main(String[] args) 
		{
			int[] ar = {7,8,1,3,4,2};
			MergeInClass.display(ar);
			MergeInClass.mergerSort(ar);
			MergeInClass.display(ar);
		}
		
		static void diplay(int[] ar)
		{
			System.out.println("*****");
			for(int i=0; i <ar.length; i++)
			{
				System.out.print(ar[i] + " "); 
			}
			System.out.println("");
			System.out.println("*****");
		}
		static void mergerSort(int[] ar)
		{
			MergeInClass.mergeSortHelper(ar, 0, ar.length-1);
		}

		static void mergeSortHelper(int[] ar, int begin, int end)
		{
			MergeInClass.diplay(ar, begin, end);
			if(begin != end)
			{
				int leftBegin = begin;
				int leftEnd = ((end-begin)/2 + begin);
				int rightBegin = ((end-begin)/2 + begin) + 1;
				int rightEnd = end;
				MergeInClass.mergeSortHelper(ar, leftBegin, leftEnd);
				MergeInClass.mergeSortHelper(ar, rightBegin, rightEnd);


				//when we return here, we have two partially sorted lists
				//now we need to merge them together into a single list
				//where all the values are sorted.  Create a new array of
				//the correct length, then perform the merge algorithm to fill
				//that array with the correct data.  Then copy the contents
				//of that array back over the original array from begin to end
				int[] temp = new int[rightEnd-leftBegin +1]; 
				int currLeft = leftBegin; 
				int currRight = rightBegin; 
				
				for (int tempPos =0; tempPos < temp.length; tempPos++)
				{
					if(currLeft > leftEnd)
					{
						temp[tempPos] = ar[currRight]; 
						currRight++; //move to the next bucket 
					}
					else if(currRight > rightEnd)
					{
						temp[tempPos] = ar[currLeft]; 
						currLeft++; //move to the next bucket 
					}
					else
					{
						if(ar[currLeft] < ar[currRight])
						{
							temp[tempPos] = ar[currLeft];
							currLeft++; 
						}
						else
						{
							temp[tempPos] = ar[currRight];
							currRight++;
						}
						
					}
				}
				//temp is filled with the values from our 2 sublists in order
				int tempPos = 0; 
				for(int i = leftBegin; i <= rightEnd; i++)
				{
					ar[i] = temp[tempPos]; 
					tempPos++; 
				}
			}
		}
}


		




