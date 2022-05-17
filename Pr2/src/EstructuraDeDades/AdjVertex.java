package EstructuraDeDades;

public class AdjVertex<E> {
    private int code_row, code_col;
    public AdjVertex<E> next_row, next_col;
    private E tag;

    public AdjVertex(int code_row, int code_col) {
        this.code_row = code_row;
        this.code_col = code_col;
        this.next_row = null;
        this.next_col = null;
    }

    public int getCode_row() {
        return code_row;
    }

    public void setCode_row(int code_row) {
        this.code_row = code_row;
    }

    public int getCode_col() {
        return code_col;
    }

    public void setCode_col(int code_col) {
        this.code_col = code_col;
    }

    public E getTag() {
        return tag;
    }

    public void setTag(E tag) {
        this.tag = tag;
    }
}