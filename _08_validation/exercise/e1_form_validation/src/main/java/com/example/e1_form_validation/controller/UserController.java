package com.example.e1_form_validation.controller;

import com.example.e1_form_validation.Dto.UserDto;
import com.example.e1_form_validation.model.User;
import com.example.e1_form_validation.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService iUserService;
    @GetMapping
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("user",new UserDto());
        return modelAndView;
    }
    @PostMapping("/create")
    public String createNew(@Valid @ModelAttribute("user") UserDto userDto,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes,
                            Model model){
        new UserDto().validate(userDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "form";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        iUserService.save(user);
//        redirectAttributes.addFlashAttribute("message","them mới thành công");
        return showList(0,2,model);
    }
    @GetMapping("/list")
    public String showList(@RequestParam("0") int page,
                           @RequestParam("2") int size,
                           Model model){
        Pageable pathVariable = PageRequest.of(page,size);
        Page<User> users = iUserService.findAll(pathVariable);
        model.addAttribute("users",users);
        return "list";
    }

}
