
// getUnanswered Question


Select module, question_id, count(askedBy) as MostAnsBy
FROM question q
LEFT JOIN answer a
on q.widget_id =a.widget_id
WHERE  a.correctAnswer = False
GROUP BY module, question_id
ORDER BY count(askedBy) desc
Limit 1


// endorsedUserForWeek
Select u.user_id
FROM user u
LEFT JOIN Answer a
ON u.answer_id = a.answer_id
WHERE correctAnswer = True
GROUP BY u.user_id, a.date
ORDER BY count(answer_id) desc
limit 5



