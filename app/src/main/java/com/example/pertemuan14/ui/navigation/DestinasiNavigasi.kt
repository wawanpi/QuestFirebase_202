package com.example.pertemuan14.ui.navigation

interface DestinasiNavigasi{
    val route: String
    val titleRes: String
}

object DestinasiHome : DestinasiNavigasi{
    override val route: String = "home"
    override val titleRes: String = "Home"
}

object DestinasiInsert: DestinasiNavigasi{
    override val route: String = "insert"
    override val titleRes: String = "Insert"
}
object DestinasiDetail: DestinasiNavigasi{
    override val route: String = "detail"
    override val titleRes: String = "detail"
}