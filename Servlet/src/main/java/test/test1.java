package test;

public class test1 {

	public static void main(String[] args){
		test("3","d");

	}

	public static void test(String a,String b) throws NumberFormatException {

		int sum= Integer.parseInt(a)+Integer.parseInt(b);
		System.out.println(sum);
		System.out.println("tt");
		

	}
}
