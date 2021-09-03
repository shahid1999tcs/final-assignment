package com.spring.assessment.springassessment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer Question_ID;
	@NotNull
	private String question;
	private int votes;
	private String answer;
	@ManyToOne
	@JsonIgnore
	private User user;
	public Integer getID() {
		return Question_ID;
	}
	public void setID(Integer iD) {
		Question_ID = iD;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	@Override
	public String toString() {
		return "Question [ID=" + Question_ID + ", question=" + question + ", votes=" + votes + ", answer=" + answer + ", user="
				+ user + "]";
	}
	
}
