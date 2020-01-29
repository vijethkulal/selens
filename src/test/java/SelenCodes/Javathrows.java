package SelenCodes;

public class Javathrows {

    static void checkEligibilty(int stuage, int stuweight) {
        if (stuage < 12 && stuweight < 40) {
            throw new ArithmeticException("Student is not eligible for registration");
        } else {
            System.out.println("Student Entry is Valid!!");
        }
    }

    public static void main(String args[]) throws ArithmeticException {
        System.out.println("Welcome to the Registration process!!");

        String str = new String("Vijeth");

        StringBuffer str1 = new StringBuffer(str);
        str1.append(" Kulal");
        System.out.println(str1);
        String s3 = str1.toString();
        char[] a = s3.toCharArray();


        String s1 = new String("ABC");
        String s2 = "ABC";

        if (s1 == s2) {
            System.out.println("address matched");
        } else {
            System.out.println("address not matched");
        }

        if (s1.equals(s2)) {
            System.out.println("content matched");
        } else {
            System.out.println("content not matched");
        }


        for (int i = 0; i < a.length; i++) {
            if (a[i] == 'i') {
                a[i] = 'e';
            } else if (a[i] == 'e') {
                a[i] = 'i';
            }

            System.out.println(a.toString());
        }

        try {
            checkEligibilty(10, 39);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            checkEligibilty(13, 45);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Have a nice day..");
    }
}