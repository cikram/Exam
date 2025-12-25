package ma.xproce.exam.service;

import ma.xproce.exam.dao.entities.Action;
import ma.xproce.exam.dao.entities.Don;
import ma.xproce.exam.dao.entities.Donateur;
import ma.xproce.exam.dao.repositories.DonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonManager implements DonService {

    @Autowired
    DonRepository donRepository;

    @Override
    public Don save(Don don) {
        if (don != null
                && don.getMontant() != null
                && don.getMontant() > 0
                && don.getAction() != null
                && don.getDonateur() != null) {

            return donRepository.save(don);
        }
        return null;
    }

    @Override
    public List<Don> getDonsByAction(Action action) {
        if (action == null) return List.of();
        return donRepository.findByAction(action);
    }

    @Override
    public List<Don> getDonsByDonateur(Donateur donateur) {
        if (donateur == null) return List.of();
        return donRepository.findByDonateur(donateur);
    }

    @Override
    public Double getTotalMontantByAction(Action action) {
        if (action == null) return 0.0;

        return getDonsByAction(action)
                .stream()
                .mapToDouble(Don::getMontant)
                .sum();
    }

    @Override
    public void deleteDonById(Long id) {
        Don don = donRepository.findById(id).orElse(null);
        if (don != null) {
            donRepository.delete(don);
        }
    }
}
