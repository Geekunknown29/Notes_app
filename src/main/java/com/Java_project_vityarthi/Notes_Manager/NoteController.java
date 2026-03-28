package com.Java_project_vityarthi.Notes_Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Fixed 'or.' to 'org.'
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping; // Fixed 'GetMappeing' spelling below
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller 
public class NoteController {

    @Autowired
    private NoteRepository noteRepository; // Removed the space in 'note Repository'

    @GetMapping("/") // Fixed spelling from 'GetMappeing'
    public String viewHomePage(Model model) {
        // 'findAll' must have a capital 'A'
        List<Note> listOfNotes = noteRepository.findAllByOrderByCreatedAtDesc(); 
        
        // Fixed 'moel' to 'model'
        model.addAttribute("allNotesFromServer", listOfNotes); 
        return "index";
    }

    @PostMapping("/saveNote")
    public String saveNote(@ModelAttribute Note note) {
        // This saves the note to your MySQL database
        noteRepository.save(note);
        
        // This sends the user back to the list
        return "redirect:/";
    }

    @GetMapping("/deleteNote/{id}")
    public String deleteNote(@org.springframework.web.bind.annotation.PathVariable Long id) {
        noteRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // This looks for login.html in templates
    }
}