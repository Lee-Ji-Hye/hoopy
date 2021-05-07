package com.example.vue.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VueController {
	
	@CrossOrigin(origins ="http://localhost:8080")
	@GetMapping("/member/hello")
	public String hello() {
		System.out.println("------------------------API------------------------");
		return "hello";
	}
	
	@GetMapping("/member/userInfo")
	public String userInfo(Principal principal) {
		System.out.println("------------------------API1111------------------------");
		String name;
		try {
			name = principal.getName();
		}catch(NullPointerException e) {
			return "로그인해주세요.";
		}
		return name;
	}
	
	@RequestMapping(value="/csrf-token", method=RequestMethod.GET)
	public @ResponseBody String getCsrfToken(HttpServletRequest request) {
	    CsrfToken token = (CsrfToken)request.getAttribute(CsrfToken.class.getName());
	    return token.getToken();
	}
}
