package com.mirkelor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    // need a controller method to show the inital HTML form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    // need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    // need a controller method to read form data and
    // add data to the model

    @RequestMapping("/processFormVerTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

        // read the request parameter from the HTML form
        String name = request.getParameter("studentName");

        // convert the data all caps
        name = name.toUpperCase();

        // create the message
        String result = "Hey " + name + " STOP!";

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("/processFormVerThree")
    public String processFormVerThree(@RequestParam("studentName") String name, Model model){

        // read the request parameter from the HTML form

        // convert the data all caps
        name = name.toUpperCase();

        // create the message
        String result = "Hey You " + name + " STOP!";

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

}
