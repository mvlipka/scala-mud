package game

object World {
  var currentRoom: Room = _

  def init() = {

    currentRoom = new Room()
    Commander.registerMethod("go", (direction: String, _) => {
      direction.toLowerCase() match {
        case "north" => goNorth()
        case "south" => goSouth()
        case "east" => goEast()
        case "west" => goWest()
        case _ => println("Command not recognized")
      }
    })
  }

  def goNorth() = {
    currentRoom.northRoom match {
      case None => println("There is nowhere to go north")
      case _ => currentRoom = currentRoom.northRoom.get
    }
  }

  def goSouth() = {
    currentRoom.southRoom match {
      case None => println("There is nowhere to go south")
      case _ => currentRoom = currentRoom.southRoom.get
    }
  }

  def goEast() = {
    currentRoom.eastRoom match {
      case None => println("There is nowhere to go east")
      case _ => currentRoom = currentRoom.eastRoom.get
    }
  }

  def goWest() = {
    currentRoom.westRoom match {
      case None => println("There is nowhere to go west")
      case _ => currentRoom = currentRoom.westRoom.get
    }
  }

  def step() = {
    currentRoom.step()
  }
}
