package com.Java_project_vityarthi.Notes_Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller 
public class NoteController {

    @Autowired
    private NoteRepository noteRepository; 

    @GetMapping("/") 
    public String viewHomePage(Model model) {
        
        List<Note> listOfNotes = noteRepository.findAllByOrderByCreatedAtDesc(); 
        
        
        model.addAttribute("allNotesFromServer", listOfNotes); 
        return "index";
    }

    @PostMapping("/saveNote")
    public String saveNote(@ModelAttribute Note note) {
        
        noteRepository.save(note);
    
        return "redirect:/";
    }

    @GetMapping("/deleteNote/{id}")
    public String deleteNote(@org.springframework.web.bind.annotation.PathVariable Long id) {
        noteRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login"; 
    }
}