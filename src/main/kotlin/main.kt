fun main() {
    val landingMessage = {println("""
        :: BIENVENIDO A RECYPERMAKER ::
        
        Selecciona la opción deseada
        1. Hacer una receta
        2. Ver mis recetas
        3. Salir
        
    """.trimIndent())}

    val chooseOptionMessage = { print("Elija su opción: ") }
    val chooseIngredientMessage = { print("\nElija su ingrediente: " )}

    val listOfIngredients: List<String> = listOf("Agua", "Leche", "Carne", "Verduras", "Frutas", "Cereal", "Huevos", "Aceite")
    val savedIngredients: MutableList<String> = mutableListOf<String>()

    val makeRecipe = { list: List<String> ->

        println("\n:: Elija sus Ingredientes ::\n")

        listOfIngredients.forEachIndexed { index: Int, s: String ->
            println("${index+1}. $s")
        }
        println("9. Salir al menú")
    }

    val viewRecipe = { ingredientes: MutableList<String>,  response: String? ->

        when(response?.toInt()) {
            1 -> savedIngredients.add("Agua")
            2 -> savedIngredients.add("Leche")
            3 -> savedIngredients.add("Carne")
            4 -> savedIngredients.add("Verduras")
            5 -> savedIngredients.add("Frutas")
            6 -> savedIngredients.add("Cereal")
            7 -> savedIngredients.add("Huevos")
            8 -> savedIngredients.add("Aceite")
            else -> landingMessage()
        }
    }

    val viewSaved = { ingredients: MutableList<String> ->

        println("""
                
                1. receta guardada: $ingredients
                2. Volver al menu
                
                """.trimIndent())
        chooseOptionMessage()

        val resp = readLine()

        when(resp?.toInt()){
            1 -> println(ingredients)
            2 -> landingMessage()
        }

    }



    test@ do{

        landingMessage()
        chooseOptionMessage()

        val response = readLine()

        if(response?.toInt() == 1){

            do{

                makeRecipe(listOfIngredients)

                chooseIngredientMessage()

                val ingredientResponse = readLine()

                viewRecipe(savedIngredients, ingredientResponse)


            }while(ingredientResponse?.toInt()!! <= 8)

        } else if(response?.toInt() == 2){

            viewSaved(savedIngredients)

        }else{
            print("\n\n :: Gracias por usar Recype Maker :) ::\n\n")
            break
        }
    }while(response?.toInt()!! < 3)

}