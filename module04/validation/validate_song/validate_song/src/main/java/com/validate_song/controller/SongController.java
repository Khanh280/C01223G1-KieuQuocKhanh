package com.validate_song.controller;

import com.validate_song.dto.SongDTO;
import com.validate_song.model.Song;
import com.validate_song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.xml.ws.Action;

@Controller
public class SongController {
    @Autowired
    private ISongService iSongService;
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("songList", iSongService.findAll());
        return "/home";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("songDTO", new SongDTO());
        return "/create";
    }
    @PostMapping("create")
    public String save(@Validated @ModelAttribute("songDTO") SongDTO songDTO, BindingResult bindingResult,Model model){
        new SongDTO().validate(songDTO,bindingResult);
        if(bindingResult.hasErrors()){
            return "/create";
        }else {
            Song song = new Song();
            BeanUtils.copyProperties(songDTO,song);
            boolean statusSave = iSongService.save(song);
            model.addAttribute("statusSave",statusSave);
            model.addAttribute("songList",iSongService.findAll());
            return "/home";
        }
    }
    @GetMapping("/update/{id}")
    public String updateInfo(@PathVariable("id")Long id, Model model){
        SongDTO songDTO = new SongDTO();
        Song song = iSongService.findSongById(id);
        BeanUtils.copyProperties(song,songDTO);
        model.addAttribute("songDTO",songDTO);
        return "/update";
    }
    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("songDTO")SongDTO songDTO,BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new SongDTO().validate(songDTO,bindingResult);
        if(bindingResult.hasErrors()){
            return "/update";
        }else {
            Song song = new Song();
            BeanUtils.copyProperties(songDTO,song);
            boolean statusUpdate = iSongService.save(song);
            redirectAttributes.addFlashAttribute("statusUpdate",statusUpdate);
            return "redirect:/";
        }
    }
    @GetMapping("/delete")
    public  String delete(@RequestParam("id") Long id,RedirectAttributes redirectAttributes){
        boolean statusDelete = iSongService.delete(id);
        redirectAttributes.addFlashAttribute("statusDelete",statusDelete);
        return "redirect:/";
    }
}
