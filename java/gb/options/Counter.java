package gb.options;

public class Counter implements AutoCloseable{
    private  int count;

    public Counter() {
        count = 0;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() throws Exception {

    }

    public void add() {
        count++;
    }
}
