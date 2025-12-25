package ma.xproce.exam.service;

import ma.xproce.exam.dao.entities.Action;
import ma.xproce.exam.dao.entities.Don;
import ma.xproce.exam.dao.repositories.ActionRepository;
import ma.xproce.exam.dao.repositories.DonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionManager implements IActionService {

    @Autowired
    ActionRepository actionRepository;
    @Autowired
    DonRepository donRepository;

    @Override
    public Action Save(Action action) {
        if (action != null
                && action.getMontantobj() != null
                && action.getMontantobj() > 0) {

            return actionRepository.save(action);
        }
        return null;
    }


    @Override
    public List<Don> getAllDons(Action action) {

        if (action == null) {
            return null;
        }
        return donRepository.findByAction(action);
    }

    @Override
    public Double getTotalMontantAction(Action action) {
        Double total = 0.0;
        List<Don> dons = getAllDons(action);
        for (Don don : dons) {
            total += don.getMontant();
        }
        return total;
    }

    @Override
    public Action getActionById(Long id){
        return actionRepository.findById(id).orElse(null);
    }


    @Override
    public void deleteActionById(Long id) {
        Action action = actionRepository.findById(id).orElse(null);
        if (action != null) {
            actionRepository.delete(action);
        }
    }


    @Override
    public void deleteAction(Action action) {
        if (action != null) {
            actionRepository.delete(action);
        }
    }

    @Override
    public List<Action> getAllActions() {
        return actionRepository.findAll();
    }




}








