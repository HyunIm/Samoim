package com.kb.samoim.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ClassDto {
	
	public ClassDto() {
		
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
	public String getLarge_category() {
		return large_category;
	}
	public void setLarge_category(String large_category) {
		this.large_category = large_category;
	}
	public String getSmall_category() {
		return small_category;
	}
	public void setSmall_category(String small_category) {
		this.small_category = small_category;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMax_member() {
		return max_member;
	}
	public void setMax_member(String max_member) {
		this.max_member = max_member;
	}
	public String getOwener_id() {
		return owener_id;
	}
	public void setOwener_id(String owener_id) {
		this.owener_id = owener_id;
	}
	public String getOpen_date() {
		return open_date;
	}
	public void setOpen_date(String open_date) {
		this.open_date = open_date;
	}
	public String getDetail_contents() {
		return detail_contents;
	}
	public void setDetail_contents(String detail_contents) {
		this.detail_contents = detail_contents;
	}
	public String getPhoto_path() {
		return photo_path;
	}
	public void setPhoto_path(String photo_path) {
		this.photo_path = photo_path;
	}
	private Long id;
	private String name;
	private String large_category;
	private String small_category;
	private String city;
	private String address;
	private String max_member;
	private String owener_id; // USER Email
	private String open_date;
	private String detail_contents;
	private String photo_path;
	
}
