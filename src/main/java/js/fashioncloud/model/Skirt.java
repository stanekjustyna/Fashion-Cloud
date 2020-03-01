package js.fashioncloud.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
public class Skirt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createdAt;

    @NotNull
    @Size(min=4, max=32, message="Name should be between 4 and 32 characters long.")
    private String name;

    @NotNull(message="Specify preferred size.")
    private String size;

    @NotNull(message="Specify preferred length.")
    private String length;

    @NotNull(message="Specify preferred color.")
    private String color;

    @NotNull(message="Specify preferred pattern.")
    private String pattern;

    public Skirt(String name, String size, String length, String color, String pattern) {
        this.name = name;
        this.size = size;
        this.length = length;
        this.color = color;
        this.pattern = pattern;
    }
}
