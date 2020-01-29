package SelenCodes;

public class Region {
    int x;

    // Constructor with a parameter
    public Region() {
        this.x = 5;
        //this.x = x;
    }

    // Call the constructor
    public static void main(String[] args) {
        Region myObj = new Region();
        System.out.println("Value of x = " + myObj.x);
    }
} 
