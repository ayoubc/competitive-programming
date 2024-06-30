class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> sets = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");
        for(int i=0;i<words.length;i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<words[i].length();j++){
                String s = sb.toString();
                if (sets.contains(s)) {
                    words[i] = s;
                    break;
                }
                sb.append(words[i].charAt(j));
            }
        }
        return String.join(" ", words);
    }
}