import java.util.ArrayList;

public class StepsByKnight
{
    public static void main(String args[])
    {
        int a[] = new int[]{4, 5};
        int b[] = new int[]{1, 1};
        System.out.println(minStepToReachTarget(a, b, 8));
    }

    public static int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        Pair source = new Pair((KnightPos[0]-1), (KnightPos[1]-1));
        Pair destination = new Pair((TargetPos[0]-1), (TargetPos[1]-1));
        return bfs(source, destination, N);
    }
    
    public static boolean isInside(int x, int y, int N)
    {
        if(x>=0 && x<N && y>=0 && y<N)
        return true;

        return false;
    }
    
    public static int bfs(Pair source, Pair destination, int N)
    {
        int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};
        
        ArrayList<Pair> q = new ArrayList<>(); //queue for storing the states
        q.add(source);

        Pair t;
        int x,y;
        boolean visit[][] = new boolean[N][N];

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            visit[i][j] = false;
        }

        visit[source.first][source.second] = true;

        while(!q.isEmpty())
        {
            t = q.get(0);
            q.remove(0);

            if(t.first == destination.first && t.second == destination.second)
            return t.dis;

            for(int i=0;i<8;i++)
            {
                x = t.first + dx[i];
                y = t.second + dy[i];

                if(isInside(x, y, N) && !visit[x][y])
                {
                    visit[x][y] = true;
                    q.add(new Pair(x, y, t.dis + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}

class Pair 
{
	int first;
	int second;
    int dis;

	public Pair(int first, int second) 
    {
		this.first = first;
		this.second = second;
        this.dis = 0;
	}

    public Pair(int first, int second, int dis) 
    {
		this.first = first;
		this.second = second;
        this.dis = dis;
	}
}