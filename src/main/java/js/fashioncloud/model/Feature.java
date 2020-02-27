package js.fashioncloud.model;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Feature {

    private final String id;
    private final String name;
    private final Type type;

    public static enum Type{
        SIZE, LENGTH, COLOR, PATTERN, FABRIC
    }

    public static List<Feature> filterByType(List<Feature> features, Type type){

        return features.stream()
                .filter(e -> e.getType() == type)
                .collect(Collectors.toList());
    }
}
