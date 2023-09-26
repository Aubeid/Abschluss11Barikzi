import kotlin.system.exitProcess

open class Store() {


    var kundenListe: MutableList<KundenAccount> = mutableListOf()
    var adminList: MutableList<AdminAccount> = mutableListOf()


    var computer1: Computer = Computer("MacBook Air", 1600.90, 4.6, true)
    var schuh1: Schuhe = Schuhe("Nike", 80.95, 3.8, 42.5)
    var tv1: TV = TV("Loewe", 3570.99, 4.9, true)
    var computer2: Computer = Computer("Lenovo", 699.00, 4.3, false)
    var schuhe2: Schuhe = Schuhe("Adidas Run", 93.90, 4.8, 42.5)
    var tv2: TV = TV("LG", 4500.00, 5.0, true)

    var produkteListe: MutableList<Produkt> = mutableListOf(computer1, schuh1, tv1, computer2, schuhe2, tv2,Computer("HP Pavilion", 899.99, 4.5, true),
        Schuhe("Puma Sport", 65.50, 4.2, 41.0),
        TV("Samsung", 3200.00, 4.7, false),
        Computer("Dell XPS", 1200.00, 4.8, true),
        Schuhe("Reebok Classic", 75.25, 4.1, 43.0),
        TV("Sony Bravia", 4100.00, 4.6, true),
        // Fügen Sie hier weitere 30 Artikel hinzu
        Computer("Acer Aspire", 799.00, 4.4, false),
        Schuhe("New Balance", 88.75, 4.0, 44.5),
        TV("Toshiba", 2800.00, 4.3, true),
        Computer("Asus Zenbook", 1350.00, 4.7, true),
        Schuhe("Converse All Star", 70.00, 4.5, 39.0),
        TV("Panasonic", 3800.00, 4.8, true),
        Computer("Microsoft Surface", 1200.00, 4.6, true),
        Schuhe("Vans Old Skool", 60.50, 4.3, 42.0),
        TV("Sharp", 3400.00, 4.5, true),
        Computer("Apple iMac", 1999.00, 4.9, true),
        Schuhe("Skechers Go Walk", 55.80, 4.2, 41.0),
        TV("Philips", 3100.00, 4.4, true),
        Computer("HP Envy", 1099.00, 4.7, true),
        Schuhe("Under Armour", 78.25, 4.1, 43.0),
        TV("Hisense", 2700.00, 4.6, true)
    )
    var einkaufsWagen: MutableList<Produkt> = mutableListOf()

    fun einkaufsWagenTotal(): String {
        val total = einkaufsWagen.sumOf { it.preis }
        return String.format("%.2f", total)
    }

    /*fun einkaufsWagenTotal(): Double {
        return einkaufsWagen.sumOf { it.preis }
    }
     */

    fun einkauf() {
        println("Willkommen im Shop")
        println("das sind unsere produkte")

        store.produkteListe.forEachIndexed { index, produkt ->
            println("${index + 1}. ${produkt.name} (${produkt.preis})")
        }

        try {

            println("Bitte wählen sie ihr produkt aus was sie kaufen möchten und geben sie die zahl ein ")

            var eingabe = readln().toInt()
            var eingabe1 = store.produkteListe[eingabe - 1]
            store.einkufHinzufuegen(store, eingabe1)
            eingabe1
            println("${store.einkaufsWagen}")
            println("Willst du noch weiter Einkaufen")
            var eingabe2 = readln().lowercase()
            when (eingabe2) {
                "ja" -> {
                    einkauf()
                }

                "j" -> {
                    einkauf()
                }

                "nein" -> {
                    println("Das sind die prudukte in deinem Einkaufskorb ${store.einkaufsWagen} mit der gesamt summe ${store.einkaufsWagenTotal()}")

                }

                "n" -> {
                    println("Das sind die prudukte in deinem Einkaufskorb ${store.einkaufsWagen}")
                    println("Gesamtsumme: ${store.einkaufsWagenTotal()}")

                }

            }


        } catch (e: Exception) {
            println("Ungültige eingabe.Bitte gib eine gültige zahl ein")
            einkauf()
        }

        println("Wie möchtest du Bezahlen?")
        println(
            """ 1 für PayPal
        | 2 für Rechnung
        | 3 für Kreditkarte """.trimMargin()
        )
        var eingabe3 = readln().toInt()
        try {

            when (eingabe3) {
                1 -> {
                    println("Danke für ihren Einkauf.Sie bezahlen PayPal ")
                    hauptMenu()
                }

                2 -> {
                    println("Danke für ihren Einkauf.Sie bezahlen Rechnung ")
                    hauptMenu()
                }

                3 -> {
                    println("Danke für ihren Einkauf.Sie bezahlen Kreditkarte ")
                    hauptMenu()
                }
            }

        } catch (e: Exception) {
            println("Ungültige eingabe.Bitte versuchen sie es erneut")

            eingabe3
        }


    }

    fun exit(){
        (exitProcess(0))
    }


    fun einkufHinzufuegen(store: Store, produkt: Produkt) {
        einkaufsWagen.add(produkt)
        println("${produkt.name} wurde zum Warenkorb Hinzugefügt")

    }

    fun produktHinzu(store: Store, produkt: Produkt) {
        store.produkteListe.add(produkt)
        println("${produkt.name} wurde Hinzugefügt")
    }

    fun prduktEntfer(store: Store, produkt: Produkt) {
        store.produkteListe.remove(produkt)
        println("${produkt.name} wurde Entfernt")
    }

    fun prodNachPreisSortiert() {
        var sortierteProdukt: List<Produkt> = produkteListe.sortedBy { it.preis }
        println("Produkte nach Preis Sortiert")
        sortierteProdukt.forEach { println("${it.name}-${it.preis} €") }
    }


    fun prodNachNameSortiert() {
        var sortierteProdukt: List<Produkt> = produkteListe.sortedBy { it.name }
        println("Produkte nach Preis Sortiert")
        sortierteProdukt.forEach { println("${it.name}-${it.preis} €") }
    }


    /*fun prodByIndex(index:Int):Produkt?{
        if (index in 0..<produkteListe.size){
            return produkteListe[index]
        }
        return null
    }

     */


    fun hauptMenu(){
        println("Du Befindest dich im Hauptmenü")
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
                kunde.kundenLogIn()
            }

            3 -> {
                admin.adminLogIn()
            }

            4 -> exit()  // Von Gordans code kopiert

        }
    }


}