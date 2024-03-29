package indi.zhy;

public class BTraverser
{
	private static boolean[] visited;
	public static StringBuffer sb = new StringBuffer("");

	public static void BFSTraverse(IGraph G) throws Exception
	{
		visited = new boolean[G.getVexNum()];
		for (int v = 0; v < G.getVexNum(); v++)

			visited[v] = false;
		for (int v = 0; v < G.getVexNum(); v++)
			if (!visited[v])
				BFS(G, v);
	}

	private static void BFS(IGraph G, int v) throws Exception
	{
		visited[v] = true;
		sb.append(G.getVex(v).toString() + " ");
		// System.out.print(G.getVex(v).toString() + " ");
		LinkQueue Q = new LinkQueue();
		Q.offer(v);
		while (!Q.isEmpty())
		{
			int u = (Integer) Q.poll();
			for (int w = G.firstAdjVex(u); w >= 0; w = G.nextAdjVex(u, w))
				if (!visited[w])
				{
					visited[w] = true;
					sb.append(G.getVex(w).toString() + " ");
					// System.out.print(G.getVex(w).toString() + " ");
					Q.offer(w);
				}
		}
	}

}
