package ma.xproce.exam.dao.repositories;

import ma.xproce.exam.dao.entities.Donateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonateurRepository extends JpaRepository<Donateur,Long> {
}
