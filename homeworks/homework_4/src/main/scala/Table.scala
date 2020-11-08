import scala.collection.mutable

class Table(val width: Int, val height: Int) {
  private val matrix: mutable.MutableList[Cell] = mutable.MutableList.fill(width * height)(new EmptyCell)

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (ix > width || ix < 0 || iy > height ||iy < 0)
      None
    else
      matrix.get(ix + iy * width)
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    matrix(ix + iy * width) = cell
  }
}

