package js.fashioncloud.repository;

import js.fashioncloud.model.Skirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkirtRepository extends JpaRepository<Skirt, Long> {
    Skirt save(Skirt skirt);
}
