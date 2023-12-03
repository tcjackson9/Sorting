import java.util.*;

public class SortMergeTest {
    private static Random gen;

    public static void main(String[] args) {
	gen = new Random(System.currentTimeMillis());
	
	double score = 0.0;
	int testNum = 1;
	double ptsPoss = 1.25;
	
	//Test 1
	score += test(testNum++, new int[]{75}, ptsPoss);
	//Test 2
	score += test(testNum++, new int[]{85, 15}, ptsPoss);
	//Test 3
	score += test(testNum++, new int[]{14, 30, 28}, ptsPoss);
	//Test 4
	score += test(testNum++, new int[]{10, 24, 1, 17}, ptsPoss);
	//Test 5
	int[] subArr = new int[15];
	for(int i = 0; i < subArr.length; i++)
	    subArr[i] = 1;
	score += test(testNum++, subArr, ptsPoss);
	//Test 6
	score += test(testNum++, new int[]{101, 8, 19, 255, 302}, ptsPoss);
	//Test 7
	subArr = new int[600];
	for(int i = 0; i < subArr.length; i++)
	    subArr[i] = 1;
	    score += test(testNum++, subArr, ptsPoss);
	//Test 8
	subArr = new int[30];
	for(int i = 0; i < subArr.length; i++)
	    subArr[i] = gen.nextInt(100) + 1;
	    score += test(testNum++, subArr, ptsPoss);
	
	System.out.println("Total score for SortMerge: " + score);
    }

    private static double test(int num, int[] subArrays, double pts) {
	System.out.println("Begin test " + num + "...");
	int[] array = getArray(subArrays);
	int[] copy = getCopy(array);
	SortMerge.sort(array);
	Arrays.sort(copy);
	boolean passed = checkArrays(array, copy);
	printMsg(num, passed, pts, array, copy);
	if(passed)
	    return pts;
	return 0.0;
    }

    private static void printMsg(int test, boolean passed, double points, 
				 int[] array, int[] copy) {
	if(passed) 
	    System.out.println("Test " + test + " passed! (+" + points + " pts)");
	else {
	    System.out.println("Test " + test + " failed.");
	    System.out.println("Expected: " + Arrays.toString(copy));
	    System.out.println("Actual: " + Arrays.toString(array));
	}
    }

    private static int[] getArray(int[] subArrays) {
	int size = 0;
	for(int i : subArrays)
	    size += i;
	int[] ret = new int[size];
	ret[0] = gen.nextInt(100);
	int j = 0;
	int k = 1;
	int i = 1;
	while(i < ret.length) {
	    while(k < subArrays[j]) {
		ret[i] = ret[i-1] + gen.nextInt(20);
		k++;
		i++;
	    }
	    j++;
	    k = 0;
	    if(i < ret.length) {
		ret[i] = ret[i-1] - (gen.nextInt(20) + 1);
		k++;
		i++;
	    }
	}
	return ret;
    }

    private static int[] getCopy(int[] array) {
	int[] copy = new int[array.length];
	for(int i = 0; i < array.length; i++) {
	    copy[i] = array[i];
	}
	return copy;
    }

    private static boolean checkArrays(int[] array1, int[] array2) {
	if(array1.length != array2.length)
	    return false;
	for(int i = 0; i < array1.length; i++) {
	    if(array1[i] != array2[i])
		return false;
	}
	return true;
    }
}
