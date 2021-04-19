package id.bachtiar.harits.studentattendancesystem

import id.bachtiar.harits.studentattendancesystem.model.Schedule

object DummyHome {

    private val scheduleSubjects = arrayOf(
        "Matematika",
        "Matematika",
        "Matematika",
        "Matematika",
        "Matematika",
    )

    private val scheduleGrade = arrayOf(
        "X IPA 1",
        "X IPA 2",
        "X IPA 3",
        "X IPA 4",
        "X IPA 5"
    )

    private val scheduleStartTime = arrayOf(
        "08.00",
        "10.00",
        "12.00",
        "08.00",
        "10.00"
    )

    private val scheduleEndTime = arrayOf(
        "10.00",
        "12.00",
        "14.00",
        "10.00",
        "12.00"
    )

    private val scheduleDay = arrayOf(
        "Senin",
        "Senin",
        "Senin",
        "Selasa",
        "Selasa"
    )

    val data: ArrayList<Schedule>
        get() {
            val list = arrayListOf<Schedule>()
            scheduleSubjects.forEachIndexed { index, _ ->
                val grade = Schedule(
                    subjects = scheduleSubjects[index],
                    grade = scheduleGrade[index],
                    startTime = scheduleStartTime[index],
                    endTime = scheduleEndTime[index],
                    day = scheduleDay[index]
                )
                list.add(grade)
            }
            return list
        }
}