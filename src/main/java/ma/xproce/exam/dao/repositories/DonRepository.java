package ma.xproce.exam.dao.repositories;

import ma.xproce.exam.dao.entities.Action;
import ma.xproce.exam.dao.entities.Don;
import ma.xproce.exam.dao.entities.Donateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonRepository extends JpaRepository<Don,Long> {
    List<Don> findByAction(Action action);
    List<Don> findByDonateur(Donateur donateur);
}
