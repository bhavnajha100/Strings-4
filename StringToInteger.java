//TC : O(n)
//SC : O(1)
class StringToInteger {
    public int myAtoi(String s) {
        int result = 0;
        boolean sign = true;
        s = s.trim(); //O(n)
        if(s.length() == 0) return result;
        char firstChar = s.charAt(0);
        if (firstChar != '-' && firstChar != '+' && !Character.isDigit(firstChar))
            return result;
        if (firstChar == '-') {
            sign = false;
        }

        int limit = Integer.MAX_VALUE / 10; // we deal the with overflow value one digit before the overflow
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int currDigit = ch - '0';
                if (sign) {
                    if (result > limit) {
                        return Integer.MAX_VALUE;
                    } else if (result == limit) {
                        if (currDigit >= 7) {
                            return Integer.MAX_VALUE;
                        }
                    }

                } else {
                    if (result > limit) {
                        return Integer.MIN_VALUE;
                    } else if (result == limit) {
                        if (currDigit >= 8) {
                            return Integer.MIN_VALUE;
                        }
                    }
                }
                result = result * 10 + currDigit;
            } else if (i != 0) { // -1-1 -> first -1 is handled on second -1 loop will break
                break;
            }
        }
        if (sign)
            return result;
        return -result;
    }
}