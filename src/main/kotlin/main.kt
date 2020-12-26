fun main() {
    val landingMessage = """
        :: BIENVENIDO A RECYPERMAKER ::
        
        Selecciona la opción deseada
        1. Hacer una receta
        2. Ver mis recetas
        3. Salir
        
    """.trimIndent()

    val chooseOptionMessage = "Elija su opción: "
    val chooseIngredientMessage = "Elija su ingrediente: "

    val listOfIngredients: List<String> = listOf("Agua", "Leche", "Carne", "Verduras", "Frutas", "Cereal", "Huevos", "Aceite")
    var savedIngredients: MutableList<String> = mutableListOf<String>()

    test@ do{

        println(landingMessage)
        print(chooseOptionMessage)

        val response = readLine()

        if(response?.toInt() == 1){

            do{
                println("\n:: Elija sus Ingredientes ::\n")

                listOfIngredients.forEachIndexed { index: Int, s: String ->
                    println("${index+1}. $s")
                }
                println("9. Salir al menú")

                print("\n$chooseIngredientMessage")


                val ingredientResponse = readLine()

                when(ingredientResponse?.toInt()) {
                    1 -> savedIngredients.add("Agua")
                    2 -> savedIngredients.add("Leche")
                    3 -> savedIngredients.add("Carne")
                    4 -> savedIngredients.add("Verduras")
                    5 -> savedIngredients.add("Frutas")
                    6 -> savedIngredients.add("Cereal")
                    7 -> savedIngredients.add("Huevos")
                    8 -> savedIngredients.add("Aceite")
                    else -> continue@test
                }


            }while(ingredientResponse?.toInt()!! <= 8)

        } else if(response?.toInt() == 2){
            test2@ do{
                println("""
                
                1. receta guardada: $savedIngredients
                2. Volver al menu
                
                """.trimIndent())
                print(chooseOptionMessage)

                val seeMenuResponse = readLine()
                if(seeMenuResponse?.toInt() == 2){
                    continue@test
                }else{
                    continue@test2
                }
            }while(seeMenuResponse?.toInt()!! <= 2)

        }else{
            print("\n\n :: Gracias por usar Recype Maker :) ::\n\n")
            break
        }
    }while(response?.toInt()!! < 3)

}