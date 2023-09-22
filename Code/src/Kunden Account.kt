class KundenAccount(username: String, password: String) : Account(username, password) {

    override fun toString(): String {
        return "Name: $username Password: $password"
    }



    fun kundenRegist() {
        println("Bitte geben sie ihr Alter ein um zu überprüfen ab sie Alt genug sind für unseren Shop ")
        var minAge = readln().toInt()
        if (minAge >= 16) {
            println("Überprüfung erfolgreich")
            println("Bitte erstellen sie einen Benutzernamen und einen Passwort")
            println("Bitte Benutzername eingeben")
            var username1 = readln()
            println("Bitte Passwort eingeben")
            var password1 = readln()
            var neuAccount: KundenAccount = KundenAccount(username1, password1)

            store.kundenListe.add(neuAccount)
            println("Benutzer $username1 Name und Passwort $password1 wurden erfolgreich erstellt ")
            println("Bitte geben sie ihren Benutzernamen und ihr Passwort erneut ein. Sie haben 3 Versuche")
            for (i in 1..3) {
                println("Bitte Benutzername eingeben")
                var userCheck: String = readln()
                println("Bitte Passwort eingeben")
                var passwordCheck: String = readln()
                if (neuAccount.username == userCheck && neuAccount.password == passwordCheck) {
                    println("Benutzername und Passwort ist richtig")
                    store.einkauf()
                    break

                } else {
                    println("Da ist was falsch gelaufen versuch es nochmal")
                    println("Bitte Registerer dich erneut")

                }


            }
            kundenRegist()
        }


    }

}


fun kundenLogIn(){
    println("Bitte gib deinen Benutzernamen und dein Passwort ein")
    println("Benutzername: ")
    var benutzerName = readln()
    println("Password")
    var benutzerPassword = readln()
    if (store.kundenListe.any { it.username == benutzerName && it.password == benutzerPassword }){
        store.einkauf()
    }else{
        println("Da ist was falsch gelaufen versuch es nochmal")
        kundenLogIn()
    }
}


