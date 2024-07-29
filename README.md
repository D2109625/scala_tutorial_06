SCS 2204 - Functional Programming
Scala Tutorial – 06
1. You are managing an inventory system for a warehouse, where each product
is represented by a unique product ID along with details such as name,
quantity, and price. Your tasks include retrieving all product names from the
collection, calculating the total value of all products, checking if the collection is
empty, merging two collections of products by updating quantities and retaining
the highest price for products with the same ID, and checking if a product with
a specific ID exists and printing its details if it does.
Implement the following operations using Scala Maps
I. Retrieve all product names from inventory1.
II. Calculate the total value of all products in inventory1.
III. Check if inventory 1 is empty.
IV. Merge inventory1 and inventory2, updating quantities and retaining the
highest price.
V. Check if a product with a specific ID (e.g., 102) exists and print its
details.(Implement the code to check if product ID 102 exists in
inventory1 and print its details if it does.
2. Develop a Scala application for managing student records with the following
functionalities using Scala Tuples.
a. Function getStudentInfo:
Reads a student's name, marks, and total possible marks from
the keyboard. Validates input to ensure the name is not empty
and marks are positive integers not exceeding the total possible
marks. Calculates the percentage and assigns a grade based on:
1. A for percentage >= 90%
2. B for 75% <= percentage < 90%
3. C for 50% <= percentage < 75%
4. D for percentage < 50%
b. Function printStudentRecord:
Takes a tuple (name: String, marks: Int, totalMarks: Int,
percentage: Double, grade: Char) and prints:
c. Function validateInput:
Validates user input (name, marks, total possible marks) and
returns (isValid: Boolean, errorMessage: Option[String]).
d. Function getStudentInfoWithRetry:
Prompts the user for input until valid data is provided, using
validateInput. Returns the tuple as specified in getStudentInfo
