package ma.xproce.exam.dao.repositories;

import ma.xproce.exam.dao.entities.Action;
import ma.xproce.exam.dao.entities.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActionRepository extends JpaRepository<Action,Long> {
    List<Action> findByOrganisation(Organisation organisation);
}
