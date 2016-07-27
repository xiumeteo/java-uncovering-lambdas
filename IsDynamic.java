public class IsDynamic { 
	public static void main( String... args ){

		java.util.List<String> list = new java.util.ArrayList<>();

		for( int i = 0 ; i< 5; i++ ){
			String enumerated = args[0] + i;
			list.add( enumerated );
		}

		System.out.println( list );

	}

}