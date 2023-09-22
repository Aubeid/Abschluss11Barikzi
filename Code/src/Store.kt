open class Store() {


    var kundenListe: MutableList<KundenAccount> = mutableListOf()


    var computer1:Computer = Computer("MacBook Air",1600.90, 4.6,true)
    var schuh1:Schuhe = Schuhe("Nike",80.95,3.8,42.5)
    var tv1 : TV = TV("Loewe",3570.99,4.9,true)
    var computer2:Computer = Computer("Lenovo",699.00,4.3,false)
    var schuhe2:Schuhe =Schuhe("Adidas Run",93.90,4.8,42.5)
    var tv2 : TV = TV("LG",4500.00,5.0,true)
    var produkteListe: MutableList<Produkt> = mutableListOf(computer1,schuh1,tv1,computer2,schuhe2,tv2)
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
        println(""" 1 für PayPal
        | 2 für Rechnung
        | 3 für Kreditkarte """.trimMargin())
        var eingabe3 = readln().toInt()
        try {

            when(eingabe3){
                1->{
                    println("Danke für ihren Einkauf.Sie bezahlen PayPal ")
                }
                2->{
                    println("Danke für ihren Einkauf.Sie bezahlen Rechnung ")
                }
                3->{
                    println("Danke für ihren Einkauf.Sie bezahlen Kreditkarte ")
                }
            }

        }catch (e:Exception){
            println("Ungültige eingabe.Bitte versuchen sie es erneut")

            eingabe3
        }


    }


    fun einkufHinzufuegen(store: Store,produkt: Produkt){
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

    fun prodNachPreisSortiert(){
        var sortierteProdukt: List<Produkt> = produkteListe.sortedBy { it.preis }
        println("Produkte nach Preis Sortiert")
        sortierteProdukt.forEach{ println("${it.name}-${it.preis} €") }
    }


    fun prodNachNameSortiert(){
        var sortierteProdukt: List<Produkt> = produkteListe.sortedBy { it.name }
        println("Produkte nach Preis Sortiert")
        sortierteProdukt.forEach{ println("${it.name}-${it.preis} €") }
    }


    /*fun prodByIndex(index:Int):Produkt?{
        if (index in 0..<produkteListe.size){
            return produkteListe[index]
        }
        return null
    }

     */





}