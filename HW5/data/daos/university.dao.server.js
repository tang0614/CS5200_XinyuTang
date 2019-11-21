const connectDB = require('../db')
const mongoose = require('mongoose')
const questionModel = require('../models/question.model.server')
const answerModel = require('../models/answer.model.server')
const studentModel = require('../models/student.model.server')

connectDB()

async function truncateDatabase() {
  await connectDB()
  mongoose.connection.dropDatabase()
}


//populate database
function populateStudents() {
	createStudent({
	    _id: 123,
	    firstName: 'Alice',
	    lastName: 'Wonderand',
	    username: 'alice',
	    password: 'alice',
	    gradYear: 2020,
	    scholarship: 15000
	  }).then(newUser => console.log('new user: ' + newUser))

	  createStudent({
	    _id: 234,
	    firstName: 'Bob',
	    lastName: 'Hope',
	    username: 'bob',
	    password: 'bob',
	    gradYear: 2021,
	    scholarship: 12000
	  }).then(newUser => console.log('new user: ' + newUser))

}

async function populateDatabase(){
	  await connectDB()
	  await populateStudents()
	  await populateQuestions()
	  await populateAnswers()
}



createStudent = student => studentModel.create(student)
deleteStudent = studentId => studentModel.deleteOne({"_id": studentId}).then(console.log('delete student ' + studentId)) // need to excute delete?
createQuestion = question => questionModel.create(question)
deleteQuestion = questionId => questionModel.deleteOne({"_id": questionId}).then(console.log('delete question ' + questionId))

function answerQuestion(studentId, questionId, answer){
  answer.student = studentId
  answer.question = questionId
  return answerModel.create(answer)
}
deleteAnswer = answerId => answerModel.deleteOne({"_id": answerId}).then(console.log('delete answer ' + answerId))




findAllStudents = () => studentModel.find()
findStudentById = studentId => studentModel.findById(studentId)
findAllQuestions = () => questionModel.find()
findQuestionById = questionId => questionModel.findById(questionId)
findAllAnswers = () => answerModel.find()
findAnswerById = answerId => answerModel.findById(answerId)
findAnswersByStudent = studentId => answerModel.find({student: studentId})
findAnswersByQuestion = questionId => answerModel.find({question: questionId})

function populateAnswers() {
	  answerQuestion(123, 321, {
	    _id: 123,
	    trueFalseAnswer: true
	  }).then(x => console.log(x))

	  answerQuestion(123, 432, {
	    _id: 234,
	    trueFalseAnswer: false
	  }).then(x => console.log(x))
	  
	  answerQuestion(123, 543, {
	    _id: 345,
	    multipleChoiceAnswer: 1
	  }).then(x => console.log(x))

	  answerQuestion(123, 654, {
	    _id: 456,
	    multipleChoiceAnswer: 2
	  }).then(x => console.log(x))

	  answerQuestion(234, 321, {
	    _id: 567,
	    trueFalseAnswer: false
	  }).then(x => console.log(x))

	  answerQuestion(234, 432, {
	    _id: 678,
	    trueFalseAnswer: true
	  }).then(x => console.log(x))
	  
	  answerQuestion(234, 543, {
	    _id: 789,
	    multipleChoiceAnswer: 3
	  }).then(x => console.log(x))

	  answerQuestion(234, 654, {
	    _id: 890,
	    multipleChoiceAnswer: 4
	  }).then(x => console.log(x))
	}
function populateQuestions() {
	  createQuestion({
	    _id: 321,
	    question: 'Is the following schema valid?',
	    points: 10,
	    questionType: 'TRUE_FALSE',
	    trueFalse: {
	      isTrue: false
	    }
	  }).then(x => console.log(x))

	  createQuestion({
	    _id: 432,
	    question: 'DAO stands for Dynamic Access Object.',
	    points: 10,
	    questionType: 'TRUE_FALSE',
	    trueFalse: {
	      isTrue: false
	    }
	  }).then(x => console.log(x))

	  createQuestion({
	    _id: 543,
	    question: 'What does JPA stand for?',
	    points: 10,
	    questionType: 'MULTIPLE_CHOICE',
	    multipleChoice: {
	      choices: 'Java Persistence API,Java Persisted Application,JavaScript Persistence API,JSON Persistent Associations',
	      correct: 1
	    }
	  }).then(x => console.log(x))

	  createQuestion({
	    _id: 654,
	    question: 'What does ORM stand for?',
	    points: 10,
	    questionType: 'MULTIPLE_CHOICE',
	    multipleChoice: {
	      choices: 'Object Relational Model,Object Relative Markup,Object Reflexive Model,Object Relational Mapping',
	      correct: 4
	    }
	  }).then(x => console.log(x))
	}


