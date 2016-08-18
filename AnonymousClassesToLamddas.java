public class AnonymousClassesToLamddas{

  public static void main( String... args ){

    Thread t = new Thread(new Runnable(){
      public void run(){
        System.out.println( "i'm runnable from an anon class" );
      }
    });

    t.start();

    t = new Thread(() -> {System.out.println("Im a lambda"); });
    t.start();

    t = new Thread( AnonymousClassesToLamddas::methodReference );
    t.start();

    //what happens if we have the same methodReference as an instance method?

  }

  public static void methodReference(){
    System.out.println("this is a method reference");
  }

}
