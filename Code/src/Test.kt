fun produktAbfrage() {
    println("Welche Art von Artikel möchtest du Hinzufühgen")
    println(
        """Bitte gib             1 für Computer
                      2 für TV
                      3 für Schuhe
                      4 für Log OUT""".trimMargin()
    )
    var eingabe = readln().toInt()
    try {
        when (eingabe) {
            1 -> {
                println("Namen:")
                var name = readln()
                println("Preis:")
                var preis = readln().toDouble()
                println("Bewertung:")
                var bewertung = readln().toDouble()
                println("Fingersensor: ?")
                var fingersensor = readln().toBoolean()

                var computerHin = Computer(name, preis, bewertung, fingersensor)
                store.produktHinzu(store, computerHin)
            }

            2 -> {
                println("Namen:")
                var name = readln()
                println("Preis:")
                var preis = readln().toDouble()
                println("Bewertung:")
                var bewertung = readln().toDouble()
                println("4K möglich: ?")
                var vierK = readln().toBoolean()

                var tvHin = TV(name, preis, bewertung, vierK)
                store.produktHinzu(store, tvHin)
            }

            3 -> {
                println("Namen:")
                var name = readln()
                println("Preis:")
                var preis = readln().toDouble()
                println("Bewertung:")
                var bewertung = readln().toDouble()
                println("Grüße:")
                var groese = readln().toDouble()

                var schuheHin = Schuhe(name, preis, bewertung, groese)
                store.produktHinzu(store, schuheHin)
            }

            4 -> {
                store.exit()
            }

        }


    } catch (e: Exception) {
        println("Sorry Ungültige eingabe. Versuches nochmal")

    }
    println("Was möchtest du al nächstes machen")
    println(
        """Bitte gib             1 für Noch mehr Artikel Hinzufügen 
                      2 für Hauptmenü
                      3 für LOG OUT""".trimMargin()
    )
    try {
        var eingabe22 = readln().toInt()

        if (eingabe22 == 1) {
            produktAbfrage()

        } else if (eingabe22 == 2) {
            store.hauptMenu()
        } else if (eingabe22 == 3) {
            store.exit()
        }
    } catch (ex: java.lang.Exception) {
        println("Sorry Ungültige eingabe. Versuches nochmal")
    }
}

fun produktEntfernen() {
    println("Welche Art von Artikel möchtest du Entfernen")
    println("Gib Bitte die zahl vom Produkt ein die du Entfernen willst")
    store.produkteListe.forEachIndexed { index, produkt ->
        println("${index + 1}. ${produkt.name} (${produkt.preis})")
    }
    try {
        println(store.produkteListe)
        var eingabe = readln().toInt()
        var eingabe1 = store.produkteListe[eingabe - 1]
        store.prduktEntfer(store, eingabe1)
        eingabe1
        println(store.produkteListe)
        println("Willst du noch weitere Produkte Entfernen")
        var eingabe2 = readln().lowercase()
        when (eingabe2) {
            "ja" -> {
                produktEntfernen()
            }

            "j" -> {
                produktEntfernen()
            }

            "nein" -> {
                admin.adminOptionen(store)

            }

            "n" -> {
                admin.adminOptionen(store)

            }

        }


    } catch (e: Exception) {
        println("Ungültige eingabe.Bitte gib eine gültige zahl ein")
        produktEntfernen()
    }
}
