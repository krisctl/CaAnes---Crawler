package webcrawl;

public class StackData {

	int beginIndex;
	int arraySize;
	
	/**
	 * @param beg
	 * @param size
	 * Class Constructor
	 */
	public StackData(int beg, int size){
		beginIndex= beg;
		arraySize = size;
	}
	/**
	 * @return the beginIndex
	 */
	public int getBeginIndex() {
		return beginIndex;
	}
	/**
	 * @param beginIndex the beginIndex to set
	 */
	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}
	/**
	 * @return the arraySize
	 */
	public int getArraySize() {
		return arraySize;
	}
	/**
	 * @param arraySize the arraySize to set
	 */
	public void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}
}
