package EstructuraDeDades;

public class AdjVertex<E> {
    private String name;
    public AdjVertex<E> next_row, next_col;
    private E tag_row, tag_col;

    public AdjVertex(String name, E tag_row, E tag_col) {
        this.name = name;
        this.tag_row = tag_row;
        this.tag_col = tag_col;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public E getTag_row() {
        return tag_row;
    }

    public void setTag_row(E tag_row) {
        this.tag_row = tag_row;
    }

    public E getTag_col() {
        return tag_col;
    }

    public void setTag_col(E tag_col) {
        this.tag_col = tag_col;
    }
}