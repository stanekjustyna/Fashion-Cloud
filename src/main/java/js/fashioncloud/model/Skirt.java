package js.fashioncloud.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
public class Skirt {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Date createdAt;

    @NotNull
    @Size(min=4, max=32, message="Name should be between 4 and 32 characters long.")
    private String name;

    @ManyToOne(targetEntity = Feature.class)
    @NotNull(message="Specify preferred size.")
    private Feature size;

    @ManyToOne(targetEntity = Feature.class)
    @NotNull(message="Specify preferred length.")
    private Feature length;

    @ManyToOne(targetEntity = Feature.class)
    @NotNull(message="Specify preferred color.")
    private Feature color;

    @ManyToOne(targetEntity = Feature.class)
    @NotNull(message="Specify preferred pattern.")
    private Feature pattern;

    @PrePersist
    void createdAt(){
        this.createdAt = new Date();
    }

}
