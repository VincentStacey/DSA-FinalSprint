package com.keyin.controller;

import com.keyin.model.TreeRecord;
import com.keyin.service.TreeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TreeController {
    private final TreeService service;

    public TreeController(TreeService service) {
        this.service = service;
    }

    @GetMapping("/enter-numbers")
    public String showForm() {
        return "enter-numbers";
    }

    @PostMapping("/process-numbers")
    public String process(@RequestParam("numbers") String numbers, Model model) {
        try {
            TreeRecord record = service.processInput(numbers);
            model.addAttribute("treeJson", record.getTreeJson());
            model.addAttribute("inputNumbers", record.getInputNumbers());
            return "tree-result";
        } catch (Exception e) {
            model.addAttribute("error", "Invalid input.");
            return "enter-numbers";
        }
    }

    @GetMapping("/previous-trees")
    public String showPrevious(Model model) {
        model.addAttribute("records", service.getAllRecords());
        return "previous-trees";
    }
}
