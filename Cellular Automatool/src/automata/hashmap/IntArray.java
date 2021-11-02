package automata.hashmap;


public class IntArray {
    protected int[] arr;
    public IntArray(int[] arr) {
	this.arr = arr;
    }
    
    @Override
    public boolean equals(Object o) {
	//we assume it is an IntArray with the same arr length;
	IntArray other = (IntArray)o;
	for(int i = 0; i < arr.length; i++)
	    if(arr[i] != other.arr[i])return false;
	
	return true;
    }
}
