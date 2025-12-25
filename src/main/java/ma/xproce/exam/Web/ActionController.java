package ma.xproce.exam.Web;

import ma.xproce.exam.dao.entities.Action;
import ma.xproce.exam.dao.entities.Don;
import ma.xproce.exam.service.ActionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ActionController {

    @Autowired
    ActionManager actionManager;

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("action", new Action());
        return "add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Action action){
        actionManager.Save(action);
        return "redirect:/add";
    }

    @GetMapping("/dons")
    public String getDonsByAction(@RequestParam("id") Long actionId, Model model) {

        Action action = actionManager.getActionById(actionId);
        if (action == null) {
            return "redirect:/add";
        }

        List<Don> dons = actionManager.getAllDons(action);
        Double totalMontantAction = actionManager.getTotalMontantAction(action);

        model.addAttribute("action", action);
        model.addAttribute("dons", dons);
        model.addAttribute("totalMontantAction", totalMontantAction);

        return "DonsByAction";
    }
}
