package sample;

public class WNode<N> {
    public WNode<N> next = null, previous = null;

    private N contents;

    public N getContents() {
        return contents;
    }

    public void setContents(N contents) {
        this.contents = contents;
    }
}
