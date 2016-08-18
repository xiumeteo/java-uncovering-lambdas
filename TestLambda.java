import java.util.function.*;
import java.util.*;
import java.util.stream.*;

public class TestLambda{

  public static void main( String... args ){
    // //Function<Integer, String> aFunction = e -> e.toString();
    // Function<Integer, Function<Integer, Integer>> composedFunction =
    //   e -> (x) -> e*2*x;
    //
    // Function<Integer, Integer> doubleIt =
    //   number -> number*2;
    //
    // Function<Integer, Integer> tripleIt =
    //   number -> number*3;
    //
    // Function<Integer, Integer> composedFunction2 =
    //   e -> doubleIt.apply(tripleIt.apply(e));
    //
    // System.out.println(composedFunction2.apply(2));
    //
    List<Integer> elements = Arrays.asList(1,2,3,4,5,6,7,8,9);
    //
    // System.out.println(elements.stream()
    //         .filter( e -> e%2 == 0 )
    //         .map( e -> e*3 )
    //         .collect( Collectors.toList() ));

    TestLambda t = new TestLambda();
    elements.forEach( e -> t.printPlusOne( e ) );

  }

  public void printPlusOne( Integer o ){ System.out.println( o + 1 );  }

  public static void print( Object o ){  System.out.println( o ); }

}
