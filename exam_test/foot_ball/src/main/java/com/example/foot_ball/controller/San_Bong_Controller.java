package com.example.foot_ball.controller;

import com.example.foot_ball.dto.San_bongDto;
import com.example.foot_ball.model.*;
//import com.example.foot_ball.repository.IRepoKhachHang;
//import com.example.foot_ball.repository.IRepoKhu_vuc;
//import com.example.foot_ball.repository.IRepoKhung_gio;
import com.example.foot_ball.repository.*;
import com.example.foot_ball.service.IServiceSan_Bong;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/stadiums")
public class San_Bong_Controller {
    final
    IServiceSan_Bong iServiceSan_bong;
    @Autowired
    IRepoKhach_Hang iRepoKhachHang;
    @Autowired
    IRepoSan_Bong iRepoSan_bong;
    @Autowired
    IRepoKhung_Gio iRepoKhung_gio;
    @Autowired
    IRepoKhuVuc iRepoKhuVuc;
    @Autowired
    IRepoLoaiSan iRepoLoaiSan;

    public San_Bong_Controller(IServiceSan_Bong iServiceSan_bong) {
        this.iServiceSan_bong = iServiceSan_bong;
    }

    @GetMapping
    public String show_List(@RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "3") int size,
                            @RequestParam("name") Optional<String> OName,
                            Model model
    ) {
        String nameValue = "";
        if (OName.isPresent()) {
            nameValue = OName.get();
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<San_bong> san_bongPage = iServiceSan_bong.findAllByNameContaining(pageable, nameValue);
        List<Khu_vuc> khu_vucs = iRepoKhuVuc.findAll();
        List<Khung_gio> khung_gios = iRepoKhung_gio.findAll();
        List<Khach_hang> khach_hangs = iRepoKhachHang.findAll();
        List<Loai_san> loaiSans = iRepoLoaiSan.findAll();
        model.addAttribute("stadiums", san_bongPage);
        model.addAttribute("type", loaiSans);
        model.addAttribute("areas", khu_vucs);
        model.addAttribute("hours", khung_gios);
        model.addAttribute("customer", khach_hangs);
        return "stadium/list";
    }

    @GetMapping("/searchname")
    public String searchName(@RequestParam("name") Optional<String> OName,
                             @PageableDefault(size = 2) Pageable pageable,
                             Model model) {
        String nameValue = "";
        if (OName.isPresent()) {
            nameValue = OName.get();
        }
        Page<San_bong> san_bongPage = iServiceSan_bong.findAllByNameContaining(pageable, nameValue);
        List<Khu_vuc> khu_vucs = iRepoKhuVuc.findAll();
        List<Khung_gio> khung_gios = iRepoKhung_gio.findAll();
        List<Khach_hang> khach_hangs = iRepoKhachHang.findAll();
        List<Loai_san> loaiSans = iRepoLoaiSan.findAll();
        model.addAttribute("stadiums", san_bongPage);
        model.addAttribute("type", loaiSans);
        model.addAttribute("areas", khu_vucs);
        model.addAttribute("hours", khung_gios);
        model.addAttribute("customer", khach_hangs);
        return "/stadium/list";
    }

    @GetMapping("/searchkhuvuc")
    public String searchKhuVuc(@RequestParam("khuvuc") Khu_vuc khu_vuc,
                               @PageableDefault(size = 2) Pageable pageable,
                               Model model) {
        Page<San_bong> san_bongPage = iServiceSan_bong.findKhuVuc(pageable, khu_vuc);
        List<Khu_vuc> khu_vucs = iRepoKhuVuc.findAll();
        List<Khung_gio> khung_gios = iRepoKhung_gio.findAll();
        List<Khach_hang> khach_hangs = iRepoKhachHang.findAll();
        List<Loai_san> loaiSans = iRepoLoaiSan.findAll();
        model.addAttribute("type", loaiSans);
        model.addAttribute("stadiums", san_bongPage);
        model.addAttribute("areas", khu_vucs);
        model.addAttribute("hours", khung_gios);
        model.addAttribute("customer", khach_hangs);
        return "/stadium/list";
    }

    @GetMapping("/searchloaisan")
    public String searchType(@RequestParam("loaisan") Loai_san loai_san,
                             @PageableDefault(size = 2) Pageable pageable,
                             Model model) {
        Page<San_bong> san_bongPage = iServiceSan_bong.findLoaiSan(pageable, loai_san);
        List<Khu_vuc> khu_vucs = iRepoKhuVuc.findAll();
        List<Khung_gio> khung_gios = iRepoKhung_gio.findAll();
        List<Khach_hang> khach_hangs = iRepoKhachHang.findAll();
        List<Loai_san> loaiSans = iRepoLoaiSan.findAll();
        model.addAttribute("type", loaiSans);
        model.addAttribute("stadiums", san_bongPage);
        model.addAttribute("areas", khu_vucs);
        model.addAttribute("hours", khung_gios);
        model.addAttribute("customer", khach_hangs);
        return "/stadium/list";
    }

    @GetMapping("/searchAll")
    public String searchAll(@RequestParam("loaisann") Loai_san loai_san,
                            @RequestParam("khuvucc") Khu_vuc khu_vuc,
                            @RequestParam("namee") Optional<String> OName,
                            @PageableDefault(size = 2) Pageable pageable,
                            Model model) {
        String nameValue = "";
        if (OName.isPresent()) {
            nameValue = OName.get();
        }
        Page<San_bong> san_bongPage = iServiceSan_bong.findThreeField(pageable, nameValue, khu_vuc, loai_san);
        List<Khu_vuc> khu_vucs = iRepoKhuVuc.findAll();
        List<Khung_gio> khung_gios = iRepoKhung_gio.findAll();
        List<Khach_hang> khach_hangs = iRepoKhachHang.findAll();
        List<Loai_san> loaiSans = iRepoLoaiSan.findAll();
        model.addAttribute("type", loaiSans);
        model.addAttribute("stadiums", san_bongPage);
        model.addAttribute("areas", khu_vucs);
        model.addAttribute("hours", khung_gios);
        model.addAttribute("customer", khach_hangs);
        return "/stadium/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id,Model model){
        iServiceSan_bong.delete(id);
        return "redirect:/stadiums";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("stadium",new San_bongDto());
        List<Khu_vuc> khu_vucs = iRepoKhuVuc.findAll();
        List<Khung_gio> khung_gios = iRepoKhung_gio.findAll();
        List<Khach_hang> khach_hangs = iRepoKhachHang.findAll();
        List<Loai_san> loaiSans = iRepoLoaiSan.findAll();
        model.addAttribute("type", loaiSans);
        model.addAttribute("areas", khu_vucs);
        model.addAttribute("hours", khung_gios);
        model.addAttribute("customer", khach_hangs);
        return "/stadium/create";
    }
    @PostMapping("/create")
    public String createNew(@Valid @ModelAttribute("stadium") San_bongDto san_bongDto,
                            BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model){

        if(bindingResult.hasErrors()){
            List<Khu_vuc> khu_vucs = iRepoKhuVuc.findAll();
            List<Khung_gio> khung_gios = iRepoKhung_gio.findAll();
            List<Loai_san> loaiSans = iRepoLoaiSan.findAll();
            model.addAttribute("type", loaiSans);
            model.addAttribute("areas", khu_vucs);
            model.addAttribute("hours", khung_gios);
            return "/stadium/create";
        }
        San_bong san_bong = new San_bong();
        BeanUtils.copyProperties(san_bongDto,san_bong);
        iServiceSan_bong.save(san_bong);
        redirectAttributes.addFlashAttribute("mess","add success!!!");
        return "redirect:/stadiums";
    }

}
