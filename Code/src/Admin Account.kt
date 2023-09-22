open class AdminAccount(username: String, password: String) : Account(username, password) {

    var adminList: MutableList<AdminAccount> = mutableListOf()

    override fun toString(): String {
        return "Name: $username Password: $password"
    }

    fun adminOptionen(store: Store, adminAccount: AdminAccount) {
        println("Was möchten Sie als Admin tun?")
        println("1. Artikel hinzufügen")
        println("2. Artikel löschen")
        println("3. Artikel nachbestellen")
        var adminOption = readlnOrNull()?.toIntOrNull()

        when (adminOption) {
            1 -> {
                try {
                    println("Welches Produkt möchtest du hinzufügen")
                    println("Name,Preis,Bewertung,Finger Sensor")
                    var prodHinzu: Computer = Computer(readln(), readln().toDouble(), readln().toDouble(), readln().toBoolean())

                    store.produkteListe.add(prodHinzu)
                    println("Produkt wurde Hinzugefügt")
                    println(store.prodNachNameSortiert())
                }catch (e:Exception){
                    println("Sorry Ungültige eingabe. Versuches nochmal")
                    adminOption
                }

            }

            2 -> {
                (store.produkteListe.forEach { println(it.name) })
                var entfer = store.produkteListe
                store.prduktEntfer(store, store.schuh1)


            }

            3 -> {
                //Artikel nachbestellen
            }

            else -> println("Ungültige option")
        }


    }


    fun adminLogIn() {
        println("Bitte gib deinen Benutzernamen und dein Passwort ein")
        println("Benutzername: ")
        var benutzerName = readln()
        println("Password")
        var benutzerPassword = readln()
        var adminCheck: AdminAccount = AdminAccount(benutzerName, benutzerPassword)

        if (admin.adminList.any { it.username == benutzerName && it.password == benutzerPassword }) {
            adminOptionen(store, adminCheck)
        } else {
            println("Da ist was falsch gelaufen versuch es nochmal")
            adminLogIn()
        }
    }


}