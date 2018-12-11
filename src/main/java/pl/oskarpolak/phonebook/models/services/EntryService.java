package pl.oskarpolak.phonebook.models.services;


import org.springframework.stereotype.Service;
import pl.oskarpolak.phonebook.models.EntryModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class EntryService {
    private List<EntryModel> entries;


    //taka klasa, musi mieć bezargumentowy kostruktor!
    public EntryService() {
        entries = new LinkedList<>();
    }

    public void addEntry(EntryModel entryModel){
        entries.add(0, entryModel);
    }

    public List<EntryModel> getEntries() {
        return entries;
    }
}
