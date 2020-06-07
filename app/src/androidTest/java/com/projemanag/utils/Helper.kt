import androidx.test.InstrumentationRegistry
import org.json.JSONObject

fun readJSONFromAsset(file: String): String? {
    var json: String? = null
    try {
        val inputStream = InstrumentationRegistry.getContext().getAssets().open(file)
        json = inputStream.bufferedReader().use { it.readText() }
    } catch (ex: Exception) {
        ex.printStackTrace()
        return null
    }
    return json
}

fun getJsonValue(value: String): String = JSONObject(readJSONFromAsset("cred.json"))
    .getString(value)