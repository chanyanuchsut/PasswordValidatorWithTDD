package lib;

public class PasswordValidatorTest{
    
    public static void run() {
        System.out.println("--- Running Password Validator Tests ---");
        
        // Test Case 1: รหัสผ่านสั้นควรจะ INVALID
        String pw = "123";
        PasswordStrength result1 = PasswordValidator.validate(pw);
        if (result1 == PasswordStrength.INVALID) {
            System.out.println("Test Case 1 : "+pw+" Passed: Short password is INVALID");
        } else {
            System.out.println("Test Case 1 : "+pw+" FAILED: Expected INVALID but got " + result1);
        }

        //case2: รหัสผ่านตั้งหมดเป็นตัวเล็กจะ WEAK
        pw = "abcdefghij" ;
        PasswordStrength result2 = PasswordValidator.validate(pw);
        if (result2 == PasswordStrength.WEAK) {
            System.out.println("Test Case 2 :" +pw+" : Passed: All lowercase password is WEAK."); //if = ค่าที่คาดหวัง
        } else {
            System.out.println("Test Case 2 :" +pw+" : FAILED: Expected INVALID but got " + result2);
        }
        //case2: รหัสผ่านตั้งหมดเป็นตัวใหญ่จะ WEAK
        pw = "ABCDEFGHIJ" ;
        if (result2 == PasswordStrength.WEAK) {
            System.out.println("Test Case 3 :" +pw+" : Passed: All uppercase password is WEAK."); //big
        } else {
            System.out.println("Test Case 3 :" +pw+" : FAILED: Expected INVALID but got " + result2);
        }
        //case2: รหัสผ่านตั้งหมดเป็นตัวเลขจะ WEAK
        pw = "123456789" ;
        if (result2 == PasswordStrength.WEAK) {
            System.out.println("Test Case 4 :" +pw+" : Passed: All number password is WEAK."); //num
        } else {
            System.out.println("Test Case 4 :" +pw+" : FAILED: Expected INVALID but got " + result2);
        }
        //case3: มีตัวเล็กตัวใหญ่ตะวเลขผสมกัน MEDIUM
        pw = "Dif95HUIhuip" ;
        PasswordStrength result3 = PasswordValidator.validate(pw);
        if (result2 == PasswordStrength.MEDIUM) {
            System.out.println("Test Case 5 :" +pw+" : Passed: All lowercase password is MEDIUM.");
        } else {
            System.out.println("Test Case 5 :" +pw+" : FAILED: Expected INVALID but got " + result3);
        }
        //case4: มีตัวเล็กตัวใหญ่ตัวเลขและอักขระพืเศษผสมกัน STRONG
        pw = "RTkr86l9_98%!?" ;
        PasswordStrength result4 = PasswordValidator.validate(pw);
        if (result2 == PasswordStrength.STRONG) {
            System.out.println("Test Case 6 :" +pw+" : Passed: All lowercase password is STRONG.");
        } else {
            System.out.println("Test Case 6 :" +pw+" : FAILED: Expected INVALID but got " + result4);
        }

        System.out.println("--------------------------------");
    }
}
