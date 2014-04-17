package webcrawl;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestSort {

	/**
	 * Test case to check the stooge sort
	 */
	@Test
	public final void testSort() {
		List<String> data = new ArrayList<String>();
		List<String> data1 = new ArrayList<String>();
		data.add("krishan");
		data.add("SAvitha");
		data.add("summa");
		data.add("Sanchit");
		data.add("krish");
		Stooge st = new Stooge();
		data1.add("krish");
		data1.add("krishan");
		data1.add("Sanchit");
		data1.add("SAvitha");
		data1.add("summa");
		
		assertEquals(data1,st.stoogeSort(data));
	}
	
	/**
	 * @throws IOException
	 * Test case to check if the file is created or not
	 */
	@Test
	public final void testFile() throws IOException{
		File file = new File("sortedfile.txt");
		assertTrue(file.exists());
	}

	/**
	 * Test case to check removal of punctuations, digits and using space as delimiter
	 */
	@Test
	public final void testCleanAndSplitString(){
		String input = "krishan 1234 . adf .123";
		List<String> data1 = new ArrayList<String>();
		data1.add("krishan");
		data1.add("adf");
		MyCrawler mc = new MyCrawler();
		assertEquals(data1, mc.cleanAndSplitString(input));
	}
}
