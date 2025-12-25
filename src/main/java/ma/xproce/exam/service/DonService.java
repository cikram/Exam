package ma.xproce.exam.service;

import ma.xproce.exam.dao.entities.Action;
import ma.xproce.exam.dao.entities.Don;
import ma.xproce.exam.dao.entities.Donateur;

import java.util.List;

public interface DonService {

    Don save(Don don);

    List<Don> getDonsByAction(Action action);

    List<Don> getDonsByDonateur(Donateur donateur);

    Double getTotalMontantByAction(Action action);

    void deleteDonById(Long id);
}
