import com.rocketseat.nlw.nearby.data.model.NearbyCategory
import com.rocketseat.nlw.nearby.core.network.KtorHttpClient.httpClientAndroid
import com.rocketseat.nlw.nearby.data.model.Coupon
import com.rocketseat.nlw.nearby.data.model.NearbyMarket
import com.rocketseat.nlw.nearby.data.model.NearbyMarketDetail
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.patch

object NearbyRemoteDataSource {
    private const val LOCAL_HOST_EMULATOR_BASE_URL = "http://10.0.2.2:3333"
    private const val LOCAL_HOST_DEVICE_BASE_URL = "http://192.168.1.102:3333"
    private const val BASE_URL = LOCAL_HOST_DEVICE_BASE_URL

    // - busca de categorias
    // - busca de locais
    // - busca de detalhes de um local

    suspend fun getCategories(): Result<List<NearbyCategory>> = try {

        val categories =
            httpClientAndroid.get("${BASE_URL}/categories").body<List<NearbyCategory>>()

        Result.success(categories)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun getMarkets(categoryId: String): Result<List<NearbyMarket>> = try {
        val markets = httpClientAndroid.get("$BASE_URL/markets/category/${categoryId}")
            .body<List<NearbyMarket>>()

        Result.success(markets)
    } catch (e: Exception) {
        Result.failure(e)
    }


    suspend fun getMarketDetails(marketId: String): Result<NearbyMarketDetail> = try {

        val marketDetail = httpClientAndroid.get("${BASE_URL}/markets/${marketId}")
            .body<NearbyMarketDetail>()

        Result.success(marketDetail)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun patchCoupon(marketId: String): Result<Coupon> = try {

        val coupon = httpClientAndroid.patch("${BASE_URL}/coupons/${marketId}").body<Coupon>()

        Result.success(coupon)
    } catch (e: Exception) {
        Result.failure(e)
    }

}