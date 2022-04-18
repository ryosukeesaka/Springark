package com.example.demo.Controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {
	
	private Map<String,String>radioM;
	
	private Map<String,String>ini(){
		Map<String,String>radio = new LinkedHashMap<>();
		
		radio.put("既婚","trune");
		radio.put("未婚", "false");
		
		return radio;
	}
	
	@GetMapping("/signup")
	public String getSignUp(Model model) {
		
		radioM = ini();
		model.addAttribute("rM",radioM);
		
		return "signup";
		
	}
	
	@PostMapping("signup")
	public String postSignUp(Model model) {
		return "redirect:/login";
	}

}
