package ma.xproce.exam.service;

import ma.xproce.exam.dao.entities.Don;
import ma.xproce.exam.dao.entities.Donateur;

import java.util.List;

public interface DonateurService {

    Donateur save(Donateur donateur);

    Donateur getDonateurById(Long id);

    List<Donateur> getAllDonateurs();

    List<Don> getDonsByDonateur(Donateur donateur);

    Double getTotalMontantByDonateur(Donateur donateur);

    void deleteDonateurById(Long id);

    void deleteDonateur(Donateur donateur);
}
