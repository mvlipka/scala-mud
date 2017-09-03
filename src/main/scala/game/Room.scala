package game

class Room {
  var northRoom: Option[Room] = None: Option[Room]
  var southRoom: Option[Room] = None: Option[Room]
  var eastRoom: Option[Room] = None: Option[Room]
  var westRoom: Option[Room] = None: Option[Room]

  // Initialize room and register room specific commands and events
  def init(): Unit = {

  }

  def step(): Unit = {
  }

  // Deregister commands and clean up room specific events
  def cleanup(): Unit = {

  }
}
