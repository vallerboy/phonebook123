package pl.oskarpolak.phonebook.models.services;


import it.ozimov.springboot.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.oskarpolak.phonebook.models.EntryModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class EntryService {
    private List<EntryModel> entries;
    private NotificationService notificationService;

    @Autowired
    public EntryService(NotificationService notificationService) {
        entries = new LinkedList<>();
        this.notificationService = notificationService;
    }

    public void addEntry(EntryModel entryModel){
        entries.add(0, entryModel);

        notificationService.sendMessageToAdmin("Ktoś się wpisał do księgi :)");
    }

    public List<EntryModel> getEntries() {
        return entries;
    }
}
