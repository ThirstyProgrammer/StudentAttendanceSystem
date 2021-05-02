package id.bachtiar.harits.studentattendancesystem.model

data class AttendanceForm(
    var teachingMedia: String,
    var learningMaterials: String,
    var obstaclesAndSolution: String,
    var grade: String,
    var subject: String,
    var date: String,
    var totalStudentPresent: Int
//    var physicalEvidence: String
)
