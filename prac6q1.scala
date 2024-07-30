object InventoryApp {

  type ProductID = Int
  type ProductName = String
  type Quantity = Int
  type Price = Double
  type ProductDetails = (ProductName, Quantity, Price)

  def main(args: Array[String]): Unit = {
   
    val inventory1: Map[ProductID, ProductDetails] = Map(
      01 -> ("suger", 20, 180.00),
      02 -> ("chocolate", 30,110.00),
      03 -> ("book", 40, 128.00)
    )

    val inventory2: Map[ProductID, ProductDetails] = Map(
      01 -> ("suger", 10, 178.00),
      04 -> ("pencil", 25, 18.50)
    )

    
    val productNames: Set[ProductName] = inventory1.values.map(_._1).toSet
    println(s"Product Names:\n${productNames.mkString("\n")} \n")

    

    val totalValue: Double = inventory1.values.map {
      case (_, quantity, price) => quantity * price
    }.sum
    println(s"Total Value: ${totalValue}\n")

   


    val isEmpty: Boolean = inventory1.isEmpty
    println(s"Is Inventory1 Empty: $isEmpty \n")

    


    val mergedInventory: Map[ProductID, ProductDetails] = (inventory1 ++ inventory2).map {
      case (id, (name, quantity, price)) =>
        id -> (
          if (inventory2.contains(id)) {
            val (name2, quantity2, price2) = inventory2(id)
            (name, quantity + quantity2, math.max(price, price2))
          } else {
            (name, quantity, price)
          }
        )
    }
    println("Merged Inventory:")
    mergedInventory.foreach { case (id, (name, quantity, price)) =>
      println(s"ID: $id >> Name: $name, Quantity: $quantity, Price: ${price}")
    }

    



    val productIdToCheck = 02
    val productDetails: Option[ProductDetails] = inventory1.get(productIdToCheck)
    productDetails match {
      case Some((name, quantity, price)) =>
        println(s"\nProduct ID $productIdToCheck exists.\n Details: Name: $name, Quantity: $quantity, Price: ${price}")
      case None =>
        println(s"\nProduct ID $productIdToCheck does not exist in inventory1.")
    }
  }
}
