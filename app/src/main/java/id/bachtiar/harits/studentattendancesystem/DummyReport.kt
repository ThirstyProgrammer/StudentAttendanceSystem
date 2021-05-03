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

    fun getList(): List<Array<StudentModel>> {
        val list: ArrayList<Array<StudentModel>> = arrayListOf()
//        list.add(studentsIPA1)
//        list.add(studentsIPA2)
//        list.add(studentsIPA3)
//        list.add(studentsIPA4)
//        list.add(studentsIPA5)
        list.add(studentsIPS1)
        list.add(studentsIPS2)
        list.add(studentsIPS3)
        list.add(studentsIPS4)
        return list
    }

    val studentsIPA1 = arrayOf(
        StudentModel("Aaliya Nayla Fadya Rizqya", "P"),
        StudentModel("Adibatul Hasanah", "P"),
        StudentModel("Agil Sukmawati", "P"),
        StudentModel("Ahmad Pandu Trengginas", "L"),
        StudentModel("Aqilah Faizah", "P"),
        StudentModel("Barbie Amoura Keyra", "P"),
        StudentModel("Clarissa Zhafira Amelia", "P"),
        StudentModel("Davin Radtya", "L"),
        StudentModel("Devan Premari Augusto", "L"),
        StudentModel("Devandra Daffa Pratama", "L"),

        StudentModel("Devi Septiani Ahmad", "P"),
        StudentModel("Dharma Wijaya", "L"),
        StudentModel("Dias Mulya Rahman Sunadi", "L"),
        StudentModel("Dinar Adila Zain", "P"),
        StudentModel("Fajar Adikurnia Daulay", "L"),
        StudentModel("Gintan Ghaisani Putri", "P"),
        StudentModel("Hana Fauziyah", "P"),
        StudentModel("Irdan Suwardana Yahya", "L"),
        StudentModel("Kinanti Muthmadinta", "P"),
        StudentModel("Kyla Dianisya Mulazamah", "P"),

        StudentModel("Lintang Patmala Aprin", "P"),
        StudentModel("Muhammad Ibrahim Mufid", "L"),
        StudentModel("Muhammad Raihan Pratama", "L"),
        StudentModel("Muhammad Zaki Putra", "L"),
        StudentModel("Nadjla Salsabila", "P"),
        StudentModel("Naufal Dena Febrian", "L"),
        StudentModel("Naya Raila Azzahra", "P"),
        StudentModel("Nikita Adi Yundari", "P"),
        StudentModel("Rafi Muhammad Fayiz", "L"),
        StudentModel("Rahma Putri Dwi Swasti", "P"),

        StudentModel("Rani Aprilianti", "P"),
        StudentModel("Revalina Adelia", "P"),
        StudentModel("Selly Augestari Binha", "P"),
        StudentModel("Tyanita Dwi Nuraini", "P"),
        StudentModel("Ulung Wijayanto", "L"),
        StudentModel("Vania Aldennatha", "P"),
        StudentModel("Wildan Humaidi", "L"),
        StudentModel("Zack Xanoah Ziyaad", "L"),
    )

    val studentsIPA2 = arrayOf(
        StudentModel("Adella Dyah Arofiah", "P"),
        StudentModel("Anastacia Carolyn", "P"),
        StudentModel("Anastasia Putri Maria", "P"),
        StudentModel("Aqila Rizkiah Maheswari", "P"),
        StudentModel("Bagaskoro Rizqullah", "L"),
        StudentModel("Callysta Annelly", "P"),
        StudentModel("Christian Joseph Silaban", "L"),
        StudentModel("David Cristiano", "L"),
        StudentModel("Davit Samuel Tamba", "L"),
        StudentModel("Deby Karina Tampubolon", "P"),

        StudentModel("Djuwita Rohaly", "P"),
        StudentModel("Esa Yusalima", "L"),
        StudentModel("Evan Galih Suhardi", "L"),
        StudentModel("Farisah Lailla Qasthalani", "P"),
        StudentModel("Gadis Adara Nathania", "P"),
        StudentModel("Haidar Ali Arrasyid", "L"),
        StudentModel("Letazkya Marella Satria", "P"),
        StudentModel("M. Rizky", "L"),
        StudentModel("Melin Cita Ayswara", "P"),
        StudentModel("Miftahul Jannah", "P"),

        StudentModel("Muhammad Alfi Fairus", "L"),
        StudentModel("Muhammad Irsyad", "L"),
        StudentModel("Muhammad Rizky Chandra", "L"),
        StudentModel("Muhammad Sackty Pramana", "L"),
        StudentModel("Naila Salsabila", "P"),
        StudentModel("Najwa Kamilah", "P"),
        StudentModel("Naya Nailah Yusril", "P"),
        StudentModel("Nisrina Kayla Fathia", "P"),
        StudentModel("Rahma Dhania Zahra", "P"),
        StudentModel("Rania Aisah Putri", "P"),

        StudentModel("Reiki Aurellio Hafizh", "L"),
        StudentModel("Revo Adhi Pramana", "L"),
        StudentModel("Rindu Afrianti", "P"),
        StudentModel("Tri Wulandari", "P"),
        StudentModel("Yoseph Satria Praka", "L"),
        StudentModel("Zahwa Rakhshanda Afif", "P"),
        StudentModel("Zhafirah Fatin Azzah", "P"),
    )

    val studentsIPA3 = arrayOf(
        StudentModel("Ahmadi Alwan Husaini", "L"),
        StudentModel("Alfrina Damayanti", "P"),
        StudentModel("Alya Azzahra", "P"),
        StudentModel("Alya Salsabil", "P"),
        StudentModel("Amirah Nayla Dinar Susena", "P"),
        StudentModel("Aulliya Nastiti", "P"),
        StudentModel("Azkia Mahayang Chiganjati", "P"),
        StudentModel("Chesa Chairunissa", "P"),
        StudentModel("Danisha Mutiara Rabbani", "P"),
        StudentModel("Dear Ajeng Syahfitri", "P"),

        StudentModel("Dick Abel Lazar", "L"),
        StudentModel("Difa Romadhon", "L"),
        StudentModel("Gita Aprilia", "P"),
        StudentModel("Hafizh Khairi Habibillah", "L"),
        StudentModel("Iqbal Fardhani Pohan", "L"),
        StudentModel("Muhamad Azmi Zulfadhli", "L"),
        StudentModel("Muhammad Bagas Wildan", "L"),
        StudentModel("Muhammad Farras", "L"),
        StudentModel("Muhammad Iksan Ramadhani", "L"),
        StudentModel("Muhammad Ilham", "L"),

        StudentModel("Muhammad Rivaldy Dwiyanto", "L"),
        StudentModel("Nadila Anandita", "P"),
        StudentModel("Nurdianah", "P"),
        StudentModel("Pramariza Fadhlansyah", "L"),
        StudentModel("Rafi Gifari", "L"),
        StudentModel("Reza Saefullah", "L"),
        StudentModel("Rheva Chairunnisa Erwin", "P"),
        StudentModel("Sabrina Shafa Qonita", "P"),
        StudentModel("Salwa Hafidzah", "P"),
        StudentModel("Sefti Auliah Harahap", "P"),

        StudentModel("Shafanya Fithdia Novanti", "P"),
        StudentModel("Sheila Tri Basuki", "P"),
        StudentModel("Sri Rahmadhani", "P"),
        StudentModel("Syifa Sa'adah", "P"),
        StudentModel("Vellisya Afifa Qonita", "P"),
        StudentModel("Virda Amelia Putri", "P"),
        StudentModel("Zahra Kemala Ningrum", "P"),
        StudentModel("Zaky Noverio Ramadhan", "L"),
    )

    val studentsIPA4 = arrayOf(
        StudentModel("Adrian Ilham Alfarizi", "L"),
        StudentModel("Ahmad Diwan Kalifa", "L"),
        StudentModel("Andi Farhatun Qorimah", "P"),
        StudentModel("Annestika Mikhael", "P"),
        StudentModel("Ashadel Cantika Andhama", "P"),
        StudentModel("Asyer Ruben Gamaliel", "L"),
        StudentModel("Bela Aleteia Pieters", "P"),
        StudentModel("Dhea Putri Zhafira", "P"),
        StudentModel("Dhini Dwi Yanti", "P"),
        StudentModel("Faiqa Shifa Rania", "P"),

        StudentModel("Farras Aryanti", "P"),
        StudentModel("Gabriella Dofaani Natalia", "P"),
        StudentModel("Halifah Cahyani", "P"),
        StudentModel("Hanif Nabil Dhaifullah", "L"),
        StudentModel("Helen Kezia Nofitri Siahaan", "P"),
        StudentModel("Joanne Kelita Depari", "P"),
        StudentModel("Kalilah Putri Aulia", "P"),
        StudentModel("Kalyca Rafa Nurwendah", "P"),
        StudentModel("Levia Putri Mismara", "P"),
        StudentModel("Lunamaya Handayanti", "P"),

        StudentModel("Michael Salem Petra", "L"),
        StudentModel("M. Aurel Diarra Schetiar", "L"),
        StudentModel("Muhammad Fauzi Abdullah", "L"),
        StudentModel("Muhammad Mulki", "L"),
        StudentModel("Najla Camila Shafara", "P"),
        StudentModel("Najwa Shafa Aulia", "P"),
        StudentModel("Najwa Shafwadhila", "P"),
        StudentModel("Nurmalita Devi Anggraeni", "P"),
        StudentModel("Rafa Maulana", "L"),
        StudentModel("Rahel Mangoloi Sinabariba", "L"),

        StudentModel("Rahmania Putri Nabila", "P"),
        StudentModel("Raihan David Erianto", "L"),
        StudentModel("Ridwandanu Maulana", "L"),
        StudentModel("Rizq Muhammad", "L"),
        StudentModel("Ryan Ahsan Aulia", "L"),
        StudentModel("Sonia Nurul Cahyani", "P"),
        StudentModel("Syifa Annisa Safitri", "P"),
        StudentModel("Zeland Elnito", "L"),
    )

    val studentsIPA5 = arrayOf(
        StudentModel("Adelia Tiara Putri", "P"),
        StudentModel("Adinda Saphira Rizky", "P"),
        StudentModel("Adit Saputra", "L"),
        StudentModel("Aldia Humaira", "P"),
        StudentModel("Althaf Faizulhaq Aleyandra", "L"),
        StudentModel("Dita Ariani", "P"),
        StudentModel("Dwi Febriana", "P"),
        StudentModel("Eka Yutriaskia", "P"),
        StudentModel("Evan Dwitama", "L"),
        StudentModel("Fania Rafalina Fadli", "P"),

        StudentModel("Faris Audah", "L"),
        StudentModel("Febby Nur Fadillah Hamzah", "P"),
        StudentModel("Ghina Aulia Iskandar", "P"),
        StudentModel("Julyana Ayu N.P", "P"),
        StudentModel("Karima Ghalbie Fajrina", "P"),
        StudentModel("Keefe Razaan Hidayat", "L"),
        StudentModel("Khanza Sutan Nirwasita", "P"),
        StudentModel("Khaylia Nur Alifa", "P"),
        StudentModel("Luly Zahnar", "P"),
        StudentModel("Muhamad Alghifari", "L"),

        StudentModel("Muhammad Danang Annadhif", "L"),
        StudentModel("Muhammad Dzaki Suryana", "L"),
        StudentModel("Muhammad Fathan", "L"),
        StudentModel("Muhammad Rizaldi", "L"),
        StudentModel("Nasyatra Bleizea Fitrisyah", "P"),
        StudentModel("Niko Genta Syaputra", "L"),
        StudentModel("Puspita Wulandari", "P"),
        StudentModel("Quincy Nikita Sulaeman", "P"),
        StudentModel("Raafid Azhar Firaas", "L"),
        StudentModel("Raffa Alifio Darmahendra", "L"),

        StudentModel("Rika Septi Pujiana", "P"),
        StudentModel("Rizky Dafa Herlambang", "L"),
        StudentModel("Satria Tri Ferdiansyah", "L"),
        StudentModel("Sherly Ramadhania", "P"),
        StudentModel("Siti Fatimahtul Zahro", "P"),
        StudentModel("Syahrul Rachman", "L"),
        StudentModel("Syifa Anabella", "P"),
        StudentModel("Yerni Murni", "P"),
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

    val studentsIPS2 = arrayOf(
        StudentModel("Adistia Rahmawati", "P"),
        StudentModel("Ahmad Rahman Nur Alif", "L"),
        StudentModel("Alfina Aurelia Putri", "P"),
        StudentModel("Alfitho Dwi Putro", "L"),
        StudentModel("Alifia Tiara Cadiaz Gemilang", "P"),
        StudentModel("Annisa Aulia Zahra", "P"),
        StudentModel("Annisa Tasya Salsabila", "P"),
        StudentModel("Caesar Nobel Paraloan", "L"),
        StudentModel("Callysta Feodora", "P"),
        StudentModel("Dinda Armerta Putri", "P"),

        StudentModel("Domianus Fieldo", "L"),
        StudentModel("Eleora Grimonia Eryn", "P"),
        StudentModel("Fariza Bunga Azzahra", "P"),
        StudentModel("Fuji Indah Lestari", "P"),
        StudentModel("Gading Arya Pramudya", "L"),
        StudentModel("Grant Yoshio Artha", "L"),
        StudentModel("I Gede Dharma Putra", "L"),
        StudentModel("Ignatius Johannes", "L"),
        StudentModel("Intan Salsabila", "P"),
        StudentModel("Isma Safitri", "P"),

        StudentModel("Josua Nadapdap", "L"),
        StudentModel("Lestari Kamila", "P"),
        StudentModel("Lina Nafilah Salsabila", "P"),
        StudentModel("Mariska Anin Dya Putri", "P"),
        StudentModel("Marsya Syabila", "P"),
        StudentModel("Melati Mulki", "P"),
        StudentModel("Mehafif Arya Putra", "L"),
        StudentModel("Muhamad Fajar", "L"),
        StudentModel("Muhamad Randi Jaki", "L"),
        StudentModel("Muhammad Aditya Wibisono", "L"),

        StudentModel("Muhammad Hafizh Abiyyu", "L"),
        StudentModel("Muhammad Hanan Rafani", "L"),
        StudentModel("Tri Febriyanti Putri", "P"),
        StudentModel("Trista Gema Sayidina", "P"),
        StudentModel("Vicko Branta Nielry", "L"),
        StudentModel("Vio Novalin", "P"),
        StudentModel("Yeskiel Christian", "L"),
    )

    val studentsIPS3 = arrayOf(
        StudentModel("Aida Makbullah", "P"),
        StudentModel("Aldila Eka Permata", "P"),
        StudentModel("Andhika Darmawan", "L"),
        StudentModel("Andrian Hayyun Ramadhan", "L"),
        StudentModel("Anmira Quisha Fatimah", "P"),
        StudentModel("Arya Prastya Igo Loulein S", "L"),
        StudentModel("Athalah Caesar Khalfani", "L"),
        StudentModel("Ayu Wulandari", "P"),
        StudentModel("Bella Amelia", "P"),
        StudentModel("Cut Maulida Fitriyani", "P"),

        StudentModel("Dahva Satria Tama", "L"),
        StudentModel("Dania Zahra Putri Permana", "P"),
        StudentModel("Dwi Melani", "P"),
        StudentModel("Eka Saputra Ramadhani", "L"),
        StudentModel("Faridha Rachmayanti", "P"),
        StudentModel("Ferdian Dwi Fitama", "L"),
        StudentModel("Ftriyah Salsabila", "P"),
        StudentModel("Gafar Nugraha Ilham", "L"),
        StudentModel("Luthfiah Dewi Cahyani", "P"),
        StudentModel("Maulana Abdul Aziz", "L"),

        StudentModel("Moch Reno Alfiansyah", "L"),
        StudentModel("Muhammad Luthfi Rahman", "L"),
        StudentModel("Nabilah Putri Wibisono", "P"),
        StudentModel("Nasrul Haq Yahya", "L"),
        StudentModel("Nur Aulia Ismukanto", "P"),
        StudentModel("Nur Saadah Andreani", "P"),
        StudentModel("Nurul Aida", "P"),
        StudentModel("Panji Jusuf Gumilang", "L"),
        StudentModel("Putri Rizkia Permatasari", "P"),
        StudentModel("Rayhan Firdaus", "L"),

        StudentModel("Revi Septi Andriyani", "P"),
        StudentModel("Sahra Pra Cahyani", "P"),
        StudentModel("Sasi Kirana Bilqisthi", "P"),
        StudentModel("Satria Nugroho", "L"),
        StudentModel("Tabina Fauziyyah Rofa", "P"),
        StudentModel("Wirdah Amalia Ulfah", "P"),
        StudentModel("Zikriya Alisya Dafinna", "P"),
    )

    val studentsIPS4 = arrayOf(
        StudentModel("Alfia Maftuna Ramadhani", "P"),
        StudentModel("Andre Tri Prasetyo", "L"),
        StudentModel("Anissa Amelia Putri", "P"),
        StudentModel("Ariya Jaya", "L"),
        StudentModel("Astanovia Saffa Qodria", "P"),
        StudentModel("Citra Narita Pramesti", "P"),
        StudentModel("Davina", "P"),
        StudentModel("Dharma Raja Alfian", "L"),
        StudentModel("Dimas Sulistyo", "L"),
        StudentModel("Donatha Laudya Hanum", "P"),

        StudentModel("Dwi Arief Mifthahudin", "L"),
        StudentModel("Dyah Retno Satiti", "P"),
        StudentModel("Elia Elisabet Sihombing", "P"),
        StudentModel("Hafiz Alfarizy", "L"),
        StudentModel("Huwaiza Aisyah Syahla", "P"),
        StudentModel("Jeremiya Hutagaol", "L"),
        StudentModel("Jeven Alexander H", "L"),
        StudentModel("Kevin Agustian", "L"),
        StudentModel("Mikhael Jansen", "L"),
        StudentModel("Muhammad Filah", "L"),

        StudentModel("Muhammad Ghaly Ibrahim", "L"),
        StudentModel("Muhammad Ilham", "L"),
        StudentModel("Nadira Putri Utami", "P"),
        StudentModel("Niken Armesya Daniswaraa", "P"),
        StudentModel("Niza Hamidah", "P"),
        StudentModel("Normalisa Ilham Luviana", "P"),
        StudentModel("Pery", "L"),
        StudentModel("Rahma Alya Putri", "P"),
        StudentModel("Raihana", "P"),
        StudentModel("Raisya Zahrania Ahmad", "P"),

        StudentModel("Reno Herdian Pangeran", "L"),
        StudentModel("Rizal Rachmat Ramadan", "L"),
        StudentModel("Salwa Amalia Putri", "P"),
        StudentModel("Siti Halizah", "P"),
        StudentModel("Tamamun Khoirun Nisa", "P"),
        StudentModel("Tarisa Fadilah", "P"),
        StudentModel("Yabes Rafael Sihombing", "L"),
    )

//    val studentsIPS1 = arrayOf(
//        StudentModel("Abdul Aziz Siswanto", "L"),
//        StudentModel("Achmad Hariri", "L"),
//        StudentModel("Aldin Ikhwan Arrasyid", "L"),
//        StudentModel("Alvina Ilaiyah", "P"),
//        StudentModel("Amanda Zalfa", "P"),
//        StudentModel("Annisa Aulia Hasanah", "P"),
//        StudentModel("Bagus Riziq Pangestu", "L"),
//        StudentModel("Debby Alifah Maulida", "P"),
//        StudentModel("Dias Erlangga Kuntarto", "L"),
//        StudentModel("Dimas Maulana", "L"),
//        StudentModel("Dzaki Azharraya", "L"),
//        StudentModel("Faisal Prasetyo", "L"),
//        StudentModel("Hafshah Qoni'a Jafna", "P"),
//        StudentModel("Haura Ahnaf", "P"),
//        StudentModel("Ilma Fitria Marantika", "P"),
//        StudentModel("Indriyani", "P"),
//        StudentModel("Kho'irun Nisa Naz'wa", "P"),
//        StudentModel("Maulana Akbar Putra", "L"),
//        StudentModel("Maulida Aprianti", "P"),
//        StudentModel("Meylinda Putri Surahman", "P"),
//        StudentModel("Muhammad Afif Athallah", "L"),
//        StudentModel("Muhammad Farid", "L"),
//        StudentModel("Nanda Aulia", "P"),
//        StudentModel("Puji Amalia", "P"),
//        StudentModel("Putri Atshila Nazwa", "P"),
//        StudentModel("Raisha Trynanda", "P"),
//        StudentModel("Ramadhansyah Putra", "L"),
//        StudentModel("Ray Arjuna Sari", "L"),
//        StudentModel("Regen Revano Rawi Pahu", "L"),
//        StudentModel("Sarah Maulidya", "P"),
//        StudentModel("Satria Putra Djangkaru", "L"),
//        StudentModel("Shilda Afriyanti", "P"),
//        StudentModel("Siska Fauziah", "P"),
//        StudentModel("Terisa Mutia Sherlina", "P"),
//        StudentModel("Yuniza Rahmawati", "P"),
//        StudentModel("Zahra Afinur Alifah", "P"),
//    )

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