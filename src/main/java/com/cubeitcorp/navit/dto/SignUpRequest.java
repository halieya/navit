package com.cubeitcorp.navit.dto;



import lombok.Data;

@Data
public class SignUpRequest {
	  private String username;
	    private String email;
	    private String password;
	    private String filter;
}
