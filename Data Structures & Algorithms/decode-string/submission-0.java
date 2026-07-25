class Solution {
    public String decodeString(String s) {
        //Input: s = "2[a3[b]]c"
        Stack<Integer> st = new Stack();
        Stack<StringBuilder> st1 = new Stack();
        StringBuilder str = new StringBuilder();
        int n = 0;

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch))
                n = n * 10 + (ch - '0');
            else if(ch == '['){
                st.push(n);
                n = 0;
                st1.push(str);
                str = new StringBuilder();
            }else if (ch == ']'){
                int k = st.pop();
                StringBuilder temp = str;
                str = st1.pop();
                while(k-- > 0)
                    str.append(temp);
            }else
                str.append(ch);
        }
        return str.toString();
    
    }
}