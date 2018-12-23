package com.itcast.controller;

import com.itcast.domain.PageBean;
import com.itcast.domain.User;
import com.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public String findAll(Model model, PageBean pageBean) throws Exception{
        System.out.println(pageBean.getUser());
        if(pageBean!=null){
            if(pageBean.getCurrentPage()==null){
                pageBean.setCurrentPage(1);
            }

            if(pageBean.getPageCount()==null){
                pageBean.setPageCount(3);
            }
        }
        List<User> userList = userService.findAll(pageBean);
        int totalCount=userService.findCount(pageBean);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage((int) Math.ceil(1.0*pageBean.getTotalCount()/pageBean.getPageCount()));
        model.addAttribute("userList",userList);
        model.addAttribute("pages",pageBean);
        return "list";
    }


    @RequestMapping("/login")
    public String findLogin(User user, HttpServletResponse response,String ck) throws Exception{
        User u=userService.findLogin(user);

        if(u!=null){
            Cookie cookieName=new Cookie("username",u.getUsername());
            Cookie cookiePwd=new Cookie("pwd",u.getPwd());

            if("1".equals(ck)){
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
        }else{
            return "loginError";
        }

    }

    @RequestMapping("/saveUser")
    public String saveUser(User user)throws Exception{
         userService.saveUser(user);
         return "redirect:/user/findAll";
    }

    @RequestMapping("/findById")
    public String findById(Integer id,Model model) throws Exception{
       User user=userService.findById(id);
       model.addAttribute("user",user);
        return "update";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user) throws Exception{
        userService.updateUser(user);
        return "redirect:/user/findAll";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(Integer id)throws Exception{
        userService.deleteUser(id);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/deleteAll")
    public String deleteAll(int[] its )throws Exception{
        userService.deleteAll(its);
        return "redirect:/user/findAll";
    }
}
