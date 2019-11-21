const mongoose = require('mongoose')

module.exports = mongoose.Schema({
 _id: Number,
 student: {type: mongoose.Schema.Types.Number, ref: 'StudentModel'},
 question: {type: mongoose.Schema.Types.Number, ref: 'QuestionModel'},
 trueFalseAnswer: Boolean,
 multipleChoiceAnswer: Number
}, {collection: 'answers'})