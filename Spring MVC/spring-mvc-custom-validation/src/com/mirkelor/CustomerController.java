package com.mirkelor;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    private Customer customer;
    private BindingResult bindingResult;

    // add an initbinder ... to convert trim input strings
    // remove leading and trailing whitespace
    // resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/")
    public String showMain(){
        return "main-menu";
    }

    @RequestMapping("/showForm")
    public String showForm(Model model){

        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer,
                              BindingResult bindingResult){
        this.customer = customer;
        this.bindingResult = bindingResult;
        System.out.println("Customer Last Name: |" + customer.getLastName() + "|");
        System.out.println("Binding Result: " + bindingResult);
        System.out.println("\n\n\n\n");
        if(bindingResult.hasErrors()){
            return "customer-form";
        } else {
            return "customer-confirmation";
        }
    }
}
