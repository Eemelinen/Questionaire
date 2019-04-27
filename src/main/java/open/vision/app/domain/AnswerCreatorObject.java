package open.vision.app.domain;

public class AnswerCreatorObject {
		
	private Long questionId;
	private String title;
	private String type;
	private AnswerOption chosenAnswer;
	
	public AnswerCreatorObject() {
		super();
	}

	public AnswerCreatorObject(Long questionId, String title, String type, AnswerOption chosenAnswer) {
		super();
		this.questionId = questionId;
		this.title = title;
		this.type = type;
		this.chosenAnswer = chosenAnswer;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getTitle() {
		return title;
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

	public AnswerOption getChosenAnswer() {
		return chosenAnswer;
	}

	public void setChosenAnswer(AnswerOption chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}
}
