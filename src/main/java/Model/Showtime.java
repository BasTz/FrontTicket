package Model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class Showtime {
    private int id;
    private Theater theater;
    private Movie movie;
    private Date datetime;

    public Showtime(int id, Theater theater, Movie movie, Date datetime) {
        this.id = id;
        this.theater = theater;
        this.movie = movie;
        this.datetime = datetime;
    }
}
