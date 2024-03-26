data class Conditions(
    var snow: Boolean? = false,
    var gravel: Boolean? = false,
    var potholes: Boolean? = false,
    var ice: Boolean? = false,
    var plowed: Boolean? = false,
    var salt: Boolean? = false,
    var flooded: Boolean? = false,
    var golfballhail:Boolean? = false,

    ){

    fun toMap(): Map<String, Any?> {
        return mapOf(
            "snow" to snow,
            "plowed" to plowed,
            "ice" to ice,
            "salt" to salt,
            "flooded" to flooded,
            "gravel" to gravel,
            "potholes" to potholes,
            "golfballhail" to golfballhail,
        )
    }
}