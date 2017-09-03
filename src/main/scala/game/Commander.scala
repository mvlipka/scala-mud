package game

object Commander {

  var commands: Map[String, (String, String) => Unit] = Map()

  def registerMethod(command: String, f: (String, String) => Unit) = {
    commands += (command -> f)
  }

  def run(command: String) = {
    val parsedInput: Array[String] = parse(command)

    val verb = parsedInput(0)
    var actor = ""
    var other = ""

    parsedInput.length match {
      case 2 => actor = parsedInput(1)
      case 3 => actor = parsedInput(1); other = parsedInput(2)
      case _ => ()
    }

    commands(verb)(actor, other)
  }

  def parse(command: String): Array[String] = {
    val words = command.toLowerCase.split(" ")

    return words
  }
}
