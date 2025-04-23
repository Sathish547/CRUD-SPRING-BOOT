package springbootpro.ThymeleafformMp.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import springbootpro.ThymeleafformMp.model.Usermodel;

@Controller
public class HelloController {
	@Autowired
	JdbcTemplate jdbc;
	@GetMapping("index")
	public String indexpage()
	{
		return "index";
	}
	@GetMapping("delete")
	public String delpage(Model m)
	{
		Usermodel u=new Usermodel();
		m.addAttribute("data",u);
		return "deletepage";
	}
	@GetMapping("reg")
	public String Regpage(Model m)
	{
		Usermodel u=new Usermodel();
		m.addAttribute("data", u);
		List <String> listprofession=Arrays.asList("Front-End Developer","Tester","Back-End Developer");
		m.addAttribute("listprofession",listprofession);
		return "home";
	}
	@GetMapping("view")
	public String Submitpage(Model m,@ModelAttribute("data") Usermodel u)
	{
		System.out.println(u.getName());
		m.addAttribute("userform",u);
		jdbc.update("insert into employee1(name,email,password1,gender,address,profession)"+
		"values(?,?,?,?,?,?)",u.getName(),u.getEmail(),u.getPassword(),u.getGender(),u.getAddress(),u.getProfession());
		return "viewpage";
	}
	@GetMapping("delete1")
	public String deletepage(Model m,@ModelAttribute("data") Usermodel u)
	{
		jdbc.update("delete from employee1 where name=?",u.getName());
		return "index";
		
	}
}
