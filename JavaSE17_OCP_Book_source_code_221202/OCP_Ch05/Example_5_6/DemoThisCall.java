// File: DemoThisCall.java
class Light {
  // Fields:
  private int     noOfWatts;
  private boolean indicator;
  private String  location;

  // Constructors:
  Light() {                                 // (1) No-argument constructor
    this(0, false);
    System.out.println("Returning from no-argument constructor no. 1.");
  }
  Light(int watt, boolean ind) {                             // (2)
    this(watt, ind, "X");
    System.out.println("Returning from constructor no. 2.");
  }
  Light(int noOfWatts, boolean indicator, String location) { // (3)
    this.noOfWatts = noOfWatts;
    this.indicator = indicator;
    this.location  = location;
    System.out.println("Returning from constructor no. 3.");
  }
}
//______________________________________________________________________________
public class DemoThisCall {
  public static void main(String[] args) {                   // (4)
    System.out.println("Creating Light object no. 1.");
    Light light1 = new Light();                              // (5)
    System.out.println("Creating Light object no. 2.");
    Light light2 = new Light(250, true);                     // (6)
    System.out.println("Creating Light object no. 3.");
    Light light3 = new Light(250, true, "attic");            // (7)
  }
}