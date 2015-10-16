
public class Merge
{
	private int [] array; 
	private int [] tempMergAr; 
	private int length; 
	
	public static void main(String[] args) 
	{
		int[] inputAr = {7,8,1,3,4,2};
		Merge M = new Merge(); 
		M.Sort(inputAr);
		for(int i:inputAr)
		{
			System.out.print(i); 
			System.out.print(" ");
		}
	}

	public void Sort(int inputArr[])
	{
		this.array= inputArr; 
		this.length = inputArr.length; 
		this.tempMergAr= new int [length]; 
		
		mergeSortHelper(0, length-1);
	}

	private void mergeSortHelper(int begin,  int end)
	{
		if(begin < end)
		{
			int leftBegin = begin;
			int middle = ((end-begin)/2 + begin);
			int rightBegin = ((end-begin)/2 + begin) + 1;
			int rightEnd = end;
			
			mergeSortHelper(begin, middle);
			mergeSortHelper(middle + 1, end); 
			mergeParts(begin, middle, end);
			
		}
	}
	
	private void mergeParts(int begin, int middle, int end)
	{
		for(int i = begin; i<=end; i++)
		{
			tempMergAr[i] = array[i]; 
		}
		int iBegin = begin; 
		int jMiddle = middle +1; 
		int kEnd = end; 
		while (iBegin <= middle && jMiddle <= end)
		{
			if (tempMergAr[iBegin] <= tempMergAr[jMiddle]) 
			{
				array[kEnd] = tempMergAr[iBegin]; 
				iBegin++; 
			}
			else 
			{
				array[kEnd] = tempMergAr[jMiddle];
				jMiddle++; 
			}
			kEnd++; 
		}
		while (iBegin <= middle)
		{
			array[kEnd] = tempMergAr[iBegin]; 
			kEnd++; 
			iBegin++; 
		}
	}

			
	//when we return here, we have two partially sorted lists

	//now we need to merge them together into a single list

	//where all the values are sorted.  Create a new array of

	//the correct length, then perform the merge algorithm to fill

	//that array with the correct data.  Then copy the contents

	//of that array back over the original array from begin to end
	

	
}
