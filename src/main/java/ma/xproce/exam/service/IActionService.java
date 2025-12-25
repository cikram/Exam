package ma.xproce.exam.service;

import ma.xproce.exam.dao.entities.Action;
import ma.xproce.exam.dao.entities.Don;

import java.util.List;

public interface IActionService {

    Action Save(Action action);
    List<Don>  getAllDons(Action action);
    Double getTotalMontantAction(Action action);
    Action getActionById(Long id);
    void deleteActionById(Long id);
    void  deleteAction(Action action);
    List<Action> getAllActions();



}
