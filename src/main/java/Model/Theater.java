package Model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Theater {
    private int id;
    private String name;

    public Theater(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
