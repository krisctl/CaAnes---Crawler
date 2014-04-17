package webcrawl;

//import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Stooge {

	/*public static void main(String args[]){
		List<String> data = new ArrayList<String>();
		data.add("krishan");
		data.add("SAvitha");
		data.add("summa");
		data.add("Sanchit");
		data.add("krish");
		data = stoogeSort(data);
		for(int i=0; i< data.size(); i++)
			System.out.print(data.get(i) +" ");
	}*/

	
	/**
	 * @param data - Unsorted List of strings
	 * @return- Sorted list of strings
	 * This function takes an unsorted list as input and performs stooge sort (iterative)
	 * and returns a sorted list. 
	 */
	public List<String> stoogeSort(List<String> data) {
		// TODO Auto-generated method stub
		Stack<StackData> stack = new Stack<StackData>();
		
		StackData sd = new StackData(0,data.size());
		
		stack.push(sd);
		while(!stack.isEmpty()){
			/*System.out.println("BEgin index before popping: " + stack.peek().getBeginIndex());
			System.out.println("Array size before popping: " + stack.peek().getArraySize());*/
			sd= stack.pop();
			int i = sd.getBeginIndex();
			int j = sd.getArraySize();
			
			//System.out.println("Inside while");
			
			if(data.get(j-1).compareToIgnoreCase(data.get(i)) < 0){
				String tmp = data.get(i);
	            data.set(i, data.get(j-1));
	            data.set(j-1, tmp);
			}
			if(j-i>=3){
				
				int t = (j-i)/3;
				
				/*System.out.println("Begin index: "+i);
				System.out.println("Array Size: "+ (j-t));
				sd.setBeginIndex(i);sd.setArraySize(j-t);*/
				
				stack.push(new StackData(i,(j-t)));
				/*System.out.println("Begin index: "+(i+t));
				System.out.println("Array Size: "+ j);
				sd.setBeginIndex(i+t);sd.setArraySize(j);*/
				
				stack.push(new StackData((i+t),j));
				/*stack.push(sd);
				System.out.println("Begin index: "+i);
				System.out.println("Array Size: "+ (j-t));
				sd.setBeginIndex(i);sd.setArraySize(j-t);*/
				
				stack.push(new StackData(i,(j-t)));
				/*sd.setBeginIndex(i);sd.setArraySize(j-t);
				stack.push(sd);*/
			}
		}
		return data;
	}
}
