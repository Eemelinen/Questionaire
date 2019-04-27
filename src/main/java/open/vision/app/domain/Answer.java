package open.vision.app.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

//@Entity
public class Answer {
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long answerId;
	private String answerValue;
	
//	@OneToOne
//	@JoinColumn(name = "questionId")
//	private Question question;
	
	public Answer() {
		super();
	}	

//	public Answer(String answerValue, Question question) {
//		super();
//		this.answerValue = answerValue;
//		this.question = question;
//	}

	public Answer(Long answerId, String answerValue) {
		super();
		this.answerId = answerId;
		this.answerValue = answerValue;
	}

	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	public String getAnswerValue() {
		return answerValue;
	}

	public void setAnswerValue(String answerValue) {
		this.answerValue = answerValue;
	}

//	public Question getQuestion() {
//		return question;
//	}
//
//	public void setQuestion(Question question) {
//		this.question = question;
//	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", answerValue=" + answerValue + ", question=" + "]";
	}
	
}
