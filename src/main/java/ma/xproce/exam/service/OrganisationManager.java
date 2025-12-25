package ma.xproce.exam.service;

import ma.xproce.exam.dao.entities.Action;
import ma.xproce.exam.dao.entities.Organisation;
import ma.xproce.exam.dao.repositories.ActionRepository;
import ma.xproce.exam.dao.repositories.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisationManager implements OrganisationService {

    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    ActionRepository actionRepository;

    @Override
    public Organisation save(Organisation organisation) {
        if (organisation != null
                && organisation.getNom() != null
                && organisation.getEmail() != null) {

            return organisationRepository.save(organisation);
        }
        return null;
    }

    @Override
    public Organisation getOrganisationById(Long id) {
        return organisationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Action> getActionsByOrganisation(Organisation organisation) {
        if (organisation == null) return List.of();
        return actionRepository.findByOrganisation(organisation);
    }

    @Override
    public void deleteOrganisationById(Long id) {
        Organisation organisation = getOrganisationById(id);
        if (organisation != null) {
            organisationRepository.delete(organisation);
        }
    }
}
