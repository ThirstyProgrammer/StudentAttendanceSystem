package id.bachtiar.harits.studentattendancesystem

import id.bachtiar.harits.studentattendancesystem.model.firebase.StudentAttendanceModel
import id.bachtiar.harits.studentattendancesystem.model.firebase.StudentModel
import id.bachtiar.harits.studentattendancesystem.util.StringHelper

object DummyReport {

    val students = arrayOf(
        StudentModel("Abdul Fattah Kholid", "L"),
        StudentModel("Afita Aura Zahrah", "P"),
        StudentModel("Alaita Uyun", "P"),
        StudentModel("Amanda Permata Putri", "P"),
        StudentModel("Anastasya Gunthardt Rizkia P", "P"),
        StudentModel("Aurelia Lisdy Nandiya", "P"),
        StudentModel("Bintang Gading Pramaditya", "L"),
        StudentModel("Chesi Deviaksa Yahya", "P"),
        StudentModel("Citta Hayu Karin R", "P"),
        StudentModel("Dea Alisha Putri", "P"),
    )

    val studentsIPS1 = arrayOf(
        StudentModel("Abdul Aziz Siswanto", "L"),
        StudentModel("Achmad Hariri", "L"),
        StudentModel("Aldin Ikhwan Arrasyid", "L"),
        StudentModel("Alvina Ilaiyah", "P"),
        StudentModel("Amanda Zalfa", "P"),
        StudentModel("Annisa Aulia Hasanah", "P"),
        StudentModel("Bagus Riziq Pangestu", "L"),
        StudentModel("Debby Alifah Maulida", "P"),
        StudentModel("Dias Erlangga Kuntarto", "L"),
        StudentModel("Dimas Maulana", "L"),
        StudentModel("Dzaki Azharraya", "L"),
        StudentModel("Faisal Prasetyo", "L"),
        StudentModel("Hafshah Qoni'a Jafna", "P"),
        StudentModel("Haura Ahnaf", "P"),
        StudentModel("Ilma Fitria Marantika", "P"),
        StudentModel("Indriyani", "P"),
        StudentModel("Kho'irun Nisa Naz'wa", "P"),
        StudentModel("Maulana Akbar Putra", "L"),
        StudentModel("Maulida Aprianti", "P"),
        StudentModel("Meylinda Putri Surahman", "P"),
        StudentModel("Muhammad Afif Athallah", "L"),
        StudentModel("Muhammad Farid", "L"),
        StudentModel("Nanda Aulia", "P"),
        StudentModel("Puji Amalia", "P"),
        StudentModel("Putri Atshila Nazwa", "P"),
        StudentModel("Raisha Trynanda", "P"),
        StudentModel("Ramadhansyah Putra", "L"),
        StudentModel("Ray Arjuna Sari", "L"),
        StudentModel("Regen Revano Rawi Pahu", "L"),
        StudentModel("Sarah Maulidya", "P"),
        StudentModel("Satria Putra Djangkaru", "L"),
        StudentModel("Shilda Afriyanti", "P"),
        StudentModel("Siska Fauziah", "P"),
        StudentModel("Terisa Mutia Sherlina", "P"),
        StudentModel("Yuniza Rahmawati", "P"),
        StudentModel("Zahra Afinur Alifah", "P"),
    )

    val studentAttendance = arrayOf(
        StudentAttendanceModel(
            "Matematika",
            "Sakit",
            "08.00",
            "10.00",
            StringHelper.getCurrentDate()
        ),
        StudentAttendanceModel(
            "Fisika",
            "Sakit",
            "10.00",
            "12.00",
            StringHelper.getCurrentDate()
        )
    )

    val data1 = hashMapOf<String, Any>(
        "name" to "X IPA 1",
        "homeroomTeacher" to "EnyPurwaningsih, S.Pd",
        "students" to 38
    )

    val data2 = hashMapOf<String, Any>(
        "name" to "X IPA 2",
        "homeroomTeacher" to "Dra. Yabia L, M.Pd.K",
        "students" to 37
    )

    val data3 = hashMapOf<String, Any>(
        "name" to "X IPA 3",
        "homeroomTeacher" to "Dra. Marselina Handari",
        "students" to 38
    )

    val data4 = hashMapOf<String, Any>(
        "name" to "X IPA 4",
        "homeroomTeacher" to "Paryono, S.Sn",
        "students" to 38
    )

    val data5 = hashMapOf<String, Any>(
        "name" to "X IPA 5",
        "homeroomTeacher" to "Muhammad Sholihul Hadi, M.Pd",
        "students" to 38
    )

    val data6 = hashMapOf<String, Any>(
        "name" to "X IPS 1",
        "homeroomTeacher" to "Muhammad Arwan Fathimy, S.Si",
        "students" to 36
    )

    val data7 = hashMapOf<String, Any>(
        "name" to "X IPS 2",
        "homeroomTeacher" to "Randa Prakarsa, S.Pd",
        "students" to 37
    )

    val data8 = hashMapOf<String, Any>(
        "name" to "X IPS 3",
        "homeroomTeacher" to "Nadia Deviani Tamara, M.Pd",
        "students" to 37
    )

    val data9 = hashMapOf<String, Any>(
        "name" to "X IPS 4",
        "homeroomTeacher" to "Sri Astuti, S.Pd",
        "students" to 37
    )

}