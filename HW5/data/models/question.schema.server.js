const mongoose = require('mongoose')
const TrueFalseSchema = require('./true-false.schema.server')
const MultipleChoiceSchema = require('./multiple-choice.schema.server')

module.exports = mongoose.Schema({
 _id: Number,
 trueFalse: TrueFalseSchema
 question: String,
 points: Number,
 questionType: String,
 multipleChoice: MultipleChoiceSchema,

}, {collection: 'questions'})