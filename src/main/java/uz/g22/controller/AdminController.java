package uz.g22.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import uz.g22.entity.product.Product;
import uz.g22.entity.user.User;
import uz.g22.entity.user.UserRole;
import uz.g22.service.order.OrderService;
import uz.g22.service.product.ProductService;
import uz.g22.service.user.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final ProductService productService;
    private  final OrderService orderService;
    private final UserService userService;

    @GetMapping("/all-products-admin/{id}")
    public String allProductAdmin(
            @PathVariable UUID id,
            Model model
    ){
        model.addAttribute("userId",id);

        model.addAttribute("allProducts",productService.getAllProducts());
        return "admin/allProduct";
    }
    @GetMapping("/delete-admin-product/{id}")
    public String deleteProduct(
            @PathVariable UUID id,
            @RequestParam UUID productId,
            Model model
    ){
        productService.deleteById(productId);
        model.addAttribute("products",productService.getUserProducts(id));
        model.addAttribute("userId",id);
        return "admin/allProduct";
    }

    @GetMapping("/all-orders/{id}")
    public String AllOrders(
            @PathVariable UUID id,
            Model model
    ){
        model.addAttribute("AllOrders",orderService.getAllOrders());
        model.addAttribute("userId",id);
        return "admin/allOrders";
    }
    @GetMapping("/delete-order-admin/{id}")
    public  String deleteOrder(
            @PathVariable UUID id,
            @RequestParam UUID orderId,
            Model model
    ){
        orderService.deleteById(orderId);
        model.addAttribute("AllOrders",orderService.getAllOrders());
        model.addAttribute("orderId",orderId);
        model.addAttribute("userId",id);
//        model.addAttribute("orderId",id);
        return "admin/allOrders";

    }

    @GetMapping("/all-users-admin/{id}")
    public String allUsersAdmin(
            @PathVariable UUID id,
//            @ModelAttribute User user,
            Model model
    ){
        model.addAttribute("userId",id);
        User user = userService.getById(id);
        model.addAttribute("user",user);
        model.addAttribute("allUsers",userService.allUser());
        return "admin/allUsers";
    }

    @GetMapping("/block-users/{id}")
    public String blockUsers(
            @PathVariable UUID id,
//            @ModelAttribute User user,
            Model model
    ){
        model.addAttribute("userId",id);
        User user = userService.getById(id);
        model.addAttribute("user",user);
        model.addAttribute("allUsers",userService.allUser());
        return "admin/allBlockUsers";
    }

    @GetMapping("/delete-user/{id}")
    public  String deleteUser(
            @PathVariable UUID id,
//            @RequestParam UUID orderId,
            Model model
    ){
        userService.deleteById(id);
        User user = userService.getById(id);
        model.addAttribute("user",user);
        model.addAttribute("allUsers",userService.allUser());
//        model.addAttribute("orderId",orderId);
        model.addAttribute("userId",id);
//        model.addAttribute("orderId",id);
        return "admin/allUsers";

    }

    @GetMapping("/block-user/{id}")
    public String BlockUser(
            @PathVariable UUID id,
//           @ModelAttribute User user1,
            Model model
    ){
        model.addAttribute("userId",id);
        User user = userService.getById(id);
        List<Product> userProducts = productService.getUserProducts(id);
//        if (userProducts == null){
//             model.addAttribute("message","these are the products that the user can not block it");
//        }
        userService.updateRole(UserRole.BLOCK,id);
        model.addAttribute("user",user);
        model.addAttribute("allUsers",userService.allUser());
        return "admin/allUsers";
    }


    @GetMapping("/unblock-users/{id}")
    public String UnBlockUser(
            @PathVariable UUID id,
//           @ModelAttribute User user1,
            Model model
    ){
        model.addAttribute("userId",id);
        User user = userService.getById(id);
        userService.updateRole(UserRole.UNBLOCK,id);
        List<User> userList = new ArrayList<>();
        for (User user1 : userService.allUser()) {
            if (user1.getRole().equals(UserRole.BLOCK)){
                userList.add(user1);
            }
        }
        model.addAttribute("user",user);
        model.addAttribute("user1",userList);
        return "admin/allBlockUsers";
    }


}
