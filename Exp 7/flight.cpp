
//Leetcode Question simple Push the function
class Solution {
public:
    unordered_map<int,list<pair<int,int>>> adj;

    int bfs(int src,int dst,int k,vector<int>& dist,int distance){
        queue<pair<int,int>> q;
        q.push({src,0});
        while(!q.empty() && distance <= k){
            int N = q.size();
            while(N--){
                auto top = q.front();
                q.pop();
                int nodeDistance = top.second;
                int topNode = top.first;
                for(auto nbr: adj[topNode]){
                    if(nodeDistance + nbr.second < dist[nbr.first]){
                        dist[nbr.first] = nodeDistance + nbr.second;
                        q.push(make_pair(nbr.first,nodeDistance + nbr.second));
                    }
                }
            }
            distance++;
        }
        if(dist[dst] == INT_MAX)
            return -1;
        return dist[dst];

    }
    


    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        for(auto &num: flights){
            int u = num[0];
            int v = num[1];
            int wt = num[2];
            adj[u].push_back({v,wt});
        }
        vector<int> dist(n,INT_MAX);
        int distance = 0;
        return bfs(src,dst,k,dist,distance);
    }
};
