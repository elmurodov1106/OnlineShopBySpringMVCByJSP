package uz.g22.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import uz.g22.service.history.HistoryService;
import uz.g22.service.product.ProductService;
import uz.g22.service.user.UserService;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class HistoryController {

    private final HistoryService historyService;
    private final ProductService productService;
    private final UserService userService;
    @GetMapping("/my-history/{id}")
    public String allProductPage(
            @PathVariable UUID id,
            Model model
    ){
        model.addAttribute("histories",historyService.getUserHistories(id));
        model.addAttribute("userId",id);
        return "seller/history";
    }


    @GetMapping("/delete-history/{id}")
    public String deleteProduct(
            @PathVariable UUID id,
            @RequestParam UUID userId,
            Model model
    ){
        historyService.deleteById(id);
        model.addAttribute("histories",historyService.getUserHistories(userId));
        model.addAttribute("userId",userId);
        return "seller/history";
    }


}
