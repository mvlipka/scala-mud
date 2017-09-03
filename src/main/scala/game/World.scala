package game

object World {
  var currentRoom: Room = _

  def init(): Unit = {

    currentRoom = new Room()
    Commander.registerMethod("go", (direction: String, _) => {
      direction.toLowerCase() match {
        case "north" => goNorth()
        case "south" => goSouth()
        case "east" => goEast()
        case "west" => goWest()
        case _ => println(s"Direction $direction not recognized")
      }
    })
  }

  def goNorth(): Unit = {
    currentRoom.northRoom match {
      case None => println("There is nowhere to go north")
      case _ => {
        currentRoom.cleanup()
        currentRoom = currentRoom.northRoom.get
        currentRoom.init()
        currentRoom
      }
    }
  }

  def goSouth(): Unit = {
    currentRoom.southRoom match {
      case None => println("There is nowhere to go south")
      case _ => {
        currentRoom.cleanup()
        currentRoom = currentRoom.southRoom.get
        currentRoom.init()
        currentRoom
      }
    }
  }

  def goEast(): Unit = {
    currentRoom.eastRoom match {
      case None => println("There is nowhere to go east")
      case _ => currentRoom = {
        currentRoom.cleanup()
        currentRoom = currentRoom.eastRoom.get
        currentRoom.init()
        currentRoom
      }
    }
  }

  def goWest(): Unit = {
    currentRoom.westRoom match {
      case None => println("There is nowhere to go west")
      case _ => currentRoom = {
        currentRoom.cleanup()
        currentRoom = currentRoom.westRoom.get
        currentRoom.init()
        currentRoom
      }
    }
  }

  def step(): Unit = {
    currentRoom.step()
  }
}
