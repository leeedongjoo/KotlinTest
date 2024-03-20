fun main() {
    val question = Question()
    val user=User("Kotlin",31)
    println(user.name)
    println(user.age)
    val userJava = user.copy(name="Java")
    println(userJava.name)
    println(userJava.age)
    val userNull = user.copy(name = null)
    println(userNull)
    userJava.name?.let{println(it)}
    println("stop")

    question.question1()
    question.question2()
    question.question3()
    question.question4()
    question.question5()
    question.question6()
}


//test


class Question {
    fun question1() {
        println("question1")
        /*
        문제 1: 리스트에서 짝수만 필터링하기
        주어진 정수 리스트에서 짝수만을 추출하여 새 리스트로 반환하는 함수를 작성하세요.
         */
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val last = mutableListOf(0, 0, 0, 0, 0)
        var count = 0
        for (i in 0..9){
            var check = list[i]
            var result = check%2

            if(result == 0) {
                last[count]=check
                count++
            }
        }
        println(last)


    }

    fun question2() {
        println("question2")
        /*
        문제 2: 이름의 목록에서 길이가 5보다 큰 이름 찾기
        주어진 이름의 목록에서 길이가 5보다 큰 첫 번째 이름을 찾아 반환하는 함수를 작성하세요. 해당하는 이름이 없으면 "Not found"를 반환하세요.
         */
        val list = listOf("Kotlin", "Java", "C++", "JavaScript", "Python")
        for(i in 0..4){
            if(list[i].length>5){
                println(list[i])
            }
            else{
                println("Not found")
            }
        }

    }

    fun question3() {
        println("question3")
        /*
        문제 3: null이 포함될 수 있는 리스트에서 최대값 찾기
        null이 포함될 수 있는 정수 리스트에서 최대값을 찾아 반환하는 함수를 작성하세요. 리스트가 null이거나 비었으면 null을 반환하세요.
         교수정답
         val list = listOf(1, 2, 3, 4, 5, 6, null, 8, null, 10, 10)
         println(list.filterNotNull().maxOrNull())
         println(list.fliter{it==10})



         */
        val list = listOf(1, 2, 3, 4, 5, 6, null, 8, null, 10)
        var count = 0
        for(i in 0..9){

            if(list[i]==null) {
                println(null)
            }
            else{

                if(count< list[i]!!){
                    count = list[i]!!
                }
            }
        }
        println(count)

    }

    fun question4() {
        println("question4")
        /*
        문제 4: 사용자 입력 처리하기
        사용자로부터 받은 입력 문자열이 null이 아니고, "exit"가 아닐 때까지 계속 입력을 받아 그 내용을 출력하는 프로그램을 작성하세요.
        Tip: readLine() 함수를 사용하여 사용자 입력을 받을 수 있습니다.

        while(true){
        println("입력하세요")
        val input = readLine()?.takeUnless{it=="exit"}?:break
        println("exit를 입력하세요")
        }
         */

        do {
            println("exit를 입력할때까지 반복됩니다")
            val ord = readLine()
        } while (ord != "exit")
    }



    fun question5(): List<String?> {
        println("question5")
        /*
        문제 5: 리스트 변환하기
        주어진 User 객체의 리스트에서 각 사용자의 이름을 추출하여 새로운 리스트를 생성하되, 이름이 null이 아니고 3글자 이상인 사용자의 이름만 대문자로 변환하여 포함시키는 함수를 작성하세요.
         users.map {
            if (it.name != null && it.name.length > 3){
            (it.name.uppercase())
            }
            else{
                null
        }
        */
        val users = listOf(
            User("Kotlin", 31),
            User("Java", 20),
            User(null, 25),
            User("C", 40),
            User("JS", 30),
            User("Python", 35)
        )
        val usersFilter = users.filter{it.name!=null && it.name!!.length >= 3}
        println("userFilter $usersFilter")
        return users.filter{ it.name!=null && it.name.length >= 3}.map { it.name?.uppercase()}

    }

    fun question6() {
        /*
        return orders.filter{it.isDelivered}
            .flatMap{it.products}
            .filter{it.price>=100}
            .map{it.apply{
            this.name = this.name.uppercase()
        }}
        문제 6: 복잡한 조건의 데이터 처리
        주어진 Order 객체 리스트에서 isDelivered가 true인 주문을 찾고, 해당 주문의 products 리스트에서 price가 100 이상인 제품의 이름을 대문자로 변환하여 새 리스트를 생성하는 함수를 작성하세요.
         */
        val orders = listOf(
            Order(
                listOf(Product("Kotlin", 100), Product("Java", 80), Product("C", 60)),
                true
            ),
            Order(
                listOf(Product("JS", 120), Product("Python", 90), Product("C++", 110)),
                false
            ),
            Order(
                listOf(Product("C#", 70), Product("Swift", 130), Product("Go", 40)),
                true
            ),
            Order(
                listOf(Product("Ruby", 110), Product("R", 50), Product("Dart", 90)),
                false
            ),
            Order(
                listOf(Product("TypeScript", 100), Product("PHP", 80), Product("Scala", 120)),
                true
            )
        )
        val a =orders.filter{it.isDelivered}
            .flatMap{it.products}
            .filter{it.price>=100}
            .map{it.apply{
            this.name = this.name.uppercase()
        }}
        println(a)
    }
}
