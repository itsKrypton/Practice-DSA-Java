public class NumberOfChangesForString {
    public static void main(String args[])
    {
        System.out.println(editDistance("gfg", "gfg"));
    }

    public static int editDistance(String s, String t) {
        int answer = 0;
        int lettersOfS[] = new int[26];
        int lettersOfT[] = new int[26];

        for(int i=0; i<s.length(); i++)
        lettersOfS[s.charAt(i) - 'a']++;

        /* System.out.println(Arrays.toString(lettersOfS)); */

        for(int i=0; i<t.length(); i++)
        lettersOfT[t.charAt(i) - 'a']++;

        /* System.out.println(Arrays.toString(lettersOfT));
        System.out.println(Arrays.toString(lettersOfS)); */

        for(int i=0; i<lettersOfS.length; i++)
        {
            lettersOfS[i] = Math.abs(lettersOfS[i] - lettersOfT[i]);
            answer += lettersOfS[i];
        }

        return answer;
    }
}
