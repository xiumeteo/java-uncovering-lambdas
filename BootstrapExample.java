import java.lang.invoke.*;
import net.bytebuddy.implementation.*;
import java.lang.instrument.*;
import net.bytebuddy.dynamic.loading.*;
import net.bytebuddy.*;
import static net.bytebuddy.matcher.ElementMatchers.*;

public class BootstrapExample{

	static abstract class Example {
		abstract int method();
	}

	static class Counter {
		static int count(String name) {
			return name.length();
		}
	}


	public static class Bootstrapper {
		public static CallSite bootstrap(Object... args) throws Throwable {
			MethodType methodType = MethodType.methodType(int.class, new Class<?>[] {String.class});
			MethodHandles.Lookup lookup = (MethodHandles.Lookup)args[0];
			MethodHandle methodHandle = lookup.findStatic(Counter.class, "count", methodType);
			return new ConstantCallSite(methodHandle);

		}
	}

	public static void main( String... args ) throws Exception{

		Implementation invokeDynamic = InvokeDynamic
		.bootstrap(Bootstrapper.class.getDeclaredMethod("bootstrap", Object[].class))
		.withoutArguments()
		.withValue("foo");


		Example example = new ByteBuddy()
		.subclass(Example.class)
		.method(named("method")).intercept(invokeDynamic)
		.make()
		.load(Example.class.getClassLoader(),
			ClassLoadingStrategy.Default.INJECTION)
		.getLoaded()
		.newInstance();

		int result = example.method();

		System.out.println(result);

	}
}
