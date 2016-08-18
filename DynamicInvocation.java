import java.util.*;
import java.util.function.*;

public class DynamicInvocation {
	public static void main( String... args ){

		Function< Double, Double > square =  new Function< Double, Double >(){
			@Override
			public Double apply( Double base ){
				return base*base;
			}
		};


		Function<Double, Double> squareLambda = ( base ) -> { return base*base; };

		System.out.println( square.apply( 5.0 ) );
		System.out.println( squareLambda.apply( 5.0 ) );

	}
}
