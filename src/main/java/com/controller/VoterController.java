package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entity.Voter;
import com.service.VoterService;

import jakarta.validation.Valid;

@Controller
public class VoterController {

    @Autowired
    private VoterService voterService;

    @GetMapping("/voterregister")
    public String showVoterRegister(Model model){
        model.addAttribute("voter", new Voter());
        return "voterregister";
    }

    @PostMapping("/voter")
    public String registerVoter(@Valid @ModelAttribute Voter voter, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "voterregister";
        }
        voterService.saveVoter(voter);
        model.addAttribute("message", "Voter registered successfully.");
        return "voterregister";
    }

    @GetMapping("/deletevoter")
    public String deleteVoterPage(Model model) {
        return "deletevoter";
    }

    @PostMapping("/deletevoter")
    public String deleteVoter(@RequestParam int id, Model model) {
        try {
            voterService.deleteByid(id);
            model.addAttribute("message", "Voter deleted successfully.");
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "deletevoter";
    }

    @GetMapping("/voterlist")
    public String getVoterList(Model model) {
        model.addAttribute("voters", voterService.voterlist());
        return "voterlist";
    }

    @GetMapping("/updatevoter")
    public String showUpdateVoter(@RequestParam("id") int id, Model model) {
        Voter voter = voterService.findbyid(id);
        model.addAttribute("voter", voter);
        return "updatevoter";
    }

    @PostMapping("/updatevoter")
    public String updateVoter(@Valid @ModelAttribute Voter voter, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "updatevoter";
        }
        voterService.updatevoter(voter, voter.getId());
        model.addAttribute("message", "Voter updated successfully.");
        return "updatevoter";
    }
}
