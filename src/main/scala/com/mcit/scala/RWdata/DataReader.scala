package com.mcit.scala.RWdata

import com.mcit.scala.ClassEntities.{Calendar, Routes, Trips}

import scala.io.Source

class DataReader {
  val filePathRoutes = "/home/bd-user/IdeaProjects/DataEnrichment/routes.txt"
  val filePathCalendar = "/home/bd-user/IdeaProjects/DataEnrichment/calendar.txt"
  val filePathTrips = "/home/bd-user/IdeaProjects/DataEnrichment/trips.txt"

  def getRouteList: List[Routes] = {
      val source = Source.fromFile(filePathRoutes)
        val input = source.getLines().drop(1)
      .map(line => line.split(","))
      .map(a => Routes(a(0).toInt, a(1), a(2), a(3), a(4), a(5), a(6))).toList
    source.close()
    input
  }
  def getCalendarList: List[Calendar] = {
    val source = Source.fromFile(filePathCalendar)
    val input = source.getLines().drop(1)
      .map(line => line.split(","))
      .map(a=> Calendar(a(0), a(1), a(2), a(3), a(4), a(5), a(6), a(7), a(8), a(9))).toList
    source.close()
    input
  }
  def getTripList: List[Trips] = {
    val source = Source.fromFile(filePathTrips)
    val input = source.getLines().drop(1)
      .map(line => line.split(",", -1))
      .map(a => Trips(a(0).toInt, a(1), a(2), a(3), a(4), a(5), a(6), if (a(7).isEmpty) None else Some(a(7)), if (a(8).isEmpty) None else Some(a(8)))).toList
    source.close()
    input
  }
}
