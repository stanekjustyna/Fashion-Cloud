package js.fashioncloud.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Feature {

    @Id
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type{
        SHAPE, LENGTH, COLOR, FABRIC, SIZE

        }

    public static List<Feature> filterByType(List<Feature> features, Type type){

        return features.stream()
                .filter(e -> e.getType() == type)
                .collect(Collectors.toList());
    }
}
