package com.example.demo.controller;

import com.example.demo.dto.QuestionDto;
import com.example.demo.model.QuestionContent;
import com.example.demo.model.Type;
import com.example.demo.repository.ITypeRepo;
import com.example.demo.service.IQuestionService;
import com.example.demo.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/questions")
public class ControllerQuestion {
    private final IQuestionService iQuestionService;
    private final ITypeRepo iTypeRepo;

    public ControllerQuestion(IQuestionService iQuestionService, ITypeRepo iTypeRepo) {
        this.iQuestionService = iQuestionService;
        this.iTypeRepo = iTypeRepo;
    }

    @GetMapping("")
    public ModelAndView show_List(@PageableDefault(size = 3,page = 0) Pageable pageable,
                                  @RequestParam(name = "title",defaultValue = "",required = false) String title,
                                  @RequestParam(name = "type",defaultValue = "",required = false) String type_name
    ) {

        pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),Sort.by("dateCreated").ascending());
//        Page<QuestionContent> questionPage =iQuestionService.findAllByTitleContainingAndType_Name(pageable,title,type_name)
        Page<QuestionContent> questionPage =iQuestionService.findAllByTitleContainingAndType_Name(pageable,title,type_name);
        List<Type> types = iTypeRepo.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("types",types);
        modelAndView.addObject("title",title);
        modelAndView.addObject("type_name",type_name);
        modelAndView.addObject("questions",questionPage);
        return modelAndView;
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("question", new QuestionDto());
        List<Type> types = iTypeRepo.findAll();
        model.addAttribute("types",types);
        return "/create";
    }
    @PostMapping("/create")
    public String createNew(@Validated @ModelAttribute("question") QuestionDto questionDto,
                            BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasErrors()) {
            List<Type> types = iTypeRepo.findAll();
            model.addAttribute("types",types);
            return "/create";
        }
        QuestionContent questionContent = new QuestionContent();
        BeanUtils.copyProperties(questionDto, questionContent);
        questionContent.setDateCreated(LocalDate.now());
        iQuestionService.save(questionContent);
        redirectAttributes.addFlashAttribute("mess", "add success!!!");
        return "redirect:/questions";
    }
//    @GetMapping("/searchAll")    cach 2
//    public String searchAll(
//                            @RequestParam(value = "type") String type,
//                            @RequestParam("title") Optional<String> title,
//                            @RequestParam(defaultValue = "0") int page,
//                            @RequestParam(defaultValue = "2") int size,
//                            Model model) {
//        String nameValue = "";
//        if (title.isPresent()) {
//            nameValue = title.get();
//        }
//        Pageable pageable = PageRequest.of(page, size);
//        if (nameValue == null) {
//            Page<QuestionContent> san_bongPage = iQuestionService.findAllByType_Name(pageable, type);
//            List<Type> types = iTypeRepo.findAll();
//            model.addAttribute("types",types);
//            model.addAttribute("questions",san_bongPage);
//            return "list";
//        }
//        if(type ==""){
//            Page<QuestionContent> san_bongPage = iQuestionService.findAllBYTitle(pageable, nameValue);
//            List<Type> types = iTypeRepo.findAll();
//            model.addAttribute("types",types);
//            model.addAttribute("questions",san_bongPage);
//            return "list";
//        }
//        Page<QuestionContent> san_bongPage = iQuestionService.findAllByTitleContainingAndType_Name(pageable,nameValue,type);
//        List<Type> types = iTypeRepo.findAll();
//        model.addAttribute("types",types);
//        model.addAttribute("questions",san_bongPage);
//        return "list";
//    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        iQuestionService.delete(id);
        return "redirect:/questions";
    }
    @GetMapping("/edit/{id}")
    public String showUp(@PathVariable Long id,Model model){
        QuestionContent questionContent = iQuestionService.findByid(id);
        model.addAttribute("question", questionContent);
        List<Type> types = iTypeRepo.findAll();
        model.addAttribute("types",types);
        return "/detail";
    }
}
