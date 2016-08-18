import java.lang.invoke.*;

public class MetaFactoryTest {

  @FunctionalInterface
  public interface Test {
    String getString();
  }

  public static void main(String[] args) throws Throwable {

    MethodHandles.Lookup caller = MethodHandles.lookup();
    MethodType methodType = MethodType.methodType(String.class);
    MethodType invokedType = MethodType.methodType(Test.class);
    CallSite site = LambdaMetafactory.metafactory(caller,
      "getString",
      invokedType,
      methodType,
      caller.findStatic(MetaFactoryTest.class, "print", methodType),
      methodType);
    MethodHandle factory = site.getTarget();


    Test r = (Test) factory.invoke();
    System.out.println(r.getString());
  }

  private static String print() {
    return "hello world";
  }
}
