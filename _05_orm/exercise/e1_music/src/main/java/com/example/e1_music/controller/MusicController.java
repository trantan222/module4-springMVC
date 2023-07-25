package com.example.e1_music.controller;

import com.example.e1_music.model.Music;
import com.example.e1_music.model.MusicForm;
import com.example.e1_music.service.MusicImpl;
import com.example.e1_music.service.MusicService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class MusicController {
    @Value("${file-upload}")
    private String fileUpload;
    MusicService musicService = new MusicImpl();
    @GetMapping("/")
    public String showList(Model model){
       model.addAttribute("music",musicService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("newM",new Music());
        return "create";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute("musicForm") MusicForm musicForm, RedirectAttributes redirectAttributes) throws IOException {
        MultipartFile multipartFile = musicForm.getPlay();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getPlay().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Music music = new Music(musicForm.getIdMusic(),musicForm.getNameMusic(),musicForm.getNameSinger(),musicForm.getTypeMusic(),musicForm.getLink(),fileName);
        musicService.create(music);
        redirectAttributes.addFlashAttribute("mess", "them thanh cong");
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String showUp(@PathVariable("id") int id, Model model){
        model.addAttribute("uMusic",musicService.findById(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute("uMusic") Music music){
        musicService.update(music);
        return "redirect:/";
    }
    @PostMapping ("/search")
    public String search(@RequestParam("NameS") String n, Model model){
        List<Music> music ;
        model.addAttribute("music",musicService.searchName(n));
        return "list";
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        musicService.delete(id);
        return "redirect:/";
    }
}
