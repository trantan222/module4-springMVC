package com.example.sudungthymeleafdequanlisanpham.controller;

import com.example.sudungthymeleafdequanlisanpham.model.product;
import com.example.sudungthymeleafdequanlisanpham.service.ProductServiceImpl;
import com.example.sudungthymeleafdequanlisanpham.service.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.print.ServiceUI;
import java.util.List;

@Controller
public class ProductController {
    ServiceProduct productService = new ProductServiceImpl();

    @GetMapping("/")
    public String show(Model model){
        model.addAttribute("product",productService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("productC",new product());
        return "create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute product product, Model model,
                       RedirectAttributes  redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("mess","create successful!!!");
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("productE",productService.detail(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(product product,RedirectAttributes redirect){
        productService.edit(product.getId(), product);
        redirect.addFlashAttribute("mess", "update successful !!");
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id,Model model,RedirectAttributes redirect){
        productService.remove(id);
        redirect.addFlashAttribute("mess", "remove successful!!");
        return "redirect:/";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id,Model model){
        model.addAttribute("product",productService.detail(id));
        return "view";
    }
    @GetMapping("/search")
    public String search(@RequestParam("search") String search,Model model){
        List<product> products =productService.findbyName(search);
        if(products != null){
            model.addAttribute("product",products);
            return "list";
        }
        return null;
    }


}
