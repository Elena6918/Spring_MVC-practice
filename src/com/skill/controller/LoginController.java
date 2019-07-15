package com.skill.controller;

import com.skill.domain.LoginCommand;
import com.skill.domain.User;
import com.skill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/loginCheck")
    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand) {
        boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
        if (!isValidUser) {
            return new ModelAndView("login", "error", "invalid username or password.");
        } else {
            User user = userService.findUserByUserName(loginCommand.getUserName());
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);
            request.getSession().setAttribute("user", user);
            return new ModelAndView("main");
        }
    }

    @RequestMapping(value = "/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/registering")
    public ModelAndView registering(HttpServletRequest request, LoginCommand loginCommand) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (StringUtils.isEmpty(username)) {
            return new ModelAndView("register", "error", "Username cannot be null.");
        }
        if (StringUtils.isEmpty(password)) {
            return new ModelAndView("register", "error", "Password cannot be null.");
        }

//      test name repetition
        User user;
        try {
            user = userService.findUserByUserName(username);
        } catch (Exception e) {
            user = null;
        }
        if (user.getUserName() == username) {
            return new ModelAndView("register", "error", "The username is registered.");
        }

        User newUser = new User();
        newUser.setUserName(username);
        newUser.setPassword(password);
        loginCommand.setUserName(username);
        loginCommand.setPassword(password);
        try {
            userService.insert(newUser);
            return new ModelAndView("register", "info", "registration success");
        } catch (Exception e) {
            return new ModelAndView("register", "error", e.getMessage());
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "login";
    }
}