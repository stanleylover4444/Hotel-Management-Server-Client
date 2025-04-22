package regex;

public class RegexHelper {
    public static boolean regexCustomerName(String name) {
        String firstLetter="[A-EGHIK-VXYÃ‚Ä�á»”Ã”Ãšá»¨]";
      	String otherLetters="[a-eghik-vxyÃ Ã¡Ã¢Ã£Ã¨Ã©ÃªÃ¬Ã­Ã²Ã³Ã´ÃµÃ¹ÃºÃ½á»³á»¹á»·á»µá»±á»­á»¯á»«á»©Æ°á»¥á»§Å©á»£á»Ÿá»¡á»�á»›Æ¡á»™á»•á»—á»“á»‘á»�á»�á»‹á»‰Ä©á»‡á»ƒá»…á»�áº¿áº¹áº»áº½áº·áº³áºµáº±áº¯Äƒáº­áº©áº«áº§áº¥áº¡áº£Ä‘â‚«]";
      	String regexString="^"
                 +firstLetter+otherLetters+"+\\s"
                 +"("+firstLetter+otherLetters+"+\\s)*"
                 +firstLetter+otherLetters+"+$";
        
        return name.matches(regexString);
    }
    public static boolean regexDeviceName(String name) {
        String firstLetter="[A-ZÃ‚Ä‚Ä�Ã”á»”Ã”Ãšá»¨]";
        String firstLetter1="[a-zÃ¢Ä‘á»•Ã´Ãºá»©]";
      	String otherLetters="[a-zÃ Ã¡Ã¢Ã£Ã¨Ã©ÃªÃ¬Ã­Ã²Ã³Ã´ÃµÃ¹ÃºÃ½á»³á»¹á»·á»µá»±á»­á»¯á»«á»©Æ°á»¥á»§Å©á»£á»Ÿá»¡á»�á»›Æ¡á»™á»•á»—á»“á»‘á»�á»�á»‹á»‰Ä©á»‡á»ƒá»…á»�áº¿áº¹áº»áº½áº·áº³áºµáº±áº¯Äƒáº­áº©áº«áº§áº¥áº¡áº£Ä‘â‚«]";
      	String regexString="^("
                 +firstLetter+otherLetters+"+)(\\s"
                +"("+firstLetter1+otherLetters+"+))*";        
        return name.matches(regexString);
    }
    
    public static boolean regexPhoneNumber(String number) {
        String regex = "^((09(\\d){8})|(08(\\d){8})|(03(\\d){8})|(07(\\d){8})|(05(\\d){8}))$";
        return number.matches(regex);
    }
    
    public static boolean regexCMND(String number) {
        String regex = "[0-9]{9}";
        return number.matches(regex);
    }
    
    public static boolean regexEmail(String email) {
        String regex = "\\w+.@\\w+.\\w{2,5}";
        return email.matches(regex);
    }
    public static boolean regexPriceService(String price)
    {
        String regex = "^[0-9]+";
        return  price.matches(regex);
    }
    public static boolean regexTangPhong(String tang)
    {
        String regex = "^[0-9]+";
        return  tang.matches(regex);
    }
    public static boolean regexNameRoom(String name)
    {
        String regex = "^[VT][0-9]{3}$";
        return  name.matches(regex);
    }
    public static boolean regexSoLuongTon(String so)
    {
        String regex = "([1-9][0-9]*)|(100)";
        return  so.matches(regex);
    }
    public static boolean regexGia(String so)
    {
        String regex = "([1-9][0-9]{3,7})(.0)?";
        return  so.matches(regex);
    }
    public static boolean regexLuong(String luong)
    {
        String regex = "^[0-9]+";
        return  luong.matches(luong);
    }
}