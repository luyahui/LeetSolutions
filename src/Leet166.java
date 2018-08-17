import java.util.HashMap;
import java.util.Map;

public class Leet166 {
    public String fractionToDecimal(int numerator, int denominator) {
        String result = "";
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0))
            result = "-";
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        Map<Long, Integer> map = new HashMap<>();
        result += String.valueOf(num / den);
        num %= den;
        if (num == 0)
            return result;
        result += ".";

        while (num > 0) {
            num *= 10;
            if (map.keySet().contains(num)) {
                int pos = map.get(num);
                result = result.substring(0, pos) + "(" + result.substring(pos, result.length()) + ")";
                break;
            }
            map.put(num, result.length());
            // int quotient = num / den;
            result += String.valueOf(num / den);
            num %= den;
        }
        return result;
    }
}
