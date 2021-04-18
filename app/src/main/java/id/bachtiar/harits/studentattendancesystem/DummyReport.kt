package id.bachtiar.harits.studentattendancesystem

import id.bachtiar.harits.studentattendancesystem.model.Grade
import id.bachtiar.harits.studentattendancesystem.model.Student

object DummyReport {

    private val gradeName = arrayOf(
        "X IPA 1",
        "X IPA 2",
        "X IPA 3",
        "X IPA 4",
        "X IPA 5",
        "X IPS 1",
        "X IPS 2",
        "X IPS 3",
        "X IPS 4"
    )

    private val homeroomTeacher = arrayOf(
        "Eny Purwaningsih, S.Pd",
        "Dra. Yabia L, M.Pd.K",
        "Dra. Marselina Handari",
        "Paryono, S.Sn",
        "Muhammad Sholihul Hadi, M.Pd",
        "Muhammad Arwan Fathimy, S.Si",
        "Randa Prakarsa, S.Pd",
        "Nadia Deviani Tamara, M.Pd",
        "Sri Astuti, S.Pd"
    )

    private val students = arrayOf<List<Student>>(
        arrayListOf(
            Student("AALIYA NAYLA FADYA RIZQYA", "P", "Islam", arrayListOf()),
            Student("ADIBATUL HASANAH", "P", "Islam", arrayListOf()),
            Student("AGIL SUKMAWATI", "P", "Islam", arrayListOf())
        ),
        arrayListOf(
            Student("ADELLA DYAH AROFIAH", "P", "Islam", arrayListOf()),
            Student("ANASTACIA CAROLYN", "P", "Kristen", arrayListOf()),
            Student("ANASTASIA PUTRI MARIA", "P", "Kristen", arrayListOf())
        ),
        arrayListOf(
            Student("AHMADI ALWAN HUSAINI", "L", "Islam", arrayListOf()),
            Student("ALFRINA DAMAYANTI", "P", "Islam", arrayListOf()),
            Student("ALYA AZZAHRA", "P", "Islam", arrayListOf())
        ),
        arrayListOf(
            Student("ADRIAN IDHAM ALFARIZI", "L", "Islam", arrayListOf()),
            Student("AYHMAD DIWAN KALIFA", "L", "Islam", arrayListOf()),
            Student("ANDI FARYHATUN QORIMAH", "P", "Islam", arrayListOf())
        ),
        arrayListOf(
            Student("ADELIA TIARA PUTRI", "P", "Islam", arrayListOf()),
            Student("ADINDA SAPHIRA RIZKY", "P", "Islam", arrayListOf()),
            Student("ADIT SAPUTRA", "L", "Islam", arrayListOf())
        ),
        arrayListOf(
            Student("ABDUL AZIZ SISWANTO", "L", "Islam", arrayListOf()),
            Student("ACHMAD HARIRI", "L", "Islam", arrayListOf()),
            Student("ALDIN IKHWAN ARRASYID", "L", "Islam", arrayListOf())
        ),
        arrayListOf(
            Student("ADISTIA RAHMAWATI", "P", "Islam", arrayListOf()),
            Student("AHMAD RAHMAN NUR ALIF", "L", "Islam", arrayListOf()),
            Student("ALFINA AURELIA PUTRI", "P", "Islam", arrayListOf())
        ),
        arrayListOf(
            Student("AIDA MAKBULLAH", "P", "Islam", arrayListOf()),
            Student("ALDILA EKA PERMATA", "P", "Islam", arrayListOf()),
            Student("ANDHIKA DARMAWAN", "L", "Islam", arrayListOf())
        ),
        arrayListOf(
            Student("ALFIA MAFTUNA RAMADHANI", "P", "Islam", arrayListOf()),
            Student("ALDILA EKA PERMATA", "L", "Islam", arrayListOf()),
            Student("ANDHIKA DARMAWAN", "L", "Islam", arrayListOf())
        ),
    )

    val data: ArrayList<Grade>
        get() {
            val list = arrayListOf<Grade>()
            gradeName.forEachIndexed { index, _ ->
                val grade = Grade(
                    name = gradeName[index],
                    homeroomTeacher = homeroomTeacher[index],
                    students = students[index]
                )
                list.add(grade)
            }
            return list
        }
}