package Model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Customer {
    private int id;
    private String row;
    private int col;
    private Showtime showtime;

    public Customer(int id, String row, int col, Showtime showtime) {
        this.id = id;
        this.row = row;
        this.col = col;
        this.showtime = showtime;
    }
}
