package com.example.e1_picture_in_day.controller;

import com.example.e1_picture_in_day.Dto.commentDto;
import com.example.e1_picture_in_day.exception.AdminException;
import com.example.e1_picture_in_day.model.comment;
import com.example.e1_picture_in_day.service.comment.ICommentService;
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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/picture")
public class CommentController {
    final
    ICommentService iCommentService;


    public CommentController(ICommentService iCommentService) {
        this.iCommentService = iCommentService;
    }
    @GetMapping
    public String show(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "2") int size,
                       Model model)
    {
        Pageable pageable = PageRequest.of(page,size);
        Page<comment> comments = iCommentService.findAll(pageable);
        model.addAttribute("comment", new commentDto());
        model.addAttribute("comments", comments);
        return "list";
    }
    @PostMapping("")
    public String save(@Valid @ModelAttribute("comment")commentDto commentDto,
                       BindingResult bindingResult
                       ,Model model){
        new commentDto().validate(commentDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "error404";
        }
        comment comment = new comment();
        BeanUtils.copyProperties(commentDto,comment);
        iCommentService.save(comment);
        model.addAttribute("comments",comment);
        return "redirect:/picture";
    }
    @GetMapping("/{id}")
    public String raiseLike(@PathVariable("id") int id){
        comment comment = iCommentService.findById(id);
        comment.setLiked(comment.getLiked()+1);
        iCommentService.save(comment);
        return "redirect:/picture";
    }
    @ExceptionHandler(AdminException.class)
    public String adminException(){
        return "error404";
    }
}
