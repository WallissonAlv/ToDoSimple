package me.project.dtos;

public class UserDto {

	private Long id;
	private String name;
	private String sector;
	
	
	public UserDto(Long id, String name, String sector) {
		super();
		this.id = id;
		this.name = name;
		this.sector = sector;
	}

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
}
