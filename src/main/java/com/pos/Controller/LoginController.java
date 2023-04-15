package com.pos.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pos.dto.UserDto;

@Controller
@RequestMapping("/login")
public class LoginController {

	
	@PostMapping
	public ResponseEntity<String> test(@RequestBody UserDto user){
//		System.out.println(user.toString());
		return ResponseEntity.ok("TEST OK");
	}
}
