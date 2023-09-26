open class AdminAccount(username: String, password: String) : Account(username, password) {



    override fun toString(): String {
        return "Name: $username Password: $password"
    }

    fun adminOptionen(store: Store) {
        println("Was möchten Sie als Admin tun?")
        println("1. Artikel hinzufügen")
        println("2. Artikel löschen")
        println("3. Artikel nachbestellen")
        var adminOption = readlnOrNull()?.toIntOrNull()

        when (adminOption) {
            1 -> {
                try {
                    produktAbfrage()

                }catch (e:Exception){
                    println("Sorry Ungültige eingabe. Versuches nochmal")
                    adminOption
                }

            }

            2 -> {
                produktEntfernen()


            }

            3 -> {
                //Artikel nachbestellen
            }

            else -> println("Ungültige option")
        }


    }


    fun adminLogIn()
    {
        println("Bitte gib deinen Benutzernamen und dein Passwort ein")
        println("Benutzername: ")
        var benutzerName = readln()
        println("Password")
        var benutzerPassword = readln()

        if (store.adminList.any { it.username == benutzerName && it.password == benutzerPassword }) {
            adminOptionen(store)
        } else {
            println("Da ist was falsch gelaufen versuch es nochmal")
            adminLogIn()
        }
    }


}