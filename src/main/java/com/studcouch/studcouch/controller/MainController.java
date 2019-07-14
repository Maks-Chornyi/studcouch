package com.studcouch.studcouch.controller;

import com.studcouch.studcouch.domain.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(name = "/")
public class MainController {

    @GetMapping("/")
    public List<Post> getAllPosts() {
        List<Post> ssss = new ArrayList<>();
        ssss.add(new Post(1L, "#шукаю_вписк #Львів", "Друзі, привіт. Шукаю компанію для автостопу Київ - Львів, 5-6-7 липня.\n" +
                "\n" + "Я в цьому початківець, але в різних нюансиках вже шарю\uD83D\uDC4CСупер, якщо у тебе є досвід. \n" +
                "Але нічого страшного, якщо немає. Здобуватимемо його разом ;)", "Микола"));
        ssss.add(new Post(3L, "#шукаю_вписк #Львів", "Друзі, привіт. Шукаю компанію для автостопу Київ - Львів, 5-6-7 липня.\n" +
                "\n" + "Я від. \n" +
                "Але нічого страшного, якщо немає. Здобуватимемо його разом ;)", "Макса"));
        ssss.add(new Post(2L, "тут будуть теги", "тут буде текст", "here should be author"));
        return ssss;
    }

}
