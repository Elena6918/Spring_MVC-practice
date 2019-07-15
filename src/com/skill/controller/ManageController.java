package com.skill.controller;

import com.skill.domain.UserWork;
import com.skill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ManageController {
    @Autowired
    private UserService userService;

    @RequestMapping("/upload")
    public ModelAndView upload(@RequestParam("picture") MultipartFile picture, ModelMap modelMap) throws Exception {
        modelMap.addAttribute("picture", picture);
        System.out.println(picture.getOriginalFilename());
        return new ModelAndView("composition", "info", "upload successfully!");
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request, String textarea){
//        String workContent = request.getParameter("textarea");
        UserWork newUserWork = new UserWork();
        newUserWork.setWorkContent(textarea);
        newUserWork.setCreationTime(new Date());
        try{
            userService.saveUserWork(newUserWork);
            return new ModelAndView("composition", "info", "save successfully!");
        }
        catch(Exception e) {
            return new ModelAndView("composition", "error", e.getMessage());
        }
    }
    @RequestMapping("/composition")
    public String composition(){
        return "composition";
    }
}