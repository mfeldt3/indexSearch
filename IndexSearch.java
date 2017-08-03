public class IndexSearch
{
   public static void main(String[] args){
      Comparable[] testArray={1,2,3,6,9,11,12,13};
      int test=binarySearch(testArray,16); //Object should be placed at index 8
      int test2=binarySearch(testArray,0);//Should be placed at index 0
      int test3=binarySearch(testArray,2); //Should be placed at index 1
      int test4=binarySearch(testArray,5); //Should be placed at index 5;
      
      System.out.println(test); //prints 8
      System.out.println(test2); //prints 0
      System.out.println(test3); //prints 1
      System.out.println(test4); //prints 3
      
   }
	public static int binarySearch(Comparable[] objArray, Comparable searchObj)
	{	
		int low=0;
		
		int high=objArray.length-1;
		int mid=0;
		int temp;
	
		while(low<=high)
		{
			mid=(low+high)/2;
		
			if (objArray[mid].compareTo(searchObj)<0)
			{
				temp=mid;
				low=mid+1;
				try //Try catch to IndexOutOFBoundsException
				{
					if (objArray[low].compareTo(searchObj)>0) //if new low value is greater than search object but old low was less than search object then the index must be between the two values
					{
						return low;
					}
				}
				catch(IndexOutOfBoundsException e)
				{
					return low;
				}
			}
			else if (objArray[mid].compareTo(searchObj) >0)
			{
				temp=mid;
				high=mid-1;
				try //Try catch to IndexOutOFBoundsException
				{
					if (objArray[high].compareTo(searchObj)<0) 
					{
						return temp;
					}
				}
				catch(IndexOutOfBoundsException e)
				{
					return temp;
				}
			}
			else
			{
				return mid;
			}
		}
		return 0;
	}
}