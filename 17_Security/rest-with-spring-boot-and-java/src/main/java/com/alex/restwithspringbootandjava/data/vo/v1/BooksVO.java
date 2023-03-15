package com.alex.restwithspringbootandjava.data.vo.v1;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder( {"id", "author", "launchTime", "price" , "title" })
public class BooksVO extends RepresentationModel<BooksVO> implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	@Mapping("id")
	private Long key;
	private String author;
	private LocalDateTime launchTime;
	private Double price;
	private String title;

	public BooksVO() {
	}

	public BooksVO(Long key, String author, LocalDateTime launchTime, Double price, String title) {
		super();
		this.key = key;
		this.author = author;
		this.launchTime = launchTime;
		this.price = price;
		this.title = title;
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getLaunchTime() {
		return launchTime;
	}

	public void setLaunchTime(LocalDateTime launchTime) {
		this.launchTime = launchTime;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		return Objects.hash(key);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BooksVO other = (BooksVO) obj;
		return Objects.equals(key, other.key);
	}

}
