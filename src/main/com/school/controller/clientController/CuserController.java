package school.controller.clientController;

import com.alibaba.fastjson.JSONObject;
import school.bean.User;
import school.service.TaskService;
import school.service.UserService;
import school.util.ImageToUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/*
* 用的是谷歌的gson
*/
@Controller
@RequestMapping("")
public class CuserController {
    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;
    // 客户端登录处理
    @RequestMapping("/cLogin")
    @ResponseBody
    public JSONObject cLogin(String userStr){
        System.out.println(userStr);
        JSONObject jsonObject = new JSONObject();
        User user = userService.isLoginSuccess(JSONObject.parseObject(userStr, User.class));
        if (user==null){
            // 没有查询到
            jsonObject.put("user","loginfail");
            return jsonObject;
        }else {
            // 密码置空
            user.setPassword("");
            // 返回用户信息
            jsonObject.put("user",user);
            return jsonObject;
        }
    }
    // 客户端注册处理
    @RequestMapping("/register")
    @ResponseBody
    public JSONObject cRegister(String userStr){
        JSONObject jsonObject = new JSONObject();
        System.out.println(userStr);
        int row = userService.addUser(JSONObject.parseObject(userStr,User.class));
        if (row==0){
            // 用户已存在
            jsonObject.put("user","exists");
            return jsonObject;
        }
        // 成功注册
        jsonObject.put("user","successregister");
        return  jsonObject;
    }
    // 客户端完善信息
    @RequestMapping("/perfectInformation")
    @ResponseBody
    public JSONObject perfectInformation(MultipartFile file, String userStr, HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        // 这里的路径由于idea热部署的原因不会将项目部署到tomcat目录下，所有手动创建路径
        // 1.先将文件保存在本地服务器上
        // 1.1获得文件名，客户端中均以该用户账户命名
        String fileName = file.getOriginalFilename();
        File uploadFile = new File("E:/idea/ideaCode/schoolApp/images",fileName);
        if (!uploadFile.exists()){
            // 文件不存在
            try {
                uploadFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            // 对图片进行解析看是否能生成二维码url
            file.transferTo(uploadFile);
            String s = ImageToUrl.testDecode(uploadFile.getAbsolutePath());
            if (s.equals("")){
                // 解析失败
                jsonObject.put("user","picfail");
                // 删除文件
                uploadFile.delete();
                return jsonObject;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 2.往数据库中填信息
        User user = JSONObject.parseObject(userStr,User.class);
        // 2.1 修改文件存放位置
        user.setPath(uploadFile.getAbsolutePath());
        // 2.2 数据库操作
        int row = userService.updateUserByC(user);
        if (row!=0){
            // 成功
            jsonObject.put("user","successperfect");
            return jsonObject;
        }
        jsonObject.put("user","");
        return jsonObject; // 没有成功
    }
    // 获取用户二维码图片
    @RequestMapping("/getUserImage")
    public void getUserPayImage(int account, HttpServletRequest request, HttpServletResponse response) {
        // 1.取得文件
        File userFile = taskService.getUserFile(account);
        // 2.返回给客户端
        InputStream inputStream = null;
        OutputStream outputStream =null;
        try {
            // 获取输入流
            inputStream = new FileInputStream(userFile);
            // 创建输出流
            outputStream = response.getOutputStream();
            // 创建缓冲区
            byte buffer[] = new byte[1024];
            int len = 0;
            // 循环将输入流中的内容读取到缓冲区当中
            while ((len = inputStream.read(buffer)) > 0) {
                // 输出缓冲区的内容到浏览器，实现文件下载
                outputStream.write(buffer, 0, len);
                outputStream.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (inputStream!=null)
                    inputStream.close();
                if (outputStream!=null)
                    outputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
