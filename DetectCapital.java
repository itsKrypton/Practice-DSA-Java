public class DetectCapital {
    public static boolean detectCapitalUse(String word) {
        if(word.length() == 1) return true;
        boolean isFirstLetterCap = Character.isUpperCase(word.charAt(0));
        boolean allLettersSmall = false, allLettersCap = false;

        for(int i = 1; i < word.length(); i++)
        {
            if(isFirstLetterCap)
            {
                if(allLettersSmall)
                {
                    if(Character.isUpperCase(word.charAt(i))) return false;
                }

                else if(allLettersCap)
                {
                    if(Character.isLowerCase(word.charAt(i))) return false;
                }

                else
                {
                    if(Character.isUpperCase(word.charAt(i))) allLettersCap = true;
                    else allLettersSmall = true;
                }
            }

            else
            if(Character.isUpperCase(word.charAt(i))) return false;
        }

        return true;
    }
}
