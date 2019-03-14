package com.mitrai.ResourcePlanner.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserModel {

	private String email_id;
	private String password;
	private String id;
	private String first_name;
	private String last_name;
	private String mobile;
	private String country;
	private String user_type;


}
