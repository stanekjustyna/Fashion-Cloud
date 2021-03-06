package js.fashioncloud.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
public class Skirt {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Date createdAt;

    private String comments;

    @ManyToOne(targetEntity = Feature.class)
    @NotNull(message="Specify preferred shape.")
    private Feature shape;

    @ManyToOne(targetEntity = Feature.class)
    @NotNull(message="Specify preferred length.")
    private Feature length;

    @ManyToOne(targetEntity = Feature.class)
    @NotNull(message="Specify preferred color.")
    private Feature color;

    @ManyToOne(targetEntity = Feature.class)
    @NotNull(message="Specify preferred fabric.")
    private Feature fabric;

    @ManyToOne(targetEntity = Feature.class)
    @NotNull(message="Specify preferred size.")
    private Feature size;

    @PrePersist
    void createdAt(){
        this.createdAt = new Date();
    }

}
