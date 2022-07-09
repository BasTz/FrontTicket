package Model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Movie {
    public int id;
    public String name;

    public Movie(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
