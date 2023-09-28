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

    var produkteListe: MutableList<Produkt> = mutableListOf(
        computer1,
        schuh1,
        tv1,
        computer2,
        schuhe2,
        tv2,
        Computer("HP Pavilion", 899.99, 4.5, true),
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


    /**
     * Diese Funktion beendet das laufende Programm und beendet die Ausführung ohne weitere Verarbeitung
     * oder Aktionen auszuführen. Es wird der Exit-Code 0 zurückgegeben, was üblicherweise auf einen
     * erfolgreichen Programmabschluss hinweist.
     */
    fun exit() {
        (exitProcess(0))
    }


    /**
     *Hauptmenü der Anwendung.
     *
     * Diese Funktion zeigt das Hauptmenü der Anwendung an und ermöglicht dem Benutzer die Auswahl
     * verschiedener Optionen wie Registrieren, Einloggen, als Administrator einloggen oder Ausloggen.
     * Je nach Auswahl wird die entsprechende Funktion aufgerufen.
     */
    fun hauptMenu() {
        println("Du Befindest dich im Hauptmenü")
        println(
            """Bitte gib             1 für Registrieren
                      2 für LOG IN
                      3 für Admin
                      4 für Log OUT"""
        )
        when (readln().toInt()) {

            1 -> {
                kundenRegist()
            }

            2 -> {
                kundenLogIn()
            }

            3 -> {
                adminLogIn()
            }

            4 -> exit()  // Von Gordans code kopiert

        }
    }

    /**
     * Berechnet den Gesamtpreis aller Artikel im Einkaufswagen und gibt ihn als formatierten String zurück.
     *
     * Diese Funktion berechnet den Gesamtpreis aller Artikel im Einkaufswagen und gibt ihn als formatierten
     * String zurück, der auf zwei Dezimalstellen gerundet ist.
     *
     * @return Der Gesamtpreis der Artikel im Einkaufswagen als formatierter String.
     */
    fun einkaufsKorbTotal(): String {
        val total = einkaufsWagen.sumOf { it.preis }
        return String.format("%.2f", total)
    }

    /**
     * Zeigt ein Menü zum Sortieren und Filtern von Artikeln an und führt die entsprechenden Aktionen aus.
     *
     * Diese Funktion zeigt dem Benutzer ein Menü mit Optionen zum Sortieren und Filtern von Artikeln an. Je nach
     * Benutzerwahl wird die entsprechende Sortier- oder Filterfunktion aufgerufen und danach kehrt sie zum Einkaufsmenü zurück.
     * Wenn der Benutzer die Option "Zurück" auswählt, wird er ebenfalls zum Einkaufsmenü zurückgeleitet.
     */
    fun sortierOption() {
        println("Nach was möchten sie Sorieren/Filtern")
        println("1. Artikel nach Preis Sortieren")
        println("2. Artikel nach Name Sortieren")
        println("3. Zurück .")
        var sotierInput = readln()?.toInt()
        when (sotierInput) {
            1 -> {
                prodNachPreisSortiert()
            }

            2 -> {
                prodNachNameSortiert()

            }

            3 -> {

            }
        }
    }

    /**
     * Einkaufsmenü, das es dem Benutzer ermöglicht, Produkte auszuwählen und in den Einkaufswagen zu legen.
     *
     * Diese Funktion zeigt dem Benutzer die verfügbaren Produkte an und ermöglicht ihm, Produkte auszuwählen und
     * in den Einkaufswagen zu legen. Der Benutzer kann seine Auswahl fortsetzen oder den Einkauf beenden und zur
     * Bezahlung übergehen. Die ausgewählten Produkte und die Gesamtsumme werden angezeigt.
     */
    fun einkauf() {
        println("Willkommen im Shop")
        println("das sind unsere produkte")

        //sortierOption()

       produkteListe.forEachIndexed { index, produkt ->
            println("${index + 1}. ${produkt.name} (${produkt.preis})")
        }




        try {

            println("Bitte wählen sie ihr produkt aus was sie kaufen möchten und geben sie die zahl ein ")

            var eingabe = readln().toInt()
            var eingabe1 = produkteListe[eingabe - 1]
            einkufHinzufuegen(eingabe1)
            eingabe1
            println(einkaufsWagen)
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
                    println("Das sind die prudukte in deinem Einkaufskorb ${einkaufsWagen} mit der gesamt summe ${einkaufsKorbTotal()}")

                }

                "n" -> {
                    println("Das sind die prudukte in deinem Einkaufskorb ${einkaufsWagen}")
                    println("Gesamtsumme: ${einkaufsKorbTotal()}")

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

    /**
     * Führt die Registrierung eines Kunden im Shop durch.
     *
     * Diese Funktion führt den Registrierungsprozess eines Kunden im Shop durch. Sie überprüft das Alter des
     * Benutzers, erstellt dann einen Benutzernamen und ein Passwort für das Konto und fügt das Konto zur Liste
     * der Kundenkonten hinzu. Nach der Registrierung wird der Benutzer aufgefordert, sich mit seinem neuen
     * Konto anzumelden, wobei er drei Versuche hat, das richtige Benutzername-Passwort-Paar einzugeben.
     */
    fun kundenRegist() {
        println("Bitte geben sie ihr Alter ein um zu überprüfen ab sie Alt genug sind für unseren Shop ")
        var minAge = readln().toInt()
        if (minAge >= 16) {
            println("Überprüfung erfolgreich")
            Thread.sleep(2000)
            println("Bitte erstellen sie einen Benutzernamen und einen Passwort")
            println("Bitte Benutzername eingeben")
            var username1 = readln()
            println("Bitte Passwort eingeben")
            var password1 = readln()
            var neuAccount: KundenAccount = KundenAccount(username1, password1)

            kundenListe.add(neuAccount)
            println("Benutzer $username1 Name und Passwort $password1 wurden erfolgreich erstellt ")
            println("Bitte geben sie ihren Benutzernamen und ihr Passwort erneut ein. Sie haben 3 Versuche")
            Thread.sleep(2000)
            for (i in 1..3) {
                println("Bitte Benutzername eingeben")
                var userCheck: String = readln()
                println("Bitte Passwort eingeben")
                var passwordCheck: String = readln()
                if (neuAccount.username == userCheck && neuAccount.passwort == passwordCheck) {
                    println("Benutzername und Passwort ist richtig")
                    einkauf()
                    break

                } else {
                    println("Da ist was falsch gelaufen versuch es nochmal")
                    println("Bitte Registerer dich erneut")

                }


            }
            kundenRegist()
        }


    }

    /**
     * Führt den Anmeldevorgang für Kunden im Shop durch.
     *
     * Diese Funktion fordert den Benutzer auf, seinen Benutzernamen und sein Passwort einzugeben, um sich im Shop anzumelden.
     * Sie überprüft, ob die eingegebenen Anmeldeinformationen in der Liste der Kundenkonten vorhanden sind. Wenn ja, wird
     * der Benutzer zur Einkaufsfunktion weitergeleitet. Andernfalls wird er aufgefordert, es erneut zu versuchen.
     */
    fun kundenLogIn() {
        println("Bitte gib deinen Benutzernamen und dein Passwort ein")
        println("Benutzername: ")
        var benutzerName = readln()
        println("Password")
        var benutzerPassword = readln()

        if (kundenListe.any { it.username == benutzerName && it.passwort == benutzerPassword }) {
            einkauf()
        } else {
            println("Da ist was falsch gelaufen versuch es nochmal")
            kundenLogIn()
        }
    }

    /**
     * Sortiert die Liste der Produkte nach dem Preis und gibt sie aus.
     *
     * Diese Funktion sortiert die Liste der Produkte nach dem Preis in aufsteigender Reihenfolge und gibt die
     * sortierte Liste aus. Jedes Produkt wird mit seinem Namen und Preis in Euro formatiert und angezeigt.
     */
    fun prodNachPreisSortiert() {
        var sortierteProdukt: List<Produkt> = produkteListe.sortedBy { it.preis }
        println("Produkte nach Preis Sortiert")
        sortierteProdukt.forEachIndexed{ index, produkt -> println("${index + 1}. ${produkt.name} (${produkt.preis})")}
        }
    /**
     * Sortiert die Liste der Produkte nach dem Namen und gibt sie aus.
     *
     * Diese Funktion sortiert die Liste der Produkte nach dem Namen in aufsteigender Reihenfolge und gibt die
     * sortierte Liste aus. Jedes Produkt wird mit seinem Namen und Preis in Euro formatiert und angezeigt.
     */
    fun prodNachNameSortiert() {
        var sortierteProdukt: List<Produkt> = produkteListe.sortedBy { it.name }
        println("Produkte nach Preis Sortiert")
        sortierteProdukt.forEachIndexed{ index, produkt -> println("${index + 1}. ${produkt.name} (${produkt.preis})")}
    }

    /**
     * Fügt ein Produkt dem Einkaufswagen hinzu.
     *
     * Diese Funktion fügt das angegebene Produkt dem Einkaufswagen hinzu und gibt eine Bestätigungsnachricht aus.
     *
     * @param produkt Das Produkt, das dem Einkaufswagen hinzugefügt werden soll.
     */
    fun einkufHinzufuegen(produkt: Produkt) {
        einkaufsWagen.add(produkt)
        println("${produkt.name} wurde zum Warenkorb Hinzugefügt")
    }

    /**
     * Ermöglicht dem Administrator, Produkte aus der Liste zu entfernen.
     *
     * Diese Funktion zeigt dem Administrator eine Liste aller Produkte an und ermöglicht ihm, Produkte zu entfernen,
     * indem er die entsprechende Zahl des zu entfernenden Produkts eingibt. Nach dem Entfernen wird die aktualisierte
     * Liste der Produkte angezeigt, und der Administrator kann entscheiden, ob er weitere Produkte entfernen möchte oder
     * zu den Administratoroptionen zurückkehren möchte.
     */
    fun produktEntfernenOption() {
        println("Welche Art von Artikel möchtest du Entfernen")
        println("Gib Bitte die zahl vom Produkt ein die du Entfernen willst")
        produkteListe.forEachIndexed { index, produkt ->
            println("${index + 1}. ${produkt.name} (${produkt.preis})")
        }
        try {
            println(produkteListe)
            var eingabe = readln().toInt()
            var eingabe1 = produkteListe[eingabe - 1]
            prduktEntfer(eingabe1)
            eingabe1
            println(produkteListe)
            println("Willst du noch weitere Produkte Entfernen")
            var eingabe2 = readln().lowercase()
            when (eingabe2) {
                "ja" -> {
                    produktEntfernenOption()
                }

                "j" -> {
                    produktEntfernenOption()
                }

                "nein" -> {
                    adminOptionen()

                }

                "n" -> {
                    adminOptionen()

                }

            }


        } catch (e: Exception) {
            println("Ungültige eingabe.Bitte gib eine gültige zahl ein")
            produktEntfernenOption()
        }
    }


    /**
     * Führt den Anmeldevorgang für Administratoren durch.
     *
     * Diese Funktion fordert den Administrator auf, seinen Benutzernamen und sein Passwort einzugeben, um sich als Administrator
     * anzumelden. Sie überprüft, ob die eingegebenen Anmeldeinformationen in der Liste der Administrator-Konten vorhanden sind.
     * Wenn dies der Fall ist, wird der Administrator zu den Administratoroptionen weitergeleitet. Andernfalls wird er aufgefordert,
     * es erneut zu versuchen.
     */
    fun adminLogIn() {
        println("Bitte gib deinen Benutzernamen und dein Passwort ein")
        println("Benutzername: ")
        var benutzerName = readln()
        println("Password")
        var benutzerPassword = readln()

        if (adminList.any { it.username == benutzerName && it.passwort == benutzerPassword }) {
            adminOptionen()
        } else {
            println("Da ist was falsch gelaufen versuch es nochmal")
            adminLogIn()
        }
    }

    /**
     * Zeigt die Administratoren-Optionen an und ermöglicht es dem Administrator, verschiedene Aktionen auszuwählen.
     *
     * Diese Funktion zeigt dem Administrator eine Liste von Optionen an, die er als Administrator auswählen kann. Dazu gehören das
     * Hinzufügen von Artikeln, das Entfernen von Artikeln und das Nachbestellen von Artikeln. Der Administrator kann eine Option
     * auswählen, und je nach seiner Auswahl wird die entsprechende Aktion ausgeführt.
     */
    fun adminOptionen() {
        println("Was möchten Sie als Admin tun?")
        println("1. Artikel hinzufügen")
        println("2. Artikel löschen")
        println("3. Artikel nachbestellen")
        var adminOption = readlnOrNull()?.toIntOrNull()
        try {
            when (adminOption) {

                1 -> {
                    produktHinzuOption()
                    println("Sorry Ungültige eingabe. Versuches nochmal")
                    adminOption
                }

                2 -> {
                    produktEntfernenOption()
                }

                3 -> {

                }

                else -> println("Ungültige option")
            }
        } catch (e: Exception) {
            println("Ungültige option")
        }


    }

    /**
     * Ermöglicht dem Administrator, neue Artikel hinzuzufügen.
     *
     * Diese Funktion zeigt dem Administrator eine Liste von Produktkategorien an, aus denen er auswählen kann, um neue Artikel
     * hinzuzufügen. Je nach ausgewählter Kategorie werden die erforderlichen Informationen abgefragt, um einen neuen Artikel zu
     * erstellen, z. B. Name, Preis, Bewertung und spezifische Eigenschaften der Kategorie (z. B. Fingersensor für Computer oder
     * 4K-Fähigkeit für TVs). Nach dem Hinzufügen eines neuen Artikels kann der Administrator entscheiden, ob er weitere Artikel
     * hinzufügen, zum Hauptmenü zurückkehren oder sich abmelden möchte.
     */
    fun produktHinzuOption() {
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
                    produktHinzu(computerHin)
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
                    produktHinzu(tvHin)
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
                    produktHinzu(schuheHin)
                }

                4 -> {
                    exit()
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
                produktHinzuOption()

            } else if (eingabe22 == 2) {
                hauptMenu()
            } else if (eingabe22 == 3) {
                exit()
            }
        } catch (ex: java.lang.Exception) {
            println("Sorry Ungültige eingabe. Versuches nochmal")
        }
    }

    /**
     * Fügt ein neues Produkt zur Liste der Produkte hinzu.
     *
     * Diese Funktion fügt das angegebene Produkt zur Liste der Produkte hinzu und gibt eine Bestätigungsnachricht aus.
     *
     * @param produkt Das Produkt, das zur Liste hinzugefügt werden soll.
     */
    fun produktHinzu(produkt: Produkt) {
        produkteListe.add(produkt)
        println("${produkt.name} wurde Hinzugefügt")
    }

    /**
     * Entfernt ein Produkt aus der Liste der Produkte.
     *
     * Diese Funktion entfernt das angegebene Produkt aus der Liste der Produkte und gibt eine Bestätigungsnachricht aus.
     *
     * @param produkt Das Produkt, das aus der Liste entfernt werden soll.
     */
    fun prduktEntfer(produkt: Produkt) {
        produkteListe.remove(produkt)
        println("${produkt.name} wurde Entfernt")
    }


}