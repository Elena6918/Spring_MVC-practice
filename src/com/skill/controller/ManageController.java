package com.skill.controller;

import com.skill.domain.UserWork;
import com.skill.service.UserService;
import com.skill.domain.User;
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

    @RequestMapping("private/main")
    public String main(){
        return "private/main";
    }

    @RequestMapping("/private/composition")
    public String composition(){
        return "private/composition";
    }

    @RequestMapping("/private/composition/doUpload")
    public ModelAndView upload(@RequestParam("picture") MultipartFile picture, ModelMap modelMap,
                               HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView("private/composition");
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

    @RequestMapping("/private/composition/doSave")
    public ModelAndView save(String title, String content, String imagePath, HttpServletRequest request){
        UserWork newUserWork = new UserWork();
        newUserWork.setWorkName(title);
        newUserWork.setWorkContent(content);
        newUserWork.setCreationTime(new Date());
        newUserWork.setImagePath(imagePath);
        User currentUser = (User) request.getSession().getAttribute("user");
        newUserWork.setUserName(currentUser.getUserName());
        try{
            userService.saveUserWork(newUserWork);
            ModelAndView mav = new ModelAndView("private/composition");
            mav.addObject("info", "save successfully!");
            return mav;
        }
        catch(Exception e) {
            return new ModelAndView("private/composition", "error", e.getMessage());
        }
    }

    @RequestMapping("/private/worklist")
    public ModelAndView workList(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("private/worklist");
        User currentUser = (User) request.getSession().getAttribute("user");
        List<UserWork> workList = userService.workList(currentUser.getUserName());
        mav.addObject("workList", workList);
        return mav;
    }

    @RequestMapping("/private/work")
    public ModelAndView work(@RequestParam("workId") int workId) {
        ModelAndView mav = new ModelAndView("private/work");
        UserWork currentWork = userService.findWorkById(workId);
        mav.addObject("workId", currentWork.getWorkId());
        mav.addObject("workTitle", currentWork.getWorkName());
        mav.addObject("workContent", currentWork.getWorkContent());
        mav.addObject("time", currentWork.getCreationTime());
        mav.addObject("imagesPath", currentWork.getImagePath());
        return mav;
    }

    @RequestMapping("/private/work/doDelete")
    public String deleteWork(int workId){
        userService.deleteUserWork(workId);
        return "redirect: /private/worklist";
    }
}