package com.example.demo.controller;

import com.example.demo.dto.CartDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("cart")
    public CartDto initCart() {
        System.out.println("init Card");
        return new CartDto();
    }

    final
    IProductService productService;

    @GetMapping
    public String showListPage(Model model, @SessionAttribute(value = "cart", required = false) CartDto cartDto,
                               @CookieValue(value = "productId",
                                       required = false,
                                       defaultValue = "-1") Long id) {
        model.addAttribute("historyProduct", productService.findById(id));
        if (cartDto != null) {
            model.addAttribute("cart", cartDto);
        }
        model.addAttribute("products", productService.findAll());
        return "product/list";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") Long id, HttpServletResponse response,Model model) {
        Cookie cookieValue = new Cookie("productId", id + "");
        cookieValue.setMaxAge(1 * 24 * 60 * 60);
        cookieValue.setPath("/");
        response.addCookie(cookieValue);
        model.addAttribute("product",productService.findById(id));
        return "product/detail";
    }
    @GetMapping("/add/{id}")
    public String addtoCart(@PathVariable("id") Long id,@SessionAttribute(value = "cart") CartDto cartDto){
        Product product = productService.findById(id);
        if(product != null){
            ProductDto  productDto = new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            cartDto.addProduct(productDto);
        }
        return "redirect:/cart";
    }


}
