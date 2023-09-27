public class DecodedStringAtIndex {
    /*
     * Find the length of the decoded string and then traverse the encoded string in reverse, that way we don't have to worry about storing the decoded string. Every
     * time we come across a digit, we divide the current length by that digit and take the modulo of k by that length. Else, if it's a character and our k matches
     * the length or if it's zero then we have found our character, else just decrement the length by one.
     */
    public String decodeAtIndex(String s, int k) {
        long length = 0;

        // Calculate the length of the decoded string
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if(Character.isDigit(ch))
                length *= (ch - '0');
            
            else
                length++;
        }

        // Traverse in reverse direction and keep decrementing the length and the update the value of k
        for(int i = s.length() - 1; i >= 0; i--)
        {
            char ch = s.charAt(i);

            if(Character.isDigit(ch))
            {
                length /= (ch - '0');
                k %= length;
            }

            else
            {
                if(k == 0 || k == length)
                    return ch + "";

                length--;
            }
        }

        return "";
    }
}
