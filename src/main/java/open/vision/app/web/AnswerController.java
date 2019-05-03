package open.vision.app.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import open.vision.app.domain.Answer;
import open.vision.app.domain.AnswerCreatorObject;
import open.vision.app.domain.AnswerRepository;
import open.vision.app.domain.Question;
import open.vision.app.domain.QuestionRepository;

@RestController
public class AnswerController {
	
	@Autowired
	private AnswerRepository answerRepo;
	
	@Autowired
	private QuestionRepository qRepo;
	
	@PostMapping(
		value="/api/submitAnswer",
		consumes = {MediaType.APPLICATION_JSON_VALUE})
	public Answer submitAnswer(@RequestBody AnswerCreatorObject requestAnswer) {
		
		String answerValue = requestAnswer.getAnswerValue();
		
		Long questionId = requestAnswer.getQuestionId();
		
		Question question = qRepo.findByQuestionId(questionId).get(0);
				
		Answer answer = new Answer(answerValue, question);
		
		answerRepo.save(answer);
		
		return answer;
	}
	
	@PostMapping(
			value="/api/submitAnswerList",
			consumes = {MediaType.APPLICATION_JSON_VALUE})
		public List<Answer> createAnswerList(@RequestBody List<AnswerCreatorObject> requestAnswers) {
		
		List<Answer> answers = new ArrayList<Answer>();
					
			for (int i = 0; i < requestAnswers.size(); i++) {
				
				String answerValue = requestAnswers.get(i).getAnswerValue();
				
				Long questionId = requestAnswers.get(i).getQuestionId();
				
				Question question = qRepo.findByQuestionId(questionId).get(0);
						
				Answer answer = new Answer(answerValue, question);
				
				answerRepo.save(answer);
				
				answers.add(answer);
			}
			return answers;
		}
	
	//RESTful service to get all answers
	@RequestMapping(value="/answers", method = RequestMethod.GET)
	public @ResponseBody List<Answer> getActualAnswersRest(){
		
		return (List<Answer>) answerRepo.findAll();
	}
	
	//RESTful service to get one answer options by id
	@RequestMapping(value="/answer/{answerid}", method=RequestMethod.GET)
	public @ResponseBody Optional<Answer> findAnswerIdRest(@PathVariable("answerid") Long id) {
		return answerRepo.findByAnswerId(id);
	}
	
}
