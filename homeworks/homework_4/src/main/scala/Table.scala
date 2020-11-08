import scala.collection.mutable

class Table(val width: Int, val height: Int){
  val matrix: mutable.MutableList[Cell] = mutable.MutableList.fill(width * height)(new EmptyCell)

  def getCell(x: Int, y: Int): Option[Cell] = {
    if (x > width || x < 0 || y > height || y < 0)
      None
    else
      matrix.get(x + y * width)
  }

  def setCell(x: Int, y: Int, cell: Cell): Unit = {
    matrix(x + y * width) = cell
  }
}