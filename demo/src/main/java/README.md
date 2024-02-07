

# Consumer Controller
## /users/register
    Belirtilen alanlar doldurulup bütün kullanıcılar buradan kayıt edilir
## /users/login
    email ve password alanları doldurulduktan sonra kullanıcı giriş
    yapmış olur ve bir adet token verilir

# Student Controller

## /student/change_comms
    Giriş yapan öğrenci email ,phone number ve token bilgilerini yazarak 
    öğrenci bilgilerini güncelleyebilir
## /student/get_student_survey
    Öğrenci token verisini girerek kayıtlı olduğu anketleri görebilir.
## /student/get_questions_by_survey
    /student/get_student_survey den alacağı id ve
    token parametrelerini vererek  seçtiği anketteki soruları görebilir .
## /student/answer_question
    /student/get_student_survey den alacağı id ,
    /student/get_questions_by_survey den alacağı id,
    ile beraber token ve soruya vermek istediğiniz 
    cevabı yazarak soru cevaplamış olursunuz
    

# Manager Controller

### /manager/find_surveys_by_teacher
    token göndererek öğretmenlerin açtıkları anketler görülebilir
### /manager/get_all_survey
    token göndererek bütün anketler görülebilir
### /manager/get_all_teacher
    token gönderilerek bütün öğretmenler görülebilir
### /manager/get_all_students
    token gönderilerek bütün öğrenciler görülebilir 

### /manager/add_manager
### /manager/add_teacher
### /manager/add_student
    Bu alanlarda teacher ,student veya manager kayıt edilebilir.
    
### /manager/get_Answers_By_Survey_And_Question
    /manager/get_all_survey 'den anket listesinden hangi anket
    soruları ve cevapları isteniyorsa o anketin id'si ve token verileri girilerek
    sorular ve verilen cevaplar listelenir .

### /manager/change_teacher_info
### /manager/change_student_info
    Bu kısımlardan teacher ve student bilgileri güncellenebilir 
    userId alanını  /manager/get_all_students ve /manager/get_all_teacher 
    buradan gelecek id alanı ve token girilmelidir.

# Teacher Controller 

### /teacher/get_student_by_survey
    surveyId ve token verileri girilerek ankete kayıtlı öğrenciler bulunur
### /teacher/get_all_questions
    token verisi girilerek soru havuzundaki bütün sorular getirilir
### /teacher/get_all_student
    token verisi girilerek bütün öğrenciler getirilir
### /teacher/get_my_questions
    token verisi girilerek öğretmene ait sorular getirilir.
### /teacher/get_my_survey
    token verisi girilerek öğretmene ait anketler getirilir.
### /teacher/add_question_to_pool
    token ve soru girilerek soru havuzuna soru eklenir.
### /teacher/add_survey
    token ve anket ismi girilerek anket oluşrulabilir .
### /teacher/add_question_to_survey
    /teacher/get_my_survey kısmında öğretmenin kendisine ait anketlerden anket id'si alınır 
    /teacher/get_all_questions veya  /teacher/get_my_questions alanlarından sorunun tamamı alınır .
    ve token verisi girilerek ankete soru eklenebilir .
### /teacher/add_student_to_survey
    /teacher/get_my_survey kısmında öğretmenin kendisine ait anketlerden anket id'si alınır
    /teacher/get_all_student kısmında eklenmek istenen öğrenciler seçilir
    ve token verisi girilerek ankete öğrenci eklenebilir.
### /teacher/get_answers_by_survey_and_question
    /teacher/get_my_survey kısmında öğretmenin kendisine ait anketlerden anket id'si alınır
    token ve id bilgisi girilerek sorular ve cevapları görüntülenebilir .

### /teacher/get_questions_by_survey
    /teacher/get_my_survey ile anket id si ve 
    token verisi girilerek anketteki sorular görülebilir
    
### /teacher/delete_survey
    /teacher/get_my_survey ile anket id si ve 
    token verisi girilerek silinmek istenen anket silinebilir.

### /teacher/delete_student
    /teacher/get_my_survey ile istenilen anketin id si
    /teacher/get_student_by_survey ile silinmek istenen öğrencilerin listesi
    ve token verileri girilerek öğrenciler silinir 

### /teacher/delete_question
    /teacher/get_my_survey ile istenilen anketin id si
    /teacher/get_questions_by_survey den istenilen sorular
    ve token verileri ile sorular silinebilir
    
















