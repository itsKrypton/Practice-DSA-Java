public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        /* return find(flowerbed, n, 0); */
        if(n == 0) return true;

        for(int i = 0; i < flowerbed.length; i++)
        {
            if(flowerbed[i] == 0)
            {
                if((i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0))
                {
                    i += 1;
                    if (--n == 0) return true;
                }
            }
        }

        return false;
    }

    //Recursion (Slower)
    public boolean find(int[] flowerbed, int n, int index)
    {
        if(n == 0)
        return true;

        if(index >= flowerbed.length)
        return false;

        if(flowerbed[index] == 1) 
        return find(flowerbed, n, index + 1);

        if((index == 0 || flowerbed[index - 1] == 0) && (index == flowerbed.length - 1 || flowerbed[index + 1] == 0))
        return find(flowerbed, n - 1, index + 2);

        else
        return find(flowerbed, n, index + 1);
    }
}
