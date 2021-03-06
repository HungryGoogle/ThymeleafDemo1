package com.example.demo.uploadfile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/uploadfile")
public class UploadFileController {
    private static String UPLOADED_FOLDER = "d://temp//";

    @GetMapping("/")
    public String index() {
        System.out.println("fileupload");
        return "/file/fileupload";
    }

//    http://localhost:8080/uploadfile/upload
    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        System.out.println("singleFileUpload");

        if (file.isEmpty()) {
            System.out.println("isEmpty");
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");

            // 这里重定向的是request mapping里面的参数
            return "redirect:/uploadfile/uploadStatus";
        }

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadfile/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        System.out.println("-------->uploadStatus");
        return "/file/uploadStatus";
    }
}
