import kotlin.system.exitProcess
var admin =AdminAccount("","")
var store = Store()
var kunde =  KundenAccount("","")
fun main() {
    var admin1 = AdminAccount("admin", "1111")
    store.adminList.add(admin1)

    var kunde1 = KundenAccount("marco","1111")
    var kunde2 = KundenAccount("ali", "2222")
    store.kundenListe.add(kunde1)
    store.kundenListe.add(kunde2)
    println(store.produkteListe)
    println("${store.kundenListe}")
    println(store.adminList)




    println("\uD83C\uDD66\uD83C\uDD58\uD83C\uDD5B\uD83C\uDD5B\uD83C\uDD5A\uD83C\uDD5E\uD83C\uDD5C\uD83C\uDD5C\uD83C\uDD54\uD83C\uDD5D \uD83C\uDD51\uD83C\uDD54\uD83C\uDD58 \uD83C\uDD50\uD83C\uDD5C\uD83C\uDD50\uD83C\uDD69\uD83C\uDD5E\uD83C\uDD5D")
    //sleep(5000)

    store.hauptMenu()

}