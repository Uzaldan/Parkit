data class ParkingLot(
    var percent: Number? = 0,
    var spaces: Number? = 0,
    var type: String? = "public",

    ){

    fun toMap(): Map<String, Any?> {
        return mapOf(
            "percent" to percent,
            "plowed" to spaces,
            "type" to type,

        )
    }
}