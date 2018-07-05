package wxgaly.example.springboot.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;

/**
 * wxgaly.example.springboot.api.UploadFileController
 *
 * @author Created by WXG on 2018/6/5 005 13:48.
 * @version V1.0
 */
@Controller
//@RequestMapping("/upload")
public class UploadFileController {

    //跳转到上传文件的页面
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String goUploadImg() {
        //跳转到 templates 目录下的 uploadimg.html
        return "thymeleaf/uploadimg";
    }

    //处理文件上传
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);
//        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        String filePath = "E:\\imgupload\\";
        System.out.println("filePath-->" + filePath);
        try {
            System.out.println("getBytes-->" + file.getBytes().length);
            uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        //返回json
        return "uploadimg success";
    }

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
