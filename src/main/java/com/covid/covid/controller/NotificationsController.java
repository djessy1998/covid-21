package com.covid.covid.controller;

import com.covid.covid.model.Activite;
import com.covid.covid.model.Notification;
import com.covid.covid.model.User;
import com.covid.covid.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class NotificationsController {

    @Autowired
    private NotificationRepository notificationRepository;

    @RequestMapping(value = "/dashboard/notifications", method = RequestMethod.GET)
    public String afficherNotifications(Model model) {

        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Notification> notifications = notificationRepository.findNotifications((int)principal.getUserId());

        for(Notification notification : notifications){
            notification.setVue(true);
            notificationRepository.save(notification);
        }

        model.addAttribute("notifications", notifications);

        return "notifications";
    }
}
