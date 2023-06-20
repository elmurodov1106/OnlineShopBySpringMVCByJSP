package uz.g22.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.g22.dto.HistoryCreateDto;
import uz.g22.dto.ProductCreateDto;
import uz.g22.entity.user.User;
import uz.g22.entity.user.UserRole;
import uz.g22.service.history.HistoryService;
import uz.g22.service.product.ProductService;
import uz.g22.service.user.UserService;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final UserService userService;
    private final HistoryService historyService;

    @GetMapping(value = "/add-product/{id}")
    public String AddProduct(
            @PathVariable UUID id,
            Model model
    ){
        model.addAttribute("userId",id);
        return "seller/addProduct";
    }
    @PostMapping(value = "/add-product/{id}")
    public String addProductPage(
            @RequestParam String category,
            @PathVariable UUID id,
            @ModelAttribute ProductCreateDto product,
            Model model
    ){
        product.setCategory(category);
         productService.add(product,id);
        User user = userService.getById(id);
        model.addAttribute("user",user);
            return "seller/seller";


    }



    @GetMapping("/all-product/{id}")
    public String allProductPage(
            @PathVariable UUID id,
            Model model
    ){
        model.addAttribute("products",productService.getUserProducts(id));
        model.addAttribute("userId",id);
        return "seller/ProductList";
    }


    @GetMapping("/delete-product/{id}")
    public String deleteProduct(
            @PathVariable UUID id,
            @RequestParam UUID userId,
            Model model
    ){
        productService.deleteById(id);
        model.addAttribute("products",productService.getUserProducts(userId));
        model.addAttribute("userId",userId);
        model.addAttribute("productId",id);
        return "seller/ProductList";
    }
    @GetMapping("/update-product/{id}")
    public String updateProductPage(
            @PathVariable UUID id,
            @RequestParam UUID userId,
            Model model
    ){
        model.addAttribute("products",productService.getUserProducts(userId));
        model.addAttribute("userId",userId);
        model.addAttribute("productId",id);
        return "seller/updateProduct";
    }

    @GetMapping("/menu")
    public String Menu(
            @RequestParam UUID userId,
            Model model
    ){
        User user = userService.getById(userId);
        model.addAttribute("user",user);
        model.addAttribute("userId",userId);
if (user.getRole().equals(UserRole.SELLER)){
            return "seller/seller";
        } else if (user.getRole().equals(UserRole.CUSTOMER)) {
            return "customer/customer";
        }
        return "admin/admin";
    }
    @PostMapping("/update-product/{id}")
    public String updateProduct(
            @PathVariable UUID id,
            @RequestParam UUID userId,
            @ModelAttribute ProductCreateDto update,
//            @ModelAttribute HistoryCreateDto history,
            Model model
    ){
        productService.update(update,id,userId);
        historyService.add(update,id,userId);
        model.addAttribute("products", productService.getUserProducts(userId));
        model.addAttribute("userId", userId);
        model.addAttribute("histories",historyService.getUserHistories(userId));

    return "seller/seller";
    }





}
