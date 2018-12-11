package pl.oskarpolak.phonebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.oskarpolak.phonebook.models.EntryModel;
import pl.oskarpolak.phonebook.models.services.EntryService;

@Controller
public class MainController {


    private EntryService entryService;


    @Autowired // new EntrySerice() - istnieje jedna instncja tej klasy na caly projekt
    public MainController(EntryService entryService){
        this.entryService = entryService;
    }

    @GetMapping("/") //@RequestMapping(method = GET, value = "/")
    public String  index() {
        return "index";
    }

    @PostMapping("/")
    public String index(@RequestParam("name") String name,
                        @RequestParam("surname") String surname,
                        @RequestParam("message") String message){
        entryService.addEntry(new EntryModel(name, surname, message));
        return "index";
    }


    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("entries", entryService.getEntries());
        return "list";
    }
}
