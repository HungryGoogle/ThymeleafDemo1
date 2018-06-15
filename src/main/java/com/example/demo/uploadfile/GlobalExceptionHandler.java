package com.example.demo.uploadfile;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    //https://jira.spring.io/browse/SPR-14651
    //4.3.5 supports RedirectAttributes redirectAttributes
    @ExceptionHandler(MultipartException.class)
    public String handleError1(MultipartException e, RedirectAttributes redirectAttributes) {
        if(redirectAttributes != null && e != null && e.getCause() != null) {
            redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
        }

        System.out.println("handleError1");
        return "redirect:/file/uploadStatus";
    }
}