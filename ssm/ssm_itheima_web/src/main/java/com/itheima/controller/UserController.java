package com.itheima.controller;

import com.itheima.domain.PageBean;
import com.itheima.domain.User;
import com.itheima.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Currency;
import java.util.List;

/**
 * @author: liwei
 * @Date: 2018-12-16
 */
@Controller
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/findAll")
    public String findAll(PageBean pageBean, Model model) throws Exception {

        if (pageBean != null) {

            if (pageBean.getCurrentPage() == null) {
                pageBean.setCurrentPage(1);
            }
            if (pageBean.getRows() == null) {
                pageBean.setRows(4);
            }

        }

        int totalCount = userService.findTotalCount(pageBean);
        System.out.println(pageBean.getUser());
        int totalPage = (int) Math.ceil(totalCount * 1.0 / pageBean.getRows());
        int start = (pageBean.getCurrentPage() - 1) * pageBean.getRows();
        pageBean.setStart(start);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalPage);
        List<User> userList = userService.findAll(pageBean);
        model.addAttribute("userList", userList);
        model.addAttribute("pb", pageBean);
        return "list";
    }

    @RequestMapping("/login")
    public String login(User user, HttpSession session, HttpServletResponse response,String rem) throws Exception {
        User u = userService.login(user);
        if (u != null) {
            session.setAttribute("user", user);

            Cookie cookieName=new Cookie("username",u.getUsername());

            Cookie cookiePwd=new Cookie("password",u.getPassword());

            if("1".equals(rem)){

                cookieName.setMaxAge(7*24*60*60);
                cookiePwd.setMaxAge(7*24*60*60);
            }else{

                cookieName.setMaxAge(0);
                cookiePwd.setMaxAge(0);
            }

            cookieName.setPath("/");
            cookiePwd.setPath("/");

            response.addCookie(cookieName);
            response.addCookie(cookiePwd);
            return "index1";
        } else {
            return "loginError";
        }
    }


    @RequestMapping("/saveUser")
    public String SaveUser(User user) {

        userService.save(user);

        return "forward:/user/findAll";
    }

    @RequestMapping("/deleteById")
    public String deleteUser(int id) {
        userService.deleteById(id);
        return "forward:/user/findAll";
    }

    @RequestMapping("/delSelectedUser")
    public String delSelectedUser(HttpServletRequest request) {
        String[] uids = request.getParameterValues("uid");
        for (String uid : uids) {
            int id = Integer.parseInt(uid);
            userService.deleteById(id);
        }
        return "forward:/user/findAll";
    }

    @RequestMapping("/findById")
    public String findById(int id, Model model) {
        User user = userService.findById(id);
        System.out.println(user);
        model.addAttribute("user", user);
        return "update";
    }

    @RequestMapping("/update")
    public String update(User user) {
        userService.update(user);
        return "forward:/user/findAll";
    }


}