package com.ems.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ManagerDTO extends UserDTO {
	
private String mangName;
private String mangAddress;
private double salary;
private String contact;
private String email;

}
