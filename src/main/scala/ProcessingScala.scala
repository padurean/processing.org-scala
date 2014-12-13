import processing.core._

object ProcessingScalaRunner {
  def main(args: Array[String]) { PApplet.main(Array("ProcessingScala")) }
}
class ProcessingScala extends PApplet {
  lazy val items = { 0 to width }.view.map { (_, random(255).toInt) }

  override def setup() {
    size(500, 200)
    frameRate(20)
  }

  override def draw() {
    for ((x, color) <- items) {
      stroke(color)
      line (x, 0, x, height)
    }
  }
}
