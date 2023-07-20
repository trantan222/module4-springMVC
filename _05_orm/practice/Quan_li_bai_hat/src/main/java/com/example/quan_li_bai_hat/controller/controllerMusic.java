package com.example.quan_li_bai_hat.controller;


import com.example.quan_li_bai_hat.model.Music;
import com.example.quan_li_bai_hat.model.MusicForm;
import com.example.quan_li_bai_hat.service.iServiceMusic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/list_music")
public class controllerMusic {
    private final iServiceMusic serviceMusic;

    @Value("${file-upload}")
    private String fileUpload;


    public controllerMusic(iServiceMusic serviceMusic) {
        this.serviceMusic = serviceMusic;
    }

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("music", serviceMusic.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("MusicForm",new MusicForm());
        return "/create";
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
        serviceMusic.create(music);
        redirectAttributes.addFlashAttribute("mess", "them thanh cong");
        return "redirect:/list_music";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        serviceMusic.delete(id);
        return "redirect:/list_music";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        Music music = serviceMusic.findById(id);
        model.addAttribute("music",music);
        return "/update";
    }

}
