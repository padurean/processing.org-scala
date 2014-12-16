import processing.core._
import processing.core.PApplet._
import processing.core.PConstants._

object ProcessingScalaRunner {
  def main(args: Array[String]) { PApplet.main(Array("ProcessingScala")) }
}

class ProcessingScala extends PApplet {
  var childSketch: PApplet = new ProcessingScalaSketch3

  override def setup() {
    size(640, 640)
    frameRate(20)
    background(0)
    childSketch.init()
    childSketch.setup()
  }

  override def draw() {
    childSketch.draw()
    //Display an image of the child sketch
    image(childSketch.get(), 0, 0)
  }

  // pass the mouse movements down to the child PApplet
  override def mouseMoved() {
    childSketch.mouseX = this.mouseX
    childSketch.mouseY = this.mouseY
  }

  // flip between 2 different sketches
  override def keyPressed() {
    key match {
      case '1' =>
        childSketch = new ProcessingScalaSketch1()
        childSketch.init()
        childSketch.setup()
      case '2' =>
        childSketch = new ProcessingScalaSketch2()
        childSketch.init()
        childSketch.setup()
      case '3' =>
        childSketch = new ProcessingScalaSketch3()
        childSketch.init()
        childSketch.setup()
      case _ =>
    }
  }
}

class ProcessingScalaSketch1 extends PApplet {
  lazy val items = { 0 to width }.view.map { (_, random(255).toInt) }

  override def setup() {
    size(640, 640)
    // frameRate(20)
  }

  override def draw() {
    for ((x, color) <- items) {
      stroke(255, 204, 0)
      line(x, 0, x, height)
    }
  }
}

class ProcessingScalaSketch2 extends PApplet {
  lazy val items = { 0 to width }.view.map { (_, random(255).toInt) }

  override def setup() {
    size(640, 640)
    // frameRate(20)
  }

  override def draw() {
    for ((x, color) <- items) {
      stroke(color)
      line(x, 0, x, height)
    }
  }
}

class ProcessingScalaSketch3 extends PApplet {
  var cx: Int = 0
  var cy: Int = 0
  var secondsRadius: Float = 0f
  var minutesRadius: Float = 0f
  var hoursRadius: Float = 0f
  var clockDiameter: Float = 0f

  override def setup() {
    size(640, 640)
    stroke(255)

    val radius: Int = min(width, height) / 2
    secondsRadius = radius * 0.72f
    minutesRadius = radius * 0.60f
    hoursRadius = radius * 0.50f
    clockDiameter = radius * 1.8f

    cx = width / 2
    cy = height / 2
  }

  override def draw() {
    // Draw the clock background
    fill(80)
    noStroke()
    ellipse(cx, cy, clockDiameter, clockDiameter)

    // Angles for sin() and cos() start at 3 o'clock;
    // subtract HALF_PI to make them start at the top
    val s: Float = map(second(), 0, 60, 0, TWO_PI) - HALF_PI
    val m: Float = map(minute() + norm(second(), 0, 60), 0, 60, 0, TWO_PI) - HALF_PI
    val h: Float = map(hour() + norm(minute(), 0, 60), 0, 24, 0, TWO_PI * 2) - HALF_PI

    // Draw the hands of the clock
    stroke(255)
    strokeWeight(1)
    line(cx, cy, cx + cos(s) * secondsRadius, cy + sin(s) * secondsRadius)
    strokeWeight(2)
    line(cx, cy, cx + cos(m) * minutesRadius, cy + sin(m) * minutesRadius)
    strokeWeight(4)
    line(cx, cy, cx + cos(h) * hoursRadius, cy + sin(h) * hoursRadius)

    // Draw the minute ticks
    strokeWeight(2)
    beginShape(POINTS)
    for (a <- 0 until 360 by 1) {
      val angle: Float = radians(a)
      val x: Float = cx + cos(angle) * secondsRadius
      val y: Float = cy + sin(angle) * secondsRadius
      vertex(x, y)
    }
    endShape()
  }
}
