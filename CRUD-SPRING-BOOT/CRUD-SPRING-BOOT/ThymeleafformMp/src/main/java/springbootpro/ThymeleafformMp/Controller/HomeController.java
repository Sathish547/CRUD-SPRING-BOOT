package springbootpro.ThymeleafformMp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootpro.ThymeleafformMp.model.Usermodel;

@RestController
public class HomeController {
	@Autowired
	JdbcTemplate jdbctemp;
	@GetMapping(path="/details")
	public List<Usermodel> getalldata()
	{
		String sql="select * from employee1";
		return jdbctemp.query(sql, BeanPropertyRowMapper.newInstance(Usermodel.class));
	}
}
