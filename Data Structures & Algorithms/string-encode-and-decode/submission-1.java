class Solution {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        
          StringBuilder sb = new StringBuilder();
          for(String str : strs){
            sb.append(str.length()).append('|').append(str);
          }  

          return sb.toString();
          // strs = ["Hello","World"] =>5|Hello5|World

    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decodedString = new ArrayList<>();
        int i = 0;
        while(i< s.length()){

            int delimitIndex = s.indexOf('|',i); // IMPORTANT  index of | from i

            int size = Integer.parseInt(s.substring(i, delimitIndex));

            decodedString.add(s.substring(delimitIndex+1, delimitIndex+1+size));

            i = delimitIndex+1+size;

        }
        return decodedString;
    }
}
