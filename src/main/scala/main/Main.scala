package main

import game.{Commander, Player, World}

import scala.io.StdIn

object Main extends App {
  // Initialize world
  println("Loading world...")
  World.init()
  println("World loaded!\n")

  // Welcome message and name input
  println("Welcome to World of Scala!")
  var name = StdIn.readLine("Please enter your name: ")
  Player.name = name

  println(s"Hello, ${Player.name}")

  // Game loop
  while (true) {
    val input = StdIn.readLine(":")

    Commander.run(input)

    World.step()
  }
}
