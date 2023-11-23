package com.strayalpaca.tiffanyentropy.presentation.navigation

interface Destinations {
    val route : String
}

object HomeDest : Destinations {
    override val route: String = "home"
}

object SensorMonitoringDest : Destinations {
    override val route: String = "sensor_monitoring"
}

object NotificationDest : Destinations {
    override val route: String = "notification"
}

object QrRecognition : Destinations {
    override val route: String = "qr_code"
}

object CollectionHistory : Destinations {
    override val route: String = "collection_history"

}