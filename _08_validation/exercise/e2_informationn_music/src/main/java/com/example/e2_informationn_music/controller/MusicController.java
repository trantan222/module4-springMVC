package com.example.e2_informationn_music.controller;

import com.example.e2_informationn_music.dto.MusicDto;
import com.example.e2_informationn_music.model.Music;
import com.example.e2_informationn_music.service.IServiceMusic;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Controller
@RequestMapping("/music")
public class MusicController {
    final
    IServiceMusic musicService;

    public MusicController(IServiceMusic musicService) {
        this.musicService = musicService;
    }

    @GetMapping
    public String showList(@RequestParam( defaultValue = "0") int page,
                           @RequestParam( defaultValue = "2") int size,
                           Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Music> musics = musicService.findAll(pageable);
        model.addAttribute("musics",musics);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("music", new MusicDto());
        return "create";
    }

    @PostMapping("/createOrUp")
    public String CreateOrUpdateMusic(@Valid @ModelAttribute("music")
                                 MusicDto musicDto,
                                 BindingResult bindingResult,
                                 @RequestParam("id") Long id,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Music music = musicService.findById(id);
        if(music != null){
            BeanUtils.copyProperties(musicDto, music);
            musicService.save(music);
            return "redirect:/music";
        }else{
            Music Newmusic = new Music();
            BeanUtils.copyProperties(musicDto, Newmusic);
            musicService.save(Newmusic);
            return "redirect:/music";
        }
    }

    @GetMapping("/edit/{id}")
    public String ShowUp(@PathVariable("id") Long id, Model model) {
        Music music = musicService.findById(id);
        if (music != null) {
            MusicDto musicDto = new MusicDto();
            BeanUtils.copyProperties(music, musicDto);
            model.addAttribute("music", musicDto);
            return "create";
        }
        return "error404";
    }

}
