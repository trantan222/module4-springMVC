package com.example.cart.Controller;


import com.example.cart.Dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("cart")
public class CartController {
    @ModelAttribute("cart")
    public CartDto setUpcart(){
        return new CartDto();
    }
    @GetMapping
    public String showCart(@SessionAttribute(value = "cart",required = false)CartDto cartDto, Model model){
        model.addAttribute("cart",cartDto);
        return "cart/list";
    }

}
