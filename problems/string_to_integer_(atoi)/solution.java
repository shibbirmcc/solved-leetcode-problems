class Solution {
	private String lowerLimit = "2147483648";
	private int lowest = -2147483648;
	private String upperLimit = "2147483647";
	private int highest = 2147483647;
	private int lengthLimit = 10;
	
    public int myAtoi(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        }
    	String number = s.stripLeading();
        if(number.isEmpty()){
            return 0;
        }
    	boolean isNegative = false;
    	char firstChar = number.charAt(0);
    	int i = 0;
    	if(firstChar == '+' || firstChar == '-') {
    		isNegative = firstChar == '-';
    		i = 1;
    	}
    	
    	String finalNumber = "";
    	int result = 0;
    	int length = 0;
		for (; i < number.length(); i++) {
			char c = number.charAt(i);
			if (c >= '0' && c <= '9') {
				if (result == 0) {
					finalNumber = String.valueOf(c);
					length = 1;
				} else {
					finalNumber += c;
					length++;
				}

				if (result > 0 && length > 10 && !isNegative) {
					result = highest;
					break;
				} else if (result > 0 && length > 10 && isNegative) {
					result = lowest;
					break;
				} else if(result > 0 && length == 10) {
					String numberCheck = populateCompleteNumber(finalNumber);
					if (!isNegative && numberCheck.compareTo(upperLimit) > 0) {
						result = highest;
						break;
					} else if (isNegative && numberCheck.compareTo(lowerLimit) > 0) {
						result = lowest;
						break;
					} else {
						result = (result * 10) + ((int) (c - '0'));
					}
				} else if(result > 0) {
					result = (result * 10) + ((int) (c - '0'));
				}else {
					result = (int) (c - '0');
				}
			} else {
				break;
			}
		}
    	
    	if(isNegative && result > 0) {
    		result *= -1;
    	}
        return result;
    }
    
    
    private String populateCompleteNumber(String s) {
    	int length = s.length();
    	while(length < lengthLimit) {
    		s = "0"+s;
    		length++;
    	}
    	return s;
    }
}