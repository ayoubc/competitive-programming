def evenForest(t_nodes, t_edges, t_from, t_to):
    tree = [[] for _ in range(t_nodes+1)]
    for i in range(t_edges):
        u, v = t_from[i], t_to[i]
        tree[u].append(v)
        tree[v].append(u)
        
    deleted = set()
    global cnt
    cnt = 0
    vis = set()
    def dfs(s):
        vis.add(s)
        global cnt
        cnt += 1
        for e in tree[s]:
            if e not in vis and not ((s, e) in deleted or (e, s) in deleted):
                dfs(e)
    
    for i in range(t_edges):
        vis = set()
        ok = True
        u, v = t_from[i], t_to[i]
        deleted.add((u, v))
        for j in range(1, t_nodes+1):
            if j not in vis:
                cnt = 0
                dfs(j)
                if cnt % 2 != 0:
                    ok = False
                    break
        if not ok:
            deleted.remove((u, v))
    
    return len(deleted)