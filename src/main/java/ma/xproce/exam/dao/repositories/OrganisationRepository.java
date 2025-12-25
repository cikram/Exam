package ma.xproce.exam.dao.repositories;

import ma.xproce.exam.dao.entities.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepository extends JpaRepository<Organisation,Long> {
}
