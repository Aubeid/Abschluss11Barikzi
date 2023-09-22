import kotlin.system.exitProcess
var admin =AdminAccount("","")
var store = Store()
fun main() {
    //var store = Store()
    var admin =AdminAccount("","")
    var admin1 = AdminAccount("admin", "2334")
    admin.adminList.add(admin1)

    var kunde =  KundenAccount("","")
    var kunde1 = KundenAccount("marco","1111")
    var kunde2 = KundenAccount("ali", "2222")
    store.kundenListe.add(kunde1)
    store.kundenListe.add(kunde2)
    println(store.produkteListe)
    println("${store.kundenListe}")
    println(admin.adminList)




    println("\uD83C\uDD66\uD83C\uDD58\uD83C\uDD5B\uD83C\uDD5B\uD83C\uDD5A\uD83C\uDD5E\uD83C\uDD5C\uD83C\uDD5C\uD83C\uDD54\uD83C\uDD5D \uD83C\uDD51\uD83C\uDD54\uD83C\uDD58 \uD83C\uDD50\uD83C\uDD5C\uD83C\uDD50\uD83C\uDD69\uD83C\uDD5E\uD83C\uDD5D")
    //sleep(5000)

    println(
        """Bitte gib             1 für Registrieren
                      2 für LOG IN
                      3 für Admin
                      4 für Log OUT"""
    )
    when (readln().toInt()) {

        1 -> {
            kunde.kundenRegist()
        }
        2 -> {
            kundenLogIn()
        }
        3 -> {
            admin.adminLogIn()
        }
        4 -> (exitProcess(0))  // Von Gordans code kopiert
    }
}