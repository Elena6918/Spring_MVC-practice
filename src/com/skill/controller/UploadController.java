package com.skill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
    @RequestMapping("/upload")
    public ModelAndView upload(@RequestParam("picture") MultipartFile picture, ModelMap modelMap) throws Exception {
        modelMap.addAttribute("picture", picture);
        System.out.println(picture.getOriginalFilename());
        return new ModelAndView("composition", "info", "upload successfully!");
    }

    @RequestMapping("/composition")
    public String composition(){
        return "composition";
    }
}
