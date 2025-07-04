package lib;

public class PasswordValidator {

    /**
     * คุณจะต้องเขียน Javadoc ที่สมบูรณ์ที่นี่ในอนาคต
     * เพื่ออธิบายกฎการทำงานของเมธอด
     * case 1 password สั่นไป จะไม่สามารถตึั้งค่ารหัสผ่านได้ =  INVALID
     * case 2 รหัสผ่านเป็นตัวเล็ก/ตัวใหญ่/ตัวเลขทั้งหมด = WEAK
     * case 3 มีตัวเล็กตัวใหญ่ตัวเลขผสมกัน = MEDIUM
     * case 4 มีตัวเล็กตัวใหญ่ตัวเลขและอักขระพืเศษผสมกัน = STRONG
     * โดยทุก case ต้องมีตัวอักษรมากกว่า 8 ตัวอักษร ห้ามเว้นวรรค ห้ามเป็นค่าว่าง
     */
    // TODO: แก้ไข return type ของเมธอดนี้ให้ถูกต้อง
    public static PasswordStrength validate(String password) { // Function Type ให้เป็น PasswordStrength 
        
        if(password == null || password.length() <8)
            return PasswordStrength.INVALID;

            boolean hasLower = false;
            boolean hasUpper = false;
            boolean hasNUmber = false;
            boolean hasSpcial = false;

        int count = 0;
        for(char c : password.toCharArray()){
            if(Character.isLowerCase(c))
                hasLower = true;
            else if(Character.isUpperCase(c))
                hasUpper = true; 
            else if(Character.isDigit(c))
                hasNUmber = true;
            else 
                hasSpcial = true; 
                   
        }
        if(hasLower && !hasUpper && !hasNUmber)
            return PasswordStrength.WEAK;
        if(hasUpper && !hasLower && !hasNUmber)
            return PasswordStrength.WEAK;
        if(hasNUmber && !hasUpper && !hasLower)
            return PasswordStrength.WEAK;
        if(hasLower && hasUpper && hasNUmber && !hasSpcial)
            return PasswordStrength.MEDIUM;
        if(hasLower && hasUpper && hasNUmber && hasSpcial)
            return PasswordStrength.STRONG;
        
        //nt minLength = 8 ; // TODO: มีอะไรขาดหายไปที่บรรทัดนี้?
        
        return PasswordStrength.INVALID ; // TODO: การคืนค่านี้ถูกต้องหรือไม่?
    }
}