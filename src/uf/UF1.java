package uf;

public class UF1 implements IUF {

    private int []id; //分量id
    private int count;//分量数量

    public UF1(int N){
        //初始化分量id数组
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public int find(int p) {
        //quick find
        return id[p];
    }

    @Override
    public void union(int p, int q) {
        //将p q 归结到相同的分量中
        int pid = id[p];
        int qid = id[q];
        if (pid == qid){
            return;
        }
        // 重置为q 的id
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid){
                id[i] = qid;
            }
        }
        count --;
    }
}
