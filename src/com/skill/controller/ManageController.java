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
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;



@Controller
public class ManageController {
    @Autowired
    private UserService userService;

    @RequestMapping("/upload")
    public ModelAndView upload(@RequestParam("picture") MultipartFile picture, ModelMap modelMap,
                               HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView("composition");
        modelMap.addAttribute("picture", picture);
        String pathRoot = request.getSession().getServletContext().getRealPath("");
        String path="";
        if(!picture.isEmpty()){
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            String contentType=picture.getContentType();
            String imageName=contentType.substring(contentType.indexOf("/")+1);
            path="/resources/image/"+uuid+"."+imageName;
            picture.transferTo(new File(pathRoot+path));
            modelMap.addAttribute("imagesPath", path);
            mav.addObject("info", "upload successfully!");
            return mav;
        }
        mav.addObject("info", "no image selected.");
        return mav;
    }

    @RequestMapping("/save")
    public ModelAndView save(String title, String content, String imagePath){
        UserWork newUserWork = new UserWork();
        newUserWork.setWorkName(title);
        newUserWork.setWorkContent(content);
        newUserWork.setCreationTime(new Date());
        newUserWork.setImagePath(imagePath);
        try{
            userService.saveUserWork(newUserWork);
            ModelAndView mav = new ModelAndView("composition");
            mav.addObject("info", "save successfully!");
            return mav;
        }
        catch(Exception e) {
            return new ModelAndView("composition", "error", e.getMessage());
        }
    }

    @RequestMapping("/composition")
    public String composition(){
        return "composition";
    }

    @RequestMapping("/worklist")
    public ModelAndView workList(){
        ModelAndView mav = new ModelAndView("worklist");
        List<UserWork> workList = userService.workList();
        mav.addObject("workList", workList);
        return mav;
    }

    @RequestMapping("/work")
    public ModelAndView work(@RequestParam("workName") String workName) {
        ModelAndView mav = new ModelAndView("work");
        UserWork currentWork = userService.findWorkByWorkName(workName);
        mav.addObject("workTitle", currentWork.getWorkName());
        mav.addObject("workContent", currentWork.getWorkContent());
        mav.addObject("time", currentWork.getCreationTime());
        mav.addObject("imagesPath", currentWork.getImagePath());
        System.out.println(currentWork.getImagePath());
        return mav;
    }
}