package com.protfolio.sessioneighth.controller;

import com.protfolio.sessioneighth.model.*;
import com.protfolio.sessioneighth.utility.MailHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collections;

@Controller
public class WebController {

    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping(value = "/")
    public String index(Model model){

        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setName("Taman Neupane");
        personalInfo.setAddress("Kathmandu, Nepal");
        personalInfo.setAge(30);
        personalInfo.setDescription("This is my description. \n This is second line of my description");
        personalInfo.setEmail("taman.neupane@gmail.com");
        personalInfo.setPhoneNumber("9851184633");
        personalInfo.setCvURL("https://drive.google.com/file/d/1n0GGAYj4LmGxIx3Jdm-qLDKekL1Qnwcx/view?usp=sharing");


        ArrayList<ProtfolioService> services = new ArrayList<>();
        services.add(new ProtfolioService("Web App Development", "Create web application using spring boot", ""));
        services.add(new ProtfolioService("Mobile App Development", "Create mobile application using java", ""));

        Collections.sort(services);

        ArrayList<MyEducation> myEducations = new ArrayList<>();
        myEducations.add(new MyEducation("2012-2016", "BEX", "Tribhuvan University", "Bachelor in Electronics and communication"));
        myEducations.add(new MyEducation("2012-2016", "BEX", "Tribhuvan University", "Bachelor in Electronics and communication"));
        myEducations.add(new MyEducation("2012-2016", "BEX", "Tribhuvan University", "Bachelor in Electronics and communication"));

        ArrayList<MyExperience> myExperiences = new ArrayList<>();
        myExperiences.add(new MyExperience("2012-2016", "BEX", "Tribhuvan University", "Bachelor in Electronics and communication"));
        myExperiences.add(new MyExperience("2012-2016", "BEX", "Tribhuvan University", "Bachelor in Electronics and communication"));
        myExperiences.add(new MyExperience("2012-2016", "BEX", "Tribhuvan University", "Bachelor in Electronics and communication"));


        model.addAttribute("personal", personalInfo);
        model.addAttribute("services", services);
        model.addAttribute("educations", myEducations);
        model.addAttribute("experiences", myExperiences);

        return "index";
    }

    @PostMapping(value = "/contact")
    public String contact(@ModelAttribute Contact contact){
        System.out.println("This is getting called");
        System.out.println(contact);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: ");
        stringBuilder.append(contact.getName());
        stringBuilder.append("\n");
        stringBuilder.append("Email: ");
        stringBuilder.append(contact.getEmail());
        stringBuilder.append("\n");
        stringBuilder.append("Message: ");
        stringBuilder.append(contact.getMessage());
        stringBuilder.append("\n");

        MailHelper.sendTextEmail(stringBuilder.toString(), javaMailSender);

        return "redirect:";
    }
}
