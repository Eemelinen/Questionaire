package open.vision.app.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import open.vision.app.domain.AnswerOption;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long questionId;
	private String title;
	private String type;
	
	private String chosenAnswer;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	@JsonIgnoreProperties("questions")
	private List<AnswerOption> answers;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	private Answer answer;
		
	public Question() {}
	
	public Question(String title, String type) {
		super();
		this.title = title;
		this.type = type;
	}
	
	public Question(Long questionId, String title, String type, String chosenAnswer) {
		super();
		this.questionId = questionId;
		this.title = title;
		this.type = type;
		this.chosenAnswer = chosenAnswer;
	}

	public Question(String title, String type, String chosenAnswer) {
		super();
		this.title = title;
		this.type = type;
		this.chosenAnswer = chosenAnswer;
	}

	public String getTitle() {
		return title;
	}

	public String getChosenAnswer() {
		return chosenAnswer;
	}

	public void setChosenAnswer(String chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<AnswerOption> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerOption> answers) {
		this.answers = answers;
	}
	
}
