import java.util.function.*;

public class LambdaConsumer{
	
	int i;

	void bar( int j ){
		Consumer<Integer> consumer = k -> System.out.println( i + j+ k );
	}

}