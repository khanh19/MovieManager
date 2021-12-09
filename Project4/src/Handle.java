public class Handle {
    private int position;
    private int len;

    public Handle(int len, int position) {
        this.len = len;
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getLen() {
        return this.len;
    }

    public void setLen(int len) {
        this.len = len;
    }
}
