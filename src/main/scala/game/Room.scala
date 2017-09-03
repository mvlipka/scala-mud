package game

class Room {
  var northRoom: Option[Room] = None: Option[Room]
  var southRoom: Option[Room] = None: Option[Room]
  var eastRoom: Option[Room] = None: Option[Room]
  var westRoom: Option[Room] = None: Option[Room]

  def step(): Unit = {
  }
}
