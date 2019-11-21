const dao = require('../data/daos/university.dao.server')
const assert = require('assert');

async function check() {
  await dao.truncateDatabase()
  dao.populateDatabase()

}

async function testStudentsInitialCount() {
  let count = await dao.findAllStudents().then(x => x.length)
  console.log("count: " + count)
  assert(count == 2, "testStudentsInitialCount fail")
}

async function testQuestionsInitialCount() {
  let count = await dao.findAllQuestions().then(x => x.length)
  console.log("count: " + count)
  assert(count == 4, "testQuestionsInitialCount fail")
}

async function testAnswersInitialCount() {
  let count = await dao.findAllAnswers().then(x => x.length)
  console.log("count: " + count)
  assert(count == 8, "testAnswerInitialCount fail")
}

async function testDeleteAnswer() {
  // total answer count
  await dao.deleteAnswer(890)
  let count1 = await dao.findAllAnswers().then(x => x.length)
  console.log("answer count1: " + count1)
  assert(count1 == 7, "testDeleteAnswer fail")

  // bob's answer count
  let count2 = await dao.findAnswersByStudent(234).then(x => x.length)
  console.log("answer count2: " + count2)
  assert(count2 == 3, "testDeleteAnswer fail")

  // related question answer count
  let count3 = await dao.findAnswersByQuestion(654).then(x => x.length)
  console.log("answer count3: " + count3)
  assert(count3 == 1, "testDeleteAnswer fail")
}

async function testDeleteStudent() {
  await dao.deleteStudent(234)
  let count = await dao.findAllStudents().then(x => x.length)
  console.log("count: " + count)
  assert(count == 1, "testDeleteStudent fail")
}

async function testDeleteQuestion() {
  await dao.deleteQuestion(321)
  let count = await dao.findAllQuestions().then(x => x.length)
  console.log("count: " + count)
  assert(count == 3, "testDeleteQuestion fail")
}

async function runTest() {

  await testStudentsInitialCount()
  await testQuestionsInitialCount()
  await testAnswersInitialCount()
  await testDeleteAnswer()
  await testDeleteStudent()
  await testDeleteQuestion()
}

