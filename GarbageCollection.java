public class GarbageCollection {
    public int garbageCollection(String[] garbage, int[] travel) {
        int metalTime = 0;
        int metalDis = 0;
        int paperTime = 0;
        int paperDis = 0;
        int glassTime = 0;
        int glassDis = 0;

        int totalTime = 0;

        for(int i=0; i<garbage.length; i++)
        {
            String currentString = garbage[i];

            for(int j=0; j<currentString.length(); j++)
            {
                char ch = currentString.charAt(j);

                if(ch == 'M')
                {
                    metalDis = i;
                    metalTime++;
                }

                else if(ch == 'P')
                {
                    paperDis = i;
                    paperTime++;
                }

                else if(ch == 'G')
                {
                    glassDis = i;
                    glassTime++;
                }
            }
        }

        for(int i=0; i<travel.length; i++)
        {
            if(i < metalDis)
            totalTime += travel[i];

            if(i < paperDis)
            totalTime += travel[i];

            if(i < glassDis)
            totalTime += travel[i];
        }

        return totalTime + metalTime + paperTime + glassTime;
    }
}
