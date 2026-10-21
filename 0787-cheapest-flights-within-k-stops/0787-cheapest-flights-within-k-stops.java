class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] f : flights) {
            adj.get(f[0]).add(new int[] {f[1], f[2]});
        }
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{src,0,0});
        List<Integer> ls=new ArrayList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        while(!q.isEmpty()){
            int arr[]=q.poll();
            int node=arr[0];
            int stops=arr[1];
            if(stops > k) continue;
            int cost=arr[2];
            for(int[] next:adj.get(node)){
                int v = next[0], price = next[1];
                if(cost+price < dist[v]){
                    dist[v]=cost + price;
                    q.offer(new int[]{v, stops+1,cost+price});
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}