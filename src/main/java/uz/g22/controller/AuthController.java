package uz.g22.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import uz.g22.entity.user.User;
import uz.g22.entity.user.UserRole;
import uz.g22.service.user.UserService;

@Controller
@RequiredArgsConstructor

public class AuthController {

    private final UserService userService;


    @RequestMapping(value = "/sign-up",method = RequestMethod.GET)
    public String signUpPage(){
        return "signUp";
    }
    @RequestMapping(value = "/sign-up",method = RequestMethod.POST)
    public String signUp(
            @ModelAttribute User user,
            @RequestParam String role,
            Model model

    ){
        user.setRole(UserRole.valueOf(role));
       if( userService.add(user)==400){
           model.addAttribute("message","Bad email or password");
        return "singUp";
       }
         return "signIn";
    }

    @RequestMapping(value = "/sign-in",method = RequestMethod.GET)
    public String signInPage(){
        return "signIn";
    }

    @RequestMapping(value = "/sign-in",method = RequestMethod.POST)
    public String signIn(
            @RequestParam String email,
            @RequestParam String password,
            Model model){
        System.out.println("email = " + email);
        System.out.println("password = " + password);
        User user = userService.signIn(email, password);
        if (user != null){
            model.addAttribute(user);
          //  model.addAttribute(productService.getUserProducts(user.getId()));
            if (user.getRole().equals(UserRole.SELLER)){
                return "seller/seller";
            } else if (user.getRole().equals(UserRole.CUSTOMER)) {
                return "customer/customer";
            }else if (user.getRole().equals(UserRole.BLOCK)){
                model.addAttribute("message","You have been blocked by the admin because " +
                        "you did not use the program correctly");
                return "signIn";
            }else if (user.getRole().equals(UserRole.UNBLOCK)){
                userService.updateRole(UserRole.CUSTOMER,user.getId());
//                userService.deleteById(user.getId());
                return "signIn";
            }
            return "admin/admin";
        }else {
            return "signUp";
        }
    }

}
