public class Invoke{
	
	public interface Test{
		boolean test(int element);
	}

	public static class Tester implements Test{
		@Override
		public boolean test(int element){
			return element != 0;
		}

		public boolean test( int element, int test ){
			return element != test;
		}

		public static boolean testEquality( int element, int test ){
			return element == test;
		}
	}

	public static void main( String... args ){

		Test tester = new Tester();
		tester.test( 5 );

		Tester classReference = new Tester();
		classReference.test( 3 );
		classReference.test( 0, 5 );

		Tester.testEquality( 0, 5 );
	}
	

}