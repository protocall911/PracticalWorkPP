//package com.example.PracticalWorkPP.controllers;
//
//import com.example.PracticalWorkPP.models.Role;
//import com.example.PracticalWorkPP.models.Shop;
//import com.example.PracticalWorkPP.models.User;
//import com.example.PracticalWorkPP.repository.RoleRepository;
//import com.example.PracticalWorkPP.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.ArrayList;
//
//@Controller
//public class UserRoleController {
////    @Autowired
////    private UserRepository userRepository;
////    @Autowired
////    private RoleRepository roleRepository;
////    @GetMapping("/user")
////    public String Main(Model model){
////        Iterable<Role> role = roleRepository.findAll();
////        ArrayList<Role> roleArrayList = new ArrayList<>();
////        for (Role user_role: role) {
////            if (user_role.getUser() == null) {
////                roleArrayList.add(user_role);
////            }
////        }
////        Iterable<User> users = userRepository.findAll();
////        model.addAttribute("users", users);
////        model.addAttribute("role", role);
////        return "user/index";
////    }
////
////    @PostMapping("/user/add")
////    public String userRoleAdd(@RequestParam String username, @RequestParam String nameRole, Model model)
////    {
////        System.out.println(username);
////        Role role = roleRepository.findByName(nameRole);
////        System.out.println(role.getId());
////        User user = new User(username, role);
////        userRepository.save(user);
////        return "redirect:/user";
////    }
//}
