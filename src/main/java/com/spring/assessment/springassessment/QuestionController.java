package com.spring.assessment.springassessment;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class QuestionController {
	
	@Autowired
	IUserRepository urepo;
	
	@Autowired
	IQuestionRepository qrepo;
	
	@PostMapping("{id}/question")
	public void saveQuestion(@Valid @RequestBody Question q, @PathVariable("id") Integer id) {

		User user = urepo.findById(id).get();
		System.out.println(user.getFirstName());
		q.setUser(user);
		System.out.println(q.getUser().getFirstName());
		System.out.println(q);
		qrepo.save(q);

	}
	@GetMapping("/questions")
	public Iterable<Question> getQuestions() {
		return qrepo.findAll();
	}
	
	@PutMapping("questions/{id}")//Updating the votes of the question. Calculation done through front end
	public void UpdateVote(@PathVariable("id") Integer id, @RequestBody Question question) {
		Question Q = qrepo.findById(id).get();
		Q.setVotes(question.getVotes());
		qrepo.save(Q);
	}
	
	@PutMapping("questions/{id}/answer")//Updating the question by adding its answer
	public void AddAnswer(@PathVariable("id") Integer id, @RequestBody Question question) {
		Question Q = qrepo.findById(id).get();
		Q.setAnswer(question.getAnswer());
		qrepo.save(Q);
	}
	
}
