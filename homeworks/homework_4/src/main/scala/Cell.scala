import scala.collection.mutable
trait  Cell

class EmptyCell() extends Cell {
  override def toString: String = "empty"
}

class NumberCell(number: Int) extends Cell {
  override def toString: String = number.toString
}

class StringCell(string: String) extends Cell {
  override def toString: String = string
}

class ReferenceCell (val ix: Int, val iy: Int, val table: Table) extends Cell{

  override def toString: String = {
    if (ix > table.width || ix < 0 || iy > table.height || iy < 0)
      "outOfRange"
    table.getCell(ix, iy) match {
      case Some(c: ReferenceCell) => iterateRefs()
      case Some(c: Cell) => c.toString
    }
  }

  def iterateRefs(): String = {
    var refList = new mutable.ListBuffer[Int]
    refList += ix + iy * table.width
    var cell = table.getCell(ix, iy)
    var result = ""
    while (result == "") {
      cell match {
        case Some(case_cell: ReferenceCell) => {
          cell = table.getCell(case_cell.ix, case_cell.iy)
          val xy = case_cell.ix + case_cell.iy * table.width
          if (refList.contains(xy))
            result = "cyclic"
          else
            refList += case_cell.ix + case_cell.iy * table.width
      }
        case Some(case_cell: Cell) => result = case_cell.toString
      }
    }
    result
  }
}