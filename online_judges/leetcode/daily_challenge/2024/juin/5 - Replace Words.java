class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> sets = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");
        for(int i=0;i<words.length;i++) {
            String s = "";
            for(int j=0;j<words[i].length();j++){
                if (sets.contains(s)) {
                    words[i] = s;
                    break;
                }
                s += words[i].charAt(j);
            }
        }
        return String.join(" ", words);
    }
}