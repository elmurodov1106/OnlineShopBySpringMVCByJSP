package uz.g22.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.g22.dto.FillBalanceDto;
import uz.g22.entity.card.CardEntity;
import uz.g22.entity.user.User;
import uz.g22.entity.user.UserRole;
import uz.g22.service.card.CardService;
import uz.g22.service.user.UserService;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;
    private final UserService userService;

    @GetMapping("/add-card/{id}")
    private String addcardPage(
            @PathVariable UUID id,
            Model model
            ){
        model.addAttribute("userId",id);
        return "customer/AddCard";
    }
    @PostMapping("/add-card/{id}")
    public String addCard(
            @PathVariable UUID id,
            @ModelAttribute CardEntity card,
            Model model
    ){
        User user = userService.getById(id);

        for (CardEntity allCard : cardService.getAllCards()) {
            if (allCard.getNumber().equals(card.getNumber())){
                model.addAttribute("message","this number is already used");
                 model.addAttribute("userCards",cardService.getUserCards(id));
                model.addAttribute("user",user);
                model.addAttribute("userId",id);
                return "customer/AddCard";
            }
        }
        cardService.add(card,id);
        model.addAttribute("userId",id);
        model.addAttribute("user",user);
        model.addAttribute("userCards",cardService.getUserCards(id));
        if (user.getRole().equals(UserRole.SELLER)){
            return "seller/seller";
        } else if (user.getRole().equals(UserRole.CUSTOMER)) {
            return "customer/customer";
        }
        return "admin/admin";
    }

    @GetMapping("/my-cards/{id}")
    public String MyCards(
            @PathVariable UUID id,
            Model model
    ){
        model.addAttribute("userCards",cardService.getUserCards(id));
        model.addAttribute("userId",id);
        return "customer/cardList";
    }
    @GetMapping("/delete-card/{id}")
    public  String deleteOrder(
            @PathVariable UUID id,
            @RequestParam UUID cardId,
            Model model
    ){
         cardService.deleteById(cardId);
        model.addAttribute("userCards", cardService.getUserCards(id));
        model.addAttribute("cardId",cardId);
        model.addAttribute("userId",id);
        return "customer/cardList";

    }

    @GetMapping("/fill-balance/{id}")
    private String fillBalancePage(
            @PathVariable UUID id,
            Model model
    ){
        model.addAttribute("userId",id);
        return "customer/fillBalance";
    }
    @PostMapping("/fill-balance/{id}")
    public String fillBalance(
            @PathVariable UUID id,
            @ModelAttribute FillBalanceDto fillBalance,
            Model model
    ){
        User user = userService.getById(id);
        List<CardEntity> userCards = cardService.getUserCards(id);

        for (CardEntity userCard : userCards) {
            if (userCard.getNumber().equals(fillBalance.getReceiver_number())){
                cardService.updateBalance(userCard.getId(),fillBalance.getAmount());
                model.addAttribute("userCards", cardService.getUserCards(id));
                model.addAttribute("userId",id);
                model.addAttribute("user",user);

            }else {
                model.addAttribute("message","No such card was found in your cards");
                model.addAttribute("userCards", cardService.getUserCards(id));
                model.addAttribute("userId",id);
                model.addAttribute("user",user);
                return "customer/fillBalance";
            }
        }
//        List<CardEntity> userCards = cardService.getUserCards(id);
//        for (CardEntity userCard : userCards) {
//            if (userCard.getNumber().equals(fillBalance.getSender_number())
//                    && userCard.getBalance() >= fillBalance.getAmount()
//                    && !fillBalance.getSender_number().equals(fillBalance.getReceiver_number())) {
//
//                userCard.setBalance(userCard.getBalance() - fillBalance.getAmount());
//
//                for (CardEntity card : userCards) {
//                    if (card.getNumber().equals(fillBalance.getReceiver_number())) {
//                        card.setBalance(card.getBalance() + fillBalance.getAmount());
//                        cardService.update(card, id);
//                    }
//                }
//
//                cardService.update(userCard, id);
//            }
//        }

        model.addAttribute("userCards", cardService.getUserCards(id));
        model.addAttribute("userId",id);
        model.addAttribute("user",user);
        if (user.getRole().equals(UserRole.SELLER)){
            return "seller/seller";
        } else if (user.getRole().equals(UserRole.CUSTOMER)) {
            return "customer/customer";
        }
        return "admin/admin";
    }


}
