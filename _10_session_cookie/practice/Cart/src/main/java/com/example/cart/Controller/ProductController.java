package com.example.cart.Controller;

import com.example.cart.Dto.CartDto;
import com.example.cart.Dto.ProductDto;
import com.example.cart.Service.IProductService;
import com.example.cart.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;


@SessionAttributes("cart")
@Controller
public class ProductController {
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("cart")
    public CartDto initCartDto() {
        return new CartDto();
    }
    final
    IProductService productService;
    @GetMapping
    public String showList(@SessionAttribute(value = "cart", required = false) CartDto cartDto,
                           Model model, @CookieValue(value = "productId",
            required = false
            , defaultValue = "-1") Long id) {
            model.addAttribute("products",productService.FindAll());
            model.addAttribute("productHistory",productService.findById(id));
            if(cartDto!= null){
                model.addAttribute("cartDto",cartDto);
            }
            return "product/list";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model, HttpServletResponse response){
        Cookie cookie = new Cookie("productId",id +"");
        cookie.setMaxAge(1*24*60*60);
        cookie.setPath("/");
        response.addCookie(cookie);
        model.addAttribute("product",productService.findById(id));
        return "/product/detail";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("product",new Product());
        return "product/create";
    }
    @PostMapping("/create")
    public String createNew(@ModelAttribute("product") Product product,Model model){
        productService.Save(product);
        return "redirect:/";
    }
    @GetMapping("/add/{id}")
    public String addToCard(@PathVariable("id")Long id,
                          @ModelAttribute("cart") CartDto cartDto,
                          @RequestParam("action") String action
                         ){
//        Product product = productService.findById(id);
        Optional<Product> product1 = productService.findById2(id);
        if(action.equals("increase")){
            cartDto.addProduct(product1.get());
        }else if(action.equals("reduce")){
            cartDto.deleteProduct(product1.get());
        }else{
            cartDto.addProduct(product1.get());
        }
        return "redirect:/cart";
    }

}
