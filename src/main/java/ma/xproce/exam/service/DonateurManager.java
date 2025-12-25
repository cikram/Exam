package ma.xproce.exam.service;

import ma.xproce.exam.dao.entities.Don;
import ma.xproce.exam.dao.entities.Donateur;
import ma.xproce.exam.dao.repositories.DonRepository;
import ma.xproce.exam.dao.repositories.DonateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonateurManager implements DonateurService {

    @Autowired
    DonateurRepository donateurRepository;

    @Autowired
    DonRepository donRepository;

    @Override
    public Donateur save(Donateur donateur) {
        if (donateur != null
                && donateur.getNom() != null
                && donateur.getEmail() != null) {
            return donateurRepository.save(donateur);
        }
        return null;
    }

    @Override
    public Donateur getDonateurById(Long id) {
        return donateurRepository.findById(id).orElse(null);
    }

    @Override
    public List<Donateur> getAllDonateurs() {
        return donateurRepository.findAll();
    }

    @Override
    public List<Don> getDonsByDonateur(Donateur donateur) {
        if (donateur == null) {
            return List.of();
        }
        return donRepository.findByDonateur(donateur);
    }

    @Override
    public Double getTotalMontantByDonateur(Donateur donateur) {
        if (donateur == null) return 0.0;

        return getDonsByDonateur(donateur)
                .stream()
                .mapToDouble(Don::getMontant)
                .sum();
    }

    @Override
    public void deleteDonateurById(Long id) {
        Donateur donateur = getDonateurById(id);
        if (donateur != null) {
            donateurRepository.delete(donateur);
        }
    }

    @Override
    public void deleteDonateur(Donateur donateur) {
        if (donateur != null) {
            donateurRepository.delete(donateur);
        }
    }
}
