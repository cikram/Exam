package ma.xproce.exam.service;

import ma.xproce.exam.dao.entities.Action;
import ma.xproce.exam.dao.entities.Organisation;

import java.util.List;

public interface OrganisationService {

    Organisation save(Organisation organisation);

    Organisation getOrganisationById(Long id);

    List<Action> getActionsByOrganisation(Organisation organisation);

    void deleteOrganisationById(Long id);
}
