//TC : O(NlogN)
//SC : O(1)
class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (String a, String b) -> {
            String[] strArr1 = a.split(" ", 2);
            String[] strArr2 = b.split(" ", 2);
            boolean isDigit1 = Character.isDigit(strArr1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(strArr2[1].charAt(0));
            if(!isDigit1 && !isDigit2){
                // both better logs
                int comp = strArr1[1].compareTo(strArr2[1]); // comapre contents of letter log lexicographically
                if(comp == 0) {
                    // if contents are same then comapre the identifier of letter log lexicographically
                    return strArr1[0].compareTo(strArr2[0]);
                }
                return comp;
            } else if(isDigit1 && !isDigit2){
                return 1;
            } else  if(!isDigit1 && isDigit2){
                return -1;
            } else {
                return 0;
            }
        });
        return logs;
    }
}