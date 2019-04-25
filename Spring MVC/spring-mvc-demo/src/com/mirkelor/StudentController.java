package com.mirkelor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptions}")
    private Map<String, String> countryOptions;

    @Value("#{languageOptions}")
    private Map<String, String> languageOptions;

    @Value("#{operationOptions}")
    private Map<String, String> operationOptions;

    @RequestMapping("/showForm")
    public String showForm(Model model){

        // create a student object
        Student student = new Student();

        // add student object to the model
        model.addAttribute("student", student);

        // add country options to the model
        model.addAttribute("countryOptions", countryOptions);

        // add language options to the model
        model.addAttribute("languageOptions", languageOptions);

        // add operation options to the model
        model.addAttribute("operationOptions", operationOptions);

        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student){

        // log the input data
        System.out.println(student.toString());

        return "student-confirmation";
    }
}
