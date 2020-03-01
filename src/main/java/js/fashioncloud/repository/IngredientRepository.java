package js.fashioncloud.repository;

import js.fashioncloud.model.Feature;

public interface IngredientRepository {

    Iterable<Feature> findAll();

    Feature findOne(String id);

    Feature save(Feature feature);
}
