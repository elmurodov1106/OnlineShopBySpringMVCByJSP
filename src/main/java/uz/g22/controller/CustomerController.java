package uz.g22.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.g22.dto.OrderCreateDto;
import uz.g22.dto.ProductCreateDto;
import uz.g22.entity.card.CardEntity;
import uz.g22.entity.order.OrderEntity;
import uz.g22.entity.product.Product;
import uz.g22.entity.user.User;
import uz.g22.entity.user.UserRole;
import uz.g22.service.card.CardService;
import uz.g22.service.history.HistoryService;
import uz.g22.service.order.OrderService;
import uz.g22.service.product.ProductService;
import uz.g22.service.user.UserService;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final ProductService productService;
 private  final OrderService orderService;
    private final UserService userService;
    private final CardService cardService;
    private final HistoryService historyService;

    @GetMapping("/all-products/{id}")
    public String allProduct(
            @PathVariable UUID id,
            Model model
    ){
        model.addAttribute("userId",id);
        model.addAttribute("allProducts",productService.getAllProducts());
        return "customer/AllProducts";
    }
    @GetMapping("/buy-product/{id}")
    public String buyProductPage(
            @PathVariable UUID id,
            @RequestParam UUID productId,
            Model model
    ){
        model.addAttribute("userId",id);
        model.addAttribute("cards",cardService.getUserCards(id));
        model.addAttribute("productId",productId);
        return "customer/buyProduct";
    }
    @PostMapping("/buy-product/{id}")
    public String buyProduct(
            @PathVariable UUID id,
            @RequestParam UUID productId,
            @ModelAttribute OrderCreateDto order,
            Model model
    ){
//        System.out.println("order.getCard().getBalance() = " + order.getCard().getBalance());
        List<CardEntity> userCards = cardService.getUserCards(id);
        Product byId = productService.getById(productId);
        if (order.getAmount() > byId.getAmount()){
            model.addAttribute("message","the number of products is not enough");
            model.addAttribute("orders", orderService.getUserOrders(id));
            model.addAttribute("cards",cardService.getUserCards(id));
            model.addAttribute("userId", id);
            model.addAttribute("productId", productId);
            return "customer/buyProduct";
        }
//        for (CardEntity userCard : userCards) {
//            if (userCard.getNumber().equals(order.getCard().getNumber())){
//            cardService.updateBalance(userCard.getId(), byId.getPrice());
//
//            }
//        }
        orderService.add(order,id,productId);
        model.addAttribute("orders", orderService.getUserOrders(id));
        model.addAttribute("userId", id);
        model.addAttribute("productId", productId);
        model.addAttribute("cards",cardService.getUserCards(id));
        User user = userService.getById(id);
        model.addAttribute("user",user);
        if (user.getRole().equals(UserRole.SELLER)){
            return "seller/seller";
        } else if (user.getRole().equals(UserRole.CUSTOMER)) {
            return "customer/customer";
        }
        return "admin/admin";
    }

    @GetMapping("/my-orders/{id}")
    public String allProductPage(
            @PathVariable UUID id,
            Model model
    ){

        model.addAttribute("orders",orderService.getUserOrders(id));
        model.addAttribute("userId",id);
        return "customer/orderList";
    }
    @GetMapping("/delete-order/{id}")
    public  String deleteOrder(
            @PathVariable UUID id,
            @RequestParam UUID orderId,
            Model model
    ){
        orderService.deleteById(orderId);
        model.addAttribute("orders",orderService.getUserOrders(id));
        model.addAttribute("orderId",orderId);
        model.addAttribute("userId",id);
//        model.addAttribute("orderId",id);
        return "customer/orderList";

    }

    @GetMapping("/update-order/{id}")
    public String updateProductPage(
            @PathVariable UUID id,
            @RequestParam UUID userId,
            Model model
    ){
//        model.addAttribute("products",productService.getUserProducts(userId));
        model.addAttribute("userId",userId);
        model.addAttribute("orderId",id);
        return "customer/updateOrder";
    }
    @PostMapping("/update-order/{id}")
    public String updateProduct(
            @PathVariable UUID id,
            @RequestParam UUID userId,
            @ModelAttribute OrderCreateDto update,
//            @ModelAttribute HistoryCreateDto history,
            Model model
    ){
        orderService.update(update,id,userId);
//        historyService.add(update,id,userId);
        model.addAttribute("orders", orderService.getUserOrders(userId));
        model.addAttribute("userId", userId);
        model.addAttribute("orderId",id);
        User user = userService.getById(userId);
        model.addAttribute("user",user);
        if (user.getRole().equals(UserRole.SELLER)){
            return "seller/seller";
        } else if (user.getRole().equals(UserRole.CUSTOMER)) {
            return "customer/customer";
        }
        return "admin/admin";
    }


}
