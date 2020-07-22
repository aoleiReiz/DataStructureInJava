package uf;

public interface IUF {
    boolean connected(int p, int q);
    void union(int p, int q);
    int find(int p);
    int count();
}
