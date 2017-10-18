package cn.hn.bookstore.controller;

import cn.hn.bookstore.po.Category;
import cn.hn.bookstore.po.Page;
import cn.hn.bookstore.po.User;
import cn.hn.bookstore.service.BusinessService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huangning on 2017/9/30.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    Logger logger = Logger.getLogger("hn");
    @Autowired
    private BusinessService service ;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/queryAll")
    public ModelAndView queryAll(String pageNum,String category_id){
        List<Category> categories = service.getAllCategory();
        //request.setAttribute("categories", categories);
        //String pagenum = pagenum;
        //String category_id = request.getParameter("category_id");
        Page page = service.getPageData(pageNum, category_id);
        //request.setAttribute("page", page);
        //request.getRequestDispatcher("/client/body.jsp").forward(request, response);
        Map<String,Object> model = new HashMap<>();
        model.put("page",page);
        model.put("categories",categories);
        return new ModelAndView("client/body",model);

    }
    @RequestMapping("/head")
    public String head(){
        return "client/head";
    }
    @RequestMapping("buycart")
    public String buycart(){
        return "client/buycart";
    }
    @RequestMapping("login")
    public ModelAndView login(String username, String password, HttpSession session){
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        BusinessServiceImpl service = new BusinessServiceImpl();
        Map<String,Object> model = new HashMap<>();
        String resultView;

        User user = service.findUser(username,password);
        if(user == null){
//            request.setAttribute("message", "username or password is wrong");
//            request.getRequestDispatcher("/message.jsp");
            model.put("message","username or password is wrong");
            resultView = "message";
            return new ModelAndView(resultView,model);
        }
//        request.getSession().setAttribute("user", user);
//        request.getRequestDispatcher("/client/head.jsp").forward(request, response);
        session.setAttribute("user",user);
        model.put("user",user);
        resultView = "client/head";

        return new ModelAndView(resultView,model);
    }
    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "client/head";
    }
    @RequestMapping("registerUI")
    public String registerUI(Model model){
        model.addAttribute(new User());
        return "client/register";
    }
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public ModelAndView register(@Validated User user, BindingResult result){
        if(result.hasErrors()){
            return new ModelAndView("client/register");
        }
        logger.info("username is " + user.getUsername() + "\n password is " + user.getPassword());
//        service.registerUser(user);
        Map<String,Object> model = new HashMap<>();
        model.put("message","register successfully");
        return new ModelAndView("message",model);
    }

}
