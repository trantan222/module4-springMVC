package com.example.demo.controller;

import com.example.demo.model.QuestionContent;
import com.example.demo.model.Type;
import com.example.demo.repository.ITypeRepo;
import com.example.demo.service.IQuestionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping()
    public String show_List(@RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "3") int size,
                            @RequestParam("title") Optional<String> OName,
                            Model model
    ) {
        String nameValue = "";
        if (OName.isPresent()) {
            nameValue = OName.get();
        }
        Pageable pageable = PageRequest.of(page, size);
//        Page<QuestionContent> questionPage =iQuestionService.findAllBYTitle(pageable,nameValue);
        Page<QuestionContent> questionPage = iQuestionService.findAllBy(pageable);
        List<Type> types = iTypeRepo.findAll();
        model.addAttribute("types",types);
        model.addAttribute("questions",questionPage);
        return "list";
    }
}
