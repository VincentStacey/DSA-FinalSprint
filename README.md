# Binary Search Tree Visualizer (Spring Boot App)

This is a simple Spring Boot application that allows users to enter numbers, which are then used to construct a Binary Search Tree (BST). The BST is serialized to JSON and saved to a database. Users can also view previously submitted trees.

## Features

- Enter a sequence of numbers to create a BST
- BST is visualized as JSON
- History of previously submitted trees
- Input validation with user-friendly error handling
- Frontend built using Thymeleaf templates

## Technologies Used

- Java 17
- Spring Boot 3
- Spring Data JPA
- Thymeleaf
- MySQL (or compatible DB)
- Jackson (for JSON)
- Maven

## How It Works

1. **User Input:**
    - Navigate to `localhost:8080/enter-numbers`
    - Input comma-separated numbers (e.g. `5,2,7,1,3`)
    - Click **Submit**

2. **Processing:**
    - The backend creates a BST from the input
    - The BST is converted to a JSON structure
    - The input and tree are saved to the database

3. **Result Page:**
    - Shows the original input and JSON structure of the BST
    - Options to go back or view tree history

4. **View History:**
    - Go to `localhost:8080/previous-trees` to see a list of all past inputs and their BST JSON



