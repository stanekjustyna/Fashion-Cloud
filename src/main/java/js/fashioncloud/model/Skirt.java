package js.fashioncloud.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Skirt {

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
}
