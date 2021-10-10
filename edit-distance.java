public int minDistance(String word1, String word2) {
    char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
    int[][] memo = new int[w1.length+1][w2.length+1];
    return minDistanceHelper(w1, w2, 0, 0, memo);
}

public int minDistanceHelper(char[] w1, char[] w2, int w1Index, int w2Index, int[][] memo) {
    if(w1Index == w1.length) return w2.length - w2Index;
    if(w2Index == w2.length) return w1.length - w1Index;

    if(memo[w1Index][w2Index] != 0) return memo[w1Index][w2Index];

    if(w1[w1Index] == w2[w2Index]) {
        memo[w1Index][w2Index] = minDistanceHelper(w1, w2, w1Index+1, w2Index+1, memo);
    } else {
        int opt1 = minDistanceHelper(w1, w2, w1Index+1, w2Index, memo);
        int opt2 = minDistanceHelper(w1, w2, w1Index, w2Index+1, memo);
        int opt3 = minDistanceHelper(w1, w2, w1Index+1, w2Index+1, memo);
        memo[w1Index][w2Index] = Math.min(opt1, Math.min(opt2, opt3)) + 1;
    }
    return memo[w1Index][w2Index];
}
